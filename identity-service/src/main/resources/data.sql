CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;



INSERT INTO `user` (`password`, `username`)
VALUES ('$2a$10$2KhsCxCd4iTA6kUA1TgURujLsuB9Cd3ll5N7JBhIvc.Whw2YMKGa6', 'test');