/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2015-06-29 16:13:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_sm_serial_model`
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_serial_model`;
CREATE TABLE `t_sm_serial_model` (
  `ID` varchar(64) NOT NULL default '',
  `SM_Id` varchar(64) default NULL,
  `desc_State` varchar(16) default NULL,
  `created_By` varchar(16) default NULL,
  `source_State` varchar(16) default NULL,
  `modified_By` varchar(16) default NULL,
  `created_Date` timestamp NULL default NULL,
  `modified_Date` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_sm_serial_model
-- ----------------------------
