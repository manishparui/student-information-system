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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `id` varchar(10) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) DEFAULT 'NA',
  `sex` varchar(15) NOT NULL,
  `dob` varchar(25) NOT NULL,
  `contact_no` varchar(15) DEFAULT 'NA',
  `email` varchar(70) DEFAULT 'NA',
  `address` varchar(1000) DEFAULT 'NA',
  `university` varchar(200) NOT NULL,
  `college` varchar(200) NOT NULL,
  `department` varchar(45) NOT NULL,
  `section` varchar(10) NOT NULL,
  `reg_no` varchar(30) NOT NULL,
  `roll_no` varchar(20) NOT NULL,
  PRIMARY KEY (`id`,`roll_no`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `roll_no_UNIQUE` (`roll_no`),
  UNIQUE KEY `reg_no_UNIQUE` (`reg_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('','','','','','','','','','','','','',''),('0','Manish','Parui','M','1997-01-26','09804307030','manishparui8@gmail.com','BL 59, Salt Lake, Sector 2, Kolkata','MAKAUT','TI','BCA','A','163091010036 of 2016-2017','30901216085'),('1','Adrita','Majumder','F','1996-03-04','NA','adritamajumder4@gmail.com','125 Rabindrapally,Kestopur,Kolkata-700101','MAKAUT','TI','BCA','A','163091010006 of 2016-2017','30901216115'),('10','Eshani','Kundu','F','1998-05-19','NA','NA','BC-78, Kamal Park,Kestopur-700101','MAKAUT','TI','BBA','A','163091020010 of 2016-2017','30901215085'),('101','Rahul','Roy','M','1997-07-14','09874561254','NA','Salt Lake Sector V, Kolkata - 73	','MAKAUT','TI','BBA','K2','163091010031 of 2016 - 2017','30901216111'),('11','Arunima',' Paul','F','1995-08-22','09876543210','arumita@gmail.com','CF-79,Sector 3 Salt Lake Bidhan Nagar,Kolkata-700091','MAKAUT','TI','MCA','A','163091040012 of 2016-2017','30901214088'),('12','Bishal','Das','M','1995-07-28','NA','NA','128 Rabindrasarani,Kolkata-700007','MAKAUT','TI','MCA','K2','163091040085 of 2016-2017','30901214100'),('13','Sourav','Mondal','M','1995-11-07','NA','NA','138-Cotton Street, Kolkata-700007','MAKAUT','TI','MCA','K1','163091040049 of 2016-2017','30901214108'),('14','Nikita','Roy','F','1995-01-14','9876543210','NA','DE-162/4,West Narayantala,Kolkata-700159','MAKAUT','TI','MCA','B','163091040000 of 2016-2017','30901214101'),('15','Tarun','Dutta','M','1995-05-31','NA','NA','BD-94,Sector 2 Salt Lake Bidhan Nagar,Kolkata-700091','MAKAUT','TI','MBA','B','163091050040 of 2016-2017','30901212118'),('16','Ankush','Mitra','M','1995-12-31','NA','NA','BC-57,Anurupapally,Kestopur,Kolkata-700101','MAKAUT','TI','MBA','B','163091050028 of 2016-2017','30901212124'),('17','Tomali','Sen','F','1995-06-19','NA','NA','De-164/5, East Narayantala, Kolkata-700159','MAKAUT','TI','MBA','A','163091050034 of 2016-2017','30901212045'),('18','Rakesh','Dhar','M','1995-07-12','NA','NA','2nd floor,Mangalam Apartment Beside Dr. Savitri Dalmia,Kalimanda Road,Madhupur 815353,Deoghar','MAKAUT','TI','MBA','B','163091050024 of 2016-2017','30901212028'),('19','Sriparna','Roy','F','1995-09-22','NA','NA','AL-128,near AL Park,Sector 2 Salt Lake Bidhan Nagar, Kolkata-700091','MAKAUT','TI','MBA','B','163091050018 of 2016-2017','30901212096'),('2','Manojit','Saha','M','1998-07-14','9876543210','email@gmail.com','Sahay Narayan Ghosh Lane,Near Gita Press, Madhupur 815353,Deoghar','MAKAUT','TI','BCA','B','163091010000 of 2016-2017','30901216084'),('20','Rahul','Das','M','1995-04-24','NA','NA','AL-71,near tank no 8,Sector 2,Salt Lake Bidhan Nagar, Kolkata-700091','MAKAUT','TI','MCA','K1','163091040042 of 2016-2017','30901214094');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
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
