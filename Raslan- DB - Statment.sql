-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: employeemanagementsystem
-- ------------------------------------------------------
-- Server version	5.6.20


--
-- Table structure for table `department`
--
CREATE DATABASE employeemanagementsystem;

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `DEPARTMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `abbreviation_name` varchar(10) DEFAULT NULL,
  `DEPARTMENT_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`DEPARTMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
INSERT INTO `department` VALUES (1,'HR','Human Resources Management'),(2,'IT','Information Technology'),(3,'ENGG','Engineering'),(4,'R&D','Research and Development'),(5,'MK','Marketing'),(6,'ACNT','Accounting');
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(50) DEFAULT NULL,
  `LAST_NAME` varchar(50) DEFAULT NULL,
  `department_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`),
  KEY `FKbejtwvg9bxus2mffsm3swj3u9` (`department_id`),
  CONSTRAINT `FKbejtwvg9bxus2mffsm3swj3u9` FOREIGN KEY (`department_id`) REFERENCES `department` (`DEPARTMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
INSERT INTO `employee` VALUES (1,'Apoorva','Joshi',4,'Active'),(2,'Tim','Cook',3,'NotActive');
UNLOCK TABLES;


DROP TABLE IF EXISTS `RequestResponseLog`;
CREATE TABLE `RequestResponseLog` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `REQUEST_ID` varchar(100) DEFAULT NULL,
  `REQUEST_URL` varchar(100) DEFAULT NULL,
  `HTTP_METHOD` varchar(100) DEFAULT NULL,
  `CLASS_METHOD` varchar(100) DEFAULT NULL,
  `STORED_DATE` varchar(100) DEFAULT NULL,
  `RESPONSE` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

