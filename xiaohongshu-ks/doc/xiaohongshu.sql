/*
 Navicat Premium Data Transfer

 Source Server         : newone
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : xiaohongshu

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 05/05/2024 14:13:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `category_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '分类名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0：未删除 1：已删除',
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `uk_category_name`(`name` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_collection
-- ----------------------------
DROP TABLE IF EXISTS `t_collection`;
CREATE TABLE `t_collection`  (
  `collection_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '收藏id',
  `note_id` bigint NOT NULL COMMENT '笔记id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
  PRIMARY KEY (`collection_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `comment_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `note_id` bigint NOT NULL COMMENT '被评论文章',
  `user_id` bigint NOT NULL COMMENT '评论的用户',
  `comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '评论内容',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_like
-- ----------------------------
DROP TABLE IF EXISTS `t_like`;
CREATE TABLE `t_like`  (
  `like_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '点赞id',
  `note_id` bigint NOT NULL COMMENT '被点赞文章',
  `user_id` bigint NOT NULL COMMENT '点赞的用户',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间',
  PRIMARY KEY (`like_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '点赞表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_note
-- ----------------------------
DROP TABLE IF EXISTS `t_note`;
CREATE TABLE `t_note`  (
  `note_id` bigint NOT NULL COMMENT '笔记id',
  `title` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '笔记内容',
  `city` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '城市',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  `is_deleted` tinyint NOT NULL COMMENT '逻辑删除：0：未删除 1：已删除',
  PRIMARY KEY (`note_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '笔记表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_note_category_rel
-- ----------------------------
DROP TABLE IF EXISTS `t_note_category_rel`;
CREATE TABLE `t_note_category_rel`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '笔记分类关系id',
  `note_id` bigint NOT NULL COMMENT '笔记id',
  `category_id` bigint NOT NULL COMMENT '分类id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '笔记分类关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_note_image
-- ----------------------------
DROP TABLE IF EXISTS `t_note_image`;
CREATE TABLE `t_note_image`  (
  `image_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `note_id` bigint NOT NULL COMMENT '笔记id',
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '图片地址',
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '笔记图片表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_note_topic_rel
-- ----------------------------
DROP TABLE IF EXISTS `t_note_topic_rel`;
CREATE TABLE `t_note_topic_rel`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '笔记话题id',
  `note_id` bigint NOT NULL COMMENT '笔记id',
  `topic_id` bigint NOT NULL COMMENT '话题id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '笔记话题关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_note_video
-- ----------------------------
DROP TABLE IF EXISTS `t_note_video`;
CREATE TABLE `t_note_video`  (
  `video_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '视频id',
  `note_id` bigint NOT NULL COMMENT '笔记id',
  `video_url` varbinary(255) NOT NULL COMMENT '视频地址',
  PRIMARY KEY (`video_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '笔记视频表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_share
-- ----------------------------
DROP TABLE IF EXISTS `t_share`;
CREATE TABLE `t_share`  (
  `share_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '分享id',
  `note_id` bigint NOT NULL COMMENT '笔记id',
  `user_id` bigint NOT NULL COMMENT '分享的用户id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '分享时间',
  PRIMARY KEY (`share_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '分享表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic`  (
  `topic_id` bigint NOT NULL AUTO_INCREMENT COMMENT '话题id',
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '话题名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0：未删除 1：已删除',
  PRIMARY KEY (`topic_id`) USING BTREE,
  UNIQUE INDEX `uk_topic_name`(`name` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '话题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '性别：M：男性 F：女性 O：其他',
  `birthday` datetime NULL DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '手机号',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '头像',
  `background` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '背景图片',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '简介',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0：未删除 1：已删除',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `uk_username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `role_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `username` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `role` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户角色',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
