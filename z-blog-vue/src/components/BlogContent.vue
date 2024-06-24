<template>
  <div class="container">
    <div  class="app-content">
      <div class="blog-title">
        <h1>{{this.$store.state.blogContent.blogTitle}}</h1>
      </div>
      <div class="blog-author">
        {{this.$store.state.blogContent.username}}
      </div>
      <div class="blog-content">
        {{this.$store.state.blogContent.blogContent}}
      </div>

      <div class="blog-comment">
        评论：
        <div v-for="comment in allComment" :key="comment.id" class="single-comment">
          <div class="comment-author">
            {{ comment.username}}
          </div>
          <div class="comment-content">
            {{ comment.commentContent }}
          </div>
        </div>
      </div>
      <div>
        发布评论：
        <p></p>
        <el-input

            placeholder="这里是评论区，不是无人区（登陆后即可发布评论）"
            v-model="inputComment"
            clearable>
        </el-input>
        <p></p>
        <div style="display: flex;justify-content: flex-end;" @click="commentIsLogin()"><el-button>评论</el-button></div>
      </div>
    </div>
  </div>
</template>

<script>
// import request from "@/utils/request";

import request from "@/utils/request";

export default {


  data() {
    return {
      allComment:[],
      inputComment:'',
    };
  },
  // props:{
  //   blogContent:{
  //     type:Object,
  //     required: true
  //   }
  // },
  methods: {
    axiosBlogComment(){
      console.log(this.$store.state.blogContent)
      request.post('/comment/all', this.$store.state.blogContent)
          .then(Response => {
            this.allComment=Response.data
            this.inputComment=""
          })
    },
    axiosUserComment(){
      const comment={
        bId:this.$store.state.blogContent.id,
        username:this.$store.state.username,
        commentContent:this.inputComment,
      }
      request.post('/comment/write',comment)
          .then(Request =>{
            console.log(Request)
            console.log(comment),
            this.axiosBlogComment()
          })
    },
    commentIsLogin(){
      if(this.$store.state.isLoggedIn){
        this.axiosUserComment()

      }else{
        this.$message.error("登陆后即可评论")
      }
    }
  },
  mounted() {
    this.axiosBlogComment()
    console.log( "111",this.allComment[0])
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
.blog-author {
  text-align: right;
  font-style: italic;
  margin-bottom: 10px;
}

.blog-content {
  line-height: 1.5;
  word-wrap: break-word;
  white-space: pre-wrap;
}
.blog-comment{
  margin-top: 60px;

}
.single-comment {
  margin-bottom: 15px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}
.comment-author {
  font-weight: bold;
}

.comment-content {
  margin-left: 10px;
  margin-top: 5px;
}
</style>