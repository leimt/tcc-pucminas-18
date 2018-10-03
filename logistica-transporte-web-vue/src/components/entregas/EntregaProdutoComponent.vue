<template>
  <div>
    <menu-component></menu-component>
    <b-jumbotron>
      <h4>Dados do produto</h4>
      <b-table stacked :items="items"></b-table>
      
      <b-form-select v-model="selected" :options="options" class="mb-3" />
      <b-button @click="enviarEstadoTransporte(selected)">Enviar mensagem</b-button>
    </b-jumbotron>
  </div>
</template>

<script>
import MenuComponent from '../MenuComponent'

export default {
  data() {
    return {
      selected: null,
      options: [
        { value: null, text: '-- Selecione uma opção --' },
        { value: 0, text: 'Iniciar coleta', disabled: false },
        { value: 1, text: 'Entregue no armazém' },
        { value: 2, text: 'Coletado para entrega' },
        { value: 3, text: 'Entregue no destinatário' }
      ],
      items: [
        { remetente: 'Antonio de Sousa',
          destinatario: 'José da Silva',
          descricao_do_produto: 'Geladeira',
          endereco: 'Quadra 25 Conjunto A Lote 5',
          cep: '72.800-000' }
      ]
    }
  },
  components: {
    MenuComponent
  },
  methods: {
    getProduto() {
      var url = 'http://localhost:8080/entregas/teste';
      this.$http.get( url );
    },
    enviarEstadoTransporte( numEvento ) {
      this.$http.get('http://localhost:8080/entregas/produto/status', { params: { numEvento: numEvento } } )
      .then( response => {
        // success callback
      }, response => {
        // error callback
      });
    }
  }
}
</script>

<style>
</style>
