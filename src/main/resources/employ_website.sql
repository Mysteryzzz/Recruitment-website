/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : employ_website

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 11/05/2019 16:39:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for annotation
-- ----------------------------
DROP TABLE IF EXISTS `annotation`;
CREATE TABLE `annotation`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(12) NOT NULL COMMENT '用户id',
  `message` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '通知信息',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '通知信息表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comp_reg_infos
-- ----------------------------
DROP TABLE IF EXISTS `comp_reg_infos`;
CREATE TABLE `comp_reg_infos`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `company_id` int(12) NOT NULL COMMENT '公司id',
  `reg_date` datetime(0) NOT NULL COMMENT '注册时间',
  `reg_capital` double(10, 2) NOT NULL COMMENT '注册资本',
  `manage_range` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '经营范围',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '公司注册信息表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `company_all_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '公司全称',
  `company_intr` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '公司介绍',
  `company_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '公司省份',
  `product_intr` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '产品介绍',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '公司简称',
  `company_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '公司logo url',
  `company_bussines` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '公司营业执照',
  `id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '身份证',
  `company_location_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '公司详细地址',
  `hr_id` int(12) NOT NULL COMMENT 'hr 主键值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '公司信息表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (3, '1234', '1234', '1234', '1234', '2019-05-03 16:15:16', -1, '2019-05-03 16:15:16', -1, '1234', 'D:/upload/f18ff0f2-297a-4789-a241-8c3998b44dd4_1544433285106.jpg', 'D:/upload/0eb6a3ee-c637-407d-951e-2c62bf6261c4_1544433173597.jpg', 'D:/upload/ecf4f72d-411b-4ea3-a55e-dbb0a0712e87_1544433234785.jpg', '1234', 17);
INSERT INTO `company` VALUES (4, '英聘招聘网站', '精英招聘网站，，', '山东省', '英聘网站', '2019-05-05 13:51:18', -1, '2019-05-07 11:23:23', -1, '英聘', 'D:/upload/3b101fc9-7542-4ccb-b114-73b0e2f4372f_1544433173597.jpg', 'D:/upload/f8e91ae0-d1d6-42f1-81a4-83f376abaa1c_1544433164785.jpg', 'D:/upload/956c2dd5-4892-4eac-af92-0f3e1a250645_1544433157688.jpg', '山东省青岛市山东科技大学', 18);
INSERT INTO `company` VALUES (5, '123', '123', '123', '123', '2019-05-07 12:15:15', -1, '2019-05-07 12:15:15', -1, '123', 'D:/upload/3961cb60-cbb2-4c79-ab53-3456a12caa70_1544433136968.jpg', 'D:/upload/7a8fafb2-b7f8-4194-8176-278046ac110e_1544433164785.jpg', 'D:/upload/e3fbc3fa-4b29-43d2-addf-715f2adb8e35_1544433157688.jpg', '123', 19);
INSERT INTO `company` VALUES (6, '123', '123', '123', '123', '2019-05-07 12:21:19', -1, '2019-05-07 12:21:19', -1, '123', 'D:/upload/c9034585-c9c2-4333-ab66-69bcd2f3f531_1544433136968.jpg', 'D:/upload/7cb61043-83f1-4fd3-bbd6-bec3ed283ff4_1544433194254.jpg', 'D:/upload/f3d8d0ec-9d10-4383-962b-a580e0ff2870_1544433157688.jpg', '123', 20);
INSERT INTO `company` VALUES (7, '123', '123', '123', '123', '2019-05-07 13:16:29', -1, '2019-05-07 13:16:29', -1, '123', 'error in uploading', 'error in uploading', 'error in uploading', '123', 21);
INSERT INTO `company` VALUES (8, '123', '123', '123', '123', '2019-05-07 13:18:06', -1, '2019-05-07 13:18:06', -1, '123', 'error in uploading', 'error in uploading', 'error in uploading', '1231', 22);
INSERT INTO `company` VALUES (9, 'DAS', 'DAS', 'DSA', 'DAS', '2019-05-07 13:22:17', -1, '2019-05-07 13:22:17', -1, 'DAS', 'error in uploading', 'error in uploading', 'error in uploading', 'DAS', 23);
INSERT INTO `company` VALUES (10, 'DSADASD', 'DASD', 'DSAD', 'DASD', '2019-05-07 13:24:37', -1, '2019-05-07 13:26:20', -1, 'DSADSAD', 'http://pr4a6evzm.bkt.clouddn.com/50d492b8-3d25-446e-9727-6a9705f76fe5_1544433136968.jpg', 'pr4a6evzm.bkt.clouddn.com/76540369-31b9-427c-a581-b7c4e0795cd3_1544433280174.jpg', 'pr4a6evzm.bkt.clouddn.com/8ce7ac39-7799-4738-85bf-22270dd9d4f5_1544433194254.jpg', 'DSAD', 24);
INSERT INTO `company` VALUES (11, '阿里巴巴', '啊实打实大苏打大大大大大大大大大大大大大大水水水水水水水水水水水水水水阿三顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶阿斯顿顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶啊水水水水水水水水水水水水水水啊啊啊啊啊啊啊啊啊啊啊啊', '浙江', '阿三顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶阿三顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶啊水水水水水水水水水水水水水水水水水水阿三顶顶顶顶顶顶顶顶顶顶顶顶顶', '2019-05-07 14:44:19', -1, '2019-05-10 10:33:53', -1, '阿里', 'http://files.trickmaster.cn/e5895080-474e-4abc-9eb7-728128c8be17_1544433136968.jpg', 'http://files.trickmaster.cn/4ef6ffd9-b692-4e0e-a8db-a2e91a6f863b_1544433183846.jpg', 'http://files.trickmaster.cn/c9e2b1a5-d873-42e1-aa5e-7c58acc3511f_1544433136968.jpg', '杭州市', 25);

