import Vue from 'vue'
import App from './App.vue'
import router from './config/router'
import store from './config/store'
import iview from 'iview'
import 'iview/dist/styles/iview.css';
import VueRouter from "vue-router";
import less from 'less'
import echarts from 'echarts'
import axios from 'axios'

Vue.use(axios);
Vue.config.productionTip = false;
Vue.use(iview);
Vue.use(VueRouter);
Vue.use(less);
Vue.use(echarts);

new Vue({
  router,
  store,
  render: function (h) { return h(App) }
}).$mount('#app');
