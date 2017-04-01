CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL

)
  ENGINE = InnoDB;

CREATE TABLE duties(
  id INT NOT NULL  AUTO_INCREMENT PRIMARY KEY,
  dutyname VARCHAR(255) NOT NULL,
  dutyduration BIGINT NOT NULL,
  dutystartdate DATETIME NOT NULL,
  dutydescription TEXT NOT NULL,
  dutyimportance TINYTEXT NOT NULL,
  dutystatus TINYTEXT NOT NULL,
  user_id INT NOT NULL,
  FOREIGN KEY (user_id)REFERENCES users(id)
)
ENGINE InnoDB;