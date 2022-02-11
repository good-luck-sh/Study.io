<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>애플리케이션</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <%@ include file="common/navbar.jsp"%>
    <div class="row mb-3">
        <div class="col">
            <h1>로그인 폼</h1>
        </div>
    </div>
    <div class="row mb-3">
        <div class="col-6">
            <p>이메일과 비밀번호를 입력하세요.</p>
            <form action="/login" method="post" class="border bg-light p-3">
                <sec:csrfInput/>
                <div class="mb-3">
                    <label for="email-field" class="form-label">이메일</label>
                    <input type="text" class="form-control" id="email-field" name="email">
                </div>
                <div class="mb-3">
                    <label for="password-field" class="form-label">비밀번호</label>
                    <input type="password" class="form-control" id="password-field" name="password">
                </div>
                <div class="text-end">
                    <a href="/register" class="btn btn-secondary">회원가입</a>
                    <button class="btn btn-primary">로그인</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
