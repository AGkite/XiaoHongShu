package com.newone.xiaohongshu.web.model.vo.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRspVO {
    /**
     * 社区 ID
     */
    private Long categoryId;
    /**
     * 社区名称
     */
    private String name;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
