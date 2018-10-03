<template>
  <div>
    <div class="jumbotron text-center">
      <img src="../assets/delivery-truck-128.png" />
      <h1>Sistema de Logística de Transporte</h1>
    </div>

    <div>
      <b-alert show variant="danger" v-if="exibirMsgErro">Usuário ou senha inválida.</b-alert>
    </div>

    <div>
      <form>
        <div class="container">
          <div class="row">
            <div class="col-sm-12">
              <div class="form-group">
                  <label>Login:</label>
                  <b-form-input id="input-large" size="lg" type="text" placeholder="Digite o login" v-model="login">
                  </b-form-input>
              </div>
          
              <div class="form-group">
                  <label>Senha:</label>
                  <b-form-input id="input-large2" size="lg" type="password" placeholder="Digite a senha" v-model="senha">
                  </b-form-input>
              </div>
              <button class="btn btn-info" v-on:click="autenticar()">Entrar</button>
            </div>
          </div>
        </div>
      </form>
    </div>
    <br/>
    <br/>
  </div>
</template>

<script>
var jsSha512 = require('js-sha512').sha512

export default {
  data () {
    return {
      login: '',
      senha: '',
      token: 'Bearer ',
      exibirMsgErro: false,
      usuario: {
        login: '',
        senhaHash: '',
        role: 'admin'
      }
	  }
  },
  methods: {
    autenticar() {
      this.usuario.login     = this.login;
      this.usuario.senhaHash = jsSha512.hex( this.senha );
      console.log( this.usuario );
      this.$http.post('http://localhost:8080/seguranca/token', this.usuario )
        .then( response => {  // success callback
          var permissao = JSON.parse( response.bodyText );
          if ( permissao.token == null ) {
            this.exibirMsgErro = true;
          } else {
            localStorage.setItem('user-token', permissao.token );
            localStorage.setItem('user', JSON.stringify( { is_admin: 1 } ) );
            this.token += permissao.token; // obtém o token
            this.definirMenus( permissao.perfil );
            this.$router.push('/menu');
          }
        }, response => {  // error callback
          localStorage.removeItem('user-token');
          localStorage.removeItem('user');
          this.exibirMsgErro = true;
      });
    },
    definirMenus( perfil ) {
      localStorage.setItem( 'perfil', perfil );
    }
  }
}
</script>

<style>
</style>
