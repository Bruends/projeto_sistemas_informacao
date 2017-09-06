CREATE DATABASE  IF NOT EXISTS `projeto_si` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `projeto_si`;
-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: projeto_si
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `cnpj` varchar(45) NOT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Empresa1','contato@enterprisesa.com','54642133','rua. alguma coisa - SP'),(2,'Empresa2','evilcorp@email.com','54156154','rua. random - NY'),(3,'empresa3','empresa3@email.com','2323232','Rua3 - MG'),(4,'E. Corp','empresa3@email.com','2323232','Rua3 - MG');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta_receber`
--

DROP TABLE IF EXISTS `conta_receber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta_receber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `data_vencimento` date DEFAULT NULL,
  `data_pagamento` date DEFAULT NULL,
  `parcela_atual` int(11) DEFAULT '0',
  `total_parcelas` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_id_cliente_idx` (`id_cliente`),
  CONSTRAINT `fk_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta_receber`
--

LOCK TABLES `conta_receber` WRITE;
/*!40000 ALTER TABLE `conta_receber` DISABLE KEYS */;
INSERT INTO `conta_receber` VALUES (3,1,2500.00,'cancelado',NULL,NULL,1,2),(4,1,188.00,'pendente',NULL,NULL,2,2),(6,2,500.00,'pendente',NULL,NULL,1,2),(8,1,100.00,'pendente',NULL,NULL,0,1),(9,1,222.00,'pendente',NULL,NULL,0,5),(10,2,100.00,'pendente',NULL,NULL,0,2),(11,2,1000.00,'pendente',NULL,NULL,0,10),(12,2,2000.00,'pendente',NULL,NULL,0,10),(14,4,5000.00,'pendente',NULL,NULL,0,3);
/*!40000 ALTER TABLE `conta_receber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(80) NOT NULL,
  `senha` varchar(80) NOT NULL,
  `nivel_acesso` int(1) NOT NULL,
  `nome` varchar(80) DEFAULT NULL,
  `cpf` varchar(80) DEFAULT NULL,
  `ano_nascimento` varchar(45) DEFAULT NULL,
  `cargo` varchar(45) DEFAULT NULL,
  `departamento` varchar(45) DEFAULT NULL,
  `salario` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'adm@email.com','123',3,'adm','',NULL,NULL,NULL,NULL),(3,'operador@email.com','123',2,'fulano',NULL,NULL,NULL,NULL,NULL),(4,'basico@email.com','123',1,'ciclano',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-05 20:26:39
