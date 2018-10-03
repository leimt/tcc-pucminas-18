import Vue from 'vue';
import VueRouter from 'vue-router';
import App from './App';
import VueResource from 'vue-resource';

import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

import LoginComponent from './components/LoginComponent.vue';
import MenuComponent from './components/MenuComponent.vue';
import PerfilComponent from './components/usuario/PerfilComponent.vue'
import EntregaProdutoComponent from './components/entregas/EntregaProdutoComponent.vue'
import GerenciadorCTEComponent from './components/cte/GerenciadorCTEComponent.vue'

Vue.config.productionTip = false;

Vue.use(VueRouter);
Vue.use(BootstrapVue);
Vue.use(VueResource);

const routes = [
  {
	path: '/',					// http://localhost:4200/#
	name: 'login',
	component: LoginComponent,
	meta: {
	  guest: true
	}
  },
  {
	path: '/menu',				// http://localhost:4200/#/menu
	name: 'menu',
	component: MenuComponent,
	meta: {
	  requiresAuth: true
	}
  },
  {
	path: '/perfil',
	name: 'perfil',
	component: PerfilComponent,
	meta: {
	  requiresAuth: true,
	  is_admin: true
	}
  },
  {
	path: '/entrega-produto',
	name: 'entrega-produto',
	component: EntregaProdutoComponent,
	meta: {
	  requiresAuth: true
	}
  },
  {
	path: '/gerenciar-cte',
	name: 'gerenciar-cte',
	component: GerenciadorCTEComponent,
	meta: {
	  requiresAuth: true
    }
  }
];

const router = new VueRouter({
  routes
});

router.beforeEach( ( to, from, next ) => {
    if ( to.matched.some( record => record.meta.requiresAuth ) ) {
        if ( localStorage.getItem('user-token') == null ) {	// se o token não existir, redirecona p/ pág. de login
            next({
                path: '/',
                params: { nextUrl: to.fullPath }
            })
        } else {	// senão, verifica se o user foi definido
            let user = JSON.parse( localStorage.getItem('user') )
            if ( to.matched.some( record => record.meta.is_admin ) ) {
                if( user.is_admin == 1 ) {
                    next()
                }
                else{
                    next({ name: 'menu'})
                }
            } else {
                next()
            }
        }
    } else if ( to.matched.some( record => record.meta.guest ) ) {	// ### AINDA NÃO TENHO ESSE PERFIL
        if ( localStorage.getItem('user-token') == null ) {
            next()
        }
        else {
            next({ name: 'menu'})
        }
    } else {
        next() 
    }
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
});
