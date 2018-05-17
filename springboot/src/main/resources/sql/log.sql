-- 日志表：t_log
-- 标题，时间，图片，内容

DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '标题',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '图片',
  `content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `createTime` datetime DEFAULT NULL,
  `modified` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;