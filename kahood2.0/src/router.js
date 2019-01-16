import Vue from 'vue'
import Router from 'vue-router'
import GroupPage from './components/GroupPage'
import LandingsPage from './components/LandingsPage'
import LoginPage from './components/LoginPage'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path:"/login",
            name:"Login",
            component: LoginPage
        },
        {
            path: '/course/:id*',
            name: 'GroupPage',
            component: GroupPage
        },
        {
            path: '/',
            name: 'LandingsPage',
            component: LandingsPage
        },
        {path:"*", redirect:"/"}
    ],
    mode: "history"
})
