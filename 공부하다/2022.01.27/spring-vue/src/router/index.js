import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import BookList from '../views/BookList.vue'
import BookForm from '../views/BookForm.vue'
import BookDetail from '../views/BookDetail.vue'

// 라우팅 정보 정의
// URL과 컴포넌트를 매핑시키는 정보
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/book/list',
    name: 'BookList',
    component: BookList
  },
  {
    path: '/book/form',
    name: 'BookForm',
    component: BookForm
  },
  {
    path: '/book/detail/:id',
    name: 'BookDetail',
    component: BookDetail
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
