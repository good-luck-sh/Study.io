/*
 axios는 서버와 HTTP통신을 지원하는 라이브러리다.

 axios의 주요 API
    - axios.get(url)  //GET방식 요청을 서버로 보낸다.   데이터 조회
    - axios.post(url, data) //POST방식 요청을 서버로 보낸다.    데이터 추가
    - axios.put(url, data)  //PUT방식 요청을 서버로 보낸다. 데이터 변경
    - axios.delete(url)     //DELETE 방식 요청을 서버로 보낸다. 데이터 삭제
    *위의 메소드를 실행하면 .then(콜백) .catch(콜백) .then(콜백) 메소드를 포함하고 있는 객체가 반환된다.
    메소드 체이닝이 되는 것이다.
    .then(function(response){...})
    .catch(function(error){...})
    .then(function()) 메소드를 포함하고 있는 (Promise 객체)가 반환된다.
axios의 요청 처리하기 
    axios.get(url) //url로 요청하면 then을 사용할 수 있다.
    .then(function(response){
        //성공적인 응답 핸들링
    })
    .catch(function(error) {
        //에러 응답 핸들링
    })
    .then(function(){
        //항상 실행되는 영역
    })
response
    {
        data: {},       //서버가 제공하는 응답데이터
        status: 200,    //HTTP 응답코드  //우리는 데이터밖에 신경쓰지 않는다.
        statusText:"OK",//HTTP 상태 메세지
        headers:{},     //응답 헤더 정보
        config:{},      //요청할 때 axois가 사용한 구성정보
        request:{}      //이번 응답에 대한 요청정보, web에서 XMLHttpRequest다.
    }
*/
import axios from "axios";

//axios 초기화하기 const는 상수를 의미한다. var라고 해도 된다. 
const http = axios.create({ //axios를 초기화하고 http에 담다.
    baseURL: 'http://localhost:8081/api',//기본링크설정
    withCredentials:false,//인증안보낸다.
    headers:{
        Accept:'application/json', //응답컨텐츠 타입
        'Content-Type':'application/json' //요청컨텐츠 타입
    } //보낼때마다 설정하기 싫어서 만들어놓음
});
export default {
    getAllBooks(){ //메소드를 하나 만들었다.이 메소드를 호출하면
        //서버로 요청보내기
        //요청방식 : GET
        //요청 URL : http://localhost/api/book 
        return http.get("/book"); //get, post, put, delete //이 메소드가 실행된다.
    }
}