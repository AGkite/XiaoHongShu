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
@TableName("t_collection")
public class CollectionDO {
    /**
     * 收藏id
     */
    @TableId(type = IdType.AUTO)
    private Long collectionId;
    /**
     * 帖子id
     */
    private Long noteId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
