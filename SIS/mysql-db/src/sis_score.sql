CREATE DATABASE  IF NOT EXISTS `sis` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `sis`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: sis
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `score` (
  `roll_no` varchar(20) NOT NULL,
  `sem1sub1` varchar(5) DEFAULT NULL,
  `sem1sub2` varchar(5) DEFAULT NULL,
  `sem1sub3` varchar(5) DEFAULT NULL,
  `sem1sub4` varchar(5) DEFAULT NULL,
  `sem1sub5` varchar(5) DEFAULT NULL,
  `sem1sub6` varchar(5) DEFAULT NULL,
  `sem1sub7` varchar(5) DEFAULT NULL,
  `sem1sub8` varchar(5) DEFAULT NULL,
  `sem1avg` varchar(5) DEFAULT NULL,
  `sem2sub1` varchar(5) DEFAULT NULL,
  `sem2sub2` varchar(5) DEFAULT NULL,
  `sem2sub3` varchar(5) DEFAULT NULL,
  `sem2sub4` varchar(5) DEFAULT NULL,
  `sem2sub5` varchar(5) DEFAULT NULL,
  `sem2sub6` varchar(5) DEFAULT NULL,
  `sem2sub7` varchar(5) DEFAULT NULL,
  `sem2sub8` varchar(5) DEFAULT NULL,
  `sem2avg` varchar(5) DEFAULT NULL,
  `sem3sub1` varchar(5) DEFAULT NULL,
  `sem3sub2` varchar(5) DEFAULT NULL,
  `sem3sub3` varchar(5) DEFAULT NULL,
  `sem3sub4` varchar(5) DEFAULT NULL,
  `sem3sub5` varchar(5) DEFAULT NULL,
  `sem3sub6` varchar(5) DEFAULT NULL,
  `sem3sub7` varchar(5) DEFAULT NULL,
  `sem3sub8` varchar(5) DEFAULT NULL,
  `sem3avg` varchar(5) DEFAULT NULL,
  `sem4sub1` varchar(5) DEFAULT NULL,
  `sem4sub2` varchar(5) DEFAULT NULL,
  `sem4sub3` varchar(5) DEFAULT NULL,
  `sem4sub4` varchar(5) DEFAULT NULL,
  `sem4sub5` varchar(5) DEFAULT NULL,
  `sem4sub6` varchar(5) DEFAULT NULL,
  `sem4sub7` varchar(5) DEFAULT NULL,
  `sem4sub8` varchar(5) DEFAULT NULL,
  `sem4avg` varchar(5) DEFAULT NULL,
  `sem5sub1` varchar(5) DEFAULT NULL,
  `sem5sub2` varchar(5) DEFAULT NULL,
  `sem5sub3` varchar(5) DEFAULT NULL,
  `sem5sub4` varchar(5) DEFAULT NULL,
  `sem5sub5` varchar(5) DEFAULT NULL,
  `sem5sub6` varchar(5) DEFAULT NULL,
  `sem5sub7` varchar(5) DEFAULT NULL,
  `sem5sub8` varchar(5) DEFAULT NULL,
  `sem5avg` varchar(5) DEFAULT NULL,
  `sem6sub1` varchar(5) DEFAULT NULL,
  `sem6sub2` varchar(5) DEFAULT NULL,
  `sem6sub3` varchar(5) DEFAULT NULL,
  `sem6sub4` varchar(5) DEFAULT NULL,
  `sem6sub5` varchar(5) DEFAULT NULL,
  `sem6sub6` varchar(5) DEFAULT NULL,
  `sem6sub7` varchar(5) DEFAULT NULL,
  `sem6sub8` varchar(5) DEFAULT NULL,
  `sem6avg` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`roll_no`),
  UNIQUE KEY `roll_no_UNIQUE` (`roll_no`),
  CONSTRAINT `roll_no` FOREIGN KEY (`roll_no`) REFERENCES `student` (`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES ('',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901212028','6.14','9.78','8.32','8.28','8.54','7.35','7.25','9.21',NULL,'7.21','7.21','10','8.22','7.98','7.25','8.98','8.34',NULL,'8.45','8.24','7.95','7.96','7.24','9.62','7.14','10',NULL,'9.85','7.65','9.54','7.32','8.24',NULL,NULL,NULL,NULL,'7.25','6.45','8.65','7.65','8.24','8.54','8.25',NULL,NULL,'8.24','7.85',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901212045','6.23','8.45','7.95','8.21','8.25','9.15','9.54','8.32',NULL,'8.26','8','8','9.35','5.85','8.21','8.25','10',NULL,'9.14','9.42','6.48','7.24','9.54','8.64','6.85','6.87',NULL,'7.85','8.54','7.65','7.56','8.35',NULL,NULL,NULL,NULL,'9.54','8.45','7.65','8.25','9.54','7.95','9.85',NULL,NULL,'9.25','8.72',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901212096','7.23','7.23','8.32','8.95','7.25','9.24','8.21','7.21',NULL,'9.35','9.21','6.98','5.87','9.89','8.24','6.52','8.31',NULL,'8.51','8.65','8.24','9.12','7.94','7.52','8','6.12',NULL,'8.21','8.64','6.25','8.54','9.24',NULL,NULL,NULL,NULL,'6.54','7.31','7.65','7.95','9.54','9.54','7.95',NULL,NULL,'7.65','6.58',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901212118','7.32','8.36','9.23','8.21','8.65','9.14','8.24','7.21',NULL,'7.54','7.25','9.25','7.39','7.85','8.56','6.24','8.21',NULL,'9.45','6.24','8.21','9.54','8.45','9.41','6.47','9.48',NULL,'9.54','7.65','8.45','9.21','7.52',NULL,NULL,NULL,NULL,'7.65','9.24','8.21','8.54','9.12','9.57','8.95',NULL,NULL,'6.56','7.25',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901212124','8.5','7.59','8.24','6.32','9.54','9.32','7.65','8.25',NULL,'9.84','100','8','8.65','5.64','7.98','8.95','7.25',NULL,'7.65','7.95','8.54','8.21','7.42','8.14','9.45','7.85',NULL,'7.95','7.65','9.54','7.54','8.46',NULL,NULL,NULL,NULL,'8.24','7.52','5.24','9.54','8.42','8.27','9.54',NULL,NULL,'9.51','9.24',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901214088','8.25','6.25','8.12','8.25','6.32','7.35','8','7.35',NULL,'8.31','7','6.78','8.24','9','8.98','7.25','6.12',NULL,'8.36','8.35','8.15','7.54','8.24','7.45','7.16','8.45',NULL,'8.54','6.75','8.24','9.87','9.54',NULL,NULL,NULL,NULL,'8.54','9.54','8.32','8.95','7.54','8.24','8.24',NULL,NULL,'8.54','8.26',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901214094','7.25','8.97','7.32','7.32','6.21','8.12','6.24','9',NULL,'7.36','8','6.28','9.45','7.32','5.65','9','8.51',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901214100','8.02','8.97','8.21','8.32','8.32','9.25','7.35','8.24',NULL,'9.85','9','10','7.35','8.25','7','8.35','8.32',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901214101','8.21','10','6.01','9.25','6.85','7.35','9.57','7',NULL,'8.59','9.24','9.25','8','9.25','9','9.25','9',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901214108','6.75','8.97','6.25','8.24','7.98','7.25','8.24','9.25',NULL,'8.52','8.63','8','9.35','10','7.2','8','9.52',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901215085','9.35','10','8.24','6.32','8.37','8.59','9.65','7.32',NULL,'9.32','7.25','8.32','9','7.25','8','7.25','7.36',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901216084','8.96','8.65','5.21','7.25','7.32','9.35','8.32','8.95',NULL,'7.32','5.21','9','7.35','9.21','9.32','9.65','9.35',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30901216085','7.98','8.89','8.35','9.85','8.12','8.33','8.21','8.65','','9.54','8.25','7.25','5.85','8','8.32','8.32','8.24','','7.54','8.24','9.24','8.58','7.02','9.25','8.46','7.85','','','','','','','','','','','','','','','','','','','','','','','','','','','',''),('30901216111','8','8','8','8','8','8','8','8','','8','8','8','8','8','8','8','8','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''),('30901216115','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9','9');
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-25 17:01:16
