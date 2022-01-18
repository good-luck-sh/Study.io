<template>
  <div class="row mb-3">
		<div class="col">
			<div class="d-flex justify-content-between">
				<form class="row row-cols-lg-auto g-3 align-items-center justify-content-start" >
					<input type="hidden" name="page" value="1" />
					<div class="col-12">
						<select class="form-select" name="opt">
							<option value="" selected disabled="disabled">검색조건을 선택하세요</option>
							<option value="제목"> 제목으로 검색</option>
							<option value="저자"> 저자 검색</option>
							<option value="출판사"> 출판사로 검색</option>
							<option value="최소가격"> 최소가격으로 검색</option>
							<option value="최대가격"> 최대가격으로 검색</option>
						</select>
					</div>
					<div class="col-12">
						<input type="text" class="form-control" name="value" >
					</div>
					<div class="col-12">
						<button type="button" class="btn btn-outline-primary btn-sm" >검색</button>
					</div>
				</form>
				<router-link class="btn btn-primary btn-sm py-2" to="/book/form">책 등록</router-link>
			</div>
		</div>
	</div>
</template>

<script>
export default {

}
</script>

<style>

</style>