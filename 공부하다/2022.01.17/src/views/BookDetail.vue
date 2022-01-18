<template>
  <main>
    <div class="row mb-3">
      <div class="col">
        <p>도서 상세정보를 표시합니다.</p>
        <table class="table">
          <tbody>
            <tr>
              <th style="width: 15%;">최종수정일</th>
              <td style="width: 35%;">{{book.updatedDate}}</td>
              <th style="width: 15%;">등록일</th>
              <td style="width: 35%;">{{book.createdDate}}</td>
            </tr>
            <tr>
              <th>제목</th>
              <td colspan="3">{{book.title}}</td>
            </tr>
            <tr>
              <th>저자</th>
              <td>{{book.author}}</td>
              <th>출판사</th>
              <td>{{book.publisher}}</td>
            </tr>
            <tr>
              <th>할인가격</th>
              <td><strong class="text-danger">{{book.discountPrice}}</strong> 원</td>
              <th>가격</th>
              <td>{{book.price}}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div class="row mb-3">
      <div class="col text-end"><button class="btn btn-primary" @click="back">목록</button></div>
    </div>
  </main>
</template>

<script>
import BookService from '../service/BookService';

export default {
  name: "BookDetail",
  data() {
    return {
      book: {}
    }
  },
  methods: {
    back() {
      this.$router.back();
    }
  },
  created() {
    BookService.detail(this.$route.params.no)
      .then(response => {
        if (response.data.success) {
          this.book = response.data.item
        }
      })
  }
}
</script>

<style>

</style>