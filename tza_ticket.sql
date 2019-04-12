CREATE TABLE `trackzilla_schema`.`tza_ticket` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
`application_id` INT NULL, 
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));