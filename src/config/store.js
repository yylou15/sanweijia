import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        test: 'saasfaf',
        menuItem: [
            {
                name: "菜单", icon: "md-radio-button-off", color: "red", submenu: [
                    {name: "主页", icon: "md-home", router: "home"},
                    {name: "图表", icon: "md-analytics", router: "graph"},
                    {name: "统计", icon: "ios-stats", router: "stat"}
                ]
            },
            {
                name: "配置", icon: "md-radio-button-off", color: "green", submenu: [
                    {name: "主题", icon: "ios-color-palette", router: "theme"},
                    {name: "偏好", icon: "ios-happy", router: "preference"},
                    {name: "数据", icon: "ios-analytics", router: "datasource"}
                ]
            }
        ]
    },
    mutations: {},
    actions: {}
})