-- ----------------------------
-- Table structure for dic_value
-- ----------------------------
DROP TABLE IF EXISTS `dic_value`;
CREATE TABLE `dic_value`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '类型编码',
  `dic_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '类型名称',
  `dic_value_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '字典编码',
  `dic_value_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '字典名称',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '字典表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for posi_require
-- ----------------------------
DROP TABLE IF EXISTS `posi_require`;
CREATE TABLE `posi_require`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `position_id` int(12) NOT NULL COMMENT '职位id',
  `message` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '信息',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '任职要求表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of posi_require
-- ----------------------------
INSERT INTO `posi_require` VALUES (9, 259, '12312', '2019-05-10 17:23:02', -1, '2019-05-10 17:23:02', -1);
INSERT INTO `posi_require` VALUES (10, 260, '123123', '2019-05-10 17:25:15', -1, '2019-05-10 17:25:15', -1);
INSERT INTO `posi_require` VALUES (11, 261, '1231', '2019-05-10 19:32:03', -1, '2019-05-10 19:32:03', -1);
INSERT INTO `posi_require` VALUES (12, 262, '1231', '2019-05-10 19:32:14', -1, '2019-05-10 19:32:14', -1);
INSERT INTO `posi_require` VALUES (13, 263, '2342342342', '2019-05-10 19:36:23', -1, '2019-05-10 19:36:23', -1);

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `position_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '职位名称',
  `salary` double(10, 2) NOT NULL COMMENT '薪资',
  `company_id` int(12) NOT NULL COMMENT '公司id',
  `count` int(12) NOT NULL COMMENT '需要人数',
  `end_time` datetime(0) NOT NULL COMMENT '截至日期',
  `state` int(12) NOT NULL COMMENT '状态',
  `education_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '学历要求编码',
  `location_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '地区编码',
  `experience_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '工作经验编码',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 264 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '职位招聘表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (263, '123', 123.00, 11, 123, '2019-05-06 00:00:00', 1, '研究生', '浙江', '5年', '2019-05-10 19:36:23', -1, '2019-05-10 19:36:23', -1);

-- ----------------------------
-- Table structure for position_collect
-- ----------------------------
DROP TABLE IF EXISTS `position_collect`;
CREATE TABLE `position_collect`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `position_id` int(12) NOT NULL COMMENT '职位id',
  `user_id` int(12) NOT NULL COMMENT '用户id',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '职位收藏表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position_relation
-- ----------------------------
DROP TABLE IF EXISTS `position_relation`;
CREATE TABLE `position_relation`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `user_id` int(12) NOT NULL COMMENT '求职者id',
  `company_id` int(12) NOT NULL COMMENT '公司id',
  `position_id` int(12) NOT NULL COMMENT '岗位id',
  `status` int(1) NOT NULL COMMENT '状态:1已通过，0未通过，2未查看',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '职位招聘关系表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_experience
-- ----------------------------
DROP TABLE IF EXISTS `project_experience`;
CREATE TABLE `project_experience`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `resume_id` int(12) NOT NULL COMMENT '简历id',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '详细信息',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '项目经历表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for responsibility
-- ----------------------------
DROP TABLE IF EXISTS `responsibility`;
CREATE TABLE `responsibility`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `position_id` int(12) NOT NULL COMMENT '职位id',
  `message` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '信息',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '岗位职责\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of responsibility
-- ----------------------------
INSERT INTO `responsibility` VALUES (9, 259, '123123', '2019-05-10 17:23:02', -1, '2019-05-10 17:23:02', -1);
INSERT INTO `responsibility` VALUES (10, 260, '1231231', '2019-05-10 17:25:15', -1, '2019-05-10 17:25:15', -1);
INSERT INTO `responsibility` VALUES (11, 261, '12312', '2019-05-10 19:32:03', -1, '2019-05-10 19:32:03', -1);
INSERT INTO `responsibility` VALUES (12, 262, '1231', '2019-05-10 19:32:14', -1, '2019-05-10 19:32:14', -1);
INSERT INTO `responsibility` VALUES (13, 263, '2342342', '2019-05-10 19:36:23', -1, '2019-05-10 19:36:23', -1);

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '性别：M男F女',
  `nation_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '民族编码',
  `education_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '学历编码',
  `phone` int(11) NOT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '邮箱',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '家庭住址',
  `skills` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '技能',
  `expect_salary` double(12, 2) NOT NULL COMMENT '期望薪资',
  `created_by` int(12) NULL DEFAULT -1 COMMENT '创建人',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_updated_by` int(12) NULL DEFAULT -1 COMMENT '最后一次更新人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次更新时间',
  `user_id` int(12) NOT NULL COMMENT '用户id',
  `expect_position` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '求职意向',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '邮箱',
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '手机号',
  `type` int(1) NOT NULL COMMENT '用户类型：0管理员，1求职者，2招聘者',
  `enable` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '是否可用：1可用，0未启用',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  `is_resumed` int(12) NOT NULL DEFAULT 0 COMMENT '是否有简历，1是 0否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1062852837', '97072591', '1062852837@163.com', '17806266772', 1, '1', '2019-04-18 12:44:33', 1, '2019-05-11 14:58:23', 1, 0);
