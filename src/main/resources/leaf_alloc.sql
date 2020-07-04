/*
Source Host           : localhost:3306
Source Database       : bee
Target Server Type    : MYSQL
Date: 2020-07-04 22:42:26
*/

SET FOREIGN_KEY_CHECKS=0;

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