<template>
  <div class="container">
    <div  class="app-content">
      <div class="blog-title">
        <el-input v-model="blogTitle" placeholder="请输入标题内容"></el-input>
      </div>
      <div class="blog-content">
        <textarea v-model="blogContent" style="width: 100%; height: 700px">

        </textarea>
      </div>
      <div style="display: flex; justify-content: center;">
        <input type="submit" value="发布" @click="axiosSubmitBlog">
      </div>
    </div>

  </div>
</template>
<script>
import request from "@/utils/request";

export default {
  data() {
    return {
      BData: '',
      blogTitle: '',
      blogContent: '',
    }
  },
  methods:{
    axiosSubmitBlog(){
      const blog = {
        username: this.$store.state.username,
        blogTitle: this.blogTitle,
        blogContent: this.blogContent,
      };
      request.post('/blog/create', blog)
          .then(Response => {
            this.BData=Response.data
            this.$message.success(this.BData)
            this.$router.push('/')
          })
    }

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
.blog-title {
  text-align: center;
  margin-bottom: 20px;
}
.blog-content {
  line-height: 1.5;
}
</style>