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
                        <button type="button" class="btn btn-primary" @click="formSubmit">등록</button></div> 
                </form>
            </div>
        </div>
    </main>
</template>

<script>
import BookService from '../service/BookService';//2.다른 컴포넌트를 호출한다.
export default { //컴포넌트에서 나오는 데이터는 그냥 data메소드로 반환하는 값에 작성해야한다.//v-model :양방향
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
    methods:{ //사용자와 상호작용하는 이벤트 핸들러를 등록한다.중요!!
        formSubmit(){ //1.메소드를 설정한다
            BookService.inserBook(this.book)//3.bookservice를 호출하고 return된 this.data를 보낸다.
            .then(response => {
                alert(response.data.title + "등록되었습니다."); //response.data에 정보가 들어있다.
                //지정된 경로로 이동시킨다. $router인 특수함수로 이동하면 된다. push는 이동한다는 것이다.
                this.$router.push('/book/list/1'); 
            }) //4.성공하면 응담으로 데이터를 보낸다.
            .catch(()=>alert("책 정보 등록 중 오류가 발생하였습니다."))
            //페이지를 이동시킨다.$는 vue의 특수목적 이다. router가 지정된 곳으로 이동시킨다.
        }
    }
}
</script>

<style>

</style>