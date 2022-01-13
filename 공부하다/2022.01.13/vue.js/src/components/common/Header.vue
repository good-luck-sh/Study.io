<template>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
		<div class="container">
			<ul class="navbar-nav me-auto mb-2">
				<li class="nav-item"><router-link class="nav-link" :class="{active: $route.path == '/'}" to="/">홈</router-link></li>
				<li class="nav-item"><router-link class="nav-link" :class="{active: $route.path.startsWith('/book')}" to="/book/list/1">도서 조회</router-link></li>
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