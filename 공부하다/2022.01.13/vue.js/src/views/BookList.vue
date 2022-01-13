<template>
  <main>
    <SearchForm />
    <!-- 
        :bookList="books"
          :bookList는 List컴포넌트(자식컴포넌트)에서 부모 컴포넌트가 전해줄 데이터를 전달받을 props의 이름이다.
          books는 이 컴포넌트가 자식 컴포넌트에게 전달할 데이터가 저장된 프로퍼티다.
    -->
    <List :bookList="books"/>
    <Pagination />
  </main>
</template>

<script>
//이 컴포넌트에서 사용하는 자식 컴포넌트를 import한다.
import SearchForm from "../components/book/SearchForm.vue";
import List from '../components/book/List.vue';
import Pagination from '../components/common/Pagination.vue'
//이 컴포넌트에서 사용하는 공통기능(서비스)이 구현된 객체를 import한다.
import BookService from '../service/BookService';
export default {
  name: "BookList", //name은 이 컴포넌트의 이름을 지정한다. 
  components: {   //componects는 이 컴포넌트가 사용하는 자식 컴포넌트를 지정한다. 
    SearchForm,
    List,
    Pagination
  }, data(){  //자식에게 전달하기 위해서 책정보를 전달한다.
    return{
      books:[]
    }
  },created(){ 
  //created()는 서버와 통신해서 컴포넌트의 초기 데이터를 가져오는 작업을 수행하기 적절한 라이프사이클 메소드다.  
    //vue컴포넌트의 라이프사이클메소드다. vue컴포넌트 객체가 생성되었고, data에 접근할 수 있지만, 아직 화면에 마운트 되지는 않았다. 
    BookService.getAllBooks()
    .then(response => this.books = response.data) //response.data에 들은 값을 this.books에 담는다.
    .catch(error => console.log(error))
    .then(() => console.log('서버로 부터 응답이 왔다.'))
  }
}
</script>

<style>

</style>