<template>
  <main>
    <div class="row-mb-3">
		<div class="col">
			<table class="table">
				<tbody>
					<tr>
						<th style="width: 10%;">등록일</th>
						<td style="width: 40%;">2022년 1월 1일 오전 10시 10분 10초</td>
						<th style="width: 10%;">최종 수정일</th>
						<td style="width: 40%;">2022년 1월 1일 오전 10시 10분 10초</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3">스프링부트와 Vue.js를 활용한 실전 SPA 프로젝트</td>
					</tr>
					<tr>
						<th>저자</th>
						<td>홍길동</td>
						<th>출판사</th>
						<td>강감찬</td>
					</tr>
					<tr>
						<th>할인가격</th>
						<td><strong class="text-danger">32,000 원</strong></td>
						<th>가격</th>
						<td>35,000 원</td>
					</tr>
					<tr>
						<th>출판일자</th>
						<td>2022년 1월 1일</td>
						<th>도서 재고</th>
						<td>100 권</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row mb-5 ">
    <div class="col text-end">
      <router-link to="/book/list/1" class="btn btn-primary">목록</router-link>
    </div>
	</div>
  </main>
</template>

<script>
export default {

}
</script>

<style>

</style>