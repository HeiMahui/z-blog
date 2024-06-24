<template>
  <div>
    <AppHeader/>
    <BlogContent/>
    <!--    <BackHead/>-->
  </div>

</template>

<script>
import AppHeader from "../components/AppHeader.vue";
import BlogContent  from "@/components/BlogContent.vue";
export default {
  name: 'BlogContentView',
  components: {
    // BackHead,
    BlogContent,
    AppHeader,
  },
  // computed:{
  //   blogContent(){
  //     return this.$route.params;
  //   }
  // }
}
</script>
