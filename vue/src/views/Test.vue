<template>
  <div>
    登录{{ msg }}
    <br>
    名字：{{ user.name }}
  </div>
  <el-button @click="changeMsg('改变')">changeRef</el-button>
  <el-button @click="changUser('张三')">changeReactive</el-button>
</template>

<script setup>
import {ref, reactive} from 'vue'

const msg = ref("测试")

const changeMsg = (args) => {
  msg.value = args  //通过这种方式来赋值
}

const user = reactive({
  name: '名字'
})

const changUser = (name) => {
  user.name = name
}

</script>
