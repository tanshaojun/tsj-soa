SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '标题',
  `createTime` datetime DEFAULT NULL,
  `modified` datetime DEFAULT CURRENT_TIMESTAMP,
  `readingvolume` int(64) DEFAULT NULL,
  `content` text,
  `type` int(11) DEFAULT NULL,
  `crux` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log
-- ----------------------------
INSERT INTO `t_log` VALUES ('5', '我本楚狂人，凤歌笑孔丘', '2018-06-11 19:38:30', '2018-06-11 19:38:26', '1', null, '1', '我们一直在坚持着，不是为了改变这个世界，而是希望不被这个世界所改变。', '../static/assets/i/f10.jpg');
INSERT INTO `t_log` VALUES ('6', '世间所有的相遇，都是久别重逢。', '2018-06-11 19:39:21', '2018-06-11 19:39:22', '1', null, '1', '你可以选择在原处不停地跟周遭不解的人解释你为何这么做，让他们理解你，你可以选择什么都不讲，自顾自往前走。', '../static/assets/i/f6.jpg');
INSERT INTO `t_log` VALUES ('7', '陌上花开，可缓缓归矣。', '2018-06-11 19:39:52', '2018-06-11 19:39:53', '1', null, '1', '那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。我们就在骑楼下躲雨，看绿色的邮筒孤独地站在街的对面。', '../static/assets/i/f12.jpg');
INSERT INTO `t_log` VALUES ('8', '爱自己是终生浪漫的开始', '2018-06-11 19:40:20', '2018-06-11 19:40:19', '1', null, '1', 'the whole of life becomes an act of letting go, but what always hurts the most is not taking a moment to say goodbye', '../static/assets/i/f22.jpg');
INSERT INTO `t_log` VALUES ('9', 'My dear amazeUI, Hello ', '2018-06-11 19:40:55', '2018-06-11 19:40:56', '1', null, '1', '那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。我们就在骑楼下躲雨，看绿色的邮筒孤独地站在街的对面。', '../static/assets/i/f18.jpg');
INSERT INTO `t_log` VALUES ('10', 'My way or the highway', '2018-06-11 19:41:20', '2018-06-11 19:41:21', '1', null, '1', 'A big wind rises， clouds are driven away. Home am Inow the world is under my sway. Where are brave men to guard the four frontiers today！ ', '../static/assets/i/f20.jpg');
INSERT INTO `t_log` VALUES ('11', '一想到你，我这张丑脸上就泛起微笑', '2018-06-11 19:41:45', '2018-06-11 19:41:44', '1', null, '1', '那一天我二十一岁，在我一生的黄金时代。我有好多奢望。我想爱，想吃，还想在一瞬间变成天上半明半暗的云。', '../static/assets/i/f19.jpg');


DROP TABLE IF EXISTS `t_advert_manage`;
CREATE TABLE `t_advert_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modified` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_advert_manage
-- ----------------------------
INSERT INTO `t_advert_manage` VALUES ('1', '总在思考一句积极的话', '那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。', '../static/assets/i/b1.jpg', '2018-06-12 09:55:30', '2018-06-12 09:55:37');
INSERT INTO `t_advert_manage` VALUES ('2', '总在思考一句积极的话', '那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。', '../static/assets/i/b2.jpg', '2018-06-12 09:56:04', '2018-06-12 09:56:05');
INSERT INTO `t_advert_manage` VALUES ('3', '总在思考一句积极的话', '那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。', '../static/assets/i/b3.jpg', '2018-06-12 09:56:29', '2018-06-12 09:56:30');
INSERT INTO `t_advert_manage` VALUES ('4', '总在思考一句积极的话', '那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。', '../static/assets/i/b2.jpg', '2018-06-12 09:56:55', '2018-06-12 09:56:56');

ALTER TABLE `t_log` ADD COLUMN `author` VARCHAR(64) DEFAULT '谭少军';

DROP TABLE IF EXISTS `t_share`;
CREATE TABLE `t_share` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_share
-- ----------------------------
INSERT INTO `t_share` VALUES ('1', 'linux', '链接：https://pan.baidu.com/s/1N_SQpAftOUa0MQxNaqyRaw 密码：1vye');
INSERT INTO `t_share` VALUES ('2', 'spring5', '链接：https://pan.baidu.com/s/1iB-8C5iZS-RPH1-uvvieEQ 密码：bfyo');
INSERT INTO `t_share` VALUES ('3', 'nginx', '链接：https://pan.baidu.com/s/1F1yd0GTByhUzTq7EU37Prg 密码：h8oh');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` text,
  `createTime` datetime DEFAULT NULL,
  `logid` int(11) DEFAULT NULL,
  `modified` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
ALTER TABLE `t_comment` ADD COLUMN `pid` int(11) DEFAULT 0;

