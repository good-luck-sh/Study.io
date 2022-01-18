import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import BookList from '../views/BookList.vue'
import BookForm from '../views/BookForm.vue'
import BookDetail from '../views/BookDetail.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/book/list/:no',
    name: 'BookList',
    component: BookList
  },
  {
    path: '/book/form',
    name: 'BookForm',
    component: BookForm
  },
  {
    path: '/book/detail/:no',
    name: 'BookDetail',
    component: BookDetail
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
