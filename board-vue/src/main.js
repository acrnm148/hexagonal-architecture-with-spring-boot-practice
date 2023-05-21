import Vue from 'vue'
import App from './App.vue'
import router from './routers/router.js' //router

import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
}).$mount('#app')
