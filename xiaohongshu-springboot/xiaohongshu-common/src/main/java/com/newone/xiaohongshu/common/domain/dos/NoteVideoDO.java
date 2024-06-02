package com.dala.common.domain.dos;

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
@TableName("t_note_video")
public class NoteVideoDO {
    /**
     * 视频id
     */
    @TableId(type = IdType.AUTO)
    private Long videoId;
    /**
     * 帖子id
     */
    private Long noteId;
    /**
     * 视频地址
     */
    private String videoUrl;
}
