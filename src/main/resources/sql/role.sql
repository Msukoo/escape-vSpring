CREATE TABLE `role` (
                        `username` VARCHAR(20),
                        `role` VARCHAR(20) NULL DEFAULT NULL,
                        FOREIGN KEY(`username`) REFERENCES `user` (username) on delete CASCADE
)
    COLLATE='utf8_general_ci'
ENGINE=InnoDB
;