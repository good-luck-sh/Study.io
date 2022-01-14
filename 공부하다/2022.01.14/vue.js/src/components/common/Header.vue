<template>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
		<div class="container">
			<ul class="navbar-nav me-auto mb-2">
				<li class="nav-item"><router-link class="nav-link" :class="{active: $route.path == '/'}" to="/">홈</router-link></li>
				<li class="nav-item"><router-link class="nav-link" :class="{active: $route.path.startsWith('/book/list')}" to="/book/list">도서 조회</router-link></li>
				<li class="nav-item"><router-link class="nav-link" to="/book/form">책등록</router-link></li>
				<!-- router-link : 페이지의 새로고침 없이 페이지를 바꿔준다. -->
			</ul>
	</div>
</nav>
</template>

<script>
export default {

}
</script>

<style>

</style>