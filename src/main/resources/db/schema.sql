-- --------------------------------------------------------
-- 主机:                           10.168.1.140
-- 服务器版本:                        5.6.13-rel61.0-log - Percona Server with XtraDB (GPL), Release rel61.0, Revision 461
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 oauth_server 的数据库结构
CREATE DATABASE IF NOT EXISTS `oauth_server` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `oauth_server`;

-- 导出  表 oauth_server.clientdetails 结构
CREATE TABLE IF NOT EXISTS `clientdetails` (
  `appId` varchar(256) NOT NULL,
  `resourceIds` varchar(256) DEFAULT NULL,
  `appSecret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `grantTypes` varchar(256) DEFAULT NULL,
  `redirectUrl` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additionalInformation` varchar(4096) DEFAULT NULL,
  `autoApproveScopes` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`appId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 数据导出被取消选择。
-- 导出  表 oauth_server.oauth_access_token 结构
CREATE TABLE IF NOT EXISTS `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(256) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 数据导出被取消选择。
-- 导出  表 oauth_server.oauth_approvals 结构
CREATE TABLE IF NOT EXISTS `oauth_approvals` (
  `userId` varchar(256) DEFAULT NULL,
  `clientId` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` timestamp NULL DEFAULT NULL,
  `lastModifiedAt` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 数据导出被取消选择。
-- 导出  表 oauth_server.oauth_client_details 结构
CREATE TABLE IF NOT EXISTS `oauth_client_details` (
  `client_id` varchar(256) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 数据导出被取消选择。
-- 导出  表 oauth_server.oauth_client_token 结构
CREATE TABLE IF NOT EXISTS `oauth_client_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(256) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 数据导出被取消选择。
-- 导出  表 oauth_server.oauth_code 结构
CREATE TABLE IF NOT EXISTS `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 数据导出被取消选择。
-- 导出  表 oauth_server.oauth_refresh_token 结构
CREATE TABLE IF NOT EXISTS `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 数据导出被取消选择。
-- 导出  表 oauth_server.oauth_role 结构
CREATE TABLE IF NOT EXISTS `oauth_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `desc` varchar(255) DEFAULT NULL COMMENT '角色含义',
  `status` int(2) DEFAULT '1' COMMENT '状态',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- 数据导出被取消选择。
-- 导出  表 oauth_server.oauth_user 结构
CREATE TABLE IF NOT EXISTS `oauth_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `school_id` bigint(20) DEFAULT NULL,
  `wx_openid` varchar(200) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL COMMENT '登陆名',
  `usercode` varchar(100) DEFAULT NULL COMMENT '用户编码',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `remark_name` varchar(200) DEFAULT NULL COMMENT '备注姓名',
  `name` varchar(200) DEFAULT NULL COMMENT '用户名称',
  `nickname` text,
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  `id_number` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `province` bigint(20) DEFAULT NULL COMMENT '省份',
  `role_id` bigint(20) DEFAULT NULL COMMENT '用户角色id',
  `city` bigint(20) DEFAULT NULL COMMENT '城市',
  `url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `area` bigint(20) DEFAULT NULL COMMENT '区域',
  `address` varchar(500) DEFAULT NULL COMMENT '联系地址',
  `status` int(2) DEFAULT '1' COMMENT '状态',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `last_login_failure_time` datetime DEFAULT NULL COMMENT '最后登陆失败时间',
  `login_failure_count` int(11) DEFAULT NULL COMMENT '登陆失败次数',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `usercode` (`usercode`),
  KEY `name` (`name`(191)),
  KEY `nickname` (`nickname`(191)),
  KEY `mobile` (`mobile`),
  KEY `email` (`email`),
  KEY `wx_openid` (`wx_openid`(191)),
  KEY `school_id` (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1460 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 数据导出被取消选择。
-- 导出  表 oauth_server.oauth_user_role 结构
CREATE TABLE IF NOT EXISTS `oauth_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1584 DEFAULT CHARSET=utf8 CHECKSUM=1 COMMENT='用户角色关系表';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
