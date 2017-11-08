/*
SQLyog Community v12.16 (64 bit)
MySQL - 5.6.17 : Database - projeto_si
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`projeto_si` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `projeto_si`;

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `cnpj` varchar(45) NOT NULL,
  `endereco` varchar(900) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `cliente` */

insert  into `cliente`(`id`,`nome`,`email`,`cnpj`,`endereco`,`telefone`,`cep`) values 
(1,'Empresa1','contato@enterprisesa.com','54642132','Rua Alguma coisa, nº 190 -  Complemento, Bairro,  SP  - São Paulo','12346859','1111'),
(2,'Empresa2','evilcorp@email.com','54156154','Rua Random, nº 290 - Complemento, Bairro, SP - São Paulo','24578908','3333'),
(4,'E. Corp','empresa3@email.com','2323232','Rua Rua dos bobos, nº 170 -  Complement, Bairro,  SP  - São Paulo','23445678','4444'),
(6,'Wayne Enterprises','example@email.com','158154','Rua Alguma coisa, nº 190 -  Complemento, Bairro,  SP  - São Paulo','12321312','8888');

/*Table structure for table `conta_pagar` */

DROP TABLE IF EXISTS `conta_pagar`;

CREATE TABLE `conta_pagar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(45) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `data_vencimento` varchar(11) DEFAULT NULL,
  `data_pagamento` date DEFAULT NULL,
  `parcela_atual` int(11) DEFAULT '0',
  `total_parcelas` int(11) DEFAULT '0',
  `obs` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `conta_pagar` */

insert  into `conta_pagar`(`id`,`Titulo`,`valor`,`status`,`data_vencimento`,`data_pagamento`,`parcela_atual`,`total_parcelas`,`obs`) values 
(2,'energia','222.00','Confirmado','13/03/1996',NULL,0,2,''),
(3,'Luz','193.00','Pendente','13/07/2017',NULL,0,1,''),
(4,'Concerto Computadores','2000.00','Confirmado','12/02/2017',NULL,0,3,''),
(5,'Itens de escritorio','200.00','Confirmado','16/05/2017',NULL,0,1,''),
(6,'Internet','600.00','Confirmado','16/05/2017',NULL,0,1,''),
(7,'gastos gerais','600.00','Confirmado','06/05/2017',NULL,0,1,''),
(9,'internet','600.00','Pendente','06/08/2017',NULL,0,1,''),
(10,'internet','600.00','Pendente','06/09/2017',NULL,0,1,''),
(11,'internet','600.00','Pendente','06/10/2017',NULL,0,1,''),
(12,'2 computadores','6000.00','Pendente','06/11/2017',NULL,0,2,'');

/*Table structure for table `conta_receber` */

DROP TABLE IF EXISTS `conta_receber`;

CREATE TABLE `conta_receber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `data_vencimento` varchar(45) DEFAULT NULL,
  `data_pagamento` varchar(45) DEFAULT NULL,
  `parcela_atual` int(11) DEFAULT '0',
  `total_parcelas` int(11) DEFAULT '0',
  `modo_pagamento` varchar(45) CHARACTER SET big5 NOT NULL,
  `obs` mediumtext,
  PRIMARY KEY (`id`),
  KEY `fk_id_cliente_idx` (`id_cliente`),
  CONSTRAINT `fk_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `conta_receber` */

insert  into `conta_receber`(`id`,`id_cliente`,`valor`,`status`,`data_vencimento`,`data_pagamento`,`parcela_atual`,`total_parcelas`,`modo_pagamento`,`obs`) values 
(18,6,'5000.00','Pendente','16/05/2018',NULL,0,1,'Deposito',''),
(19,1,'5800.00','Confirmado','16/05/2017',NULL,0,1,'Debito Automatico',''),
(20,2,'5800.00','Confirmado','06/08/2017',NULL,0,1,'Debito Automatico',''),
(21,4,'580.00','Confirmado','26/08/2017',NULL,0,1,'Dinheiro',''),
(22,6,'580.00','Pendente','26/08/2017',NULL,0,1,'Dinheiro',''),
(23,1,'5780.00','Pendente','26/08/2017',NULL,0,1,'Dinheiro',''),
(24,1,'5780.00','Pendente','26/09/2017',NULL,0,2,'Dinheiro',''),
(25,1,'5780.00','Pendente','06/09/2017',NULL,0,2,'Dinheiro',''),
(26,2,'780.00','Pendente','06/09/2017',NULL,0,2,'Debito Automatico',''),
(27,6,'7880.00','Pendente','06/09/2017',NULL,0,1,'Deposito',''),
(28,6,'880.00','Pendente','06/09/2019',NULL,0,1,'Deposito',''),
(29,4,'500.00','pendente','16/07/2018',NULL,0,1,'Debito Automatico','');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(80) NOT NULL,
  `senha` varchar(80) NOT NULL,
  `nivel_acesso` int(1) NOT NULL,
  `nome` varchar(80) DEFAULT NULL,
  `cpf` varchar(80) DEFAULT NULL,
  `ano_nascimento` int(4) NOT NULL,
  `cargo` varchar(45) DEFAULT NULL,
  `departamento` varchar(45) DEFAULT NULL,
  `salario` float DEFAULT NULL,
  `telefone` varchar(13) NOT NULL,
  `endereco` varchar(950) NOT NULL,
  `email_contato` varchar(80) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`id`,`email`,`senha`,`nivel_acesso`,`nome`,`cpf`,`ano_nascimento`,`cargo`,`departamento`,`salario`,`telefone`,`endereco`,`email_contato`) values 
(2,'adm@email.com','123',3,'adm','12332110890',1980,'Adm do Sistema','TI',2500,'0000000000','Rua Dos Bobos, nº 0 - Complemento, Bairro, Estado - Cidade,08076515','adm@email.com'),
(3,'operador@email.com','123',2,'fulano','12332110898',1970,'Operador Financeiro','Financeiro',2500,'00000000000','Rua endereco, nº 90 - Complemento, Bairro, Estado - Cidade,0164421','operador@email.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
