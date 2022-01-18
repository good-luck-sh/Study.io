<template>
  <div class="row mb-3">
    <div class="col">
      <p>도서 목록을 표시합니다.</p>

      <table class="table">
        <thead>
          <tr>
            <th style="width: 10%;">순번</th>
            <th style="width: 35%;">제목</th>
            <th style="width: 15%;">저자</th>
            <th style="width: 15%;">출판사</th>
            <th style="width: 15%;" class="text-end pe-2">가격</th>
            <th style="width: 10%;"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="book in bookList" :key="book.no">
            <td>{{ book.no }}</td>
            <td><router-link :to="`/book/detail/${book.no}`">{{ book.title }}</router-link></td>
            <td>{{ book.author }}</td>
            <td>{{ book.publisher }}</td>
            <td class="text-end pe-2"><strong class="text-danger">{{ book.discountPrice}} 원</strong> <del>{{ book.price }} 원</del></td>
            <td class="text-center"><button type="button" class="btn btn-outline-primary btn-sm" @click="removeBook(book.no)">삭제</button> </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import BookService from '../../service/BookService';

export default {
  name: "List",
  props: ["bookList"],
  methods: {
    removeBook(no) {
      BookService.remove(no)
        .then(response => {
          alert(response.data.item.title + "가 삭제되었습니다.");
          this.$router.go();
        })
        .catch(() => alert("삭제 중 오류가 발생하였습니다."))
    }
  }
}
</script>

<style>

</style>