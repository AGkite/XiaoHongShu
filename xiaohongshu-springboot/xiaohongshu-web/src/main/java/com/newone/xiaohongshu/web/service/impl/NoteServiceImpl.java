package com.newone.xiaohongshu.web.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.newone.xiaohongshu.common.domain.dos.*;
import com.newone.xiaohongshu.common.domain.mapper.*;
import com.newone.xiaohongshu.common.utils.Response;
import com.newone.xiaohongshu.web.model.vo.note.NoteRspVO;
import com.newone.xiaohongshu.web.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NoteServiceImpl implements NoteService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private NoteImageMapper noteImageMapper;
    @Autowired
    private NoteVideoMapper noteVideoMapper;
    @Autowired
    private LoveMapper loveMapper;
    @Autowired
    private ShareMapper shareMapper;
    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 查询笔记帖子列表
     *
     * @return 返回笔记帖子列表的响应对象
     */
    @Override
    public Response findNotesList() {
        // 查询所有帖子
        List<NoteDO> noteDOS = noteMapper.selectList(Wrappers.<NoteDO>lambdaQuery().eq(NoteDO::getIsDeleted, false));
        // 帖子id列表
        List<Long> noteIds = noteDOS.stream().map(NoteDO::getNoteId).collect(Collectors.toList());

        // 发帖用户id
        List<Long> userIds = null;
        if (!CollectionUtils.isEmpty(noteDOS)) {
            userIds = noteDOS.stream().map(NoteDO::getUserId).collect(Collectors.toList());
        }

        // 发帖用户
        List<UserDO> userDOS;
        if (!CollectionUtils.isEmpty(userIds)) {
            userDOS = userMapper.selectList(Wrappers.<UserDO>lambdaQuery().in(UserDO::getUserId, userIds));

        } else {
            userDOS = null;
        }

        List<NoteRspVO> vos = null;

        if (!CollectionUtils.isEmpty(noteIds)) {
            // 帖子图片
            List<NoteImageDO> noteImageDOS = noteImageMapper.selectList(Wrappers.<NoteImageDO>lambdaQuery().in(NoteImageDO::getNoteId, noteIds));
            // 帖子视频
            List<NoteVideoDO> noteVideoDOS = noteVideoMapper.selectList(Wrappers.<NoteVideoDO>lambdaQuery().in(NoteVideoDO::getNoteId, noteIds));
            // 点赞数量
            List<LoveDO> loveDOS = loveMapper.selectList(Wrappers.<LoveDO>lambdaQuery().in(LoveDO::getNoteId, noteIds));
            // 分享数量
            List<ShareDO> shareDOS = shareMapper.selectList(Wrappers.<ShareDO>lambdaQuery().in(ShareDO::getNoteId, noteIds));
            // 收藏数量
            List<CollectionDO> collectionDOS = collectionMapper.selectList(Wrappers.<CollectionDO>lambdaQuery().in(CollectionDO::getNoteId, noteIds));
            // 评论数量
            List<CommentDO> commentDOS = commentMapper.selectList(Wrappers.<CommentDO>lambdaQuery().in(CommentDO::getNoteId, noteIds));

            // 组合 VOS
            if (!CollectionUtils.isEmpty(noteDOS)) {
                vos = noteDOS.stream().map(noteDO -> {
                    NoteRspVO.NoteRspVOBuilder builder = NoteRspVO.builder()
                            .noteId(noteDO.getNoteId())
                            .title(noteDO.getTitle())
                            .content(noteDO.getContent())
                            .address(noteDO.getAddress())
                            .createTime(noteDO.getCreateTime());

                    // 设置用户信息
                    if (!CollectionUtils.isEmpty(userDOS)) {
                        userDOS.stream()
                                .filter(userDO -> userDO.getUserId().equals(noteDO.getUserId()))
                                .findFirst()
                                .ifPresent(userDO -> {
                                    builder.username(userDO.getUsername());
                                    builder.avatar(userDO.getAvatar());
                                });
                    }

                    // 设置帖子图片
                    if (!CollectionUtils.isEmpty(noteImageDOS)) {
                        List<String> imageUrls = noteImageDOS.stream()
                                .filter(noteImageDO -> noteImageDO.getNoteId().equals(noteDO.getNoteId()))
                                .map(NoteImageDO::getImageUrl)
                                .collect(Collectors.toList());
                        builder.imageUrl(imageUrls);
                    }

                    // 设置帖子视频
                    if (!CollectionUtils.isEmpty(noteVideoDOS)) {
                        List<String> videoUrls = noteVideoDOS.stream()
                                .filter(noteVideoDO -> noteVideoDO.getNoteId().equals(noteDO.getNoteId()))
                                .map(NoteVideoDO::getVideoUrl)
                                .collect(Collectors.toList());
                        builder.videoUrl(videoUrls);
                    }

                    // 设置点赞数量
                    if (!CollectionUtils.isEmpty(loveDOS)) {
                        long loveCount = loveDOS.stream()
                                .filter(loveDO -> loveDO.getNoteId().equals(noteDO.getNoteId()))
                                .count();
                        builder.loveNum(loveCount);
                    }

                    // 设置分享数量
                    if (!CollectionUtils.isEmpty(shareDOS)) {
                        long shareCount = shareDOS.stream()
                                .filter(shareDO -> shareDO.getNoteId().equals(noteDO.getNoteId()))
                                .count();
                        builder.shareNum(shareCount);
                    }

                    // 设置收藏数量
                    if (!CollectionUtils.isEmpty(collectionDOS)) {
                        long collectionCount = collectionDOS.stream()
                                .filter(collectionDO -> collectionDO.getNoteId().equals(noteDO.getNoteId()))
                                .count();
                        builder.collectionNum(collectionCount);
                    }

                    // 设置评论数量
                    if (!CollectionUtils.isEmpty(commentDOS)) {
                        long commentCount = commentDOS.stream()
                                .filter(commentDO -> commentDO.getNoteId().equals(noteDO.getNoteId()))
                                .count();
                        builder.commentsCount(commentCount);
                    }

                    return builder.build();
                }).collect(Collectors.toList());
            }
        }

        return Response.success(vos);
    }
}
