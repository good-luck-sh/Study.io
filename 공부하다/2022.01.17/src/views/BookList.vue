<template>
  <main>
    <SearchForm />
    <!-- 
      :bookList="books"
        :bookList는 List컴포넌트(자식컴포넌트)에서 부모 컴포넌트가 전해줄 데이터를 전달받을 props의 이름이다.
        books는 이 컴포넌트가 자식 컴포넌트에게 전달할 데이터가 저장된 프로퍼티다.
     -->
    <List :bookList="books" :x='100'/>
    <Pagination :pagination="pagination"/>
  </main>
</template>
<script>
import SearchForm from "../components/book/SearchForm.vue";
import List from '../components/book/List.vue';
import Pagination from '../components/common/Pagination.vue';

import BookService from '../service/BookService';

export default {
  name: "BookList",
  components: {
    SearchForm,
    List,
    Pagination
  },
  data() {
    return {
      books:[],
      pagination: null,
      criteria: {
        page:1,
        opt: '',
        value: ''
      }
    }
  },   
  methods: {
   
  },           
  created() {
    this.criteria.page = this.$route.params.no || 1;
    BookService.list(this.criteria)
      .then(response => {
        var success = response.data.success;
        if (success) {
          this.books = response.data.item.books;
          this.pagination = response.data.item.pagination;
        }
      });
  }
}

</script>
<style scoped>

</style>