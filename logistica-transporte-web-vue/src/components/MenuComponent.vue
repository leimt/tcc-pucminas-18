<template>
<div>
  <b-navbar toggleable="md" type="dark" variant="info">

    <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

    <b-navbar-brand href="#"><img src="../assets/delivery-truck-32.png"/>
      </b-navbar-brand>

    <b-collapse is-nav id="nav_collapse">

      <b-navbar-nav>
        <b-nav-item-dropdown text="Carregamentos" left v-if="isFuncionario || isAdmin">
          <b-dropdown-item href="#">Nova solicitação de transporte</b-dropdown-item>
          <b-dropdown-item href="#">Visualizar solicitações</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown text="Tabelas de frete" left v-if="isFuncionario || isAdmin">
          <b-dropdown-item href="#">Incluir tarifa</b-dropdown-item>
          <b-dropdown-item href="#">Listagem de tarifas</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown text="Entregas" left>
          <b-dropdown-item href="#" v-if="isMotorista"><router-link to="entrega-produto">Entregar produto</router-link></b-dropdown-item>
          <b-dropdown-item href="#" v-if="isFuncionario || isAdmin">Consultar satisfação</b-dropdown-item>
          <b-dropdown-item href="#" v-if="isFuncionario || isAdmin">Responder pesquisa de satisfação</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown text="Expedição" left v-if="isFuncionario || isAdmin">
          <b-dropdown-item href="#">Visualizar</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown text="CT-e" left v-if="isFuncionario || isAdmin">
          <b-dropdown-item href="#">Cadastrar pessoa</b-dropdown-item>
          <b-dropdown-item href="#">Cadastrar motorista</b-dropdown-item>
          <b-dropdown-item href="#">Cadastrar proprietário</b-dropdown-item>
          <b-dropdown-item href="#">Cadastrar veículo</b-dropdown-item>
          <b-dropdown-item href="#">Cadastrar tributação</b-dropdown-item>
          <b-dropdown-item href="#"><router-link to="gerenciar-cte">Gerenciar CT-e</router-link></b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown text="Devolução, reenvio e extravio" left v-if="isFuncionario || isAdmin">
          <b-dropdown-item href="#">Registrar ocorrência</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown text="Relatórios" left v-if="isFuncionario || isAdmin">
          <b-dropdown-item href="#">Devoluções</b-dropdown-item>
          <b-dropdown-item href="#">Expedição</b-dropdown-item>
          <b-dropdown-item href="#">Pendências</b-dropdown-item>
          <b-dropdown-item href="#">Rentabilidade</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item href="#" v-if="isFuncionario || isAdmin">SAC</b-nav-item>
      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">

        <b-nav-item-dropdown right>
          <!-- Using button-content slot -->
          <template slot="button-content">
            <em>Usuário</em>
          </template>
          <b-dropdown-item href="#"><router-link to="perfil">Perfil</router-link></b-dropdown-item>
          <b-dropdown-item href="#"><a href="" v-on:click="logout()">Sair</a></b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>

    </b-collapse>
  </b-navbar>
</div>
</template>

<script>
export default {
  data () {
    return {
      isFuncionario: false,
      isMotorista: false,
      isAdmin: false
    }
  },
  methods: {
    logout() {  // método executado após o logout
      localStorage.removeItem('user-token');
      localStorage.removeItem('user');
      localStorage.removeItem('perfil');
      this.$router.push('/');
    }
  },
  beforeMount() { // método executado antes da montagem da tela
    var perfil = localStorage.getItem('perfil');
    if ( perfil == 'admin' ) {
      this.isAdmin = true;
    }
    if ( perfil == 'func' ) {
      this.isFuncionario = true;
    }
    if ( perfil == 'motorista' ) {
      this.isMotorista = true;
    }
  }
}
</script>

<style>
</style>
