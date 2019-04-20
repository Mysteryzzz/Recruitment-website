/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : employ_website

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 6500

 Date: 20/04/2019 11:12:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for annotation
-- ----------------------------
DROP TABLE IF EXISTS `annotation`;
CREATE TABLE `annotation`  (
  `id` int(12) NOT NULL COMMENT '主键',
  `user_id` int(12) NOT NULL COMMENT '用户id',
  `message` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '通知信息',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '通知信息表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comp_reg_infos
-- ----------------------------
DROP TABLE IF EXISTS `comp_reg_infos`;
CREATE TABLE `comp_reg_infos`  (
  `id` int(12) NOT NULL COMMENT '主键',
  `company_id` int(12) NOT NULL COMMENT '公司id',
  `reg_date` datetime(0) NOT NULL COMMENT '注册时间',
  `reg_capital` double(10, 2) NOT NULL COMMENT '注册资本',
  `manage_range` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '经营范围',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '公司注册信息表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` int(12) NOT NULL COMMENT '主键',
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '公司名称',
  `company_intr` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '公司介绍',
  `company_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '公司地址',
  `product_intr` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '产品介绍',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '公司信息表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dic_value
-- ----------------------------
DROP TABLE IF EXISTS `dic_value`;
CREATE TABLE `dic_value`  (
  `id` int(12) NOT NULL COMMENT '主键',
  `dic_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '类型编码',
  `dic_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '类型名称',
  `dic_value_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '字典编码',
  `dic_value_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '字典名称',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '字典表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for posi_require
-- ----------------------------
DROP TABLE IF EXISTS `posi_require`;
CREATE TABLE `posi_require`  (
  `id` int(12) NOT NULL COMMENT '主键',
  `position_id` int(12) NOT NULL COMMENT '职位id',
  `message` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '信息',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '任职要求表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int(12) NOT NULL COMMENT '主键',
  `position_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '职位编码',
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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '职位招聘表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position_collect
-- ----------------------------
DROP TABLE IF EXISTS `position_collect`;
CREATE TABLE `position_collect`  (
  `id` int(12) NOT NULL COMMENT '主键',
  `position_id` int(12) NOT NULL COMMENT '职位id',
  `user_id` int(12) NOT NULL COMMENT '用户id',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '职位收藏表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position_relation
-- ----------------------------
DROP TABLE IF EXISTS `position_relation`;
CREATE TABLE `position_relation`  (
  `id` int(12) NOT NULL COMMENT '流水号',
  `user_id` int(12) NOT NULL COMMENT '求职者id',
  `company_id` int(12) NOT NULL COMMENT '公司id',
  `position_id` int(12) NOT NULL COMMENT '岗位id',
  `status` int(1) NOT NULL COMMENT '状态:1已通过，0未通过，2未查看',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '职位招聘关系表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_experience
-- ----------------------------
DROP TABLE IF EXISTS `project_experience`;
CREATE TABLE `project_experience`  (
  `id` int(12) NOT NULL COMMENT '主键',
  `resume_id` int(12) NOT NULL COMMENT '简历id',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '详细信息',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '项目经历表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for responsibility
-- ----------------------------
DROP TABLE IF EXISTS `responsibility`;
CREATE TABLE `responsibility`  (
  `id` int(12) NOT NULL COMMENT '主键',
  `position_id` int(12) NOT NULL COMMENT '职位id',
  `message` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '信息',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '岗位职责\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume`  (
  `id` int(12) NOT NULL COMMENT '主键',
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1062852837', '970725', '1062852837@163.com', '17806266772', 1, '1', '2019-04-18 12:44:33', 1, '2019-04-19 13:39:33', 1);
INSERT INTO `user` VALUES (2, 'admin', 'admin', '1062852837@qq.com', '17806266772', 0, '1', '2019-04-19 13:37:46', -1, '2019-04-19 13:39:37', -1);
INSERT INTO `user` VALUES (3, 'ls1062852837', '123456', 'liushuo1062852837@gmail.com', '17806266772', 2, '1', '2019-04-19 13:41:28', -1, '2019-04-19 13:41:28', -1);

-- ----------------------------
-- Table structure for work_experience
-- ----------------------------
DROP TABLE IF EXISTS `work_experience`;
CREATE TABLE `work_experience`  (
  `id` int(12) NOT NULL COMMENT '主键',
  `resume_id` int(12) NOT NULL COMMENT '简历id',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '详细信息',
  `creation_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int(12) NOT NULL DEFAULT -1 COMMENT '创建人',
  `last_update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_updated_by` int(12) NOT NULL DEFAULT -1 COMMENT '最后修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '工作经历表\r\n' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
