CREATE TABLE `incity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(100) NOT NULL,
  `province_name` varchar(100) NOT NULL,
  `value` double(10,2) NOT NULL,
  `city_code` varchar(100) NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `incity_UN` (`city_code`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8


CREATE TABLE `outcity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(100) DEFAULT NULL,
  `province_name` varchar(100) DEFAULT NULL,
  `value` double(10,2) DEFAULT NULL,
  `city_code` varchar(100) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `outcity_UN` (`city_code`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8


CREATE TABLE `virusdata` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `province` varchar(100) DEFAULT NULL,
  `confirm` int(10) DEFAULT NULL,
  `suspect` int(10) DEFAULT NULL,
  `heal` int(10) DEFAULT NULL,
  `dead` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `virusdata_UN` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=415 DEFAULT CHARSET=utf8
