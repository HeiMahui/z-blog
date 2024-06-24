<template>
  <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
    <el-menu-item index="1" @click="goHomeView()">首页</el-menu-item>
    <el-submenu index="2">
      <template slot="title">分类</template>
      <el-menu-item index="2-1">下次一定</el-menu-item>
      <el-menu-item index="2-2">下次一定</el-menu-item>
      <el-menu-item index="2-3">下次一定</el-menu-item>
      <el-submenu index="2-4">
        <template slot="title">下次一定</template>
        <el-menu-item index="2-4-1">下次一定</el-menu-item>
        <el-menu-item index="2-4-2">下次一定</el-menu-item>
        <el-menu-item index="2-4-3">下次一定</el-menu-item>
      </el-submenu>
    </el-submenu>
    <div class="spacer"></div>
    <el-button id="editBlog" icon="el-icon-edit" :disabled = "isDisabled" circle @click="goBlogReleaseView()" ></el-button>
    <el-button v-if="!isLoggedIn"  round @click="dialogFormVisible = true">登录</el-button>
    <el-button v-else type="danger" round @click="dialogVisible = true">登出</el-button>

    <el-dialog title="登录" :visible.sync="dialogFormVisible" :close-on-click-modal="false">
      <el-form :model="form">
        <el-form-item label="用户名" :label-width="formLabelWidth">
          <el-input v-model="form.username" autocomplete="off" placeholder="中/英文都可以"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="form.password" type="password" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="axiosLogin">登 录 / 注 册</el-button>
      </div>
    </el-dialog>

    <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        width="30%"
        :before-close="handleClose"
        :close-on-click-modal="false">
      <span>真的要退出登录吗</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="confirmLogout">确 定</el-button>
  </span>
    </el-dialog>

  </el-menu>
</template>

<script>
import request from "@/utils/request";

export default {
  data() {
    return {
      loginData:[], // 前后端交互内容
      activeIndex: '1',
      isLoggedIn: this.$store.state.isLoggedIn, // 登录状态
      isDisabled: !this.$store.state.isLoggedIn, // 发布按钮状态
      dialogFormVisible: false,
      dialogVisible: false,
      form: {
        username: '',
        password: '',
      },
      formLabelWidth: '120px',
    };
  },
  methods: {
    axiosLogin(){
      const user = {
        username: this.form.username,
        password: this.form.password
      };
      request.post('/user/login', user)
              .then(Response => {
            this.loginData=Response.data
            console.log(this)
            if (this.loginData === "创建成功" || this.loginData === "登陆成功"){
              this.confirmLogin()
              this.$message.success(this.loginData)
            }else{
              this.$message.error(this.loginData)
            }
            console.log(Response.data)
          })
          // .catch(error => {
          //   console.error('错误:', error);
          // })
    },
    goHomeView(){
      if (this.$router.currentRoute.path === "/") {
        this.$notify({
          title: '提示',
          message: this.$createElement('i', { style: 'color: teal'}, '已经在首页了')
        });
      }else {
        this.$router.push('/');
      }
    },
    goBlogReleaseView() {
      if (this.$router.currentRoute.path === "/release") {
        this.$notify({
          title: '提示',
          message: this.$createElement('i', { style: 'color: teal'}, '发布博客界面了')
        });
      }else {
        this.$router.push('/release');
      }
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
          //取消eslint警告
          // eslint-disable-next-line no-unused-vars
          .then(_ => {
            done()
          })
          // eslint-disable-next-line no-unused-vars
          .catch(_ => {})
    },
    login() {
      this.isDisabled = false // 发布按钮状态
      this.isLoggedIn = true // 登录状态
      this.$store.commit("setIsLoading", this.isLoggedIn)

    },
    logout() {
      this.isDisabled = true
      this.isLoggedIn = false
      this.$store.commit("setIsLoading", this.isLoggedIn)
    },
    confirmLogin() {
      if (this.form.username && this.form.password) {
        this.login() // 调用login方法
        this.$store.commit("setUsername", this.form.username)
        this.dialogFormVisible = false // 关闭对话框
      } else {
        this.$message.error('请填写完整的用户名和密码')
      }
    },
    confirmLogout() {
      this.dialogVisible = false
      this.logout()
      if (this.$router.currentRoute.path !== "/") {
        this.$router.push('/');
      }
    }
  },
  mounted() {

  }
}
</script>

<style scoped>

.el-menu-demo {
  flex: 1;
  display: flex;
  align-items: center;
}

.spacer {
  margin-left: auto;
}
</style>