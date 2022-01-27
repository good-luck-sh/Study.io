<template>
  <main>
  <main class="container">
    <div class="row mb-3">
      <div class="col">
        <h1 class="fs-3">도서 등록폼</h1>
      </div>
    </div>
    <div class="row mb-3">
      <div class="col">
        <form class="row g-3 border p-3 bg-light">
          <div class="col-12">
            <label class="form-label">제목</label>
            <input type="text" class="form-control" v-model="book.title"/>
          </div>
          <div class="col-6">
            <label class="form-label">저자</label>
            <input type="text" class="form-control"  v-model="book.author"/>
          </div>
          <div class="col-6">
            <label class="form-label">출판사</label>
            <input type="text" class="form-control"  v-model="book.publisher"/>
          </div>
          <div class="col-4">
            <label class="form-label">가격</label>
            <input type="text" class="form-control"  v-model="book.price"/>
          </div>
          <div class="col-4">
            <label class="form-label">할인가격</label>
            <input type="text" class="form-control"  v-model="book.discountPrice"/>
          </div>
          <div class="col-4">
            <label class="form-label">입고수량</label>
            <input type="text" class="form-control"  v-model="book.amount"/>
          </div>
          <div class="col-12">
            <label class="form-label">내용</label>
            <textarea rows="5" class="form-control"  v-model="book.description"></textarea>
          </div>
          <div class="col-12 text-end">
            <button type="button" class="btn btn-primary" @click="insertBook">등록</button>
          </div>
        </form>
      </div>
    </div>
  </main>
  </main>
</template>

<script>
import axios from 'axios'

export default {
  name: "BookForm",
  data() {
    return {
      // 입력폼의 입력요소와 양방향 데이터 바인딩되는 객체 혹은 프로퍼티를 정의한다.
      book: {
        title:'',
        author:'',
        publisher:'',
        description:'',
        price:'',
        discountPrice:'',
        amount:'',
      }
    }
  },
  methods: {  // methods는 컴포넌트 안에서 사용되는 메소드를 정의하는 곳이다.
    // 등록버튼을 클릭했을 때 실행되는 요청핸들러 메소드다.
    insertBook() {
      // axios.post(url, data, config) 
      // axios는 서버와 비동기통신(ajax 통신을 수행하는 라이브러리다.)
      // axios.post(url, data, config) 메소드는 서버로 post 방식 요청을 보낸다.
      // axios.post(url, data, config) 메소드는 .then(콜백) 메소드와 .catch(콜백) 메소드의
      // 콜백함수를 실행한다.
      // 성공적인 응답이 오면 .then(콜백)의 콜백을 실행하고, 요청이 실패하면 .catch(콜백) 메소드의 콜백함수를 실행한다.
      // .then(function(response) { ... })의 콜백함수는 서버의 응답을 response로 전달받는다.
      // response객체는 다양한 프로퍼티를 갖고 있으며, response.data는 서버가 보낸 응답컨텐츠를 반환한다.
      // response.data = {success:true, message:null}
      axios.post("/books", this.book, {
        baseURL: 'http://localhost',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json'
        }
      })
      .then(response => {
        if (response.data.success) {
          // this.$router.push(url)는 location.href=url과 같은 역할을 수행한다.
          // 브라우저 주소창의 url을 변경한다.
          // this.$route는 라우팅정보를 제공하는 객체
          // this.$router은 페이지 이동을 지원하는 메소드를 제공하는 객체
          this.$router.push('/book/list')
        }
      })
    }
  }
}
</script>

<style>

</style>