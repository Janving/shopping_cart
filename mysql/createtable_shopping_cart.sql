CREATE TABLE `web`.`shopping_cart` (
  `cart_ID` INT NOT NULL AUTO_INCREMENT,
  `purchaser_ID` VARCHAR(45) NULL,
  `good_ID` VARCHAR(45) NULL,
  `create_time` TIMESTAMP NULL,
  PRIMARY KEY (`cart_ID`));
