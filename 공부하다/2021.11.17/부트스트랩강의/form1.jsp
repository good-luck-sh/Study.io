<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>부트스트랩</title>
</head>
<body>
<div class ="container">
	<div class="row">
		<div class="col">
		<h1>부트스트랩의 기본 폼</h1>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<form class="border p-3 bg-light" method="post" action="register.jsp">
				<div class="mb-3">
					<label class="form-label" for="user-name">사용자명</label>
					<!-- label에 for속성으로 적기를 권장하고있다. -->
					<input type="text" class="form-control" name="username">
				</div>
				 <div class="mb-3">
					 <label class="form-label"for="user-email">이메일</label>
					<input type="email" class="form-control" name="email">
				 </div>
				 <div class="mb-3">
					 <label class="form-label"for="user-password">비밀번호</label>
					<input type="password" class="form-control" name="password">
					<!-- 입력 크기값을 100 맞춘다. -->
					<div class="mb-3">
					 <label class="form-label" for="user-career">경력사항</label>
					 <select class="form-select" name="career" id="user-career">
					 <!-- 
					 나중에 자바스크립트를 사용하기 위해서 id를 작성하는 것이 좋다. 
					 name은 엘리먼트를 식별하기 위하여 사용하기 떄문에 id와 name을 동일하게 작성해도 상관은없다.
					 id에는 -하이픈을 붙여서 합성어를 연결해주는 것이 좋다.id와 class를 작성할 때 방법을 적어야
					 자바스크립트시에 변수명과 헷깔리지 않는다. 
					  -->
						<option value="" selected disabled="disabled">경력사항을 선택하세요</option>
						<option value="0">신입</option>
						<option value="1">1년이상</option>
						<option value="3">3년이상</option>
						<option value="5">5년이상</option>
						<option value="7">7년이상</option>
						<option value="10">10년이상</option>
					 </select>
				 	</div>
				 	<div class="mb-3">
				 		<div class="form-check form-check-inline" >
					 		<input class="form-check-input" type="radio" name="jobType" id="job-type-1" value="R" checked />
					 		<label class="form-check-label" for="job-type-1">정규직</label>
				 		</div>
				 		<div class="form-check form-check-inline" >
					 		<input class="form-check-input" type="radio" name="jobType" id="job-type-2" value="T" />
					 		<label class="form-check-label" for="job-type-2">정규직</label>
				 		</div>
				 	</div>
				 	<div class="mb-3">
				 		<label class="form-label">보유 기술</label>
				 		<div class="form-check form-check-inline" >
					 		<input class="form-check-input" type="checkbox" name="skill" id="skill-1" value="java" />
					 		<label class="form-check-label" for="skill-1">java</label>
				 		</div>
				 		<div class="form-check form-check-inline" >
					 		<input class="form-check-input" type="radio" name="skill" id="skill-2" value="c" />
					 		<label class="form-check-label" for="skill-2">c</label>
				 		</div>
				 		<div class="form-check form-check-inline" >
					 		<input class="form-check-input" type="radio" name="skill" id="skill-3" value="python" />
					 		<label class="form-check-label" for="skill-3">python</label>
				 		</div>
				 		<div class="form-check form-check-inline" >
					 		<input class="form-check-input" type="radio" name="skill" id="skill-4" value="javascript" />
					 		<label class="form-check-label" for="skill-4">javascript</label>
				 		</div>
				 		<div class="form-check form-check-inline" >
					 		<input class="form-check-input" type="radio" name="skill" id="skill-5" value="sql" />
					 		<label class="form-check-label" for="skill-5">sql</label>
				 		</div>
				 	</div>
				 	<div class="mb-3">
				 		
				 		<label class="form-label" for="career-file">경력증명서</label>
				 		<input type="file" class="form-control" name="file" id="career-file">
				 		<div class="form-text">경력증명서는 압축파일로 만들어서 업로드 해주시기 바랍니다.</div>
				 		<!-- 도움막을 작성할 떄 form-text로 작성이 가능하다. -->
				 	</div>
				 	<div class="mb-3">
				 		<label class="form-label" for="user-prifile">자기 소개</label>
				 		<textarea rows="5" class="form-control" name="profile" id="user-prifile"></textarea>
				 	</div>
				 	<div class="mb-3 text-end">
				 		<button class="btn btn-primary btn-lg">등록</button>
				 	</div>
				 </div>
			</form>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
</body>
</html>