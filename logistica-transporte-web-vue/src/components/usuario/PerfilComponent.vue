<template>
  <div>
    <menu-component></menu-component>
    <b-jumbotron>
      <h3>Informações de perfil</h3>
      <b-table stacked :items="items"></b-table>
    </b-jumbotron>
  </div>
</template>

<script>
import MenuComponent from '../MenuComponent'

export default {
  data () {
    return {
      items: [
        { nome: 'Dickerson', perfil: 'Administrador', email: 'admin@email.com.br' }
      ]
    }
  },
  components: {
    MenuComponent
  }
}
</script>

<style>

</style>
