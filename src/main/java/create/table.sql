DROP TABLE IF EXISTS `tp3_user_log`;
CREATE TABLE `tp3_user_log` (
  `log_id` bigint(20) NOT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `log_time` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tp3_user`;
CREATE TABLE `tp3_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'openid公众号唯一id',
  `open_id` varchar(100) DEFAULT 'unique',
  `name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `phone` varchar(11) DEFAULT NULL COMMENT '用户电话',
  `worker_number` varchar(8) DEFAULT NULL COMMENT '工号',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `open_id_unique` (`open_id`),
  UNIQUE KEY `worker_number_unique` (`worker_number`)
) ENGINE=InnoDB AUTO_INCREMENT=1538375469 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tp3_insurance_file`;
CREATE TABLE `tp3_insurance_file` (
  `insurance_file_id` bigint(20) NOT NULL,
  `url` varchar(200) DEFAULT NULL COMMENT '图片url',
  `file_name` varchar(100) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `create_time` datetime DEFAULT NULL COMMENT '生产时间',
  PRIMARY KEY (`insurance_file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tp3_insurance`;
CREATE TABLE `tp3_insurance` (
  `insurance_id` bigint(20) NOT NULL,
  `insurance_number` varchar(20) DEFAULT NULL COMMENT '保单号',
  `insurance_type_id` bigint(20) DEFAULT NULL,
  `insurance_type_name` varchar(60) DEFAULT NULL COMMENT '保单类型',
  `policy_holder_name` varchar(20) DEFAULT NULL COMMENT '投保人名字',
  `policy_holder_sex` varchar(10) DEFAULT NULL COMMENT '投保人性别',
  `policy_creit_card` varchar(30) DEFAULT NULL COMMENT '投保人身份证',
  `policy_holder_birthday` varchar(100) DEFAULT NULL COMMENT '投保人生日',
  `insured_person_name` varchar(20) DEFAULT NULL COMMENT '被保人名字',
  `insured_person_sex` varchar(10) DEFAULT NULL COMMENT '被保人性别',
  `insured_creit_card` varchar(30) DEFAULT NULL COMMENT '被报人身份证',
  `insured_person_birthday` varchar(100) DEFAULT NULL COMMENT '被保人生日',
  `worker_number` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '工号',
  `file_id` bigint(20) unsigned zerofill DEFAULT NULL COMMENT '文件id',
  `is_check` int(2) DEFAULT '0' COMMENT '是否审核',
  `sure_num` int(22) DEFAULT NULL COMMENT '投保份数',
  PRIMARY KEY (`insurance_id`),
  UNIQUE KEY `un_number` (`insurance_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tp3_ensure_type`;
CREATE TABLE `tp3_ensure_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ensure_type_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

INSERT INTO `tp3_ensure_type` VALUES ('1', '生命保障');
INSERT INTO `tp3_ensure_type` VALUES ('2', '意外保障');
INSERT INTO `tp3_ensure_type` VALUES ('3', '重疾防癌');
INSERT INTO `tp3_ensure_type` VALUES ('4', '医疗保障');
INSERT INTO `tp3_ensure_type` VALUES ('5', '养老保障');
INSERT INTO `tp3_ensure_type` VALUES ('6', '子女教育');
INSERT INTO `tp3_ensure_type` VALUES ('7', '子女意外');


DROP TABLE IF EXISTS `tp3_ensure_insurace_relation`;
CREATE TABLE `tp3_ensure_insurace_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ensure_name` varchar(255) NOT NULL,
  `insurance_name` varchar(255) NOT NULL,
  `money` int(20) NOT NULL,
  `updateNo` datetime DEFAULT CURRENT_TIMESTAMP,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `project_name` varchar(255) DEFAULT NULL COMMENT '保险项目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

INSERT INTO `tp3_ensure_insurace_relation` VALUES ('1', '重疾防癌', '金佑人生终身寿险(分红型)A款(2014版)', '0', '2018-08-07 23:46:00', '2018-08-07 23:46:00', '特定疾病保费豁免');
INSERT INTO `tp3_ensure_insurace_relation` VALUES ('2', '重疾防癌', '金佑人生终身寿险(分红型)A款(2014版)', '2000', '2018-08-07 23:47:43', '2018-08-07 23:47:43', '12种特定疾病保障');
INSERT INTO `tp3_ensure_insurace_relation` VALUES ('3', '重疾防癌', '金佑人生终身寿险(分红型)A款(2014版)', '10000', '2018-08-07 23:47:46', '2018-08-07 23:47:46', '60种重大疾病保障');
INSERT INTO `tp3_ensure_insurace_relation` VALUES ('4', '意外保障', '金佑人生终身寿险(分红型)A款(2014版)', '10000', '2018-08-07 23:47:49', '2018-08-07 23:47:49', '意外身故保障');
INSERT INTO `tp3_ensure_insurace_relation` VALUES ('5', '生命保障', '金佑人生终身寿险(分红型)A款(2014版)', '10000', '2018-08-07 23:47:50', '2018-08-07 23:47:50', '疾病身故保障');
INSERT INTO `tp3_ensure_insurace_relation` VALUES ('6', '重疾防癌', '爱无忧两全保险(2.0版）', '50000', '2018-08-07 23:57:53', '2018-08-07 23:57:53', '甲状腺恶性肿瘤');
INSERT INTO `tp3_ensure_insurace_relation` VALUES ('7', '重疾防癌', '爱无忧两全保险(2.0版）', '100000', '2018-08-07 23:57:55', '2018-08-07 23:57:55', '其他恶性肿瘤');
INSERT INTO `tp3_ensure_insurace_relation` VALUES ('8', '重疾防癌', '爱无忧两全保险(2.0版）', '150000', '2018-08-07 23:57:56', '2018-08-07 23:57:56', '特定恶性肿瘤\r\n男：肺、肝、前列腺\r\n女：肺、乳腺、子宫');
INSERT INTO `tp3_ensure_insurace_relation` VALUES ('9', '生命保障', '金诺人生重大疾病保险(2018版)', '10000', '2018-08-07 23:59:11', '2018-08-07 23:59:11', '疾病身故保障');
INSERT INTO `tp3_ensure_insurace_relation` VALUES ('10', '意外保障', '金诺人生重大疾病保险(2018版)', '10000', '2018-08-07 23:59:14', '2018-08-07 23:59:14', '意外身故保障');
INSERT INTO `tp3_ensure_insurace_relation` VALUES ('11', '重疾防癌', '金诺人生重大疾病保险(2018版)', '10000', '2018-08-07 23:59:16', '2018-08-07 23:59:16', '100种重大疾病保障');
INSERT INTO `tp3_ensure_insurace_relation` VALUES ('12', '重疾防癌', '金诺人生重大疾病保险(2018版)', '2000', '2018-08-07 23:59:21', '2018-08-07 23:59:21', '50种特定疾病保障\r\n（可赔付3次）');
INSERT INTO `tp3_ensure_insurace_relation` VALUES ('13', '重疾防癌', '金诺人生重大疾病保险(2018版)', '0', '2018-08-07 23:59:25', '2018-08-07 23:59:25', '特定疾病保费豁免');