INSERT INTO `user` VALUES (2, 'admin', 'admin', '1062852837@qq.com', '17806266772', 0, '1', '2019-04-19 13:37:46', -1, '2019-04-19 13:39:37', -1, 0);
INSERT INTO `user` VALUES (3, 'ls1062852837', '123456', 'liushuo1062852837@gmail.com', '17806266772', 2, '1', '2019-04-19 13:41:28', -1, '2019-04-19 13:41:28', -1, 0);
INSERT INTO `user` VALUES (4, '12345', '123456', '1062852@163.com', '17806266772', 1, '1', '2019-05-03 11:59:03', -1, '2019-05-03 11:59:03', -1, 0);
INSERT INTO `user` VALUES (5, '1006', '123456', '123@163.com', '17806266772', 1, '1', '2019-05-03 12:03:29', -1, '2019-05-03 12:03:29', -1, 0);
INSERT INTO `user` VALUES (13, '213', '123', '123@123.com', '17806266772', 2, '1', '2019-05-03 14:54:09', -1, '2019-05-03 14:54:09', -1, 0);
INSERT INTO `user` VALUES (16, '123', '1234', '123@123.com', '17806266772', 2, '1', '2019-05-03 15:13:24', -1, '2019-05-05 13:20:51', -1, 0);
INSERT INTO `user` VALUES (17, '1234', '1234', '1062852837@16.com', '17806266772', 2, '1', '2019-05-03 16:15:16', -1, '2019-05-03 16:15:16', -1, 0);
INSERT INTO `user` VALUES (18, '10086', '123456', '1062852387@163.com', '17806266772', 2, '1', '2019-05-05 13:51:18', -1, '2019-05-05 13:51:18', -1, 0);
INSERT INTO `user` VALUES (19, '10088', '123456', '162852837@163.com', '17806266772', 2, '1', '2019-05-07 12:15:15', -1, '2019-05-07 12:15:15', -1, 0);
INSERT INTO `user` VALUES (20, '10087', '123', '123@123.com', '17806266772', 2, '1', '2019-05-07 12:21:19', -1, '2019-05-07 12:21:19', -1, 0);
INSERT INTO `user` VALUES (21, '10089', '123', '123@123.com', '17806266772', 2, '1', '2019-05-07 13:16:29', -1, '2019-05-07 13:16:29', -1, 0);
INSERT INTO `user` VALUES (22, '10083', '123', '123@12.com', '17806266772', 2, '1', '2019-05-07 13:18:06', -1, '2019-05-07 13:18:06', -1, 0);
INSERT INTO `user` VALUES (23, 'dfs', 'EDFRSDEWF', 'DSDSD@QQ.COM', '17806261908', 2, '1', '2019-05-07 13:22:17', -1, '2019-05-07 13:22:17', -1, 0);
INSERT INTO `user` VALUES (24, 'SA', 'FDSF', 'DSF@QQ.COM', '18745697896', 2, '1', '2019-05-07 13:24:37', -1, '2019-05-07 13:24:37', -1, 0);
INSERT INTO `user` VALUES (25, '1062852837', '970725', '1062852837@163.com', '17806266772', 2, '1', '2019-05-07 14:44:19', -1, '2019-05-07 14:44:19', -1, 0);

-- ----------------------------
-- Table structure for work_experience
-- ----------------------------
DROP TABLE IF EXISTS `work_experience`;
CREATE TABLE `work_experience`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `resume_id` int(12) NOT NULL COMMENT '简历id',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '详细信息',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '工作经历表\r\n' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
