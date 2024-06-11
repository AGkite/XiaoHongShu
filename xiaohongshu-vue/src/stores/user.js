import { defineStore } from 'pinia'
import { ref } from 'vue'
import { getUserName } from '@/api/frontend/user'
import { removeToken } from '@/utils/cookie'

export const useUserStore = defineStore('user', () => {
  // 用户名
  const userName = ref({})

  // 设置用户名
  function setUserName() {
    // 调用后头获取用户名接口
    getUserName().then(res => {
      if (res.success == true) {
        userName.value = res.data
      }
    })
  }
  //退出登录
  function logout() {
    //删除cookie中的token令牌
    removeToken()
    //删除登录用户信息
    userName.value = {}
  }
  return { userName, setUserName, logout }
},
  {
    //开启持久化
    persist: true,
  })