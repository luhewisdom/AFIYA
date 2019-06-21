INSERT INTO `afia`.`user` (`id`, `email`, `enabled`, `hospital_picture`, `lname`, `name`, `password`, `phone`, `username`) VALUES ('1', 'riyadworku@gmail.com', '1', 'nothospital', 'Worku', 'Riyad', 'admin', '090909', 'SUPER');



INSERT INTO `afia`.`role` (`id`, `role`) VALUES ('1', 'SUPER');

INSERT INTO `afia`.`user_role` (`user_id`, `role_id`) VALUES ('1', '1');