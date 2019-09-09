/*
 Navicat Premium Data Transfer

 Source Server         : 47.107.171.232
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 47.107.171.232:3306
 Source Schema         : skeleton

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 09/09/2019 17:05:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for QRTZ_BLOB_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;
CREATE TABLE `QRTZ_BLOB_TRIGGERS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BLOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `SCHED_NAME`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_CALENDARS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CALENDARS`;
CREATE TABLE `QRTZ_CALENDARS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_CRON_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;
CREATE TABLE `QRTZ_CRON_TRIGGERS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_CRON_TRIGGERS
-- ----------------------------
INSERT INTO `QRTZ_CRON_TRIGGERS` VALUES ('DefaultQuartzScheduler', 'job', 'test', '0/5 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for QRTZ_FIRED_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;
CREATE TABLE `QRTZ_FIRED_TRIGGERS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ENTRY_ID` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TRIG_INST_NAME`(`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY`(`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_FT_J_G`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_T_G`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TG`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_JOB_DETAILS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;
CREATE TABLE `QRTZ_JOB_DETAILS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_DURABLE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_J_REQ_RECOVERY`(`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_J_GRP`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_JOB_DETAILS
-- ----------------------------
INSERT INTO `QRTZ_JOB_DETAILS` VALUES ('DefaultQuartzScheduler', 'job', 'test', NULL, 'com.zyxx.skeleton.assembly.quartz.job.MyJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000269647372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787000000000000000017800);

-- ----------------------------
-- Table structure for QRTZ_LOCKS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_LOCKS`;
CREATE TABLE `QRTZ_LOCKS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOCK_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_LOCKS
-- ----------------------------
INSERT INTO `QRTZ_LOCKS` VALUES ('DefaultQuartzScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for QRTZ_PAUSED_TRIGGER_GRPS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;
CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_SCHEDULER_STATE
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;
CREATE TABLE `QRTZ_SCHEDULER_STATE`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_SIMPLE_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPLE_TRIGGERS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_SIMPROP_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPROP_TRIGGERS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STR_PROP_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INT_PROP_1` int(11) NULL DEFAULT NULL,
  `INT_PROP_2` int(11) NULL DEFAULT NULL,
  `LONG_PROP_1` bigint(20) NULL DEFAULT NULL,
  `LONG_PROP_2` bigint(20) NULL DEFAULT NULL,
  `DEC_PROP_1` decimal(13, 4) NULL DEFAULT NULL,
  `DEC_PROP_2` decimal(13, 4) NULL DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;
CREATE TABLE `QRTZ_TRIGGERS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PRIORITY` int(11) NULL DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) NULL DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) NULL DEFAULT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_J`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_C`(`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_T_G`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_STATE`(`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_STATE`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_G_STATE`(`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME`(`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST`(`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `QRTZ_JOB_DETAILS` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_TRIGGERS
-- ----------------------------
INSERT INTO `QRTZ_TRIGGERS` VALUES ('DefaultQuartzScheduler', 'job', 'test', 'job', 'test', NULL, 1568012645000, 1568012640000, 5, 'PAUSED', 'CRON', 1567834198000, 0, NULL, 0, '');

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录地点',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `device` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录设备',
  `code` int(11) NULL DEFAULT NULL COMMENT '状态码',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 74 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES (1, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 18:35:46', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (2, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-04 00:21:02', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (3, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-04 00:21:02', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (4, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-04 16:13:30', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (23, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-10 12:43:52', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (24, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-10 12:43:52', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (25, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 19:54:47', 'Chrome -- Windows 10', 200, '用户不存在');
INSERT INTO `login_log` VALUES (26, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 19:55:12', 'Chrome -- Windows 10', 200, '用户不存在');
INSERT INTO `login_log` VALUES (27, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 19:59:36', 'Chrome -- Windows 10', 200, '用户不存在');
INSERT INTO `login_log` VALUES (28, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 20:03:50', 'Chrome -- Windows 10', 500, '用户不存在');
INSERT INTO `login_log` VALUES (29, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 20:04:30', 'Chrome -- Windows 10', 500, '用户不存在');
INSERT INTO `login_log` VALUES (30, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 21:59:32', 'Chrome -- Windows 10', 500, '用户不存在');
INSERT INTO `login_log` VALUES (31, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 22:01:03', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (32, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 22:01:13', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (33, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 22:07:26', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (34, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 22:10:16', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (35, 'admin', '192.168.1.105', '0|0|0|内网IP|内网IP', '2019-08-11 22:23:49', 'Chrome -- Windows 10Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (36, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 13:52:21', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (37, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 13:54:29', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (38, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 13:56:46', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (39, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:03:07', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (40, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:04:17', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (41, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:06:14', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (42, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:07:06', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (43, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:09:27', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (44, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:09:36', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (45, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:52:16', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (46, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:52:26', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (47, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 09:15:00', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (48, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 10:15:50', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (49, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 11:41:18', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (50, 'tellsea', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 11:46:06', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (51, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 14:57:38', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (52, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:20:53', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (53, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:24:36', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (54, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:28:56', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (55, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:32:25', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (56, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:34:15', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (57, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:42:22', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (58, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:43:47', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (59, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:46:35', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (60, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:46:55', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (61, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:50:51', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (62, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:41:23', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (63, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:43:21', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (64, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:48:21', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (65, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:50:57', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (66, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:59:09', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (67, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 12:01:05', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (68, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 12:04:37', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (69, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 12:07:07', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (70, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 22:16:33', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (71, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-07 12:14:49', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (72, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-09 15:02:57', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (73, 'admin', '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-09 15:05:26', 'Chrome -- Windows 10', 200, 'OK');

-- ----------------------------
-- Table structure for map_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `map_role_resource`;
CREATE TABLE `map_role_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `resource_id` int(11) NOT NULL COMMENT '菜单/按钮ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色资源关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of map_role_resource
-- ----------------------------
INSERT INTO `map_role_resource` VALUES (81, 1, 1);
INSERT INTO `map_role_resource` VALUES (82, 1, 2);
INSERT INTO `map_role_resource` VALUES (83, 1, 13);
INSERT INTO `map_role_resource` VALUES (84, 1, 3);
INSERT INTO `map_role_resource` VALUES (85, 1, 7);
INSERT INTO `map_role_resource` VALUES (86, 1, 9);
INSERT INTO `map_role_resource` VALUES (87, 1, 4);
INSERT INTO `map_role_resource` VALUES (88, 1, 5);
INSERT INTO `map_role_resource` VALUES (89, 1, 6);
INSERT INTO `map_role_resource` VALUES (90, 1, 8);
INSERT INTO `map_role_resource` VALUES (91, 1, 10);
INSERT INTO `map_role_resource` VALUES (92, 1, 11);
INSERT INTO `map_role_resource` VALUES (93, 1, 12);
INSERT INTO `map_role_resource` VALUES (94, 1, 14);
INSERT INTO `map_role_resource` VALUES (95, 1, 16);
INSERT INTO `map_role_resource` VALUES (96, 1, 15);

-- ----------------------------
-- Table structure for map_user_role
-- ----------------------------
DROP TABLE IF EXISTS `map_user_role`;
CREATE TABLE `map_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of map_user_role
-- ----------------------------
INSERT INTO `map_user_role` VALUES (1, 1, 1);
INSERT INTO `map_user_role` VALUES (2, 2, 2);
INSERT INTO `map_user_role` VALUES (3, 3, 3);
INSERT INTO `map_user_role` VALUES (4, 4, 4);
INSERT INTO `map_user_role` VALUES (5, 5, 5);

-- ----------------------------
-- Table structure for resource_info
-- ----------------------------
DROP TABLE IF EXISTS `resource_info`;
CREATE TABLE `resource_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名称',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父级ID',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL',
  `perms` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '权限标识',
  `type` int(11) NOT NULL COMMENT '1menu菜单，2button',
  `icon` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  `is_leaf` tinyint(1) NULL DEFAULT 0 COMMENT '是否叶子节点，0 否，1 是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of resource_info
-- ----------------------------
INSERT INTO `resource_info` VALUES (1, '设置', 0, '/setting', 'setting', 1, 'layui-icon-set', 0, 0);
INSERT INTO `resource_info` VALUES (2, '系统管理', 1, '/systemManage', 'systemManage', 1, '', 0, 0);
INSERT INTO `resource_info` VALUES (3, '用户管理', 2, '/userInfo/init', 'userInfo:init', 1, '', 0, 0);
INSERT INTO `resource_info` VALUES (4, '新增用户', 3, '/userInfo/save**', 'userInfo:save', 2, '', 0, 1);
INSERT INTO `resource_info` VALUES (5, '更新用户', 3, '/userInfo/update**', 'userInfo:update', 2, '', 0, 1);
INSERT INTO `resource_info` VALUES (6, '删除用户', 3, '/userInfo/delete**', 'userInfo:delete', 2, '', 0, 1);
INSERT INTO `resource_info` VALUES (7, '角色管理', 2, '/roleInfo/init', 'roleInfo:init', 1, '', 0, 0);
INSERT INTO `resource_info` VALUES (8, '更新角色', 7, '/roleInfo/update**', 'roleInfo:update', 1, '', 0, 1);
INSERT INTO `resource_info` VALUES (9, '权限管理', 2, '/resourceInfo/init', 'resourceInfo:init', 1, '', 0, 0);
INSERT INTO `resource_info` VALUES (10, '新增权限', 9, '/resourceInfo/save**', 'resourceInfo:save', 1, '', 0, 1);
INSERT INTO `resource_info` VALUES (11, '更新权限', 9, '/resourceInfo/update**', 'resourceInfo:update', 1, '', 0, 1);
INSERT INTO `resource_info` VALUES (12, '删除权限', 9, '/resourceInfo/delete**', 'resourceInfo:delete', 1, '', 0, 1);
INSERT INTO `resource_info` VALUES (13, '系统日志', 1, '/systemLog/init', 'systemLog:init', 1, '', 0, 0);
INSERT INTO `resource_info` VALUES (14, '登录日志', 13, '/loginLog/init', 'loginLog:init', 1, '', 0, 0);
INSERT INTO `resource_info` VALUES (15, '删除日志', 14, '/loginLog/delete**', 'loginLog:delete', 1, '', 0, 1);
INSERT INTO `resource_info` VALUES (16, '操作日志', 13, '/systemLog/init', 'systemLog:init', 1, '', 0, 0);

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, 'admin', '超级管理员');
INSERT INTO `role_info` VALUES (2, 'scott', '系统管理员');
INSERT INTO `role_info` VALUES (3, 'monitor', '系统监控员');
INSERT INTO `role_info` VALUES (4, 'task', '任务调度员');
INSERT INTO `role_info` VALUES (5, 'tourist', '测试账号');

-- ----------------------------
-- Table structure for system_log
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作用户',
  `operation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述',
  `time` int(11) NULL DEFAULT NULL COMMENT '耗时(毫秒)',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方法',
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作参数',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户，登录名，不可更改',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐值',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `sex` int(1) NULL DEFAULT NULL COMMENT '性别 1男 2女',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_user` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态 0 有效 1 锁定 2 删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'admin', '超级管理员', 'a994fef0ddad5f9eed20804e7b18f559', 'VKqvum8YW0xNaTDFbrcijhTG6wUP5xAZ', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2562372298,495845374&fm=26&gp=0.jpg', '18386474459', 1, 'I am Iron Man', 0, '2019-06-21 16:16:30', 0);
INSERT INTO `user_info` VALUES (2, 'tiger', '系统管理员', '44eb196feb810ee770047cc34da66133', 'V1D9h266hLYqYfF5DnZCjlJKyG3Gx36c', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3041599764,2432042915&fm=26&gp=0.jpg', '18384595550', 2, '我这么美，我不能死！', 1, '2019-06-22 12:40:46', 0);
INSERT INTO `user_info` VALUES (3, 'scott', '系统监控员', '221605ef8256bb0cfbbfa5fb7688eaf1', '2HI9EdHJjSYsfyqSdbWlXZRxJNXvFnrE', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=584948523,1006436504&fm=26&gp=0.jpg', '13738449593', 2, '天生我才必有用', 1, '2019-06-22 12:45:14', 0);
INSERT INTO `user_info` VALUES (4, 'tellsea', '任务调度员', '71610aebc66d2d8643612dc334f8d69f', 'RccHBFBuC3zMywg97HVUXWd5UgKLFVqX', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1211952391,3572964969&fm=26&gp=0.jpg', '15876776539', 1, '一只懒惰的小海绵', 1, '2019-06-22 12:48:28', 0);
INSERT INTO `user_info` VALUES (5, 'tourist', '测试账号', '防守打法', '第三方', 'http://img0.imgtn.bdimg.com/it/u=567532250,2783494804&fm=26&gp=0.jpg', '17533345965', 1, '测试账号', 1, '2019-08-04 08:22:59', 2);

SET FOREIGN_KEY_CHECKS = 1;
