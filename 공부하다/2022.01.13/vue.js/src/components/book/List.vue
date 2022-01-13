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
            <td>{{book.no}}</td>
            <td><router-link :to="`/book/detail/10`">{{book.title}}</router-link></td>
            <td>{{book.author}}</td>
            <td>{{book.publisher}}</td>
            <td class="text-end pe-2"><strong class="text-danger">{{book.discountPrice}} 원</strong> <del>{{book.price}} 원</del></td>
            <td class="text-center"><button type="button" class="btn btn-outline-primary btn-sm">장바구니</button> </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name:"List",
  props:["bookList"] //BookList 컴포넌트에서 <List :bookList="books" />
}
</script>

<style>

</style>