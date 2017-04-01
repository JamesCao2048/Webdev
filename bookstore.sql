/*
Navicat MySQL Data Transfer

Source Server         : bookstore
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-03-28 23:53:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adms
-- ----------------------------
DROP TABLE IF EXISTS `adms`;
CREATE TABLE `adms` (
  `a_id` varchar(10) NOT NULL,
  PRIMARY KEY (`a_id`),
  CONSTRAINT `a_id` FOREIGN KEY (`a_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of adms
-- ----------------------------
INSERT INTO `adms` VALUES ('haha');
INSERT INTO `adms` VALUES ('junming');

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `b_id` varchar(10) NOT NULL,
  `b_name` varchar(40) DEFAULT NULL,
  `author` varchar(40) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `price` float NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('2', '33003', '0', '1', '4', 'science fiction');
INSERT INTO `books` VALUES ('333', '111', '333', '108', '111', 'directive fiction');
INSERT INTO `books` VALUES ('44', '213', '123', '11', '4444', 'economics');
INSERT INTO `books` VALUES ('bid', 'bname', 'bau', '320', '12', 'computer science');
INSERT INTO `books` VALUES ('bid10', 'bname10', 'bau10', '23', '45', 'history');
INSERT INTO `books` VALUES ('bid11', 'bname11', 'bau11', '23', '12', 'history');
INSERT INTO `books` VALUES ('bid12', 'bname12', 'bau12', '23', '123', 'literature');
INSERT INTO `books` VALUES ('bid13', 'bname13', 'bau13', '213', '12', 'literature');
INSERT INTO `books` VALUES ('bid2', 'bname2', 'bau2', '23', '31', 'biology');
INSERT INTO `books` VALUES ('bid3', 'bname3', 'bau3', '33', '43', 'biology');
INSERT INTO `books` VALUES ('bid4', 'bname4', 'bau4', '15', '21', 'computer science');
INSERT INTO `books` VALUES ('bid5', 'bname5', 'bau5', '25', '12', 'directive fiction');
INSERT INTO `books` VALUES ('bid6', 'bname6', 'bau6', '14', '25', 'science fiction');
INSERT INTO `books` VALUES ('bid7', 'bname7', 'bau7', '23', '14', 'science fiction');
INSERT INTO `books` VALUES ('bid8', 'bname8', 'bau8', '23', '14', 'science fiction');
INSERT INTO `books` VALUES ('bid9', 'bname9', 'bau9', '12', '31', 'directive fiction');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` varchar(20) NOT NULL,
  `o_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `o_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`o_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `u_id` FOREIGN KEY (`u_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('4', 'junming', '2016-03-28 15:01:58', '115.00');
INSERT INTO `orders` VALUES ('5', 'junming', '2016-03-28 15:01:58', '115.00');
INSERT INTO `orders` VALUES ('6', 'junming', '2016-03-28 15:03:42', '4.00');
INSERT INTO `orders` VALUES ('7', 'junming', '2016-03-28 15:04:04', '115.00');
INSERT INTO `orders` VALUES ('8', 'junming', '2016-03-28 15:05:03', '115.00');
INSERT INTO `orders` VALUES ('9', 'junming', '2016-03-28 15:20:28', '111.00');
INSERT INTO `orders` VALUES ('10', 'junming', '2016-03-28 15:55:20', '4.00');
INSERT INTO `orders` VALUES ('11', 'junming', '2016-03-28 15:56:52', '4.00');
INSERT INTO `orders` VALUES ('12', 'junming', '2016-03-28 16:14:26', '4.00');
INSERT INTO `orders` VALUES ('13', 'junming', '2016-05-09 21:41:29', '4.00');
INSERT INTO `orders` VALUES ('28', 'haha', '2017-03-18 17:07:42', '4571.00');
INSERT INTO `orders` VALUES ('29', 'haha', '2017-03-18 17:11:45', '4571.00');
INSERT INTO `orders` VALUES ('31', 'haha', '2017-03-18 17:14:48', '4571.00');
INSERT INTO `orders` VALUES ('32', 'junming', '2017-03-18 21:52:52', '115.00');
INSERT INTO `orders` VALUES ('33', 'junming', '2017-03-18 21:53:11', '0.00');
INSERT INTO `orders` VALUES ('34', 'junming', '2017-03-18 21:58:34', '4.00');
INSERT INTO `orders` VALUES ('37', 'junming', '2017-03-19 18:25:04', '0.00');
INSERT INTO `orders` VALUES ('38', 'haha', '2017-03-19 22:32:40', '4571.00');
INSERT INTO `orders` VALUES ('39', 'junming', '2017-03-26 12:16:28', '4.00');
INSERT INTO `orders` VALUES ('41', '112', '2017-03-29 17:10:43', '115.00');
INSERT INTO `orders` VALUES ('42', '112', '2017-03-29 17:10:53', '4.00');
INSERT INTO `orders` VALUES ('43', 'junming', '2017-03-29 20:50:46', '115.00');

-- ----------------------------
-- Table structure for order_book
-- ----------------------------
DROP TABLE IF EXISTS `order_book`;
CREATE TABLE `order_book` (
  `o_id` int(10) NOT NULL,
  `b_id` varchar(10) NOT NULL,
  PRIMARY KEY (`o_id`,`b_id`),
  KEY `b_id` (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order_book
-- ----------------------------
INSERT INTO `order_book` VALUES ('1', '2');
INSERT INTO `order_book` VALUES ('5', '2');
INSERT INTO `order_book` VALUES ('6', '2');
INSERT INTO `order_book` VALUES ('7', '2');
INSERT INTO `order_book` VALUES ('8', '2');
INSERT INTO `order_book` VALUES ('10', '2');
INSERT INTO `order_book` VALUES ('11', '2');
INSERT INTO `order_book` VALUES ('12', '2');
INSERT INTO `order_book` VALUES ('13', '2');
INSERT INTO `order_book` VALUES ('14', '2');
INSERT INTO `order_book` VALUES ('31', '2');
INSERT INTO `order_book` VALUES ('32', '2');
INSERT INTO `order_book` VALUES ('34', '2');
INSERT INTO `order_book` VALUES ('36', '2');
INSERT INTO `order_book` VALUES ('38', '2');
INSERT INTO `order_book` VALUES ('39', '2');
INSERT INTO `order_book` VALUES ('40', '2');
INSERT INTO `order_book` VALUES ('41', '2');
INSERT INTO `order_book` VALUES ('42', '2');
INSERT INTO `order_book` VALUES ('43', '2');
INSERT INTO `order_book` VALUES ('1', '333');
INSERT INTO `order_book` VALUES ('5', '333');
INSERT INTO `order_book` VALUES ('7', '333');
INSERT INTO `order_book` VALUES ('8', '333');
INSERT INTO `order_book` VALUES ('9', '333');
INSERT INTO `order_book` VALUES ('14', '333');
INSERT INTO `order_book` VALUES ('15', '333');
INSERT INTO `order_book` VALUES ('16', '333');
INSERT INTO `order_book` VALUES ('31', '333');
INSERT INTO `order_book` VALUES ('32', '333');
INSERT INTO `order_book` VALUES ('38', '333');
INSERT INTO `order_book` VALUES ('41', '333');
INSERT INTO `order_book` VALUES ('43', '333');
INSERT INTO `order_book` VALUES ('1', '44');
INSERT INTO `order_book` VALUES ('15', '44');
INSERT INTO `order_book` VALUES ('16', '44');
INSERT INTO `order_book` VALUES ('31', '44');
INSERT INTO `order_book` VALUES ('38', '44');
INSERT INTO `order_book` VALUES ('1', 'bid');
INSERT INTO `order_book` VALUES ('31', 'bid');
INSERT INTO `order_book` VALUES ('38', 'bid');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `u_id` varchar(20) NOT NULL,
  `pw` varchar(10) NOT NULL,
  `u_name` varchar(30) DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `e_mail` varchar(30) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('112', '233', 'abc', 'm\0\0\0\0\0\0\0\0\0', '233@qq.com', '23');
INSERT INTO `users` VALUES ('113', '233', '2', '1\0\0\0\0\0\0\0\0\0', '2@qq.com', '2');
INSERT INTO `users` VALUES ('1234', '233', '513', 'male', '134@qq.com', '3');
INSERT INTO `users` VALUES ('14', 'weq', 'dogliang', 'male', '2580638345@qq.com', '3');
INSERT INTO `users` VALUES ('213', 'wqe', '21', 'male', '2580638345@qq.com', '4');
INSERT INTO `users` VALUES ('222', '333', '111', '23\0\0\0\0\0\0\0\0', 's@sd', '6');
INSERT INTO `users` VALUES ('2222', '111', '233', '433\0\0\0\0\0\0\0', '1@qq.com', '5');
INSERT INTO `users` VALUES ('444', '3', '3', 'm', '2', '18');
INSERT INTO `users` VALUES ('5140379045', '5140379045', 'dogliang', 'male\0\0\0\0\0\0', 'dogliang@sjtu.edu.cn', '1');
INSERT INTO `users` VALUES ('dogliang23', 'haha', 'asd', 'male', '23213@qq.com', '20');
INSERT INTO `users` VALUES ('dogliang23344', '233', '123', '23', '4@qq.com', '123');
INSERT INTO `users` VALUES ('haha', 'hahaPW', 'mofashi', 'male\0\0\0\0\0\0', '12@qq.com', '3');
INSERT INTO `users` VALUES ('junming', '233', 'Junming Cao', 'male\0\0\0\0\0\0', 'junmingcao@sjtu.edu.cn', '10');
INSERT INTO `users` VALUES ('junming1', '233', '3', '12', '123@qq.com', '11');
INSERT INTO `users` VALUES ('wqe', 'szd', 'sa', 'male', 'sa@wqe.com', '3');
SET FOREIGN_KEY_CHECKS=1;
