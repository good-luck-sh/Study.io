<template>
  <div class="card">
    <div class="card-body">
      <div class="border-bottom pb-2">
        <router-link class="text-decoration-none btn-link text-dark fw-bold" :to="`/book/detail/${book.no}`">{{ book.title }}</router-link>
      </div>
      <p class="mt-1 d-flex justify-content-between text-secondary">
        <span>{{ book.author }}</span>
        <span>{{ book.publisher }}</span>
      </p>
      <p class="mb-0 d-flex justify-content-between">
        <small class="text-decoration-line-through">{{ book.price.toLocaleString() }} 원</small>
        <span><strong class="text-danger">{{ book.discountPrice.toLocaleString() }}</strong> 원</span>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "BookCard",
  // <BookCard :book="item" />에서 item변수에 저장된 책정보를 BookCard의 book 프로퍼티에 전달하기
  props: ["book"]
}
</script>

<style>

</style>