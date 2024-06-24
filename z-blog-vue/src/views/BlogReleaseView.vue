<template>
  <div>
    <AppHeader/>
    <BlogRelease/>

  </div>
</template>

<script>
import AppHeader from "../components/AppHeader.vue";
import BlogRelease from "@/components/BlogRelease.vue";
export default {
  name: 'HomeView',
  components: {
    BlogRelease,
    // BackHead,
    AppHeader,
  }
}
</script>
