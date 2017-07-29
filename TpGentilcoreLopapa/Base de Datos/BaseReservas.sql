CREATE DATABASE  IF NOT EXISTS `BaseReservas` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `BaseReservas`;
-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: BaseReservas
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
-- Table structure for table `CAT_TIP`
--

DROP TABLE IF EXISTS `CAT_TIP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CAT_TIP` (
  `id_categoria` int(11) NOT NULL,
  `id_tipodeelemento` int(11) NOT NULL,
  PRIMARY KEY (`id_categoria`,`id_tipodeelemento`),
  KEY `fk_id_tipodeelemento_idx` (`id_tipodeelemento`),
  CONSTRAINT `fk_CAT_TIP_Categoria` FOREIGN KEY (`id_categoria`) REFERENCES `Categoria` (`id_categoria`) ON UPDATE CASCADE,
  CONSTRAINT `fk_CAT_TIP_Tipo` FOREIGN KEY (`id_tipodeelemento`) REFERENCES `TipoDeElemento` (`id_tipodeelemento`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAT_TIP`
--

LOCK TABLES `CAT_TIP` WRITE;
/*!40000 ALTER TABLE `CAT_TIP` DISABLE KEYS */;
/*!40000 ALTER TABLE `CAT_TIP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Categoria`
--

DROP TABLE IF EXISTS `Categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categoria`
--

LOCK TABLES `Categoria` WRITE;
/*!40000 ALTER TABLE `Categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `Categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Elemento`
--

DROP TABLE IF EXISTS `Elemento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Elemento` (
  `id_elemento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `id_tipodeelemento` int(11) NOT NULL,
  PRIMARY KEY (`id_elemento`),
  KEY `fk_idtipodeelemento_idx` (`id_tipodeelemento`),
  KEY `fk_id_tipo_idx` (`id_tipodeelemento`),
  CONSTRAINT `fk_Elemento_Tipo` FOREIGN KEY (`id_tipodeelemento`) REFERENCES `TipoDeElemento` (`id_tipodeelemento`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Elemento`
--

LOCK TABLES `Elemento` WRITE;
/*!40000 ALTER TABLE `Elemento` DISABLE KEYS */;
/*!40000 ALTER TABLE `Elemento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persona`
--

DROP TABLE IF EXISTS `Persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Persona` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `contrasenia` varchar(45) NOT NULL,
  `habilitado` tinyint(4) NOT NULL,
  `email` varchar(45) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_persona`),
  KEY `fk_id_categoria_idx` (`id_categoria`),
  CONSTRAINT `fk_Persona_Categoria` FOREIGN KEY (`id_categoria`) REFERENCES `Categoria` (`id_categoria`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona`
--

LOCK TABLES `Persona` WRITE;
/*!40000 ALTER TABLE `Persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `Persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reserva`
--

DROP TABLE IF EXISTS `Reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reserva` (
  `id_persona` int(11) NOT NULL,
  `id_elemento` int(11) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `detalle` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_persona`,`id_elemento`),
  KEY `fk_Reserva_Elemento_idx` (`id_elemento`),
  CONSTRAINT `fk_Reserva_Elemento` FOREIGN KEY (`id_elemento`) REFERENCES `Elemento` (`id_elemento`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Reserva_Persona` FOREIGN KEY (`id_persona`) REFERENCES `Persona` (`id_persona`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reserva`
--

LOCK TABLES `Reserva` WRITE;
/*!40000 ALTER TABLE `Reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `Reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoDeElemento`
--

DROP TABLE IF EXISTS `TipoDeElemento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoDeElemento` (
  `id_tipodeelemento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `cantmaxrespen` int(11) NOT NULL,
  `limite_horas_res` int(11) NOT NULL,
  `dias_max_anticipacion` int(11) NOT NULL,
  PRIMARY KEY (`id_tipodeelemento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoDeElemento`
--

LOCK TABLES `TipoDeElemento` WRITE;
/*!40000 ALTER TABLE `TipoDeElemento` DISABLE KEYS */;
/*!40000 ALTER TABLE `TipoDeElemento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-29 18:39:36
