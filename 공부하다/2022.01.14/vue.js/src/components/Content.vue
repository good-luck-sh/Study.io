<template>
  <div class="container-md mb-3">
      <div class="row mb-3">
        <div class="col">
          <h1>{{ title }}<button class="btn btn-outline-primary btn-sm float-end mt-1" @click="toggleShowForm">새 책 등록</button></h1>
          <!--float는 오른쪽 끝으로 간다는 의미 -->
        </div>
      </div>
      <!-- 
        v-show의 값이 true면 화면에 컨텐츠를 출력하고, false면 화면에 출력하지 않는다.
        v-show는 style의 display 프로퍼티 값을 변경해서 컨텐츠를 보이게 하거나 감춘다.
      -->
       <div class="row mb-3" v-show="showForm">
        <div class="col">
          <p>책 정보를 입력하세요</p>
          <form class="border p-3 bg-light">
            <div class="mb-3">
                <label for="field-title" class="form-label">제목</label>
                <input type="text" class="form-control" id="field-title" v-model="titleValue">
            </div>
            <div class="mb-3">
                <label for="field-author" class="form-label">저자</label>
                <input type="text" class="form-control" id="field-author" v-model="authorValue">
            </div>
            <div class="mb-3">
                <label for="field-price" class="form-label">가격</label>
                <input type="text" class="form-control" id="field-price" v-model="priceValue">
            </div>
            <div class="mb-3 text-end">
                <button class="btn btn-primary" type="button" @click="addBook">등록</button>
            </div>
          </form>
        </div>
      </div>
      <div class="row mb-3">
        <div class="col">
          <table class="table">
            <thead>
                <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>저자</th>
                  <th>가격</th>
                  <th></th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="book in books" :key="book.no">
                  <td>{{ book.no }}</td>
                  <td>{{ book.title }}</td>
                  <td>{{ book. author }}</td>
                  <td>{{ book.price }} 원</td>
                  <td><button class="btn btn-danger btn-sm" @click="removeBook(book.no)">삭제</button></td>
                </tr>
            </tbody>
          </table>
        </div>
      </div>
  </div>
</template>

<script>
export default {//이 함수를 외부로 노출시킨다는 뜻 
  //data() 함수는 컴포넌트 자신의 데이터를 제공한다.
  //data() 함수가 반환하는 객체가 컴포넌트 자신의 데이터다.
  data(){
    return {
      title: "북스토어",
      sequnce:100,
      //책정보 입력필드와 양방향 데이터 바인딩 되는 값
      titleValue:'',
      authorValue:'',
      priceValue:0,
      //책정보 입력폼 표시 여부를 나타내는 값
      showForm:false,//변수명은 마음대로 정의한 것임
      books:[
        {no:11,title:"이것이 자바다",author:"신용권",price:35000},
        {no:12,title:"자바의 정석",author:"김유신",price:30000},
        {no:13,title:"혼자 공부하는 자바",author:"강감찬",price:28000},
        {no:14,title:"나는 자바를 공부하지 않았어요",author:"이순헌",price:33000},
        {no:15,title:"Do it, 자바",author:"홍길동",price:30000}
      ]
    }
  },
  //methods 객체는 사용자정의 함수를 추가하는 곳이다.
  //사용자와 상호작용하는 이벤트 핸들러 함수를 정의한다.
  methods:{
    addBook:function(){
      var book = {no:this.sequnce++, title:this.titleValue, author:this.authorValue, price:this.priceValue};
      this.books.push(book);
      //books객체에 push하고 객체를 입력하는 것이다.[5]배열을 지정해서 넣으면 알아차리지 못한다. 
      //책 정보가 배열에 추가되면 입력필드를 초기화한다.
      this.clearFormField();
    },
    removeBook:function(no){
        //전달받은 책번호와 일치하는 책번호를 가진 책이 배열의 몇번째 인덱스에 저장되어있는지 조회하기
        //배열에서 지정된 값이 몇번째 저장되어 있는지 조회하기 
        // +배열.findIndex(callback)
        // +callback함수가 true를 반환하면 해당 인덱스의 값을 변수에 저장한다.
        // +callback함수는 function(item, prn index) {boolean값을 반환하는 수행문;}
        var removeBookIndex = this.books.findIndex((book) => book.no == no);
        //배열에서 지정된 index위치의 값 한 개 삭제하기 
        //  + 배열.splice(삭제할위치, 삭제할 갯수, 추가할 아이템, 아이템, ...) splice는 삭제하다라는 메소드이다.
        this.books.splice(removeBookIndex,1);
    },
    toggleShowForm: function(){
      this.showForm = !this.showForm;
      //메소드를 this로 호출할 수 있다. 원래의 값을 !으로 변경해준다.
      //입력폼을 숨길 떄 입력필드를 초기화한다. 
      if(!this.showForm) {
        this.clearFormField();
      }
    },
    clearFormField(){ //function없이 이렇게 작성해도 된다.위에처럼 적는게 맞지만 아래처럼 적는것도 허용되고 있다. 
    //등록되고 clear되는것이다.
      this.titleValue = '';
      this.authorValue = '';
      this.priceValue = 0;
    }
  }
}
</script>

<style>

</style>