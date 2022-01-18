<template>
  <div>
    <Header />
    <Content />
    <Footer />
  </div>
</template>
<script>
import Header from './components/common/Header.vue';
import Content from './components/common/Content.vue';
import Footer from './components/common/Footer.vue';

export default {
  name: 'App',
  components: {
    Header, Content, Footer
  }
}
</script>

<style>
</style>
