<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title></title>
</head>
<body>
<div class ="container">
	<div class="row mb-3">
		<div class="col">
			<h1>엘리먼트 조작</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-6">
			<h3>엘리먼트 삭제하기</h3>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>연락처</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
<!-- 
			List<Person> personList = personDao.getAllPersons();
			for(Person person : personList) {
			
			<tr id="row-<=person.getNo()>">
				<td><=person.getName()></td>처럼 만들어서 사용해준다. 
				
				그럼 지우는 버튼은 <td><button class="btn btn-danger btn-sm" onclick="deleteRow('<=person.getNo()>')">삭제</button></td>
				--버튼과 tr을 관련있게 만들어주어야한다. 조회 후 idNo는 무조건 가져와야한다. 이런용도로 사용하기 위해서이다. 유니크하게 아이디를 부여하기 위하여
				갖고 있는 정보를 활용을 해주어야한다. 
				제일 중요한 부분이다. 
				//delete.jsp를 요청해서 테이블에서 삭제하고, 이 페이지로 다시 돌아오는 방식
				<td><a class="btn" href="delete.jsp?no=<=person.getNo()>">삭제</a></td>이렇게 사용한다. 
				//우리는 이것을 많이 사용할 예정이다.
				
 -->				
					<tr id="row-100">
						<td>100</td>
						<td>홍길동</td>
						<td>010-1111-1111</td>
						<td><button class="btn btn-danger btn-sm" onclick="deleteRow('row-100')">삭제</button></td>
						<!-- 클릭하면 td의 내용이 삭제되어야한다. 조작할 곳에는 id를 붙인다.  -->
					</tr>
					<tr id="row-104">
						<td>104</td>
						<td>강감찬</td>
						<td>010-2222-1111</td>
						<td><button class="btn btn-danger btn-sm" onclick="deleteRow('row-104')">삭제</button></td>
					</tr>
					<tr id="row-105">
						<td>105</td>
						<td>김유신</td>
						<td>010-3333-1111</td>
						<td><button class="btn btn-danger btn-sm" onclick="deleteRow('row-105')">삭제</button></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-6">
			<h3>엘리먼트 여러 개 선택해서 삭제하기 </h3>
			<form method="get" action="delete.jsp">
			<table class="table" id="table-person-list">
					<thead>
						<tr>
							<!-- 전체가 선택되게 메소드를 입력한다.  check박스와 radio는 onchange를 사용해야한다. -->
							<th><input type="checkbox" id="ck-all" onchange="toggleCheckbox()"><th>
							<th>번호</th>
							<th>이름</th>
							<th>연락처</th>
							<th></th>
						</tr>
						</thead>
					<tbody>
					<!-- table의 tbody안의 input을 찾으면 된다.( #table-person-list tbody input[name='no'])-->
						<tr>
							<td><input type="checkbox" id="ch-1000" name="no" value="1000"></td>
							<td>1000</td>
							<td>홍길동</td>
							<td>010-1111-1111</td>
							<td><a href="delete.jsp?no=1000" class="btn btn-danger btn-sm">삭제</a></td>
						</tr>
						<tr>
							<td><input type="checkbox" id="ch-1200" name="no" value="1200"></td>
							<td>1200</td>
							<td>홍길동</td>
							<td>010-1111-1111</td>
							<td><a href="delete.jsp?no=1200" class="btn btn-danger btn-sm">삭제</a></td>
						</tr>
						<tr>
							<td><input type="checkbox" id="ch-1300" name="no" value="1300"></td>
							<td>1300</td>
							<td>홍길동</td>
							<td>010-1111-1111</td>
							<td><a href="delete.jsp?no=1300" class="btn btn-danger btn-sm">삭제</a></td>
						</tr>
					</tbody>
				</table>
				<div class="mt-3">
					<button class="btn btn-primary" type="submit">선택삭제</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	//좌측 테이블의 삭제버튼을 클릭할 때마다 실행되는 이벤트 핸들러 함수
	function deleteRow(id) {
		//전달받은 id에 해당하는 엘리먼트를 선택한다.
		var el = document.getElementById(id);
		//엘리먼트를 삭제한다.
		el.remove();
	}
	//아이디를 잘 구성해서 coding을 한다면, 복잡해진다. id를 부여해서 입력하는 방법을 이용한다면 조작하는 방법이 많이 줄어든다. 
	//사용자와 상호작용하는 전체 선택/해제 체크박스의 체크여부가 바뀔때마다 실행되는 이벤트 핸들러 함수다.
	function toggleCheckbox(){	
		//1. 사용자와 상호작용하는 전체선택/ 해제 체크박스의 체크여부를 먼저 알아낸다. 
		//	1-1. 아이디가 ch-all인 엘리먼트를 선택한다.(이 엘리먼트는 체크박스다. )		
		var checkboxAll = document.querySelector("#ck-all");
		//	1-2.체크박스 엘리먼트의 체크 상태를 조회한다. (체크되어 있으면 true, 해제 되어 있으면 false가 조회된다.)
		var currentCheckedStatus = checkboxAll.checked;
		
		//2. 모든 항목의 체크박스를 전체선택/해제 체크박스의 상태와 동일하게 한다. 
		// 	2-1. 아이디가 table-person-list인 엘리먼트를 선택한다. 
		//		 선택된 엘리먼트의 자손 tbody를 선택한다. 
		//		 tbody의 자손 input을 선택한다. 
		//		 input중에서 name이 no인 엘리먼트를 선택한다. 
		var checkboxes = document.querySelectorAll("#table-person-list tbody input[name=no]");
		//배열 전체를 구할 수 있다. 선택지가 높다. input중에서 name이 no인 것을 찾는다.
		//	2-2. 선택된 모든 체크박스를 순서대로 하나씩 꺼낸다.
		for(var i=0; i<checkboxes.length; i++) {	//차이점은 int가 var로 변경되었다.항상for문으로 돌려서 꺼내야한다. 
			var checkbox = checkboxes[i];
			//2-3. 순서대로 하나씩 꺼낸 체크박스의 체크여부를 사용자와 상호작용하는 전체선택 체크박스의 체크여부와 동일하게 한다. 
			checkbox.checked = currentCheckedStatus;
		}
	}
	
</script>
</body>
</html>