<template>
    <nav class="fixed top-0 z-50 w-full bg-white shadow-lg dark:bg-gray-800 dark:border-gray-700">
        <div class="px-3 py-2 lg:px-5 lg:pl-3 h-[72px]">
            <div class="flex items-center justify-between">
                <div class="flex items-center justify-start rtl:justify-end">
                    <button data-drawer-target="logo-sidebar" data-drawer-toggle="logo-sidebar" aria-controls="logo-sidebar"
                        type="button"
                        class="inline-flex items-center p-2 text-sm text-gray-500 rounded-lg sm:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600">
                        <span class="sr-only">Open sidebar</span>
                        <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20"
                            xmlns="http://www.w3.org/2000/svg">
                            <path clip-rule="evenodd" fill-rule="evenodd"
                                d="M2 4.75A.75.75 0 012.75 4h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 4.75zm0 10.5a.75.75 0 01.75-.75h7.5a.75.75 0 010 1.5h-7.5a.75.75 0 01-.75-.75zM2 10a.75.75 0 01.75-.75h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 10z">
                            </path>
                        </svg>
                    </button>
                    <a href="#" class="flex mt-3 ms-2 md:me-24">
                        <img src="data:image/png;base64,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"
                            class="h-8 me-3" alt="FlowBite Logo" />
                        <span class="text-xl">创作服务平台</span>
                    </a>

                </div>
                <div class="flex items-center justify-end">
                    <!-- 点击全屏展示 -->
                    <el-tooltip class="box-item" effect="dark" content="全屏" placement="bottom">
                        <div class="w-[56px] h-[64px] cursor-pointer flex items-center justify-center text-gray-700 mr-2 hover:bg-gray-200"
                            @click="toggle">
                            <el-icon>
                                <FullScreen v-if="!isFullscreen" />
                                <Aim v-else />
                            </el-icon>
                        </div>
                    </el-tooltip>
                    <!-- 点击刷新页面 -->
                    <el-tooltip class="box-item" effect="dark" content="刷新" placement="bottom">
                        <div class="w-[56px] h-[64px] cursor-pointer flex items-center justify-center text-gray-700 hover:bg-gray-200"
                            @click="handleRefresh">
                            <el-icon>
                                <Refresh />
                            </el-icon>
                        </div>
                    </el-tooltip>
                    <!-- 登录用户头像 -->
                    <el-dropdown>
                        <span class="el-dropdown-link flex items-center justify-center text-gray-700 text-xs">
                            <!-- 头像 Avatar -->
                            <el-avatar class="mr-2" :size="25" src="https://img.howonenew.com/weblog/1.jpg" />
                            <!-- {{ userStore.userInfo.username }} -->
                            <el-icon class="el-icon--right">
                                <arrow-down />
                            </el-icon>
                        </span>
                        <template #dropdown>
                            <el-dropdown-menu>
                                <el-dropdown-item command="updatePassword">修改密码</el-dropdown-item>
                                <el-dropdown-item command="logout">退出登录</el-dropdown-item>
                            </el-dropdown-menu>
                        </template>
                    </el-dropdown>
                    <!-- 修改密码 -->
                    <el-dialog title="修改密码" width="40%" :draggable="true" :close-on-click-modal="false"
                        :close-on-press-escape="false">
                        <span>This is a message</span>
                        <template #footer>
                            <span class="dialog-footer">
                                <el-button>取消</el-button>
                                <el-button type="primary">
                                    提交
                                </el-button>
                            </span>
                        </template>
                    </el-dialog>
                </div>
            </div>
        </div>
    </nav>
</template>

<script setup>
// 引入 useFullscreen
import { useFullscreen } from '@vueuse/core'

// isFullscreen 表示当前是否处于全屏；toggle 用于动态切换全屏、非全屏
const { isFullscreen, toggle } = useFullscreen()

// 刷新页面
const handleRefresh = () => location.reload()
</script>

<style scoped></style>