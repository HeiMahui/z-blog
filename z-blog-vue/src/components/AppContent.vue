<template>
  <div class="container">

    <div  class="app-content">
      <div
          v-for="(item, index) in items" :key="index" class="center-item" @click="goBlogContentView(item)">
        {{ item.blogTitle}}
      </div>

    </div>

  </div>
</template>

<script>
import request from "@/utils/request";
export default {
  data() {
    return {
      items: [],
    };
  },
  methods: {
    axiosAppContent(){
      request.get("/blog/list")
        .then(Response =>{
          console.log(Response.data)
          this.items=Response.data
        })

    },
    goBlogContentView(item) {
      this.$router.push({ name: 'BlogContentView', params:  item  });

      this.$store.commit("setBlogContent", item)

      console.log(item)
    }
  },
  mounted() {
    this.axiosAppContent();
  }
}
</script>
<style>
  .container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    width: 100vw;

  }
  .app-content{

    width: 60%;
    height: 100%;
    border: 1px solid #d8d4d4;
    box-sizing: border-box;
    padding: 20px;
  }
  .center-item {
    margin: 10px 0;
    padding: 10px;
    border-radius: 8px;
  }
  .center-item:hover {
    background-color: rgba(200, 200, 200, 0.3);
  }


</style>