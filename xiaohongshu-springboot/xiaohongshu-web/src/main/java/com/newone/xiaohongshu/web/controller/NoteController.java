package com.newone.xiaohongshu.web.controller;

import com.newone.xiaohongshu.common.aspect.ApiOperationLog;
import com.newone.xiaohongshu.common.utils.Response;
import com.newone.xiaohongshu.web.service.NoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/note")
@Api(tags = "帖子模块")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    @ApiOperation(value = "展示帖子列表")
    @ApiOperationLog(description = "展示帖子列表")
    public Response findNoteList() {
        return noteService.findNotesList();
    }

}
