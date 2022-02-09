<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
  <div class="container">
    <a class="navbar-brand" href="/">샘플 애플리케이션</a>
    <button class="navbar-toggler d-lg-none" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavId">
      <ul class="navbar-nav me-auto mt-2 mt-lg-0">
        <li class="nav-item active">
          <a class="nav-link" href="/">홈</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/book/list">책</a>
        </li>
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="/loginform">로그인</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/registerform">회원가입</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/logout">로그아웃</a>
        </li>
      </ul>
    </div>
  </div>
</nav>