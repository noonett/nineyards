CREATE DATABASE IF NOT EXISTS `nineyards`;

USE `nineyards`;

DROP TABLE IF EXISTS demo, `user`, company, project, phase, project_manager, schedule, reminder;

CREATE TABLE `demo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `type` int DEFAULT NULL COMMENT '0- Project Member; 1- Project Manager; 2- Client;',
  `status` int DEFAULT NULL COMMENT '0- Deleted; 1- Active;',
  `activation_code` varchar(100) DEFAULT NULL,
  `header_url` varchar(200) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_username` (`username`(20)),
  KEY `index_email` (`email`(20))
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_id` int DEFAULT NULL,
  `type` int NOT NULL COMMENT '0- Project Member; 1- Project Manager; 2- Client;',
  `status` int DEFAULT NULL COMMENT '0- Active; 1- Deleted;',
  `name` varchar(45) NOT NULL,
  `notes` varchar(200) DEFAULT NULL,
  `main_telephone` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `email_address` varchar(45) NOT NULL,
  `extra_contacts` varchar(100) DEFAULT NULL,
  `landline` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `status` int DEFAULT NULL COMMENT '0- Active; 1- Deleted;',
  `name` varchar(45) NOT NULL,
  `abn` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `abn_UNIQUE` (`abn`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `project_manager` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `company_id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email_address` varchar(45) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_address_UNIQUE` (`email_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `reminder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `phase_id` varchar(45) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `notify_time` timestamp NOT NULL,
  `status` int NOT NULL COMMENT '0- Wait to notify; 1- Deleted; 2 - Notified',
  `create_time` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `project` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pm_id` int NOT NULL,
  `company_id` int NOT NULL,
  `status` int DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `member_id_list` varchar(200) DEFAULT NULL,
  `summary` varchar(200) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `phase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `project_id` varchar(45) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `dependency` varchar(45) DEFAULT NULL,
  `visibility` int NOT NULL COMMENT '0- visible; 1- not visible to client;',
  `status` int DEFAULT NULL,
  `type` int DEFAULT NULL COMMENT '0- normal; 1- milestone;',
  `description` varchar(200) DEFAULT NULL,
  `start_date` timestamp NULL DEFAULT NULL,
  `duration` bigint DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `action` (
  `id` int NOT NULL,
  `phase_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `visibility` int DEFAULT NULL COMMENT '0- visible; 1- not visible to client;',
  `dependency` varchar(45) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `type` int DEFAULT NULL COMMENT '0- normal; 1- milestone;',
  `attachment_url` varchar(200) DEFAULT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `duration` bigint DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

