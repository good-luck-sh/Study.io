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
			<h1>장바구니</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<table class="table" id="table-cart-items">
				<thead>
					<tr>
						<th><input type="checkbox" id="checkbox-toggle-checked" checked="checked"/></th>
						<th>상품명</th>
						<th>가격</th>
						<th>수량</th>
						<th>구매가격</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" name="itemNo" value="10" checked="checked" /></td>
						<td>iphone 13 pro max</td>
						<td><strong id="price-10">1,500,000</strong> 원</td>
						<td><input type="text" name="amount" id="amount-10" value="1" style="width: 50px;"/><button data-item-no="10" data-btn="update" id="data-change-amount-10">변경</button></td>
						<td><strong class="text-danger" id="order-price-10" data-order-price="1500000">1,500,000</strong> 원</td>
						<td><button data-item-no="10" data-btn="delete">삭제</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="itemNo" value="20" checked="checked" /></td>
						<td>갤럭시z 플립 3</td>
						<td><strong id="price-20">1,700,000</strong> 원</td>
						<td><input type="text" name="amount" id="amount-20"  value="1" style="width: 50px;"/><button data-item-no="20" data-btn="update" id="data-change-amount-20">변경</button></td>
						<td><strong class="text-danger" id="order-price-20"  data-order-price="1700000">1,700,000</strong> 원</td>
						<td><button data-btn="delete">삭제</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="itemNo" value="30" checked="checked" /></td>
						<td>apple watch 7</td>
						<td><strong id="price-30">600,000</strong> 원</td>
						<td><input type="text" name="amount" id="amount-30" value="1" style="width: 50px;"/><button data-item-no="30" data-btn="update" id="data-change-amount-30">변경</button></td>
						<td><strong class="text-danger"  id="order-price-30" data-order-price="600000">600,000</strong> 원</td>
						<td><button data-btn="delete">삭제</button></td>
						<!-- btn의 값이 delete로 정해서 전체적으로 삭제 할 수 있는 값을 가져올 수 있다.  -->
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5" class="text-end">총구매가격</td>
						<td><strong id="total-order-price"></strong> 원</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <script type="text/javascript">
		 //구매수량을 변경하면 구매가격을 계산해서 반영하기
		 //체크여부를 제외하고 일단 갱신되도록 만들어보기 
		 function clickAddOrderPrice(order1,order2,order3){
			 var one = parseInt($(order1).attr('data-order-price'));
			 var two = parseInt($(order2).attr('data-order-price'));
			 var three = parseInt($(order3).attr('data-order-price'));
			 var total = one + two + three;
			 $('#total-order-price').text(total.toLocaleString()); 
		 }
		 
		 
		 $('#data-change-amount-10').click(function(){
			 changeOrderPrice('#amount-10','#price-10','#order-price-10');
			 clickAddOrderPrice('#order-price-10','#order-price-20','#order-price-30');
		 })
		  $('#data-change-amount-20').click(function(){
			 changeOrderPrice('#amount-20','#price-20','#order-price-20');
			 clickAddOrderPrice('#order-price-10','#order-price-20','#order-price-30');
		 })
		  $('#data-change-amount-30').click(function(){
			 changeOrderPrice('#amount-30','#price-30','#order-price-30');
			 clickAddOrderPrice('#order-price-10','#order-price-20','#order-price-30');
		 })
		 
		 var totalOrderPrice = 0;
		 function changeOrderPrice(amount,price,orderPrice){
			 if($(amount).val() < 0){
					alert("숫자를 다시 입력하세요.");
					return;
				}
				 var price = parseInt($(price).text().replace(/,/g,""));
				 var amount = parseInt($(amount).val())
				 var orderprice = price*amount;
				 $(orderPrice).attr('data-order-price',orderprice);
				 $(orderPrice).text(orderprice.toLocaleString());

			 }
		 
		 
		 //총 구매가격을 갱신하는 함수
		 		
 		//총 구매가격 계산해서 반영하기 ,제약사항고려없이 그냥 계산했을 경우 
		var totalOrderPrice = 0;
		 $("strong[data-order-price]").each(function(){
			 var orderPrice = parseInt($(this).data('order-price'));
			 totalOrderPrice += orderPrice;
		  });
		 $("#total-order-price").text(totalOrderPrice.toLocaleString());
		 //toLocaleString() : 3자리마다 콤마 찍기
		 
		 
		 

 </script>
</body>
</html>