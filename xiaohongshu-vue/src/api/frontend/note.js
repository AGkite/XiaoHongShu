import axios from "@/axios";

// 获取笔记列表
export function getNoteList() {
    return axios.get("/note/list");
}