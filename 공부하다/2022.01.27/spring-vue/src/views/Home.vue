<template>
  <main class="container">
    <div class="row">
      <div class="col">
        <div class="border p-3 bg-light">
          <h1 class="mb-4">샘플 애플리케이션 입니다.</h1>
          <p class="mb-3">spring-boot, vue.js를 활용한 샘플애플리케이션입니다.</p>
          <router-link to="/book/list" class="btn btn-primary btn-lg">책 목록</router-link>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  name: 'Home',
  components: {
  }
}
</script>
