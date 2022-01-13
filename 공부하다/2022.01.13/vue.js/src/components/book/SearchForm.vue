<template>
  <div class="row mb-3">
		<div class="col">
			<form class="row row-cols-lg-auto g-3 align-items-center justify-content-end" >
				<input type="hidden" name="page" value="1" />
				<div class="col-12">
					<select class="form-select" name="opt">
						<option value="" selected disabled="disabled">검색조건을 선택하세요</option>
						<option value="title"> 제목으로 검색</option>
						<option value="autor"> 저자 검색</option>
						<option value="publisher"> 출판사로 검색</option>
						<option value="min"> 최소가격으로 검색</option>
						<option value="max"> 최대가격으로 검색</option>
					</select>
				</div>
				<div class="col-12">
					<input type="text" class="form-control" name="value" >
				</div>
				<div class="col-12">
					<button type="button" class="btn btn-outline-primary btn-sm" >검색</button>
				</div>
			</form>
		</div>
	</div>
</template>

<script>
export default {

}
</script>

<style>

</style>