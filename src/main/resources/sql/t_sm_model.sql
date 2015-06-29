/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2015-06-29 16:13:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_sm_model`
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_model`;
CREATE TABLE `t_sm_model` (
  `id` varchar(64) character set utf8 NOT NULL default '',
  `biz_ref_no` varchar(18) default NULL,
  `biz_type` varchar(18) default NULL,
  `current_state` varchar(18) default NULL,
  `modified_by` varchar(18) default NULL,
  `created_by` varchar(18) default NULL,
  `modified_date` timestamp NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `is_done` tinyint(1) default NULL,
  `version` int(9) default NULL,
  `attemp_count` int(9) default NULL,
  `created_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_sm_model
-- ----------------------------
