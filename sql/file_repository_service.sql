/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : file_repository_service

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-05-16 15:34:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for image_file
-- ----------------------------
DROP TABLE IF EXISTS `image_file`;
CREATE TABLE `image_file` (
  `img_id` varchar(255) NOT NULL COMMENT '图片id',
  `img_location_server` varchar(100) DEFAULT NULL COMMENT '存储服务器',
  `img_location` varchar(255) DEFAULT NULL COMMENT '图片存放位置',
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片访问地址',
  `img_system_id` varchar(100) DEFAULT NULL COMMENT '系统id',
  `img_flag` varchar(100) DEFAULT NULL COMMENT '图片标签',
  `img_attribute` varchar(100) DEFAULT NULL COMMENT '图片属性',
  `img_specific_unique_value` varchar(255) DEFAULT NULL COMMENT '特定唯一表示值',
  `img_param` varchar(100) DEFAULT NULL COMMENT '图片参数',
  `img_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `img_type` varchar(50) DEFAULT NULL COMMENT '类型',
  `img_create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '图片创建时间',
  `img_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '图片更新时间',
  `img_open_flag` varchar(50) DEFAULT 'Y' COMMENT '开放标识(Y:开放，N:私有)',
  `img_status` int(11) DEFAULT '0' COMMENT '图片状态（0：正常，1：删除）',
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of image_file
-- ----------------------------
