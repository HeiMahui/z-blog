<template>
  <div>
    <AppHeader/>
    <AppContent/>
<!--    <BackHead/>-->
  </div>

</template>

<script>
  import AppHeader from "../components/AppHeader.vue";
  import AppContent from "@/components/AppContent.vue";
  export default {
    name: 'HomeView',
    components: {
      // BackHead,
      AppContent,
      AppHeader,
    }
  }
</script>
