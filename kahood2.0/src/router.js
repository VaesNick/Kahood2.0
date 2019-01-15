import Vue from 'vue'
import Router from 'vue-router'
import CoursePage from './components/CoursePage'
import LandingsPage from './components/LandingsPage'


Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/course/:id',
            name: 'CoursePage',
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
