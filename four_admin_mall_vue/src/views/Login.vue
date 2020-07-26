<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>登录</span>
      </div>
      <el-form ref="loginForm" :rules="rules" :model="form" label-width="80px">
        <el-form-item label="账号" prop="username">
          <el-input v-model="form.username" placeholder="请输入账号"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="form.password" placeholder="请输入密码" show-password></el-input>
        </el-form-item>
        <el-form-item>
          <el-checkbox v-model="form.rem" label="记住密码"></el-checkbox>
        </el-form-item>
        <el-button-group>
          <el-button type="primary" @click="login" :loading="isLoading">登陆</el-button>
          <el-button type="primary" @click="reset">重置</el-button>
        </el-button-group>
      </el-form>
    </el-card>
  </div>
</template>

<script>
  import {api_login} from '@/network/api/admin'

  export default {
    name: "Login",
    data() {
      return {
        isLoading: false,
        form: {
          username: '',
          password: '',
          rem: false
        },
        rules: {
          username: [
            {required: true, message: '请输入账号', trigger: 'blur'},
            {min: 3, max: 20, message: '长度在3到20之间', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {min: 6, max: 18, message: '长度在6到18之间', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      login() {
        this.isLoading = true
        this.$refs.loginForm.validate(async (valid) => {
          if (!valid) {
            console.log('验证失败');
            return false;
          }
          console.log('验证成功');
          const res = await api_login(this.form.username, this.form.password)
          this.isLoading = false
          if (res.code !== 200) {
            this.$message.error(res.message)
            return true
          }
          this.$message.success(res.message)
          const data = res.data;
          if (!data) return false
          const token = data.tokenHead + data.token
          window.sessionStorage.setItem('token', token)
          if (this.form.rem) {
            this.$cookies.set('username', this.form.username, '7D')
            this.$cookies.set('password', this.form.password, '7D')
          } else {
            this.$cookies.remove('username')
            this.$cookies.remove('password')
          }
          await this.$router.replace('/home')
        })
      },
      reset() {
        this.$refs['loginForm'].resetFields();
      }
    },
    created() {
      this.form.username = this.$cookies.get('username')
      this.form.password = this.$cookies.get('password')
    }
  }
</script>

<style scoped>
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both;
  }

  .box-card {
    width: 480px;
    margin: auto;
    transform: translateY(50%);
  }

  .el-button-group {
    width: 100%;
  }

  .el-button-group > .el-button {
    width: 50%;
  }
</style>
