-- SQLite
-- orders
drop table if exists orders;
CREATE TABLE orders (
  id bigint(20) PRIMARY KEY NOT NULL,
  userid varchar(20)  NOT NULL,
  name varchar(100)  DEFAULT NULL,
  total decimal(10,2) NOT NULL,
  createtime timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  remark varchar(255)  DEFAULT NULL,
  sequence varchar(30)  DEFAULT NULL,
  abc varchar(20) DEFAULT NULL,
  updatetime timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ;

-- test_user
DROP TABLE IF EXISTS test_user;
CREATE TABLE test_user (
  id bigint(20) PRIMARY KEY NOT NULL,
  email varchar(100)  DEFAULT NULL,
  last_name varchar(60)  DEFAULT NULL,
  name varchar(60)  DEFAULT NULL,
  password varchar(60)  DEFAULT NULL,
  username varchar(60)  NOT NULL,
  createtime timestamp NULL DEFAULT CURRENT_TIMESTAMP
);

-- leaf_alloc
DROP TABLE IF EXISTS leaf_alloc;
CREATE TABLE leaf_alloc (
  id PRIMARY KEY bigint(20) NOT NULL,
  biz_tag varchar(128)  NOT NULL DEFAULT '' UNIQUE,
  max_id bigint(20) NOT NULL DEFAULT '1',
  step int(11) NOT NULL,
  description varchar(256)  DEFAULT NULL,
  update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  version int(11) DEFAULT NULL
) ;
