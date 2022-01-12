CREATE TABLE `db_api_enriquecimento`.`tb_cliente` (
  `id` int NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;

INSERT INTO `db_api_enriquecimento`.`tb_cliente` (
  `id`,
  `nome`,
  `email`,
  `cpf`)
VALUES (1, 'Rodrigo', 'rfrancacosta@gmail.com','12345678912');