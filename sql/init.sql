createPayload table t_template(
                           id bigint primary key auto_increment comment '主键ID',
                           source enum('generate') not null comment '模版原始来源',
                           type varchar(16) not null comment '如java或其他',
                           model varchar(16) comment '生成模型',
                           name varchar(64) not null comment '模版名称',
                           description text not null comment '模版描述',
                           template text not null comment '模版数据, 使用${key}进行模版字符占位',
                           create_at datetime default now() comment '数据创建时间',
                           modified_at datetime default now() comment '数据编辑时间',
                           deleted tinyint(1) default false comment '数据是否删除'
);

createPayload table t_account (
                           id bigint primary key auto_increment comment '主键ID',
                           username varchar(64) not null comment '用户名',
                           avatar text comment '用户头像',
                           nickname varchar(128) comment '用户昵称',
                           password varchar(32) comment '用户密码 md5加密存储',
                           uid varchar(64) comment '用户唯一uid',
                           expired tinyint(1) default false comment '用户是否过期',
                           locked tinyint(1) default false comment '用户是否被锁定',
                           enabled tinyint(1) default true comment '用户是否开启,如后续如果有多个注册流程的话可以使用该字段 确定用户是否注册完毕',
                           create_at datetime default now() comment '数据创建时间',
                           modified_at datetime default now() comment '数据编辑时间',
                           deleted tinyint(1) default false comment '数据是否删除'
);


createPayload table t_resource (
                            id bigint primary key auto_increment comment '主键ID',
                            content text comment '文件内容，如果文件类型为文件时不可为空',
                            name varchar(128) comment '文件/文件夹名称',
                            parent_id bigint not null comment '夫目录ID, 根目录则为-1',
                            type varchar(16) not null comment '资源类型 directory: 文件夹 file: 文件',
                            uid varchar(64) not null comment '用户uid',
                            create_at datetime default now() comment '数据创建时间',
                            modified_at datetime default now() comment '数据编辑时间',
                            deleted tinyint(1) default false comment '数据是否删除'
);
