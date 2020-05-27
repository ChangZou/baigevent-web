
CREATE TABLE `bl_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `us_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '昵称',
  `us_email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '邮箱同账户',
  `us_cellphone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '手机号同账户',
  `us_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `us_salt` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '盐',
  `us_state` int(11) NOT NULL COMMENT '状态0删除 1 正常',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `updata_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;


CREATE TABLE `bl_userlogin_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ul_userid` int(11) NOT NULL COMMENT '登录用户id',
  `ul_login_time` datetime(0) NOT NULL COMMENT '登录时间',
  `ul_login_ip` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登录ip',
  `ul_login_msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '详情说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;
