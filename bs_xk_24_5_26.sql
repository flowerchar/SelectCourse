/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : bs_xk

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 26/05/2024 21:53:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号码',
  `level` int(11) NULL DEFAULT 1 COMMENT '权限等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES (5, 'admin123', '123456', '女', '265', '111111111112', 1);
INSERT INTO `admin_info` VALUES (8, 'Luo', '123456', '男', '25', '111111111111', 1);
INSERT INTO `admin_info` VALUES (9, 'admin2', '123456', '女', '48', '111111111111', 1);
INSERT INTO `admin_info` VALUES (10, 'admin3', '123456', '女', '50', '111111111111', 1);
INSERT INTO `admin_info` VALUES (17, 'admin4', '123456', '男', '46', '111111111111', 1);
INSERT INTO `admin_info` VALUES (18, 'test2', '123456', '女', '12', '32423', 1);
INSERT INTO `admin_info` VALUES (19, 'test22', '123456', '男', '123', '12', 1);
INSERT INTO `admin_info` VALUES (20, 'test333', '123456', '男', '2312', '123', 1);
INSERT INTO `admin_info` VALUES (21, 'ttest444', '123456', '男', '12', '33', 1);
INSERT INTO `admin_info` VALUES (22, 'test555', '123456', '男', 'qew', '1213', 1);
INSERT INTO `admin_info` VALUES (23, '11111111', '123456', '女', '1234', '12', 1);
INSERT INTO `admin_info` VALUES (24, '阿达', '123456', '男', '123', '3', 1);
INSERT INTO `admin_info` VALUES (25, 'test413', '123456', '男', '43', '111111111111', 1);
INSERT INTO `admin_info` VALUES (26, 'admin512', '123456', '男', '50', '12312312', 1);
INSERT INTO `admin_info` VALUES (27, 'test512', '123456', '男', '123', '123', 1);

-- ----------------------------
-- Table structure for college_info
-- ----------------------------
DROP TABLE IF EXISTS `college_info`;
CREATE TABLE `college_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学院名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学院介绍',
  `credit_limit` int(11) NULL DEFAULT NULL COMMENT '学分限制',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of college_info
-- ----------------------------
INSERT INTO `college_info` VALUES (7, '计算机学院12', '计算机学院 智能审计学院是南京审计大学唯一的工科学院，围绕“科技强审”战略与数字化时代国家治理体系和治理能力现代化建设需求，依托学校“大审计”平台学科与行业优势，强化现代信息技术与审计交叉融合', 106);
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
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '专业名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '课程介绍',
  `majorID` bigint(20) NULL DEFAULT NULL COMMENT '专业ID',
  `credit` int(11) NULL DEFAULT NULL COMMENT '课程学分',
  `teacherID` bigint(20) NULL DEFAULT NULL COMMENT '教师ID',
  `required_num` int(11) NULL DEFAULT 0 COMMENT '规定人数',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上课时段',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上课地点',
  `selected_num` int(11) NULL DEFAULT 0 COMMENT '已选人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course_info
-- ----------------------------
INSERT INTO `course_info` VALUES (36, '英语', '大学必修英语111', 33, 3, 25, 80, '周三10:20-12:40', '致明楼315', 4);
INSERT INTO `course_info` VALUES (39, '计算机审计技术asdas', '将计算机技术应用于审计', 33, 4, 26, 20, '周三18:30-20:50', '竞东107', 3);
INSERT INTO `course_info` VALUES (40, '高级程序语言设计', '前后端技术', 33, 5, 27, 20, '周四13:30-15:00', '致明楼316', 3);
INSERT INTO `course_info` VALUES (41, '运筹学', '最优规划技术', 33, 4, 29, 50, '周五13:30-15:00', '敏行201', 1);
INSERT INTO `course_info` VALUES (42, '新时代中国特色社会主义', '新时代中国特色社会主义理论与时间', 33, 3, 30, 150, '周五15:20-17:00', '竞秀北楼三报', 2);
INSERT INTO `course_info` VALUES (43, '算法分析与设计', '数据结构与算法', 33, 4, 31, 50, '周五18:30-20:50', '致明楼315', 3);
INSERT INTO `course_info` VALUES (44, '全栈开发', '前后端技术', 38, 10, 33, 2, '周五10:00-12:00', '线上', 1);
INSERT INTO `course_info` VALUES (45, '测试课程名称1', '测试课程介绍1', 38, 5, 35, 50, '周三15:20-17:00', '测试楼105', 1);
INSERT INTO `course_info` VALUES (46, 'aaaa', 'aaaa', 34, 1, 32, 20, '周三18:30-20:50', '啊啊啊', 0);
INSERT INTO `course_info` VALUES (47, 'test111111', '测试', 34, 8, 31, 50, '周一18:30-20:00', '致明楼', 1);

-- ----------------------------
-- Table structure for course_select_info
-- ----------------------------
DROP TABLE IF EXISTS `course_select_info`;
CREATE TABLE `course_select_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '专业名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '课程介绍',
  `majorID` bigint(20) NULL DEFAULT NULL COMMENT '专业ID',
  `credit` int(11) NULL DEFAULT NULL COMMENT '课程学分',
  `teacherID` bigint(20) NULL DEFAULT NULL COMMENT '教师ID',
  `required_num` int(11) NULL DEFAULT 0 COMMENT '规定人数',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上课时段',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上课地点',
  `studentID` bigint(20) NULL DEFAULT 0 COMMENT '学生ID',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '课程状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course_select_info
