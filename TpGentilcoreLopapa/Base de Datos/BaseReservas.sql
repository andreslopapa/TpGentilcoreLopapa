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
-- Table structure for table `cat_tip`
--

DROP TABLE IF EXISTS `cat_tip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_tip` (
  `id_categoria` int(11) NOT NULL,
  `id_tipodeelemento` int(11) NOT NULL,
  PRIMARY KEY (`id_categoria`,`id_tipodeelemento`),
  KEY `fk_id_tipodeelemento_idx` (`id_tipodeelemento`),
  CONSTRAINT `fk_CAT_TIP_Categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`) ON UPDATE CASCADE,
  CONSTRAINT `fk_CAT_TIP_Tipo` FOREIGN KEY (`id_tipodeelemento`) REFERENCES `tipodeelemento` (`id_tipodeelemento`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_tip`
--

LOCK TABLES `cat_tip` WRITE;
/*!40000 ALTER TABLE `cat_tip` DISABLE KEYS */;
/*!40000 ALTER TABLE `cat_tip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elemento`
--

LOCK TABLES `elemento` WRITE;
/*!40000 ALTER TABLE `elemento` DISABLE KEYS */;
INSERT INTO `elemento` VALUES (1,NULL,1),(2,NULL,1),(3,'computadora',1),(4,'servidor',1),(5,'plotter',1),(6,'camara',1),(7,'jeen',2),(8,'corbata',2),(9,'saco',2),(10,'pantalon',2),(11,'traje',2),(12,'zapatos',2),(13,'vestido',2),(14,'canchita de futbol',3),(15,'salon de eventos',3),(16,'quinta',3),(17,NULL,3),(18,NULL,3),(19,NULL,3),(20,'auto deportivo',4),(21,'auto familiar',4),(22,'triciclo',4),(23,'panzer',4),(24,'moto',4);
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
  KEY `fk_id_categoria_idx` (`id_categoria`),
  CONSTRAINT `fk_Persona_Categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'39927307','nawe','shopping','naweferoz','123',0,'tunawebienturro@gmail.com',3),(2,'11111111','kim','deal','lakimpiola','321',1,'kim_deal@hotmail.com',3),(3,'22222222','joe','santiago','santiagojoe','000',1,'joe_santiago@yahoo.com',2),(4,'33333333','black','francis','thepixies','1989',1,'hey@yahoo.com',2),(5,'44444444','adrian','meca','debo aprobar','alumnos',1,'estoschicospromueven@hotmail.com',1),(6,'55555555','Ricky','Tabacman','Ricardo','123',1,'soyricky@yahoo.com',1);
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
  `fecha_hora_desde` datetime NOT NULL,
  `detalle` varchar(80) DEFAULT NULL,
  `fecha_hora_hasta` datetime NOT NULL,
  PRIMARY KEY (`id_persona`,`id_elemento`),
  KEY `fk_Reserva_Elemento_idx` (`id_elemento`),
  CONSTRAINT `fk_Reserva_Elemento` FOREIGN KEY (`id_elemento`) REFERENCES `elemento` (`id_elemento`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Reserva_Persona` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
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
  PRIMARY KEY (`id_tipodeelemento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodeelemento`
--

LOCK TABLES `tipodeelemento` WRITE;
/*!40000 ALTER TABLE `tipodeelemento` DISABLE KEYS */;
INSERT INTO `tipodeelemento` VALUES (1,'electronico',3,72,8),(2,'ropa',10,72,15),(3,'inmueble',4,24,30),(4,'vehiculo',2,48,30);
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

-- Dump completed on 2017-08-15 20:54:12
