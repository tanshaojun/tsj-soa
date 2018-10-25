CREATE TABLE `article` (
  `id` int(11) auto_increment COLLATE utf8_bin NOT NULL COMMENT '{name:''主键''}',
  `title` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '{name:''标题''}',
  `smallcontent` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '{name:''较少的内容''}',
  `content` text COLLATE utf8_bin NOT NULL COMMENT '{name:''内容''}',
  `author` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '{name:''作者''}',
  `type` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '{name:''分类''}',
  `imgurl` varchar(1024) COLLATE utf8_bin NOT NULL COMMENT '{name:''图片地址''}',
  `browse` int(64) COLLATE utf8_bin NOT NULL COMMENT '{name:''浏览''}',
  `isshow` int(2) COLLATE utf8_bin NOT NULL COMMENT '{name:''是否显示''}',
  `created` datetime DEFAULT NULL COMMENT '{name:''创建时间''}',
  `modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '{name:''修改时间''}',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `article_tag_middle` (
  `id` int(11) auto_increment COLLATE utf8_bin NOT NULL COMMENT '{name:''主键''}',
  `tagid` int(11) COLLATE utf8_bin NOT NULL COMMENT '{name:''标签id''}',
  `article` int(11) COLLATE utf8_bin NOT NULL COMMENT '{name:''文章id''}',
  `created` datetime DEFAULT NULL COMMENT '{name:''创建时间''}',
  `modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '{name:''修改时间''}',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `tag` (
  `id` int(11) auto_increment COLLATE utf8_bin NOT NULL COMMENT '{name:''主键''}',
  `tagname` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '{name:''标签名''}',
  `created` datetime DEFAULT NULL COMMENT '{name:''创建时间''}',
  `modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '{name:''修改时间''}',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


INSERT INTO `blog`.`article` (`id`, `title`, `smallcontent`, `content`, `author`, `type`, `browse`, `isshow`, `created`, `modified`, `imgurl`) VALUES ('1', '明心见性的一段对话', '以下是我和妹子聊到房屋拆迁话题时的对话，希望我们能一直保持平常心，认真做自己……', '12346', '谭少军', '如是观', '1000', '1', '2018-10-24 15:11:25', '2018-10-24 15:11:55', '');

INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('觉悟', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('人生', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('摄影', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('爱情', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('心情', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('生活', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('音乐', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('规则', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('夕阳', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('寂寞', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('过往', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('西乡', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('回忆', '2018-10-24 15:32:05');
INSERT INTO `blog`.`tag` (`tagname`, `created`) VALUES ('旅行', '2018-10-24 15:32:05');

