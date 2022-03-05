CREATE TABLE `api_enriquecimento`.`tb_pessoa` (
  `id` int NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;

INSERT INTO `api_enriquecimento`.`tb_pessoa` (
  `id`,
  `nome`,
  `email`,
  `cpf`)
VALUES (1, 'Rodrigo', 'rfrancacosta@gmail.com','12345678912');