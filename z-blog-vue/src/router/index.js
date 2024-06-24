import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeVue from '../views/HomeView.vue'
import BlogContentView from "@/views/BlogContentView.vue";
import BlogReleaseView from "@/views/BlogReleaseView.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeVue
  },
  {
    path: '/content',
    name: 'BlogContentView',
    component: BlogContentView
  },
  {
    path: '/release',
    name: 'ReleaseView',
    component: BlogReleaseView
  }
]

const router = new VueRouter({
  routes
})

export default router
