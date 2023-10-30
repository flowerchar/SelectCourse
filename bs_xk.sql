/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : bs_xk

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 05/10/2023 14:08:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号码',
  `level` int NULL DEFAULT 1 COMMENT '权限等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES (5, 'admin3', '123456', '女', '12', '12', 1);
INSERT INTO `admin_info` VALUES (8, '123123', '123456', '女', '123123', '12134234', 1);
INSERT INTO `admin_info` VALUES (9, '饿31231', '123456', '女', '12312', '123123', 1);
INSERT INTO `admin_info` VALUES (10, '12312', '123456', '女', '1213', '121', 1);
INSERT INTO `admin_info` VALUES (17, 'test1', '123456', '男', '12', '34', 1);
INSERT INTO `admin_info` VALUES (18, 'test2', '123456', '女', '12', '32423', 1);
INSERT INTO `admin_info` VALUES (19, 'test22', '123456', '男', '123', '12', 1);
INSERT INTO `admin_info` VALUES (20, 'test333', '123456', '男', '2312', '123', 1);
INSERT INTO `admin_info` VALUES (21, 'ttest444', '123456', '男', '12', '33', 1);
INSERT INTO `admin_info` VALUES (22, 'test555', '123456', '男', 'qew', '1213', 1);
INSERT INTO `admin_info` VALUES (23, '11111111', '123456', '女', '123', '12', 1);
INSERT INTO `admin_info` VALUES (24, '阿达', '123456', '男', '123', '3', 1);

-- ----------------------------
-- Table structure for college_info
-- ----------------------------
DROP TABLE IF EXISTS `college_info`;
CREATE TABLE `college_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学院名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学院介绍',
  `credit_limit` int NULL DEFAULT NULL COMMENT '学分限制',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college_info
-- ----------------------------
INSERT INTO `college_info` VALUES (7, '计算机学院', '计算机学院 智能审计学院是南京审计大学唯一的工科学院，围绕“科技强审”战略与数字化时代国家治理体系和治理能力现代化建设需求，依托学校“大审计”平台学科与行业优势，强化现代信息技术与审计交叉融合', 100);
INSERT INTO `college_info` VALUES (8, '外国语学院', ' 南京审计大学外国语学院是在南京审计学院外语系基础上成立的。南京审计学院外语系成立于2001年，同年招收第一届英语专业学生，同时承担全校公共英语教学', 105);
INSERT INTO `college_info` VALUES (9, '马克思主义学院', '马克思主义学院于2011年5月独立建制，原名思想政治理论教学部。2014年3月，更名为马克思主义学院。学院2018年、2020年入选江苏省示范马克思主义学院培育点，2022年入选江苏省高校思政课教育教学改革创新示范点，是中国历史唯物主义学会副理事长单位', 95);
INSERT INTO `college_info` VALUES (10, '数学学院', '南京审计大学数学学院（公共数学教学部）前身是2003年成立的应用数学系，2008 年原属经济学院的统计教研室并入，成立了数学与统计学院。2014年3月更名为理学院', 80);
INSERT INTO `college_info` VALUES (11, '政府审计学院', NULL, 110);
INSERT INTO `college_info` VALUES (12, '内部审计学院', NULL, 100);
INSERT INTO `college_info` VALUES (13, '社会审计学院', NULL, 105);
INSERT INTO `college_info` VALUES (14, '工程审计学院', NULL, 95);
INSERT INTO `college_info` VALUES (15, '会计学院', NULL, 90);
INSERT INTO `college_info` VALUES (16, '商学院', NULL, 95);
INSERT INTO `college_info` VALUES (17, '公共管理学院', NULL, 95);
INSERT INTO `college_info` VALUES (18, '文学院', NULL, 85);

-- ----------------------------
-- Table structure for course_info
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '专业名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '课程介绍',
  `majorID` bigint NULL DEFAULT NULL COMMENT '专业ID',
  `credit` int NULL DEFAULT NULL COMMENT '课程学分',
  `teacherID` bigint NULL DEFAULT NULL COMMENT '教师ID',
  `required_num` int NULL DEFAULT 0 COMMENT '规定人数',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上课时段',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上课地点',
  `selected_num` int NULL DEFAULT 0 COMMENT '已选人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_info
-- ----------------------------
INSERT INTO `course_info` VALUES (36, '英语', '大学必修英语', 33, 3, 25, 80, '周三10:20-12:40', '致明楼315', 0);
INSERT INTO `course_info` VALUES (39, '计算机审计技术', '将计算机技术应用于审计', 33, 4, 26, 20, '周三18:30-20:50', '竞东107', 2);
INSERT INTO `course_info` VALUES (40, '高级程序语言设计', '前后端技术', 33, 5, 27, 20, '周四13:30-15:00', '致明楼316', 1);
INSERT INTO `course_info` VALUES (41, '运筹学', '最优规划技术', 33, 4, 29, 50, '周五13:30-15:00', '敏行201', 0);
INSERT INTO `course_info` VALUES (42, '新时代中国特色社会主义', '新时代中国特色社会主义理论与时间', 33, 3, 30, 150, '周五15:20-17:00', '竞秀北楼三报', 0);
INSERT INTO `course_info` VALUES (43, '算法分析与设计', '数据结构与算法', 33, 4, 31, 50, '周五18:30-20:50', '致明楼315', 0);

-- ----------------------------
-- Table structure for course_select_info
-- ----------------------------
DROP TABLE IF EXISTS `course_select_info`;
CREATE TABLE `course_select_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '专业名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '课程介绍',
  `majorID` bigint NULL DEFAULT NULL COMMENT '专业ID',
  `credit` int NULL DEFAULT NULL COMMENT '课程学分',
  `teacherID` bigint NULL DEFAULT NULL COMMENT '教师ID',
  `required_num` int NULL DEFAULT 0 COMMENT '规定人数',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上课时段',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上课地点',
  `studentID` bigint NULL DEFAULT 0 COMMENT '学生ID',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '课程状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_select_info
