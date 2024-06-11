<template>
    <Header></Header>
    <aside id="logo-sidebar"
        class="fixed top-0 left-0 w-64 h-screen pt-20 transition-transform -translate-x-full bg-white border-r border-gray-200 sm:translate-x-0 dark:bg-gray-800 dark:border-gray-700"
        aria-label="Sidebar">
        <div class="h-full px-3 pb-4 overflow-y-auto bg-white dark:bg-gray-800">
            <ul class="space-y-2">
                <li>
                    <a href="#"
                        class="flex items-center p-2 text-gray-900 rounded-2xl dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
                        <svg t="1716110813920" class="icon w-5 h-5" viewBox="0 0 1024 1024" version="1.1"
                            xmlns="http://www.w3.org/2000/svg" p-id="30778" width="200" height="200">
                            <path
                                d="M409.6 665.6h204.8v358.4H409.6z m599.38816-189.80864l-460.8-460.8a51.2 51.2 0 0 0-72.3968 0l-460.8 460.8a51.2 51.2 0 0 0 72.3968 72.3968l15.01184-14.99136V972.8a51.2 51.2 0 0 0 51.2 51.2h153.6v-102.4h-102.4V430.7968l307.2-307.2 307.2 307.2V921.6h-102.4v102.4h153.6a51.2 51.2 0 0 0 51.2-51.2V533.1968l14.99136 14.99136a51.2 51.2 0 0 0 72.3968-72.3968z"
                                p-id="30779" fill="#2c2c2c"></path>
                        </svg>
                        <span class="ms-3 text-lg font-semibold">发现</span>
                    </a>
                </li>
                <li>
                    <a @click="router.push('/')"
                        class="flex items-center p-2 text-gray-900 rounded-2xl dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
                        <svg t="1716109800182" class="icon w-5 h-5" viewBox="0 0 1024 1024" version="1.1"
                            xmlns="http://www.w3.org/2000/svg" p-id="14571" width="200" height="200">
                            <path
                                d="M842 62H182c-66 0-120 54-120 120v660c0 66 54 120 120 120h660c66 0 120-54 120-120V182c0-66-54-120-120-120z m30 750c0 33-27 60-60 60H212c-33 0-60-27-60-60V212c0-33 27-60 60-60h600c33 0 60 27 60 60v600z"
                                fill="" p-id="14572"></path>
                            <path
                                d="M737 467H557V287c0-24.8-20.2-45-45-45s-45 20.2-45 45v180H287c-24.8 0-45 20.2-45 45s20.2 45 45 45h180v180c0 24.8 20.2 45 45 45s45-20.2 45-45V557h180c24.8 0 45-20.2 45-45s-20.2-45-45-45z"
                                fill="" p-id="14573"></path>
                        </svg>
                        <span class="ms-3 text-lg font-semibold">发布</span>
                    </a>
                </li>
                <li>
                    <a href="#"
                        class="flex items-center p-2 text-gray-900 rounded-2xl dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
                        <svg t="1716110678422" class="icon w-5 h-5" viewBox="0 0 1024 1024" version="1.1"
                            xmlns="http://www.w3.org/2000/svg" p-id="16884" width="200" height="200">
                            <path
                                d="M512.64 0a42.666667 42.666667 0 0 1 42.56 39.466667l0.128 3.2-0.021333 49.92c173.226667 15.573333 307.584 176.576 307.584 370.773333v126.72c0 54.954667 18.176 107.733333 50.602666 147.733333l17.408 21.482667c37.738667 46.549333 8.277333 121.706667-53.610666 121.706667h-188.202667a180.074667 180.074667 0 0 1-345.109333 0H155.733333c-61.888 0-91.349333-75.178667-53.589333-121.706667l17.408-21.504c32.426667-39.978667 50.581333-92.757333 50.581333-147.712v-126.72c0-191.296 130.389333-350.357333 299.84-369.962667V42.666667a42.666667 42.666667 0 0 1 42.666667-42.666667z m83.413333 881.002667h-159.082666a94.656 94.656 0 0 0 159.104 0zM527.765333 176.704H512.64l-0.469333-0.021333h-6.890667c-134.741333 0-246.485333 123.605333-249.728 279.68l-0.085333 7.018666v126.698667c0 74.261333-24.704 146.048-69.610667 201.429333l-3.392 4.138667h668.074667l-3.328-4.117333c-43.2-53.269333-67.712-121.685333-69.546667-192.896l-0.106667-8.554667v-126.72c0-159.36-113.045333-286.656-249.813333-286.656z"
                                fill="#000000" p-id="16885"></path>
                        </svg>
                        <span class="ms-3 text-lg font-semibold">通知</span>
                    </a>
                </li>
                <li v-if="Object.keys(userStore.userName).length">
                    <a href="#"
                        class="flex items-center p-2 text-gray-900 rounded-2xl dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
                        <img src="" alt="avatar" />
                        <span class="ms-3 text-lg font-semibold">我</span>
                    </a>
                </li>
                <li v-else>
                    <button type="button" @click="showLoginModal"
                        class="bg-[#ff2442] hover:bg-red-800 focus:outline-none focus:ring-4 focus:ring-red-300 text-white font-semibold rounded-full text-base w-full px-5 py-2.5 text-center me-2 mb-2">登录</button>
                </li>

            </ul>
        </div>
    </aside>

    <!-- 登录弹窗 -->
    <div class="overlay" v-show="showWith && !Object.keys(userStore.userName).length">
        <el-button class="close" @click="showLoginModal" plain round>
            <el-icon size="x-large">
                <Close />
            </el-icon>
        </el-button>
        <LoginModal @changeShow="showLoginModal"></LoginModal>
    </div>