-- ----------------------------
INSERT INTO `course_select_info` VALUES (52, '计算机审计技术', '将计算机技术应用于审计', 33, 4, 26, 20, '周三18:30-20:50', '竞东107', 27, '已开课');
INSERT INTO `course_select_info` VALUES (53, '高级程序语言设计', '前后端技术', 33, 5, 27, 20, '周四13:30-15:00', '致明楼316', 27, '待开课');
INSERT INTO `course_select_info` VALUES (54, '计算机审计技术', '将计算机技术应用于审计', 33, 4, 26, 20, '周三18:30-20:50', '竞东107', 28, '已开课');
INSERT INTO `course_select_info` VALUES (58, '计算机审计技术', '将计算机技术应用于审计', 33, 4, 26, 20, '周三18:30-20:50', '竞东107', 29, '待开课');
INSERT INTO `course_select_info` VALUES (61, '新时代中国特色社会主义', '新时代中国特色社会主义理论与时间', 33, 3, 30, 150, '周五15:20-17:00', '竞秀北楼三报', 27, '待开课');
INSERT INTO `course_select_info` VALUES (65, '全栈开发', '前后端技术', 38, 10, 33, 2, '周五10:00-12:00', '线上', 36, '待开课');
INSERT INTO `course_select_info` VALUES (66, '高级程序语言设计', '前后端技术', 33, 5, 27, 20, '周四13:30-15:00', '致明楼316', 35, '待开课');
INSERT INTO `course_select_info` VALUES (67, '算法分析与设计', '数据结构与算法', 33, 4, 31, 50, '周五18:30-20:50', '致明楼315', 35, '待开课');
INSERT INTO `course_select_info` VALUES (68, '英语1', '大学必修英语111', 33, 3, 25, 80, '周三10:20-12:40', '致明楼315', 35, '待开课');
INSERT INTO `course_select_info` VALUES (69, '测试课程名称1', '测试课程介绍1', 38, 5, 35, 50, '周三15:20-17:00', '测试楼105', 73, '待开课');
INSERT INTO `course_select_info` VALUES (70, '英语1', '大学必修英语111', 33, 3, 25, 80, '周三10:20-12:40', '致明楼315', 28, '待开课');
INSERT INTO `course_select_info` VALUES (71, '高级程序语言设计', '前后端技术', 33, 5, 27, 20, '周四13:30-15:00', '致明楼316', 28, '待开课');
INSERT INTO `course_select_info` VALUES (72, '新时代中国特色社会主义', '新时代中国特色社会主义理论与时间', 33, 3, 30, 150, '周五15:20-17:00', '竞秀北楼三报', 28, '待开课');
INSERT INTO `course_select_info` VALUES (73, '算法分析与设计', '数据结构与算法', 33, 4, 31, 50, '周五18:30-20:50', '致明楼315', 28, '待开课');
INSERT INTO `course_select_info` VALUES (74, '算法分析与设计', '数据结构与算法', 33, 4, 31, 50, '周五18:30-20:50', '致明楼315', 27, '待开课');
INSERT INTO `course_select_info` VALUES (78, 'test111111', '测试', 34, 8, 31, 50, '周一18:30-20:00', '致明楼', 28, '待开课');
INSERT INTO `course_select_info` VALUES (87, '英语1', '大学必修英语111', 33, 3, 25, 80, '周三10:20-12:40', '致明楼315', 27, '待开课');
INSERT INTO `course_select_info` VALUES (88, '运筹学', '最优规划技术', 33, 4, 29, 50, '周五13:30-15:00', '敏行201', 27, '待开课');

-- ----------------------------
-- Table structure for major_info
-- ----------------------------
DROP TABLE IF EXISTS `major_info`;
CREATE TABLE `major_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '专业名称',
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '系名',
  `collegeID` bigint(20) NULL DEFAULT NULL COMMENT '学院ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of major_info
-- ----------------------------
INSERT INTO `major_info` VALUES (33, '大数据审计', '电子信息', 10);
INSERT INTO `major_info` VALUES (34, '模式识别', '电子信息', 7);
INSERT INTO `major_info` VALUES (36, '人工智能', '电子信息', 7);
INSERT INTO `major_info` VALUES (37, '日语', '外国语系', 15);
INSERT INTO `major_info` VALUES (38, '计算机技术', '电子信息', 7);
INSERT INTO `major_info` VALUES (39, '网络与信息安全', '电子信息', 7);

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '年龄',
  `studentID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学号',
  `level` int(11) NULL DEFAULT 3 COMMENT '权限等级',
  `collegeID` bigint(20) NULL DEFAULT NULL COMMENT '所属学院ID',
  `credit` int(11) NULL DEFAULT 0 COMMENT '总学分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES (27, '罗伟力', '1234567', '男', '23', 'MP2309018', 3, 10, 15);
