/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : hospital

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 05/05/2021 19:43:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for behospital
-- ----------------------------
DROP TABLE IF EXISTS `behospital`;
CREATE TABLE `behospital`  (
  `beH_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `beH_nursePeoPle` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护理人',
  `beH_patBed` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病床号',
  `beH_antecedent` double NULL DEFAULT NULL COMMENT '交纳押金',
  `beH_illness` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病情介绍',
  `beH_closePrice` int(0) NULL DEFAULT NULL COMMENT '结算状态',
  `beH_state` int(0) NULL DEFAULT NULL COMMENT '信息状态',
  PRIMARY KEY (`beH_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 124 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of behospital
-- ----------------------------
INSERT INTO `behospital` VALUES (1, '高鹏帅', '0', 123, '123', 123, 1);
INSERT INTO `behospital` VALUES (2, '挖的啊', '2', 123, '123', 123123, 0);
INSERT INTO `behospital` VALUES (3, '123', '2', 123, '123', 123, 0);
INSERT INTO `behospital` VALUES (123, '321', '123', NULL, 'asd', 321, 0);

-- ----------------------------
-- Table structure for chargeproject
-- ----------------------------
DROP TABLE IF EXISTS `chargeproject`;
CREATE TABLE `chargeproject`  (
  `chaP_id` int(0) NULL DEFAULT NULL COMMENT '编号',
  `chaP_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收费项目名称',
  `chaP_money` double NULL DEFAULT NULL COMMENT '收费金额'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chargeproject
-- ----------------------------
INSERT INTO `chargeproject` VALUES (23, '234', 234);
INSERT INTO `chargeproject` VALUES (1, '摇头丸', 200);
INSERT INTO `chargeproject` VALUES (2, '冰毒', 400);
INSERT INTO `chargeproject` VALUES (333, '123', 123);

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `d_id` int(0) NULL DEFAULT NULL COMMENT '医生编号',
  `d_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `d_idcar` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证好',
  `d_phone` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `d_telPhone` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '座机',
  `d_sex` int(0) NULL DEFAULT NULL COMMENT '性别',
  `d_birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `d_age` int(0) NULL DEFAULT NULL COMMENT '年龄',
  `d_email` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `d_keshi` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属科室',
  `d_xueli` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `d_desc` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `d_inTime` date NULL DEFAULT NULL COMMENT '入职时间',
  `d_state` int(0) NULL DEFAULT NULL COMMENT '状态'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (3, '程俊', '123123123123123123', '13124345432', '01068765432', 0, '1981-09-04', 28, 'chengjun@msn.com.cn', '急诊科', '专科', '', '2021-04-19', 0);
INSERT INTO `doctor` VALUES (4, '程俊', '123123123123123123', '13124345432', '01068765432', 0, '1981-09-04', 28, 'chengjun@msn.com.cn', '急诊科', '专科', '1234124', '2021-04-19', 0);
INSERT INTO `doctor` VALUES (5, '程俊', '123123123123123123', '13124345432', '01068765432', 0, '1981-09-04', 28, 'chengjun@msn.com.cn', '急诊科', '本科', '工作热情积极表现非常的优异', '2021-04-19', 0);
INSERT INTO `doctor` VALUES (7, '刘八', '123123123123123123', '18888888888', '01088888888', 0, '1988-08-18', 28, '18888@qq.com', '血液科', '博士', '888888', '2021-04-27', 0);

-- ----------------------------
-- Table structure for drug
-- ----------------------------
DROP TABLE IF EXISTS `drug`;
CREATE TABLE `drug`  (
  `dr_id` int(0) NULL DEFAULT NULL COMMENT '药品编号',
  `dr_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品图片URL',
  `dr_inPrice` double NULL DEFAULT NULL COMMENT '进价',
  `dr_outPrice` double NULL DEFAULT NULL COMMENT '售价',
  `dr_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `dr_type` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品类型',
  `dr_simDesc` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简单介绍',
  `dr_date` date NULL DEFAULT NULL COMMENT '保质期',
  `dr_detaDesc` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细描述',
  `dr_fatory` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产厂家',
  `dr_direction` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服用说明',
  `dr_remark` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `dr_number` int(0) NULL DEFAULT NULL COMMENT '药品的库存'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug
-- ----------------------------
INSERT INTO `drug` VALUES (123, NULL, 12, 12, '123', '123', '123', '2021-04-27', '123', '123', '123', '123', 123);

-- ----------------------------
-- Table structure for drugpeople
-- ----------------------------
DROP TABLE IF EXISTS `drugpeople`;
CREATE TABLE `drugpeople`  (
  `dr_id` int(0) NULL DEFAULT NULL COMMENT '药品的编号',
  `peopleId` int(0) NULL DEFAULT NULL COMMENT '病人的编号',
  `dr_number` int(0) NULL DEFAULT NULL COMMENT '药品的数量'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drugpeople
-- ----------------------------
INSERT INTO `drugpeople` VALUES (123, 321, 12);

-- ----------------------------
-- Table structure for hosregister
-- ----------------------------
DROP TABLE IF EXISTS `hosregister`;
CREATE TABLE `hosregister`  (
  `hosR_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `hosR_idCar` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `hosR_medical` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '社保号',
  `hosR_regPrice` decimal(10, 0) NULL DEFAULT NULL COMMENT '挂号费',
  `hosR_phone` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `hosR_selfPrice` int(0) NULL DEFAULT NULL COMMENT '是否自费 0自费1免费',
  `hosR_sex` int(0) NULL DEFAULT NULL COMMENT '性别',
  `hosR_age` int(0) NULL DEFAULT NULL COMMENT '年龄',
  `hosR_work` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `hosR_lookDoctor` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '初复诊 0初诊1复诊',
  `d_id` int(0) NULL DEFAULT NULL COMMENT '医生编号',
  `hosR_remark` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `hosR_state` int(0) NULL DEFAULT NULL COMMENT '挂号状态 0挂号1已住院2已出院3已退号'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hosregister
-- ----------------------------
INSERT INTO `hosregister` VALUES ('1', '440921200011138333', '1688888', 80, '15102033158', 0, 0, 18, 'java', '0', 1, '备注备注', 0);
INSERT INTO `hosregister` VALUES ('1', '440921200011138333', '1688888', 80, '15102033158', 0, 0, 18, 'java', '0', 1, '备注备注', 0);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `m_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `m_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名字',
  `m_state` int(0) NULL DEFAULT NULL COMMENT '菜单状态',
  `m_url` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单路径',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (2, '挂号信息办理', 0, '/register/index');
INSERT INTO `menu` VALUES (11, '用户管理', 0, '/user/index');
INSERT INTO `menu` VALUES (12, '角色管理', 0, '/role/index');
INSERT INTO `menu` VALUES (13, '资源管理', 0, '/menu/index');

-- ----------------------------
-- Table structure for pricepeople
-- ----------------------------
DROP TABLE IF EXISTS `pricepeople`;
CREATE TABLE `pricepeople`  (
  `chaP_id` int(0) NULL DEFAULT NULL COMMENT '收费编号',
  `beH_id` int(0) NULL DEFAULT NULL COMMENT '病人编号'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pricepeople
-- ----------------------------
INSERT INTO `pricepeople` VALUES (23, 123);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `r_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `r_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `r_state` int(0) NULL DEFAULT NULL COMMENT '角色状态',
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', 0);
INSERT INTO `role` VALUES (2, '医生', 0);
INSERT INTO `role` VALUES (3, '药品管理员', 0);
INSERT INTO `role` VALUES (4, '收费标准管理员', 0);
INSERT INTO `role` VALUES (11, 'aaa', 0);
INSERT INTO `role` VALUES (12, 'sss', 0);

-- ----------------------------
-- Table structure for role-menu
-- ----------------------------
DROP TABLE IF EXISTS `role-menu`;
CREATE TABLE `role-menu`  (
  `r_id` int(0) NOT NULL,
  `m_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role-menu
-- ----------------------------
INSERT INTO `role-menu` VALUES (1, 1);
INSERT INTO `role-menu` VALUES (2, 2);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `r_id` int(0) NULL DEFAULT NULL COMMENT '角色编号',
  `m_id` int(0) NULL DEFAULT NULL COMMENT '菜单编号'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 11);
INSERT INTO `role_menu` VALUES (1, 12);
INSERT INTO `role_menu` VALUES (1, 2);
INSERT INTO `role_menu` VALUES (9, 2);
INSERT INTO `role_menu` VALUES (9, 11);
INSERT INTO `role_menu` VALUES (10, 11);
INSERT INTO `role_menu` VALUES (10, 12);
INSERT INTO `role_menu` VALUES (11, 2);
INSERT INTO `role_menu` VALUES (11, 11);
INSERT INTO `role_menu` VALUES (11, 12);
INSERT INTO `role_menu` VALUES (11, 13);
INSERT INTO `role_menu` VALUES (12, 11);
INSERT INTO `role_menu` VALUES (12, 12);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_login_name` int(0) NULL DEFAULT NULL COMMENT '登陆名',
  `u_passWord` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `u_true_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `u_email` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `u_state` int(0) NULL DEFAULT NULL COMMENT '用户状态',
  `r_id` int(0) NULL DEFAULT NULL COMMENT '角色编号',
  `u_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (666, 'aaa', '迪迦', '163@qq.com', 0, 1, 1);
INSERT INTO `user` VALUES (777, 'bbb', '戴拿', '163@qq.com', 0, 1, 2);

SET FOREIGN_KEY_CHECKS = 1;
