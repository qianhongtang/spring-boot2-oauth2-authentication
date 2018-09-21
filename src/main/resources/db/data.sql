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

-- 正在导出表  oauth_server.clientdetails 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `clientdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientdetails` ENABLE KEYS */;

-- 正在导出表  oauth_server.oauth_access_token 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `oauth_access_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_access_token` ENABLE KEYS */;

-- 正在导出表  oauth_server.oauth_approvals 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `oauth_approvals` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_approvals` ENABLE KEYS */;

-- 正在导出表  oauth_server.oauth_client_details 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `oauth_client_details` DISABLE KEYS */;
INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`) VALUES
	('client', 'user', '{bcrypt}$2a$10$2Z/E.hvDvRX68zc2mByNaeG3z1ZGwitWX8o5AdHP/Yokcqvh5Q7DG', 'select', 'authorization_code,password,client_credentials', NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `oauth_client_details` ENABLE KEYS */;

-- 正在导出表  oauth_server.oauth_client_token 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `oauth_client_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_client_token` ENABLE KEYS */;

-- 正在导出表  oauth_server.oauth_code 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `oauth_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_code` ENABLE KEYS */;

-- 正在导出表  oauth_server.oauth_refresh_token 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `oauth_refresh_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_refresh_token` ENABLE KEYS */;

-- 正在导出表  oauth_server.oauth_role 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `oauth_role` DISABLE KEYS */;
INSERT INTO `oauth_role` (`id`, `name`, `desc`, `status`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES
	(1, 'SUPER_ADMIN', '超级管理员', 1, NULL, '2017-08-27 01:38:47', 201, '2018-01-20 23:50:30'),
	(2, 'ADMIN', '管理员', 1, NULL, '2017-08-26 18:51:01', 340, '2018-04-17 12:04:39');
/*!40000 ALTER TABLE `oauth_role` ENABLE KEYS */;

-- 正在导出表  oauth_server.oauth_user 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `oauth_user` DISABLE KEYS */;
INSERT INTO `oauth_user` (`id`, `wx_openid`, `username`, `usercode`, `password`, `name`, `remark_name`, `nickname`, `mobile`, `email`, `gender`, `id_number`, `birth_date`, `province`, `city`, `url`, `area`, `address`, `status`, `last_login_time`, `last_login_failure_time`, `login_failure_count`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES
	(1, NULL, 'super_admin', NULL, '{bcrypt}$2a$10$2Z/E.hvDvRX68zc2mByNaeG3z1ZGwitWX8o5AdHP/Yokcqvh5Q7DG', '超级管理员', NULL, '超级管理员', '', 'qianhongtang@gmail.com', NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, 0, NULL, NULL, NULL, 202, '2018-01-20 23:52:07', 46, '2018-09-21 10:20:45'),
	(2, NULL, 'admin', NULL, '{bcrypt}$2a$10$2Z/E.hvDvRX68zc2mByNaeG3z1ZGwitWX8o5AdHP/Yokcqvh5Q7DG', '管理员', NULL, '管理员', '', 'qianhongtang@gmail.com', NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, 0, NULL, NULL, NULL, 202, '2018-01-20 23:52:07', 46, '2018-09-21 10:20:43');
/*!40000 ALTER TABLE `oauth_user` ENABLE KEYS */;

-- 正在导出表  oauth_server.oauth_user_role 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `oauth_user_role` DISABLE KEYS */;
INSERT INTO `oauth_user_role` (`id`, `user_id`, `role_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES
	(1, 1, 1, 1, '2017-09-14 12:20:12', 1, '2018-09-21 10:16:56'),
	(2, 1, 2, 1, '2018-09-21 10:17:06', 1, '2018-09-21 10:17:11');
/*!40000 ALTER TABLE `oauth_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
