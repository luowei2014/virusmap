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
