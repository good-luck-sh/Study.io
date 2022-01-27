<template>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
    <div class="container">
      <ul class="navbar-nav me-auto">
        <!-- 
          링크를 표시할 때 <a>태그 대신 <router-link to="url">링크이름</router-link>
         -->
        <!-- 
          클래스 속성값을 추가할 때
            :class="{클래스: 스크립트표현식}" 혹은 :class="{클래스: 함수}"
            스크립트표현식 혹은 함수의 값이 true일 때 지정된 클래스가 추가된다.
         -->
        <li class="nav-item" :class="{'bg-danger': $route.name == 'Home'}">
          <router-link class="nav-link" to="/">홈</router-link>
        </li>
        <li class="nav-item" :class="{'bg-danger': $route.name == 'BookList'}">
          <router-link class="nav-link" to="/book/list">책</router-link>
        </li>
      </ul>
    </div>
  </nav>
  <router-view />
</template>
<style>

</style>
