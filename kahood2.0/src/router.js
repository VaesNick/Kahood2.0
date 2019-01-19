import Vue from 'vue'
import Router from 'vue-router'
import CoursePage from './components/CoursePage'
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
            name: 'Course',
            component: CoursePage
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