<!-- // @changeShow="showWith && !isLogined" -->
    <!-- 帖子列表 -->
    <div class="grid grid-cols-4 gap-4 text-sm absolute left-[280px] top-[138px]">
        <div class="inline-block w-auto h-auto" v-for="item in noteList" :key="item.noteId">
            <a href="#">
                <img class="rounded-2xl transition-opacity duration-300 ease-in-out hover:opacity-50"
                    :src="item.imageUrl[0]" :alt="item.title" />
                <p class="py-2">{{ item.title }}</p>
                <div class="flex justify-between">
                    <div>
                        <img class="w-7 h-7 rounded-full mr-2 inline" :src="item.avatar" :alt="item.author">
                        <span>{{ item.username }}</span>
                    </div>
                    <span>❤️{{ item.loveNum }}</span>
                </div>
            </a>
        </div>
    </div>

    <!-- 返回顶部 -->
    <ScrollToTopButton></ScrollToTopButton>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { initCollapses } from 'flowbite'
import { Close } from '@element-plus/icons-vue'
import { useUserStore } from '@/stores/user'
import { showMessage } from '@/utils/util'
import Header from '@/components/frontend/Header.vue'
import ScrollToTopButton from '@/components/frontend/ScrollToTopButton.vue'
import LoginModal from '@/components/frontend/LoginModal.vue'
import { getNoteList } from '@/api/frontend/note'

const router = useRouter()

// 初始化 flowbit 相关组件
onMounted(() => {
    initCollapses();
    getNote()
})

// 获取笔记列表
const noteList = ref([])

const getNote = async () => {
    const response = await getNoteList()
    noteList.value = response.data
    console.log(response.data)
}

// 登录弹窗
const showWith = ref(false)
const showLoginModal = () => {
    showWith.value = !showWith.value
}

// 是否登录，通过 userStore 中的 userInfo 对象是否有数据来判断
const userStore = useUserStore()
// 获取 userInfo 对象所有属性名称的数组
// const keys = Object.keys(userStore.userName)
// console.log('keys',keys);
// 若大于零，则表示用户已登录
// const isLogined = ref(keys.length > 0)
// console.log("isLogined:",isLogined.value)
// console.log("userStore.userName:",userStore.userName.username)

// 退出登录
const logout = () => {
    userStore.logout()
    // 标记为未登录
    isLogined.value = false
    showMessage('退出登录成功')
}

</script>

<style scoped>
.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* 设置透明度的背景色 */
  z-index: 9999; /* 设置一个较大的z-index值，确保图层位于其他内容之上 */
}

.close {
  border: 0;
  position: absolute;
  left: 73%;
  top: 18%;
  background-color: #fff;
  z-index: 1000; /* 设置一个较大的z-index值，确保图层位于其他内容之上 */
}</style>