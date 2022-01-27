<template>
  <main class="container">
    <div class="row mb-3">
      <div class="col">
        <h1 class="fs-3">도서 목록 <router-link class="btn btn-primary float-end" to="/book/form">책 등록</router-link></h1>
      </div>
    </div>
    <div class="row mb-3">
      <div class="col-4 mb-3"  v-for="item in books" :key="item.no">
        <BookCard :book="item"/>
      </div>
    </div>
  </main>
</template>

<script>
import axios from "axios";
import BookCard from '../components/BookCard.vue';

export default {
  name: "BookList",
  components: {
    BookCard
  },
  data() {
    return {
      books: []
    }
  },
  created() {
    axios.get("/books", {
      baseURL: 'http://localhost'
    })
    .then(response => {
      console.log(response);
      if (response.data.success) {
        this.books = response.data.items;
      }
    })
  }
}
</script>

<style>

</style>