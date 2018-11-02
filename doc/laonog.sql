/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
create temporary table SYS_USER
(
   id                   bigint(20) unsigned not null auto_increment comment '主键ID',
   username             varchar(32) not null comment '用户名',
   password             varchar(32) not null comment '密码',
   phone_number         varchar(16) not null comment '手机号码',
   avatar               varchar(32) comment '头像',
   nickname             varchar(32) comment '昵称',
   qr_code              varchar(32) not null comment '二维码名片',
   user_status          tinyint(1) not null DEFAULT '0' comment '用户状态 0-正常 1-锁定',
   is_real_name         tinyint(1) not null DEFAULT '0' comment '是否实名认证 1-是 0-否',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table SYS_USER comment '用户信息表';

/*==============================================================*/
/* Table: SYS_MENU                                              */
/*==============================================================*/
create table SYS_MENU
(
   id                   bigint(20) unsigned not null auto_increment comment '主键ID',
   name                 varchar(64) not null comment '菜单名称',
   permission           varchar(32) DEFAULT null COMMENT '菜单权限标识',
   url                  varchar(128) DEFAULT null comment '请求链接',
   path                 varchar(128) DEFAULT null COMMENT '前端URL',
   method               varchar(32) DEFAULT null COMMENT '请求方法',
   icon                 varchar(32) DEFAULT null comment '菜单图标',
   parent_id            bigint(20) unsigned DEFAULT null comment '父菜单ID',
   component            varchar(64) DEFAULT null COMMENT 'VUE页面',
   sort                 int(11) DEFAULT '1' COMMENT '排序值',
   type                 tinyint(1) not null COMMENT '菜单类型 （0菜单 1按钮）',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table SYS_MENU comment '资源菜单表';