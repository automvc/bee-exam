/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : bee

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2020-03-02 16:42:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `total` decimal(10,2) NOT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sequence` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `abc` varchar(20) DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('100001', 'bee', 'Bee(ORM Framework)', '95.01', '2020-03-02 11:29:28', 'test', '12345601', 'test1', '2020-03-02 16:34:19');
INSERT INTO `orders` VALUES ('100002', 'bee', 'Bee(ORM Framework)', '96.01', '2020-03-02 11:29:28', 'test', '12345602', 'test2', '2020-03-02 16:34:19');
INSERT INTO `orders` VALUES ('100003', 'bee', 'Bee(ORM Framework)', '97.01', '2020-03-02 11:29:28', 'test', '12345603', 'test3', '2020-03-02 16:34:19');
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(60) COLLATE utf8_bin NOT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=800003 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('800001', 'beeUser@163.com', null, 'Bee', 'bee', 'bee', null);
INSERT INTO `user` VALUES ('800002', 'honey@163.com', null, 'Honey', 'honey', 'honey', '2020-03-02 16:41:33');

-- ----------------------------
-- Table structure for `leaf_alloc`
-- ----------------------------
DROP TABLE IF EXISTS `leaf_alloc`;
CREATE TABLE `leaf_alloc` (
  `id` bigint(11) NOT NULL,
  `biz_tag` varchar(128) COLLATE utf8_bin NOT NULL DEFAULT '',
  `max_id` bigint(20) NOT NULL DEFAULT '1',
  `step` int(11) NOT NULL,
  `description` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_index_biz_tag` (`biz_tag`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of leaf_alloc
-- id(456537470402562) has global unique featrue.
-- see: org.teasoft.honey.distribution.SerialUniqueId
-- ----------------------------
INSERT INTO `leaf_alloc` VALUES ('456537470402562', 'test', '100', '100', 'test segment', '2020-07-04 22:42:09', '1');
INSERT INTO `leaf_alloc` VALUES ('456537470402563', 'order', '100', '100', 'order segment', '2020-07-04 22:42:10', '1');

