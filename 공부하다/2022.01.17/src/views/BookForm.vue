<template>
  <main>
    <div class="row mb-3">
      <div class="col">
        <p>새 책정보를 등록하세요</p>
        <form class="border p-3 bg-light">
          <div class="mb-3">
            <label for="title-field" class="form-label">제목</label>
            <input type="text" class="form-control" v-model="book.title"/>
          </div>
          <div class="mb-3">
            <label for="author-field" class="form-label">저자</label>
            <input type="text" class="form-control" v-model="book.author"/>
          </div>
          <div class="mb-3">
            <label for="publisher-field" class="form-label">출판사</label>
            <input type="text" class="form-control" v-model="book.publisher"/>
          </div>
          <div class="mb-3">
            <label for="pubdate-field" class="form-label">출판일</label>
            <input type="date" class="form-control" v-model="book.pubDate"/>
          </div>
          <div class="mb-3">
            <label for="price-field" class="form-label">가격</label>
            <input type="number" class="form-control" v-model="book.price"/>
          </div>
          <div class="mb-3">
            <label for="discountprice-field" class="form-label">할인가격</label>
            <input type="number" class="form-control" v-model="book.discountPrice"/>
          </div>
          <div class="mb-3">
            <label for="stock-field" class="form-label">입고량</label>
            <input type="number" class="form-control" v-model="book.stock"/>
          </div>
          <div class="mb-1 text-end">
            <button type="button" class="btn btn-primary" @click="formSubmit">등록</button>
          </div> 
        </form>
      </div>
    </div>
  </main>
</template>

<script>
import BookService from '../service/BookService'

export default {
  name: "BookForm",
  data(){
    return {
      book:{
        title:'',
        author:'',
        publisher:'',
        pubDate:'',
        price: 0,
        discountPrice:0,
        stock:0
      }
    }
  },
  methods: {
    formSubmit() {
      BookService.save(this.book)
        .then(response => {
          if (response.data.success) {
            var title = response.data.item.title;
            alert("["+title+"] 이 등록되었습니다.");
            this.$router.push('/book/list/1');
          } else {
            alert("책 등록 중 오류가 발생하였습니다.");
            this.$router.go();
          }
        })
    }
  }
}
</script>

<style>

</style>