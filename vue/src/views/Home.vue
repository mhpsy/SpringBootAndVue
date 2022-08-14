<template>
  <div>
    主页
    <el-button type="primary">test EP
      <el-icon><EditPen /></el-icon>
      <el-icon><Delete /></el-icon>
    </el-button>
    <el-icon><CircleCheckFilled /></el-icon>
  </div>
</template>
<script setup>
  import { EditPen,Delete,CircleCheckFilled } from '@element-plus/icons-vue'
</script>