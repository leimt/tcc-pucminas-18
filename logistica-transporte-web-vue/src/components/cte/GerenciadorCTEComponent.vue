<template>
  <div>
    <menu-component></menu-component>

    <b-jumbotron>
      <h4>Gerenciar CT-e</h4>
      <hr>

      <form>
        <b-container fluid>
          <b-row class="my-1">
            <b-col sm="3"><label>Perído de emissão:</label></b-col>
            <b-col sm="3"><b-form-input id="input-default" type="date"></b-form-input></b-col>
            <b-col sm="3"><label>a</label></b-col>
            <b-col sm="3"><b-form-input id="input-default" type="date"></b-form-input></b-col>
          </b-row>
          <b-row>
            <b-col sm="3"><label>Empresa:</label></b-col>
            <b-col sm="6"><b-form-input id="input-default" type="text"></b-form-input></b-col>
          </b-row>
          <br>
          <b-row>
            <b-col sm="3"><label></label></b-col>
            <b-col sm="6"><button class="btn btn-info" v-on:click="pesquisar()">Pesquisar</button></b-col>
          </b-row>
        </b-container>
      </form>
    </b-jumbotron>

    <b-jumbotron v-if="exibir">
      <h4>Dados</h4>
      <hr>
      <table class="table">
        <thead class="thead-dark">
          <tr>
            <th scope="col">Data de emissão</th>
            <th scope="col">UF início</th>
            <th scope="col">UF término</th>
            <th scope="col">Tipo de emissão</th>
            <th scope="col">Tipo de serviço</th>
            <th scope="col">Situação</th>
            <th scope="col">E-mail enviado?</th>
            <th scope="col">Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="foiExcluido">
            <td scope="row">20/09/2018</td>
            <td>DF</td>
            <td>MG</td>
            <td>Normal</td>
            <td>Normal</td>
            <td>{{ situacaoCte }}</td>
            <td>{{ emailEnviado }}</td>
            <td>
              <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Transmitir CT-e">
                <img src="../../assets/play-24.png" v-on:click="transmitirCte()" />
              </span>
              <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Excluir CT-e">
                <img src="../../assets/x-button-24.png" v-on:click="excluirCte()" v-if="!foiTransmitido" />
              </span>
              <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Visualizar">
                <img src="../../assets/xml-24.png" v-on:click="obterXmlEmitente()" />
              </span>
              <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Imprimir DACTE">
                <img src="../../assets/printer-24.png" />
              </span>
              <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Enviar e-mail">
                <img src="../../assets/email-24.png" v-on:click="enviarEmail()" v-if="foiTransmitido" />
              </span>
            </td>
          </tr>
        </tbody>
      </table>
    </b-jumbotron>

    <div>
      <!-- Modal Component -->
      <b-modal ref="modalXml" id="modalXml" title="XML Emitente">
        <p class="my-4">{{ xmlEmitente }}</p>
      </b-modal>
    </div>
  </div>
</template>

<script>
import MenuComponent from '../MenuComponent'

export default {
  data () {
    return {
      exibir: false,
      situacaoCte: 'Validado',
      emailEnviado: 'Não',
      foiExcluido: true,
      foiTransmitido: false,
      xmlEmitente: ''
    }
  },
  components: {
    MenuComponent
  },
  methods: {
    pesquisar() {
      this.exibir = true;
    },
    transmitirCte() {
      var url = 'http://localhost:8080/cte/rest/transmitir-cte';
      this.$http.get( url ).then( response => {
        this.situacaoCte = response.bodyText;
        this.foiTransmitido = true;
      }, response => {
        // error callback
        console.log('Erro ao transmitir CT-e.');
      });
    },
    enviarEmail() {
      var url = 'http://localhost:8080/cte/rest/enviar-email';
      this.$http.get( url ).then( response => {
          this.emailEnviado = response.bodyText;
        }, response => {
          // error callback
      });
    },
    obterXmlEmitente() {
      var url = 'http://localhost:8080/cte/rest/obter-xml-emitente';
      this.$http.get( url ).then( response => {
          this.xmlEmitente = response.bodyText;
        }, response => {
        // error callback
      });
      this.$refs.modalXml.show();
    },
    excluirCte() {
      this.foiExcluido = false;
    }
  }
}
</script>

<style>
</style>
