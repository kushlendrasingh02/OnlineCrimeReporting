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
-- Table structure for table `casefile`
--

DROP TABLE IF EXISTS `casefile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `casefile` (
  `casefile_id` int NOT NULL,
  `agreement` bit(1) NOT NULL,
  `avidence_pic` varchar(255) DEFAULT NULL,
  `crime_disc` varchar(500) DEFAULT NULL,
  `fir_status` varchar(255) DEFAULT NULL,
  `occurrence_address` varchar(255) DEFAULT NULL,
  `occurrence_date` date DEFAULT NULL,
  `occurrence_time` varchar(255) DEFAULT NULL,
  `officer_comment` varchar(500) DEFAULT NULL,
  `type_of_cirme` varchar(255) DEFAULT NULL,
  `victim_birthdate` date DEFAULT NULL,
  `victim_mobile` varchar(255) DEFAULT NULL,
  `victim_name` varchar(255) DEFAULT NULL,
  `victim_relativename` varchar(255) DEFAULT NULL,
  `victum_address` varchar(255) DEFAULT NULL,
  `victum_district` varchar(255) DEFAULT NULL,
  `victum_nationality` varchar(255) DEFAULT NULL,
  `victum_passport` varchar(255) DEFAULT NULL,
  `victum_ps` varchar(255) DEFAULT NULL,
  `victum_uid_no` varchar(255) DEFAULT NULL,
  `user_user_id` int DEFAULT NULL,
  PRIMARY KEY (`casefile_id`),
  KEY `FK24cxnvehgr6514f1uk0rwdp6f` (`user_user_id`),
  CONSTRAINT `FK24cxnvehgr6514f1uk0rwdp6f` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casefile`
--

LOCK TABLES `casefile` WRITE;
/*!40000 ALTER TABLE `casefile` DISABLE KEYS */;
INSERT INTO `casefile` VALUES (6,_binary '\0','hack.png','<p>Dear Sir/Mam</p>\r\n<p>I want you to know that for the last few days some of my enemies have been posting some of my photos on their social media account using some bad words.Which is totally affecting my married life and creating misconceptions about me in society. This is my humble request to take quick legal action in this<br>matter.Ihope foraquick adjustment to this problem.</p>','Pending','Junagadh Highway','2022-05-01','13:59',NULL,'Murder','2002-05-30','8320078023','Jaykumar Chandreshbhai Sapra','Chandreshbhai Sapra','Junagadh','Junagadh','Indian','123645631298','Junagadh','123645631298',2),(9,_binary '','s.jfif','<p>Iwant you to know that for the last few days some of my<br>enemies have been posting some of my photos on their<br>&nbsp; &nbsp;social media account using some bad words.<br>Which is totally affecting my married life and creating<br>&nbsp; &nbsp; &nbsp; &nbsp;misconceptions about me in society.<br>This isahumble request to take quick legal action in this<br>matter.Ihope foraquick adjustment to this problem.</p>','Pending','bihar','2022-05-27','12:09',NULL,'ranshomeware','2001-10-08','9865253610','Yuvraj Jadav','Mahendrakumar','bihar','bihar','indian','98798989565','bihar','98798989565',3),(11,_binary '','job.png','<p>Dear Sir / Mam</p>\r\n<p>vgfhbkjnlhbjdanlmkdkjbdgd,d,jnddvdvlmvgfhbkjnlhbjdanlmkdkjbdgd,d,jnddvdv;lmjkdjkdjk</p>','Pending','Online','2022-06-07','',NULL,'Job Fraud','2000-07-26','9869723598','Jill Patel','Chiragbhai','Mumbai','Mumbai','Indian','326536251425','Mumbai','326514259856',10);
/*!40000 ALTER TABLE `casefile` ENABLE KEYS */;
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
