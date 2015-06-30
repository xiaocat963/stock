/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-06-28 08:35:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
`code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`status`  int(1) NOT NULL ,
`companyid`  int(11) NOT NULL AUTO_INCREMENT ,
PRIMARY KEY (`companyid`),
UNIQUE INDEX `code_unique_key` (`code`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=8
ROW_FORMAT=COMPACT
;

-- ----------------------------
-- Records of company
-- ----------------------------

-- ----------------------------
-- Table structure for deal
-- ----------------------------
DROP TABLE IF EXISTS `deal`;
CREATE TABLE `deal` (
`dealid`  int(11) NOT NULL AUTO_INCREMENT ,
`code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`open`  float(20,2) NULL DEFAULT NULL ,
`close`  float(20,2) NULL DEFAULT NULL ,
`high`  float(20,2) NULL DEFAULT NULL ,
`low`  float(20,2) NULL DEFAULT NULL ,
`date`  date NOT NULL ,
`volume`  float(20,2) NULL DEFAULT NULL COMMENT '成交量' ,
`turnover`  float(20,2) NULL DEFAULT NULL ,
`capitalization`  float(20,2) NULL DEFAULT NULL ,
PRIMARY KEY (`dealid`),
UNIQUE INDEX `code_date_unique_key` (`code`, `date`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=9
ROW_FORMAT=COMPACT
;
-- ----------------------------
-- Records of deal
-- ----------------------------
