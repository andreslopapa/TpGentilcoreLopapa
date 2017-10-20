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
-- Table structure for table `categoria`
--
SET SQL_SAFE_UPDATES = 0;

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Administrador'),(2,'Encargado'),(3,'Usuario');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elemento`
--

DROP TABLE IF EXISTS `elemento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elemento` (
  `id_elemento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `id_tipodeelemento` int(11) NOT NULL,
  PRIMARY KEY (`id_elemento`),
  KEY `fk_idtipodeelemento_idx` (`id_tipodeelemento`),
  KEY `fk_id_tipo_idx` (`id_tipodeelemento`),
  CONSTRAINT `fk_Elemento_Tipo` FOREIGN KEY (`id_tipodeelemento`) REFERENCES `tipodeelemento` (`id_tipodeelemento`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elemento`
--

LOCK TABLES `elemento` WRITE;
/*!40000 ALTER TABLE `elemento` DISABLE KEYS */;
INSERT INTO `elemento` VALUES (3,'computadora',1),(4,'servidor',1),(5,'plotter',1),(6,'camara 60mpx',1),(8,'corbata',2),(10,'pantalon2',2),(11,'traje',2),(12,'zapatos',2),(14,'canchita de futbol',3),(15,'salon de eventos',3),(16,'quinta',3),(17,NULL,3),(18,NULL,3),(19,NULL,3),(20,'auto deportivo',4),(21,'auto familiar',4),(22,'triciclo',4),(23,'panzer',4),(24,'moto',4),(25,'voodoo',4),(26,'ambulancia',4),(27,'autobus de prioneros',4),(28,'camion de bomberos',4),(29,'patrullero',4),(30,'minivan',4),(31,'kia rio',4),(32,'LAMBORGHINI aventator',4),(34,'boina',2),(35,'gorra',2),(36,'chaleco del gta',2),(37,'medias rositas',2),(38,'guantas de trabajo',2),(39,'cinto',2),(40,'computadora lenovo',1),(41,'poncho hippie sucio',2),(42,'',1),(43,'camiseta de boca',2),(44,'bug piola',1),(45,'sad',1),(46,'bugsito',1),(47,'',1),(48,'pava electrica',1),(49,'celu robado',1),(50,'celurobado2',1),(51,'',2),(52,'',2);
/*!40000 ALTER TABLE `elemento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `contrasenia` varchar(20) NOT NULL,
  `habilitado` tinyint(4) NOT NULL,
  `email` varchar(45) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_persona`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `fk_id_categoria_idx` (`id_categoria`),
  CONSTRAINT `fk_Persona_Categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (2,'11111111','andres','lopapa','lopa','123',0,'andres@hotmail.com',2),(3,'22222222','joe','santiago','santiagojoe','000',1,'joe_santiago@yahoo.com',2),(4,'33333333','black','francis','thepixies','1989',1,'hey@yahoo.com',2),(5,'44444444','adrian','meca','soyelprofe','adrian',1,'promover@hotmail.com',1),(11,'38937308','Pity','Alvarez','intoxicados','fuego',1,'pilapila@hotmail.com',1);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `id_persona` int(11) NOT NULL,
  `id_elemento` int(11) NOT NULL,
  `fecha_hora_desde_solicitada` datetime NOT NULL,
  `detalle` varchar(140) DEFAULT NULL,
  `fecha_hora_hasta_solicitada` datetime NOT NULL,
  `id_reserva` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_hora_entregado` datetime DEFAULT NULL,
  `fecha_hora_reserva_hecha` datetime NOT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `fk_Reserva_Elemento_idx` (`id_elemento`),
  KEY `fk_Reserva_Persona_idx` (`id_persona`),
  CONSTRAINT `fk_Reserva_Elemento` FOREIGN KEY (`id_elemento`) REFERENCES `elemento` (`id_elemento`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Reserva_Persona` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (4,44,'2017-09-01 00:00:00','','2017-09-15 00:00:00',1,'2017-09-01 00:00:00','2017-08-08 00:00:00'),(4,5,'2017-09-01 00:00:00','','2017-09-16 00:00:00',3,NULL,'2017-09-09 13:01:04'),(4,23,'2017-09-01 00:00:00','','2017-09-22 00:00:00',4,NULL,'2017-09-09 19:34:56'),(4,44,'2017-09-01 00:00:00','','2017-09-15 00:00:00',5,NULL,'2017-09-09 19:35:08'),(4,6,'2017-09-01 00:00:00','','2017-09-16 00:00:00',6,NULL,'2017-09-09 19:38:15'),(4,44,'2017-09-01 00:00:00','','2017-09-15 00:00:00',7,NULL,'2017-09-09 19:40:08'),(4,6,'2017-09-08 00:00:00','dff','2017-09-21 00:00:00',8,NULL,'2017-09-09 20:11:52'),(4,50,'2017-09-01 00:00:00','asdas','2017-09-16 00:00:00',9,NULL,'2017-09-09 20:54:08'),(4,5,'2017-09-01 00:00:00','','2017-09-15 00:00:00',10,NULL,'2017-09-09 21:01:16'),(4,49,'2017-09-01 00:00:00','soy rambo','2017-09-02 00:00:00',14,NULL,'2017-09-09 21:09:44'),(4,44,'2017-09-02 00:00:00','','2017-09-22 00:00:00',25,'2017-09-08 00:00:00','2017-09-10 18:03:02'),(4,22,'2017-09-02 00:00:00','','2017-09-09 00:00:00',28,NULL,'2017-09-10 19:56:51'),(4,17,'2017-09-02 00:00:00','','2017-09-16 00:00:00',29,NULL,'2017-09-10 20:42:14'),(4,10,'2017-09-16 00:00:00','','2017-09-10 23:59:59',34,NULL,'2017-09-13 23:24:43'),(4,14,'2017-09-21 00:00:00','la del diego','2017-09-16 23:59:59',37,NULL,'2017-09-14 17:08:12'),(4,44,'2017-09-28 00:00:00','ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss','2017-09-16 23:59:59',38,NULL,'2017-09-14 17:24:14'),(4,45,'2017-09-02 00:00:00','','2017-09-02 23:59:59',43,'2017-09-01 00:00:00','2017-09-14 18:10:54'),(4,3,'2017-09-17 00:00:00','','2017-09-19 23:59:59',93,NULL,'2017-09-16 19:42:05'),(4,3,'2017-09-16 23:00:00','','2017-09-17 00:00:00',94,NULL,'2017-09-16 19:42:56'),(4,3,'2017-09-29 10:00:00','','2017-09-30 12:59:59',95,NULL,'2017-09-28 20:04:03'),(4,3,'2017-10-01 13:00:00','','2017-10-04 04:00:00',96,'2017-09-16 00:00:00','2017-09-28 20:05:24');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodeelemento`
--

DROP TABLE IF EXISTS `tipodeelemento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipodeelemento` (
  `id_tipodeelemento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `cantmaxrespen` int(11) NOT NULL,
  `limite_horas_res` int(11) NOT NULL,
  `dias_max_anticipacion` int(11) NOT NULL,
  `only_encargados` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_tipodeelemento`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodeelemento`
--

LOCK TABLES `tipodeelemento` WRITE;
/*!40000 ALTER TABLE `tipodeelemento` DISABLE KEYS */;
INSERT INTO `tipodeelemento` VALUES (1,'electronico',3,72,8,0),(2,'ropa',10,72,15,0),(3,'inmueble',4,24,30,0),(4,'vehiculo',2,48,30,0);
/*!40000 ALTER TABLE `tipodeelemento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-20  8:57:18
