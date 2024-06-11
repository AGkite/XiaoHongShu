package com.newone.xiaohongshu.web.model.vo.note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteRspVO {
    /**
     * 发帖用户
     */
    private String username;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     *  贴子id
     */
    private Long noteId;
    /**
     * 帖子标题
     */
    private String title;
    /**
     * 帖子内容
     */
    private String content;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 帖子图片
     */
    private List<String> imageUrl;
    /**
     * 视频地址
     */
    private List<String> videoUrl;
    /**
     * 点赞数量
     */
    private Long loveNum;
    /**
     * 分享数量
     */
    private Long shareNum;
    /**
     * 收藏数量
     */
    private Long collectionNum;
    /**
     * 评论数量
     */
    private Long commentsCount;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
