package com.dala.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_note")
public class NoteDO {
    /**
     * 帖子id
     */
    @TableId(type = IdType.AUTO)
    private Long noteId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * ip
     */
    private String ip;
    /**
     * 地址
     */
    private String address;
    /**
     * 搭圈总人数
     */
    private Integer buddyTotalMember;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 逻辑删除
     */
    private Boolean isDeleted;
}
