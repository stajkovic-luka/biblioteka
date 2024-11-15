/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 10.4.32-MariaDB : Database - ps24_1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ps24_1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `ps24_1`;

/*Table structure for table `autor` */

DROP TABLE IF EXISTS `autor`;

CREATE TABLE `autor` (
  `id` bigint(20) NOT NULL,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `godinaRodjenja` bigint(20) DEFAULT NULL,
  `biografija` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `autor` */

insert  into `autor`(`id`,`ime`,`prezime`,`godinaRodjenja`,`biografija`) values 
(1,'William','Shakespear',1564,'English poet and writer...'),
(2,'Jane','Austen',1775,'Enlgish novelist known for her main six novels.'),
(3,'Leo','Tolstoy',1828,'Russian novelist known for his novels...'),
(4,'Mark','Twain',1835,'American writer, humorist, best known for...'),
(5,'Virigina','Woolf',1882,'An English writer, one of the most important modernists...');

/*Table structure for table `knjiga` */

DROP TABLE IF EXISTS `knjiga`;

CREATE TABLE `knjiga` (
  `id` bigint(20) NOT NULL,
  `naslov` varchar(50) DEFAULT NULL,
  `autorId` bigint(20) DEFAULT NULL,
  `godinaIzdanja` bigint(20) DEFAULT NULL,
  `isbn` varchar(50) DEFAULT NULL,
  `zanr` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `autorId` (`autorId`),
  CONSTRAINT `knjiga_ibfk_1` FOREIGN KEY (`autorId`) REFERENCES `autor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `knjiga` */

insert  into `knjiga`(`id`,`naslov`,`autorId`,`godinaIzdanja`,`isbn`,`zanr`) values 
(1,'Hamlet v2',1,1603,'123-4567890123','Tragedy'),
(2,'Pride and prejudice',2,1813,'234-5678901234','Novel'),
(4,'Adventures of Huckleberry Finn',4,1884,'456-7890123456','Novel');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values 
(1,'admin','admin'),
(2,'luka','luka123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
