CREATE TABLE `web`.`good` (
  `good_ID` INT NOT NULL AUTO_INCREMENT,
  `good_name` VARCHAR(45) NOT NULL,
  `good_price` FLOAT NULL DEFAULT 0,
  `good_description` VARCHAR(45) NULL,
  `good_image` BLOB NULL,
  PRIMARY KEY (`good_ID`));
