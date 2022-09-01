-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: onlinecrimereporting
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `enabled` bit(1) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_address` varchar(100) DEFAULT NULL,
  `user_email` varchar(35) DEFAULT NULL,
  `user_idcard_imgurl` varchar(255) DEFAULT NULL,
  `user_idcard_no` varchar(12) DEFAULT NULL,
  `user_imgurl` varchar(255) DEFAULT NULL,
  `user_mobile` varchar(10) DEFAULT NULL,
  `user_name` varchar(15) NOT NULL,
  `user_passwd` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_j09k2v8lxofv2vecxu2hde9so` (`user_email`),
  UNIQUE KEY `UK_r1ibsuuhal3l2mxccypcamdjj` (`user_idcard_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,_binary '','ROLE_USER','dhrangadhra','kushlendra@gmail.com','default.png','121233336666','default.png','8401783081','kushlendra','$2a$10$vmzDdrMqH06zauUs6zz6K.o0El/ejFWr3wTD4PVqT9C59cfYSuUr.'),(2,_binary '','ROLE_USER','Junagadh','jay123@gmail.com','default.png','832011298989','default.png','8320078023','Jay','$2a$10$61GfWDZQsLL4mOqO3EpHLeiSbJNJIvzBAyqUkKPUrh7aANJQVzFCq'),(3,_binary '','ROLE_USER','Ahmedabad','yuvraj5@gmail.com','default.png','424265987812','default.png','8200586478','Yuvraj','$2a$10$oENKqFf0n8G/TqJXIhQadeC74mqKV.DqMgYhaFsJiiTQEWLQPe1qa'),(4,_binary '','ROLE_USER','Vadodra','vishal9@gmail.com','default.png','126578562356','default.png','9876513595','Vishal','$2a$10$5x4DInCcHBq/q0PNuS9mnup0nRMQr3wBtJXY/x8H11DXP.D7lRrBK'),(5,_binary '','ROLE_USER','Gandhinagar','arjun33@gmail.com','default.png','225665328228','default.png','9494532865','Arjun','$2a$10$cnYGEHYe8n9AIDc1SA.4m.p/6BuNoUHgxaPqsppxNb6//qEAPDK1e'),(7,_binary '','ROLE_OFFICER','Delhi','RakshitCyber1@gmail.com','default.png','126548953568','default.png','9548932564','Rakshit Tandon','$2a$10$PXdwgniEcaPMUZPYOF/3oejFRk3q57BaS7Whg7HDWj6icpGVKT7oy'),(8,_binary '','ROLE_OFFICER','Delhi','ajay9@gmail.com','default.png','653245122253','default.png','9865321425','Ajay Sharma','$2a$10$vW09HB0jMqMLsJ.MIv1DEeJ9VKnqIxVlcj.vOalc9YTPo2BxfoyBC'),(10,_binary '','ROLE_USER','Surat','jill78@gmail.com','default.png','958532126545','default.png','9529563863','Jill','$2a$10$3QRb/hBK3Am.m/0//4h4Je3ZbTk8C2rsjgp5xVSKRjoGBA5o6dcIu'),(12,_binary '','ROLE_OFFICER','Delhi','Rahulrajput@gmail.com','default.png','356815263265','default.png','9865329685','Rahul Rajput','$2a$10$mUyC5R9CtUiFFNmTyw0pYO4BNOxixv0mhw8EBFMYxHRs6DXe0YCC.');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-08 11:18:29
