import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '',
            redirect: '/home'
        },
        {
            path: '/',
            redirect: '/home'
        },
        {
            path: '/home',
            name: 'home',
            component(){
                return import('../views/main/home')
            }
        },
        {
            path: '/graph',
            name: 'graph',
            component(){
                return import('../views/main/graph')
            }
        },
        {
            path: '/stat',
            name: 'stat',
            component(){
                return import('../views/main/stat')
            }
        },
        {
            path: '/theme',
            name: 'theme',
            component(){
                return import('../views/config/theme')
            }
        },
        {
            path: '/preference',
            name: 'preference',
            component(){
                return import('../views/config/preference')
            }
        },
        {
            path: '/datasource',
            name: 'datasource.vue',
            component(){
                return import('../views/config/datasource')
            }
        },
        // {
        //   path: '/about',
        //   name: 'about',
        //   // route level code-splitting
        //   // this generates a separate chunk (about.[hash].js) for this route
        //   // which is lazy-loaded when the route is visited.
        //   component: function () {
        //     return import(/* webpackChunkName: "about" */ '../views/About.vue')
        //   }

    ]
})
