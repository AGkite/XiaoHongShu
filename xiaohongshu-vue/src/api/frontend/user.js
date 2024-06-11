import axios from "@/axios";

// 登录接口
export function login(username, password) {
    return axios.post("/login", {username, password})
}

//获取登录用户名
export function getUserName() {
    return axios.post("/user/name")
}