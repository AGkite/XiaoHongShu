package com.newone.xiaohongshu.web.service;


import com.newone.xiaohongshu.common.utils.Response;

public interface NoteService {

    /**
     * 查询笔记帖子列表
     *
     * @return 返回笔记帖子列表的响应对象
     */
    Response findNotesList();
}
