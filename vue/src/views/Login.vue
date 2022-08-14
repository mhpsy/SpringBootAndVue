<template>
  <div>
    <div style="width: 500px; margin: 150px auto;">
      <h1 style="text-align: center; margin-bottom: 50px">登 录</h1>
      <el-form :model="LoginUser" :rules="rules" ref="ruleFormRef" margin="150px auto">
        <el-form-item prop="username">
          <el-input v-model="LoginUser.username" :prefix-icon="User"/>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="LoginUser.password" :prefix-icon="Lock" show-password/>
        </el-form-item>
        <el-form-item>
          <el-button type="info" style="width: 100%" @click="login">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>

</template>

<script setup>
import {ref, reactive, getCurrentInstance} from "vue";
import {User, Lock} from "@element-plus/icons-vue"
import {ElMessage, ElNotification} from "element-plus";
import request from "../request.js";

const {proxy} = getCurrentInstance()

const rules = reactive({
  username: [
    {required: true, message: '请输入用户名', trigger: 'blur'},
    {min: 3, max: 10, message: '用户名长度应该在3-10个字符之间', trigger: 'blur'},
  ],
  password: [
    {required: true, message: '请输入密码', trigger: 'blur'},
    {min: 3, max: 16, message: '密码长度应该在3-16个字符之间', trigger: 'blur'},
  ]
})

const LoginUser = reactive({})


const login = () => {
  proxy.$refs.ruleFormRef.validate((valid) => {
    if(valid){
      request.post('/user/login',LoginUser).then(res =>{
        console.log(res)
        if(res.isDelete === 0){ //成功
          ElNotification({
            type: 'success',
            message: '登录成功'
          })
        }else {
          ElNotification({  //失败
            type: 'error',
            message: '用户名或密码错误'
          })
        }
      })
    }else {
      ElNotification({
        type: 'error',
        message: '登录失败'
      })
    }
  })
}


</script>

<style scoped>

</style>