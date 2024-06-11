/*
 Navicat Premium Data Transfer

 Source Server         : newone
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : xiaohongshu_ks

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 11/06/2024 20:17:20
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
) ENGINE = InnoDB AUTO_INCREMENT = 40018 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (40000, '教育', '2024-05-28 09:36:48', '2024-05-28 09:36:48', 0);
INSERT INTO `t_category` VALUES (40001, '穿搭', '2024-05-28 09:37:35', '2024-05-28 09:37:35', 0);
INSERT INTO `t_category` VALUES (40002, '美食', '2024-05-28 09:37:50', '2024-05-28 09:37:50', 0);
INSERT INTO `t_category` VALUES (40003, '彩妆', '2024-05-28 09:38:02', '2024-05-28 09:38:02', 0);
INSERT INTO `t_category` VALUES (40004, '影视', '2024-05-28 09:38:10', '2024-05-28 09:38:10', 0);
INSERT INTO `t_category` VALUES (40005, '职场', '2024-05-28 09:38:18', '2024-05-28 09:38:18', 0);
INSERT INTO `t_category` VALUES (40006, '家居', '2024-05-28 09:38:26', '2024-05-28 09:38:26', 0);
INSERT INTO `t_category` VALUES (40007, '游戏', '2024-05-28 09:38:37', '2024-05-28 09:38:37', 0);
INSERT INTO `t_category` VALUES (40008, '旅行', '2024-05-28 09:39:14', '2024-05-28 09:39:14', 0);
INSERT INTO `t_category` VALUES (40009, '健身', '2024-05-28 09:39:21', '2024-05-28 09:39:21', 0);
INSERT INTO `t_category` VALUES (40010, '摄影', '2024-05-28 09:39:30', '2024-05-28 09:39:30', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 50003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '收藏表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_collection
-- ----------------------------
INSERT INTO `t_collection` VALUES (50000, 80000, 10001, '2024-05-28 11:15:17');
INSERT INTO `t_collection` VALUES (50001, 80000, 10002, '2024-05-28 11:15:29');
INSERT INTO `t_collection` VALUES (50002, 80001, 10001, '2024-06-10 11:31:07');

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
) ENGINE = InnoDB AUTO_INCREMENT = 70002 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (70000, 80000, 10001, '你好', '2024-05-30 21:29:23');
INSERT INTO `t_comment` VALUES (70001, 80001, 10001, '可以拿图吗？', '2024-06-10 11:30:48');

-- ----------------------------
-- Table structure for t_love
-- ----------------------------
DROP TABLE IF EXISTS `t_love`;
CREATE TABLE `t_love`  (
  `love_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '点赞id',
  `note_id` bigint NOT NULL COMMENT '被点赞文章',
  `user_id` bigint NOT NULL COMMENT '点赞的用户',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间',
  PRIMARY KEY (`love_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60011 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '点赞表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_love
-- ----------------------------
INSERT INTO `t_love` VALUES (60000, 80000, 10000, '2024-05-28 11:05:49');
INSERT INTO `t_love` VALUES (60001, 80000, 10001, '2024-05-28 11:06:56');
INSERT INTO `t_love` VALUES (60002, 80000, 10002, '2024-05-28 11:07:14');
INSERT INTO `t_love` VALUES (60003, 80000, 10003, '2024-05-28 11:07:18');
INSERT INTO `t_love` VALUES (60004, 80000, 10004, '2024-05-28 11:07:23');
INSERT INTO `t_love` VALUES (60005, 80000, 10005, '2024-05-28 11:07:28');
INSERT INTO `t_love` VALUES (60006, 80000, 10006, '2024-05-28 11:07:33');
INSERT INTO `t_love` VALUES (60007, 80000, 10007, '2024-05-28 11:07:38');
INSERT INTO `t_love` VALUES (60008, 80000, 10008, '2024-05-28 11:07:45');
INSERT INTO `t_love` VALUES (60009, 80001, 10001, '2024-06-10 11:31:31');
INSERT INTO `t_love` VALUES (60010, 80001, 10002, '2024-06-10 11:31:43');

-- ----------------------------
-- Table structure for t_note
-- ----------------------------
DROP TABLE IF EXISTS `t_note`;
CREATE TABLE `t_note`  (
  `note_id` bigint NOT NULL AUTO_INCREMENT COMMENT '笔记id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `title` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '笔记内容',
  `address` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '详细地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0：未删除 1：已删除',
  PRIMARY KEY (`note_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 80002 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '笔记表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_note
-- ----------------------------
INSERT INTO `t_note` VALUES (80000, 10001, '住家他们为了想让我留🇺🇸竟然想要收养我', '这样的住家打败百分之99.9999999999999%的留学寄宿家庭，这次马上毕业就回LA陪住家待了一个周，然后他们以为我回国是因为F1到期了“迫不得已”才回国之后就让我了解有没有政策可不可以收养我', '美国', '2024-05-28 10:36:18', '2024-05-28 10:36:18', 0);
INSERT INTO `t_note` VALUES (80001, 10002, '是我独一无二的玫瑰🦋', '尺寸20✖️20', '四川', '2024-06-10 11:27:44', '2024-06-10 11:27:44', 0);

-- ----------------------------
-- Table structure for t_note_category_rel
-- ----------------------------
DROP TABLE IF EXISTS `t_note_category_rel`;
CREATE TABLE `t_note_category_rel`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '笔记分类关系id',
  `note_id` bigint NOT NULL COMMENT '笔记id',
  `category_id` bigint NOT NULL COMMENT '分类id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '笔记分类关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_note_category_rel
-- ----------------------------

-- ----------------------------
-- Table structure for t_note_image
-- ----------------------------
DROP TABLE IF EXISTS `t_note_image`;
CREATE TABLE `t_note_image`  (
  `image_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `note_id` bigint NOT NULL COMMENT '笔记id',
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '图片地址',
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 200005 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '笔记图片表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_note_image
-- ----------------------------
INSERT INTO `t_note_image` VALUES (200000, 80000, 'https://img.howonenew.com/xiaohongshu-ks/%E4%BD%8F%E5%AE%B6%E4%BB%96%E4%BB%AC%E4%B8%BA%E4%BA%86%E6%83%B3%E8%AE%A9%E6%88%91%E7%95%99%F0%9F%87%BA%F0%9F%87%B8.jpg');
INSERT INTO `t_note_image` VALUES (200001, 80000, 'https://img.howonenew.com/xiaohongshu-ks/%E4%BD%8F%E5%AE%B6%E4%BB%96%E4%BB%AC%E4%B8%BA%E4%BA%86%E6%83%B3%E8%AE%A9%E6%88%91%E7%95%99%F0%9F%87%BA%F0%9F%87%B82.jpg');
INSERT INTO `t_note_image` VALUES (200003, 80001, 'https://img.howonenew.com/xiaohongshu-ks/%E6%98%AF%E6%88%91%E7%8B%AC%E4%B8%80%E6%97%A0%E4%BA%8C%E7%9A%84%E7%8E%AB%E7%91%B0%F0%9F%A6%8B1.jpg');
INSERT INTO `t_note_image` VALUES (200004, 80001, 'https://img.howonenew.com/xiaohongshu-ks/%E6%98%AF%E6%88%91%E7%8B%AC%E4%B8%80%E6%97%A0%E4%BA%8C%E7%9A%84%E7%8E%AB%E7%91%B0%F0%9F%A6%8B2.jpg');

-- ----------------------------
-- Table structure for t_note_topic_rel
-- ----------------------------
DROP TABLE IF EXISTS `t_note_topic_rel`;
CREATE TABLE `t_note_topic_rel`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '笔记话题id',
  `note_id` bigint NOT NULL COMMENT '笔记id',
  `topic_id` bigint NOT NULL COMMENT '话题id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '笔记话题关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_note_topic_rel
-- ----------------------------

-- ----------------------------
-- Table structure for t_note_video
-- ----------------------------
DROP TABLE IF EXISTS `t_note_video`;
CREATE TABLE `t_note_video`  (
  `video_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '视频id',
  `note_id` bigint NOT NULL COMMENT '笔记id',
  `video_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '视频地址',
  PRIMARY KEY (`video_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 300003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '笔记视频表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_note_video
-- ----------------------------
INSERT INTO `t_note_video` VALUES (300000, 80000, 'https://img.howonenew.com/xiaohongshu-ks/%E4%BD%8F%E5%AE%B6%E4%BB%96%E4%BB%AC%E4%B8%BA%E4%BA%86%E6%83%B3%E8%AE%A9%E6%88%91%E7%95%99%F0%9F%87%BA%F0%9F%87%B8video.mp4');

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
) ENGINE = InnoDB AUTO_INCREMENT = 90004 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '分享表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_share
-- ----------------------------
INSERT INTO `t_share` VALUES (90000, 80000, 10001, '2024-05-28 11:09:17');
INSERT INTO `t_share` VALUES (90001, 80000, 10002, '2024-05-28 11:09:26');
INSERT INTO `t_share` VALUES (90002, 80000, 10003, '2024-05-28 11:09:30');
INSERT INTO `t_share` VALUES (90003, 80000, 10004, '2024-05-28 11:09:33');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '话题表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_topic
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 10003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (10001, 'newone', '$2a$10$CUGV6Ki/tSae3qjZe9eNv.4WSYlVjz2GmbTMl6zHHl.EyFTWu/cJi', 'M', '2002-09-02 00:00:00', '13533077726', 'http://img.howonenew.com/weblog/1.jpg', 'http://img.howonenew.com/weblog/1.jpg', '一个普通用户', '2024-05-15 11:17:33', '2024-05-15 11:17:33', 0);
INSERT INTO `t_user` VALUES (10002, 'test', '$2a$10$CUGV6Ki/tSae3qjZe9eNv.4WSYlVjz2GmbTMl6zHHl.EyFTWu/cJi', 'F', '1995-11-25 00:00:00', '13562839505', 'https://img.howonenew.com/xiaohongshu-ks/10001.webp', NULL, '测试账号', '2024-06-10 11:16:09', '2024-06-10 11:16:09', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