INSERT INTO `student_info` VALUES (28, '徐俊华', '123456', '男', '23', 'MP2309021', 3, 7, 12);
INSERT INTO `student_info` VALUES (29, '杨瑞', '123456', '女', '22', 'MP2309044', 3, 7, 13);
INSERT INTO `student_info` VALUES (30, '熊培淞', '123456', '男', '22', 'MP2309019', 3, 7, 14);
INSERT INTO `student_info` VALUES (32, '潘炜城', '123456', '男', '22', 'MP2309020', 3, 7, 12);
INSERT INTO `student_info` VALUES (33, 'test111111', '123456', '女', '20', 'MP2312311', 3, 8, 20);
INSERT INTO `student_info` VALUES (34, '王雨涵', '123456', '女', '23', '123', 3, NULL, 0);
INSERT INTO `student_info` VALUES (35, 'lu', '123456', '女', '19', '3210', 3, NULL, 0);
INSERT INTO `student_info` VALUES (36, 'sun', '123456', NULL, NULL, NULL, 3, NULL, 0);
INSERT INTO `student_info` VALUES (44, 'testtest', '123456', '男', '19', '191091231', 3, 10, 20);
INSERT INTO `student_info` VALUES (81, 'test2', '123456', '男', '22', 'MP2309030', 3, 7, 18);
INSERT INTO `student_info` VALUES (82, 'test3', '123456', '男', '23', 'MP2309010', 3, 7, 19);
INSERT INTO `student_info` VALUES (84, 'test5', '123456', '女', '24', 'MP2309035', 3, 8, 15);
INSERT INTO `student_info` VALUES (86, 'test789', '123456', '女', '23', 'MP2309041', 3, 7, 18);
INSERT INTO `student_info` VALUES (87, 'test8', '123456', '男', '22', 'MP2309052', 3, 7, 24);
INSERT INTO `student_info` VALUES (88, '2024_3_2', '123456', '女', '123', '123', 3, 16, 123);
INSERT INTO `student_info` VALUES (89, 'stu1', '123456', NULL, NULL, NULL, 3, NULL, 0);
INSERT INTO `student_info` VALUES (90, 't2237', '123456', NULL, NULL, NULL, 3, NULL, 0);
INSERT INTO `student_info` VALUES (91, '2322', '123456', NULL, NULL, NULL, 3, NULL, 0);
INSERT INTO `student_info` VALUES (93, NULL, '123456', NULL, NULL, NULL, 3, NULL, 0);
INSERT INTO `student_info` VALUES (94, NULL, '123456', NULL, NULL, NULL, 3, NULL, 0);
INSERT INTO `student_info` VALUES (95, '522', '123456', '男', '24', 'MP2309033', 3, 17, 100);
INSERT INTO `student_info` VALUES (96, '5221', '123456', '男', '12', '12', 3, 8, 12);
INSERT INTO `student_info` VALUES (97, NULL, '123456', NULL, NULL, NULL, 3, NULL, 0);
INSERT INTO `student_info` VALUES (98, NULL, '123456', NULL, NULL, NULL, 3, NULL, 0);

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '年龄',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '职称',
  `level` int(11) NULL DEFAULT 2 COMMENT '权限等级',
  `collegeID` bigint(20) NULL DEFAULT NULL COMMENT '所属学院ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teacher_info
-- ----------------------------
INSERT INTO `teacher_info` VALUES (25, '孙刚12', '123456', '男', '48', '副教授', 2, 8);
INSERT INTO `teacher_info` VALUES (26, '余小兵', '123456', '男', '52', '副教授', 2, 7);
INSERT INTO `teacher_info` VALUES (27, '唐明伟', '123456', '男', '47', '副教授', 2, 7);
INSERT INTO `teacher_info` VALUES (29, '许秋滨', '123456', '男', '49', '讲师', 2, 10);
INSERT INTO `teacher_info` VALUES (30, '王素萍', '123456', '女', '48', '讲师', 2, 9);
INSERT INTO `teacher_info` VALUES (31, '周一峰', '123456', '男', '50', '副教授', 2, 7);
INSERT INTO `teacher_info` VALUES (32, 'sdsdsd', '123456', '女', 'sdsd', 'dsdsdsds', 2, 7);
INSERT INTO `teacher_info` VALUES (33, 'ron', '123456', '男', '23', '学生', 2, NULL);
INSERT INTO `teacher_info` VALUES (34, 'test1', '123456', '男', '9', '教授', 2, NULL);

SET FOREIGN_KEY_CHECKS = 1;
