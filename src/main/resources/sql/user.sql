CREATE TABLE `user` (
                        `username` VARCHAR(20) primary key,
                        `password` VARCHAR(500) not null,
                        `name` VARCHAR(20) not NULL,
                        `phone` varchar(20) not null,
                        `trophy` int default 0
)
    COLLATE='utf8_general_ci'
ENGINE=InnoDB
;