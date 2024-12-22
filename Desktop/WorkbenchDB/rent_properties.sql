-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rent
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `properties`
--

DROP TABLE IF EXISTS `properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `properties` (
  `property_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `rooms` int DEFAULT NULL,
  `owner_username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `available_from` date DEFAULT NULL,
  `available_to` date DEFAULT NULL,
  PRIMARY KEY (`property_id`),
  KEY `owner_username` (`owner_username`),
  CONSTRAINT `properties_ibfk_1` FOREIGN KEY (`owner_username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `properties`
--

LOCK TABLES `properties` WRITE;
/*!40000 ALTER TABLE `properties` DISABLE KEYS */;
INSERT INTO `properties` VALUES (28,'Cozy Apartment','A cozy apartment near Central Park','New York',1200.5,2,'johndoe','2024-01-01','2024-12-31'),(29,'Luxury Villa','A luxury villa with pool and garden','Los Angeles',5000,5,'janesmith','2024-01-01','2024-12-31'),(30,'Studio Apartment','An affordable studio in the city center','Chicago',800,1,'alexj','2024-01-01','2024-06-30'),(31,'Modern Loft','A spacious loft with modern design','Miami',1800,3,'emilyd','2024-02-01','2024-12-31'),(32,'Beach House','A beautiful house near the beach','Houston',2200,4,'michaelb','2024-03-01','2024-12-31'),(33,'Penthouse','A luxury penthouse with city view','San Francisco',7000,5,'sarahw','2024-01-01','2024-12-31'),(34,'Mountain Cabin','A cozy cabin in the mountains','Seattle',1500,2,'davidl','2024-05-01','2024-10-31'),(35,'Family Home','A spacious home perfect for families','Boston',2000,4,'annat','2024-01-01','2024-12-31'),(36,'Downtown Apartment','A convenient apartment downtown','Austin',1300,2,'chrism','2024-02-15','2024-12-31'),(37,'Eco-Friendly Home','A sustainable home with solar panels','Denver',2500,3,'sophiam','2024-01-01','2024-12-31');
/*!40000 ALTER TABLE `properties` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-22 15:05:11
