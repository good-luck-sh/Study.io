<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
	<div class="container">
		<a class="navbar-brand" href="/search-app/index.jsp">CRUD 샘플 애플리케이션</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-bs-toggle="collapse" data-bs-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav me-auto mt-2 mt-lg-0">
				<li class="nav-item active">
					<a class="nav-link" href="/search-app/index.jsp">홈</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/search-app/board/list.jsp">게시글 목록</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/search-app/board/form.jsp">게시글 쓰기</a>
				</li>
			</ul>
		</div>
	</div>
</nav>