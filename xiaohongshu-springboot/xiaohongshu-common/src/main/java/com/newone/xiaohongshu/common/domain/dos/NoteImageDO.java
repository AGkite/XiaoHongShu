package com.newone.xiaohongshu.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_note_image")
public class NoteImageDO {
    /**
     * 图片ID
     */
    @TableId(type = IdType.AUTO)
    private Long imageId;
    /**
     * 帖子ID
     */
    private Long noteId;
    /**
     * 图片url
     */
    private String imageUrl;
}
