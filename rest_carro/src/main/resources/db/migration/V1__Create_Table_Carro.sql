DROP TABLE IF EXISTS `carro`;
CREATE TABLE `carro` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `nome` varchar(80) NOT NULL,
                          `modelo` varchar(80) NOT NULL,
                          PRIMARY KEY (`id`)
);
