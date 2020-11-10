-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: bankapi
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `getstatement`
--

DROP TABLE IF EXISTS `getstatement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `getstatement` (
  `accno` int DEFAULT NULL,
  `raccno` int DEFAULT NULL,
  `balance` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `getstatement`
--

LOCK TABLES `getstatement` WRITE;
/*!40000 ALTER TABLE `getstatement` DISABLE KEYS */;
INSERT INTO `getstatement` VALUES (123,2222,100),(123,2222,100),(123,2222,100),(123,2222,100);
/*!40000 ALTER TABLE `getstatement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `safebank`
--

DROP TABLE IF EXISTS `safebank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `safebank` (
  `name` varchar(40) DEFAULT NULL,
  `custid` varchar(30) DEFAULT NULL,
  `accno` int DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `balance` int DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone_Number` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `safebank`
--

LOCK TABLES `safebank` WRITE;
/*!40000 ALTER TABLE `safebank` DISABLE KEYS */;
INSERT INTO `safebank` VALUES ('mahesh','111mah',123,'mahesh',400,'mahesh@gmail.com',NULL),('Narayana','222nar',2222,'narayana',10600,'narayana@gmail.com',6302856730),('Ramesh','333ram',3333,'Ramesh',10000,'ramesh@gmail.com',646846354),('Narasimhulu','444nara',4444,'Narasimhulu',1000000,'narasimhulu@gmail.com',9515087232),('abhi','555abhi',5555,'eabhi',10000,'abhi@gmail.com',6302856730),('Mahmadh','666mah',6666,'maha',100000,'mahmadh@gmail.com',9989815278);
/*!40000 ALTER TABLE `safebank` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-10 20:42:18