-- ----------------------------
INSERT INTO `course_select_info` VALUES (52, '计算机审计技术', '将计算机技术应用于审计', 33, 4, 26, 20, '周三18:30-20:50', '竞东107', 27, '已开课');
INSERT INTO `course_select_info` VALUES (53, '高级程序语言设计', '前后端技术', 33, 5, 27, 20, '周四13:30-15:00', '致明楼316', 27, '待开课');
INSERT INTO `course_select_info` VALUES (54, '计算机审计技术', '将计算机技术应用于审计', 33, 4, 26, 20, '周三18:30-20:50', '竞东107', 28, '已开课');

-- ----------------------------
-- Table structure for major_info
-- ----------------------------
DROP TABLE IF EXISTS `major_info`;
CREATE TABLE `major_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '专业名称',
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '系名',
  `collegeID` bigint NULL DEFAULT NULL COMMENT '学院ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major_info
-- ----------------------------
INSERT INTO `major_info` VALUES (33, '大数据审计', '电子信息', 7);
INSERT INTO `major_info` VALUES (34, '模式识别', '电子信息', 7);
INSERT INTO `major_info` VALUES (36, '人工智能', '电子信息', 7);
INSERT INTO `major_info` VALUES (37, '日语', '外国语系', 8);
INSERT INTO `major_info` VALUES (38, '计算机技术', '电子信息', 7);
INSERT INTO `major_info` VALUES (39, '网络与信息安全', '电子信息', 7);

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '年龄',
  `studentID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学号',
  `level` int NULL DEFAULT 3 COMMENT '权限等级',
  `collegeID` bigint NULL DEFAULT NULL COMMENT '所属学院ID',
  `credit` int NULL DEFAULT 0 COMMENT '总学分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES (27, '罗伟力', '123456', '男', '22', 'MP2309018', 3, 7, 15);
INSERT INTO `student_info` VALUES (28, '徐俊华', '123456', '男', '23', 'MP2309021', 3, 7, 12);
INSERT INTO `student_info` VALUES (29, '杨瑞', '123456', '女', '22', 'MP2309044', 3, 7, 13);
INSERT INTO `student_info` VALUES (30, '熊培淞', '123456', '男', '22', 'MP2309019', 3, 7, 14);
INSERT INTO `student_info` VALUES (32, '潘炜城', '123456', '男', '22', 'MP2309020', 3, 7, 12);
INSERT INTO `student_info` VALUES (33, 'test1', '123456', '女', '20', 'MP2312311', 3, 8, 20);

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '年龄',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '职称',
  `level` int NULL DEFAULT 2 COMMENT '权限等级',
  `collegeID` bigint NULL DEFAULT NULL COMMENT '所属学院ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_info
-- ----------------------------
INSERT INTO `teacher_info` VALUES (25, '孙刚', '123456', '男', '48', '副教授', 2, 8);
INSERT INTO `teacher_info` VALUES (26, '余小兵', '123456', '男', '52', '副教授', 2, 7);
INSERT INTO `teacher_info` VALUES (27, '唐明伟', '123456', '男', '47', '副教授', 2, 7);
INSERT INTO `teacher_info` VALUES (29, '许秋滨', '123456', '男', '49', '讲师', 2, 10);
INSERT INTO `teacher_info` VALUES (30, '王素萍', '123456', '女', '48', '讲师', 2, 9);
INSERT INTO `teacher_info` VALUES (31, '周一峰', '123456', '男', '50', '副教授', 2, 7);
INSERT INTO `teacher_info` VALUES (32, 'sdsdsd', '123456', '女', 'sdsd', 'dsdsdsds', 2, 7);

SET FOREIGN_KEY_CHECKS = 1;
