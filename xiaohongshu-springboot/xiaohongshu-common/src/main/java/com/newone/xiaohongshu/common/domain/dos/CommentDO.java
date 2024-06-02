package com.newone.xiaohongshu.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("t_comment")
public class CommentDO {
    /**
     * 评论id
     */
    @TableId(type = IdType.AUTO)
    private Long commentId;
    /**
     * 用户id
     */
    private Long noteId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 评论
     */
    private String comment;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
