<template>
  <div class="row mb-5">
    <div class="col">
      <nav v-show="this.pageRange.length">
        <ul class="pagination justify-content-center">
          <li class="page-item" :class="{disabled: !this.existPrev}"><router-link class="page-link" :to="`/book/list/${this.prevPage}`">이전</router-link></li>
          <li class="page-item" v-for="num in pageRange" :key="num" :class="{active: this.$route.params.no == num}"><router-link class="page-link"  :to="`/book/list/${num}`">{{num}}</router-link></li>	    			
          <li class="page-item" :class="{disabled: !this.existNext}"><router-link class="page-link" :to="`/book/list/${this.nextPage}`">다음</router-link></li>
        </ul>
      </nav>
    </div>
  </div>
</template>

<script>
export default {
  name: "Pagination",
  props: ["pagination"],
  data() {
    return {
      pageRange: [],
      existPrev: false,
      existNext: false,
      prevPage: 0,
      nextPage: 0,
    }
  },
  beforeUpdate() {
    this.pageRange = [];
    if (this.pagination && this.pagination.totalPages) {
      Array.from({length: this.pagination.endPage - this.pagination.beginPage + 1}, (_, index) => index + this.pagination.beginPage)
        .forEach(value => this.pageRange.push(value));
      this.existPrev = this.pagination.existPrev;
      this.existNext = this.pagination.existNext;
      this.prevPage = this.pagination.prevPage;
      this.nextPage = this.pagination.nextPage;
    } else {
      this.pageRange = [];
    }  
  }
}
</script>

<style>

</style>