<template>
  <div class="p-4 mb-4 bg-light rounded-3">
    <div class="container-fluid py-5">
      <h1 class="display-5 fw-bold">북스토어</h1>
      <p class="fs-4">spring boot와 Vue.js로 구현한 북스토어 애플리케이션 입니다.</p>
      <router-link to="/book/list/1" class="btn btn-primary btn-lg">도서 조회</router-link>
    </div>
  </div>
</template>
<script>
export default {
  name: 'Home'
}
</script>
