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
			<h1>EL의 연산자</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<h3>empty 연산자</h3>
			<p>${empty loginedUser } : ${loginedUser }</p>
			<!-- 
				loginedUser라는 속성명으로 저장된 속성이 없다. null이 조회된다.
				empty연산자는 속성값이 null이면 true를 반환한다.
			 -->
			<p>${empty cart1 } : ${cart1 }</p>
			<!-- 
				cart1이라는 속성명으로 조회된 값이 null이다.
				empty 연산자는 속성값이 null이면 true를 반환한다. 
			 -->
			<p>${empty cart2 } : ${cart2 }</p>
			<!-- 
				cart2이라는 속성명으로 조회된 값이 길이가 0인 리스트다(비어있는 리스트다)
				empty 연산자는 속성값이 비어있는 List인 경우 true를 반환한다.
			 -->
			<p>${empty cart3 } : ${cart3 }</p>
			<!-- 
				cart3이라는 속성명으로 조회된 값이 객체를 여러개 포함하고 있는 리스트다.
				empty 연산자는 속성값이 객체를 여러개 포함하고 있는 리스트인 경우 false를 반환한다. 
			 -->
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<h3>산술연산자와 비교연산자</h3>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>상품명</th>
						<th>가격</th>
						<th>할인율</th>
						<th>할인가격</th>
						<th>구매수량</th>
						<th>구매금액</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${cart3[0].no }</td>
						<td>${cart3[0].name }</td>
						<td>${cart3[0].price } 원</td>
						<td>${cart3[0].discountRate*100 } %</td>
						<!-- discountRate가 0보다 크면 text-danger가 출력되고 아니면 아무것도 출력되지 않는다.
						삼항연산자는 class checkedbox등 active시킬때 많이 사용한다.  -->
						<td class="fw-bold ${cart3[0].discountRate gt 0 ? 'text-danger' : '' }">${cart3[0].price*(1 - cart3[0].discountRate) }</td>
						<td>${cart3[0].amount }</td>
						<td>${(cart3[0].price*(1 - cart3[0].discountRate))*cart3[0].amount } 원</td>
					</tr>
					<tr>
						<td>${cart3[1].no }</td>
						<td>${cart3[1].name }</td>
						<td>${cart3[1].price } 원</td>
						<td>${cart3[1].discountPerCent } %</td>
						<td class="fw-bold ${cart3[1].discountRate gt 0 ? 'text-danger' : '' }">${cart3[1].discountPrice } 원</td>
						<td>${cart3[1].amount }</td>
						<td>${cart3[1].orderPrice } 원</td>
						<!-- 이렇게 작성해주는 것이 뭘 표현한지 확인가능하고, 소수점도 사라진다.
						getter에 작성해주는 것이 좋다. -->
					</tr>
					<tr>
						<td>${cart3[2].no }</td>
						<td>${cart3[2].name }</td>
						<td>${cart3[2].price } 원</td>
						<td>${cart3[2].discountPerCent } %</td>
						<td class="fw-bold ${cart3[2].discountRate gt 0 ? 'text-danger' : '' }">${cart3[2].discountPrice } 원</td>
						<td>${cart3[2].amount }</td>
						<td>${cart3[2].orderPrice } 원</td>
					</tr>
					<tr>
						<td>${cart3[3].no }</td>
						<td>${cart3[3].name }</td>
						<td>${cart3[3].price } 원</td>
						<td>${cart3[3].discountPerCent } %</td>
						<td class="fw-bold ${cart3[3].discountRate gt 0 ? 'text-danger' : '' }">${cart3[3].discountPrice } 원</td>
						<td>${cart3[3].amount }</td>
						<td>${cart3[3].orderPrice } 원</td>
					</tr>
					<tr>
						<td>${cart3[4].no }</td>
						<td>${cart3[4].name }</td>
						<td>${cart3[4].price } 원</td>
						<td>${cart3[4].discountPerCent } %</td>
						<td class="fw-bold ${cart3[4].discountRate gt 0 ? 'text-danger' : '' }">${cart3[4].discountPrice } 원</td>
						<td>${cart3[4].amount }</td>
						<td>${cart3[4].orderPrice } 원</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
</body>
</html>