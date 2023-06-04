-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springboot7znd1
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `springboot7znd1`
--

/*!40000 DROP DATABASE IF EXISTS `springboot7znd1`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `springboot7znd1` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springboot7znd1`;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg'),(2,'picture2','upload/picture2.jpg'),(3,'picture3','upload/picture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussshequchangdi`
--

DROP TABLE IF EXISTS `discussshequchangdi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussshequchangdi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8 COMMENT='社区场地评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussshequchangdi`
--

LOCK TABLES `discussshequchangdi` WRITE;
/*!40000 ALTER TABLE `discussshequchangdi` DISABLE KEYS */;
INSERT INTO `discussshequchangdi` VALUES (131,'2022-07-31 23:36:58',1,1,'用户名1','评论内容1','回复内容1'),(132,'2022-07-31 23:36:58',2,2,'用户名2','评论内容2','回复内容2'),(133,'2022-07-31 23:36:58',3,3,'用户名3','评论内容3','回复内容3'),(134,'2022-07-31 23:36:58',4,4,'用户名4','评论内容4','回复内容4'),(135,'2022-07-31 23:36:58',5,5,'用户名5','评论内容5','回复内容5'),(136,'2022-07-31 23:36:58',6,6,'用户名6','评论内容6','回复内容6');
/*!40000 ALTER TABLE `discussshequchangdi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussshequhuodong`
--

DROP TABLE IF EXISTS `discussshequhuodong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussshequhuodong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8 COMMENT='社区活动评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussshequhuodong`
--

LOCK TABLES `discussshequhuodong` WRITE;
/*!40000 ALTER TABLE `discussshequhuodong` DISABLE KEYS */;
INSERT INTO `discussshequhuodong` VALUES (121,'2022-07-31 23:36:58',1,1,'用户名1','评论内容1','回复内容1'),(122,'2022-07-31 23:36:58',2,2,'用户名2','评论内容2','回复内容2'),(123,'2022-07-31 23:36:58',3,3,'用户名3','评论内容3','回复内容3'),(124,'2022-07-31 23:36:58',4,4,'用户名4','评论内容4','回复内容4'),(125,'2022-07-31 23:36:58',5,5,'用户名5','评论内容5','回复内容5'),(126,'2022-07-31 23:36:58',6,6,'用户名6','评论内容6','回复内容6');
/*!40000 ALTER TABLE `discussshequhuodong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) DEFAULT NULL COMMENT '帖子标题',
  `content` longtext NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父节点id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `isdone` varchar(200) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 COMMENT='社区论坛';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (101,'2022-07-31 23:36:58','帖子标题1','帖子内容1',0,1,'用户名1','开放'),(102,'2022-07-31 23:36:58','帖子标题2','帖子内容2',0,2,'用户名2','开放'),(103,'2022-07-31 23:36:58','帖子标题3','帖子内容3',0,3,'用户名3','开放'),(104,'2022-07-31 23:36:58','帖子标题4','帖子内容4',0,4,'用户名4','开放'),(105,'2022-07-31 23:36:58','帖子标题5','帖子内容5',0,5,'用户名5','开放'),(106,'2022-07-31 23:36:58','帖子标题6','帖子内容6',0,6,'用户名6','开放');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huodongbaoming`
--

DROP TABLE IF EXISTS `huodongbaoming`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huodongbaoming` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `baomingbianhao` varchar(200) DEFAULT NULL COMMENT '报名编号',
  `huodongmingcheng` varchar(200) NOT NULL COMMENT '活动名称',
  `huodongleixing` varchar(200) DEFAULT NULL COMMENT '活动类型',
  `huodongdidian` varchar(200) NOT NULL COMMENT '活动地点',
  `kaishishijian` varchar(200) DEFAULT NULL COMMENT '开始时间',
  `jieshushijian` varchar(200) DEFAULT NULL COMMENT '结束时间',
  `baomingjiezhi` varchar(200) DEFAULT NULL COMMENT '报名截止',
  `baomingrenshu` int(11) DEFAULT NULL COMMENT '报名人数',
  `lianxiren` varchar(200) DEFAULT NULL COMMENT '联系人',
  `lianluodianhua` varchar(200) DEFAULT NULL COMMENT '联络电话',
  `juminhao` varchar(200) DEFAULT NULL COMMENT '居民号',
  `juminxingming` varchar(200) DEFAULT NULL COMMENT '居民姓名',
  `juminshouji` varchar(200) DEFAULT NULL COMMENT '居民手机',
  `baomingshijian` datetime DEFAULT NULL COMMENT '报名时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `baomingbianhao` (`baomingbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='活动报名';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huodongbaoming`
--

LOCK TABLES `huodongbaoming` WRITE;
/*!40000 ALTER TABLE `huodongbaoming` DISABLE KEYS */;
INSERT INTO `huodongbaoming` VALUES (31,'2022-07-31 23:36:58','1111111111','活动名称1','活动类型1','活动地点1','开始时间1','结束时间1','报名截止1',1,'联系人1','13823888881','居民号1','居民姓名1','13823888881','2022-08-01 07:36:58'),(32,'2022-07-31 23:36:58','2222222222','活动名称2','活动类型2','活动地点2','开始时间2','结束时间2','报名截止2',2,'联系人2','13823888882','居民号2','居民姓名2','13823888882','2022-08-01 07:36:58'),(33,'2022-07-31 23:36:58','3333333333','活动名称3','活动类型3','活动地点3','开始时间3','结束时间3','报名截止3',3,'联系人3','13823888883','居民号3','居民姓名3','13823888883','2022-08-01 07:36:58'),(34,'2022-07-31 23:36:58','4444444444','活动名称4','活动类型4','活动地点4','开始时间4','结束时间4','报名截止4',4,'联系人4','13823888884','居民号4','居民姓名4','13823888884','2022-08-01 07:36:58'),(35,'2022-07-31 23:36:58','5555555555','活动名称5','活动类型5','活动地点5','开始时间5','结束时间5','报名截止5',5,'联系人5','13823888885','居民号5','居民姓名5','13823888885','2022-08-01 07:36:58'),(36,'2022-07-31 23:36:58','6666666666','活动名称6','活动类型6','活动地点6','开始时间6','结束时间6','报名截止6',6,'联系人6','13823888886','居民号6','居民姓名6','13823888886','2022-08-01 07:36:58');
/*!40000 ALTER TABLE `huodongbaoming` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huodongpingjia`
--

DROP TABLE IF EXISTS `huodongpingjia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huodongpingjia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `baomingbianhao` varchar(200) DEFAULT NULL COMMENT '报名编号',
  `huodongmingcheng` varchar(200) DEFAULT NULL COMMENT '活动名称',
  `huodongshijian` varchar(200) DEFAULT NULL COMMENT '活动时间',
  `huodongdidian` varchar(200) DEFAULT NULL COMMENT '活动地点',
  `baomingshijian` varchar(200) DEFAULT NULL COMMENT '报名时间',
  `huodongpingjia` longtext COMMENT '活动评价',
  `pingjiashijian` datetime DEFAULT NULL COMMENT '评价时间',
  `juminhao` varchar(200) DEFAULT NULL COMMENT '居民号',
  `juminxingming` varchar(200) DEFAULT NULL COMMENT '居民姓名',
  `juminshouji` varchar(200) DEFAULT NULL COMMENT '居民手机',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='活动评价';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huodongpingjia`
--

LOCK TABLES `huodongpingjia` WRITE;
/*!40000 ALTER TABLE `huodongpingjia` DISABLE KEYS */;
INSERT INTO `huodongpingjia` VALUES (41,'2022-07-31 23:36:58','报名编号1','活动名称1','活动时间1','活动地点1','报名时间1','活动评价1','2022-08-01 07:36:58','居民号1','居民姓名1','居民手机1'),(42,'2022-07-31 23:36:58','报名编号2','活动名称2','活动时间2','活动地点2','报名时间2','活动评价2','2022-08-01 07:36:58','居民号2','居民姓名2','居民手机2'),(43,'2022-07-31 23:36:58','报名编号3','活动名称3','活动时间3','活动地点3','报名时间3','活动评价3','2022-08-01 07:36:58','居民号3','居民姓名3','居民手机3'),(44,'2022-07-31 23:36:58','报名编号4','活动名称4','活动时间4','活动地点4','报名时间4','活动评价4','2022-08-01 07:36:58','居民号4','居民姓名4','居民手机4'),(45,'2022-07-31 23:36:58','报名编号5','活动名称5','活动时间5','活动地点5','报名时间5','活动评价5','2022-08-01 07:36:58','居民号5','居民姓名5','居民手机5'),(46,'2022-07-31 23:36:58','报名编号6','活动名称6','活动时间6','活动地点6','报名时间6','活动评价6','2022-08-01 07:36:58','居民号6','居民姓名6','居民手机6');
/*!40000 ALTER TABLE `huodongpingjia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jumin`
--

DROP TABLE IF EXISTS `jumin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jumin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `juminhao` varchar(200) NOT NULL COMMENT '居民号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `juminxingming` varchar(200) DEFAULT NULL COMMENT '居民姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `juminzhaopian` varchar(200) DEFAULT NULL COMMENT '居民照片',
  `juminshouji` varchar(200) DEFAULT NULL COMMENT '居民手机',
  `juzhudizhi` varchar(200) DEFAULT NULL COMMENT '居住地址',
  `menpaihao` varchar(200) DEFAULT NULL COMMENT '门牌号',
  `danyuanhao` varchar(200) DEFAULT NULL COMMENT '单元号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `juminhao` (`juminhao`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='居民';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jumin`
--

LOCK TABLES `jumin` WRITE;
/*!40000 ALTER TABLE `jumin` DISABLE KEYS */;
INSERT INTO `jumin` VALUES (11,'2022-07-31 23:36:58','居民号1','123456','居民姓名1','男',1,'upload/jumin_juminzhaopian1.jpg','13823888881','居住地址1','门牌号1','单元号1'),(12,'2022-07-31 23:36:58','居民号2','123456','居民姓名2','男',2,'upload/jumin_juminzhaopian2.jpg','13823888882','居住地址2','门牌号2','单元号2'),(13,'2022-07-31 23:36:58','居民号3','123456','居民姓名3','男',3,'upload/jumin_juminzhaopian3.jpg','13823888883','居住地址3','门牌号3','单元号3'),(14,'2022-07-31 23:36:58','居民号4','123456','居民姓名4','男',4,'upload/jumin_juminzhaopian4.jpg','13823888884','居住地址4','门牌号4','单元号4'),(15,'2022-07-31 23:36:58','居民号5','123456','居民姓名5','男',5,'upload/jumin_juminzhaopian5.jpg','13823888885','居住地址5','门牌号5','单元号5'),(16,'2022-07-31 23:36:58','居民号6','123456','居民姓名6','男',6,'upload/jumin_juminzhaopian6.jpg','13823888886','居住地址6','门牌号6','单元号6');
/*!40000 ALTER TABLE `jumin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quxiaobaoming`
--

DROP TABLE IF EXISTS `quxiaobaoming`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quxiaobaoming` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `huodongmingcheng` varchar(200) NOT NULL COMMENT '活动名称',
  `huodongleixing` varchar(200) DEFAULT NULL COMMENT '活动类型',
  `huodongdidian` varchar(200) NOT NULL COMMENT '活动地点',
  `kaishishijian` varchar(200) DEFAULT NULL COMMENT '开始时间',
  `jieshushijian` varchar(200) DEFAULT NULL COMMENT '结束时间',
  `baomingjiezhi` varchar(200) DEFAULT NULL COMMENT '报名截止',
  `baomingrenshu` int(11) DEFAULT NULL COMMENT '报名人数',
  `lianxiren` varchar(200) DEFAULT NULL COMMENT '联系人',
  `lianluodianhua` varchar(200) DEFAULT NULL COMMENT '联络电话',
  `juminhao` varchar(200) DEFAULT NULL COMMENT '居民号',
  `juminxingming` varchar(200) DEFAULT NULL COMMENT '居民姓名',
  `juminshouji` varchar(200) DEFAULT NULL COMMENT '居民手机',
  `quxiaoyuanyin` varchar(200) NOT NULL COMMENT '取消原因',
  `quxiaoshijian` datetime DEFAULT NULL COMMENT '取消时间',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='取消报名';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quxiaobaoming`
--

LOCK TABLES `quxiaobaoming` WRITE;
/*!40000 ALTER TABLE `quxiaobaoming` DISABLE KEYS */;
INSERT INTO `quxiaobaoming` VALUES (51,'2022-07-31 23:36:58','活动名称1','活动类型1','活动地点1','开始时间1','结束时间1','报名截止1',1,'联系人1','13823888881','居民号1','居民姓名1','居民手机1','取消原因1','2022-08-01 07:36:58',1,1,'是',''),(52,'2022-07-31 23:36:58','活动名称2','活动类型2','活动地点2','开始时间2','结束时间2','报名截止2',2,'联系人2','13823888882','居民号2','居民姓名2','居民手机2','取消原因2','2022-08-01 07:36:58',2,2,'是',''),(53,'2022-07-31 23:36:58','活动名称3','活动类型3','活动地点3','开始时间3','结束时间3','报名截止3',3,'联系人3','13823888883','居民号3','居民姓名3','居民手机3','取消原因3','2022-08-01 07:36:58',3,3,'是',''),(54,'2022-07-31 23:36:58','活动名称4','活动类型4','活动地点4','开始时间4','结束时间4','报名截止4',4,'联系人4','13823888884','居民号4','居民姓名4','居民手机4','取消原因4','2022-08-01 07:36:58',4,4,'是',''),(55,'2022-07-31 23:36:58','活动名称5','活动类型5','活动地点5','开始时间5','结束时间5','报名截止5',5,'联系人5','13823888885','居民号5','居民姓名5','居民手机5','取消原因5','2022-08-01 07:36:58',5,5,'是',''),(56,'2022-07-31 23:36:58','活动名称6','活动类型6','活动地点6','开始时间6','结束时间6','报名截止6',6,'联系人6','13823888886','居民号6','居民姓名6','居民手机6','取消原因6','2022-08-01 07:36:58',6,6,'是','');
/*!40000 ALTER TABLE `quxiaobaoming` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shequchangdi`
--

DROP TABLE IF EXISTS `shequchangdi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shequchangdi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `changdimingcheng` varchar(200) NOT NULL COMMENT '场地名称',
  `changdisheshi` varchar(200) NOT NULL COMMENT '场地设施',
  `changditupian` varchar(200) DEFAULT NULL COMMENT '场地图片',
  `changdiquyu` varchar(200) NOT NULL COMMENT '场地区域',
  `changdianpai` varchar(200) DEFAULT NULL COMMENT '场地安排',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `changdixiangqing` longtext COMMENT '场地详情',
  `shiyongshijian` varchar(200) DEFAULT NULL COMMENT '使用时间',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='社区场地';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shequchangdi`
--

LOCK TABLES `shequchangdi` WRITE;
/*!40000 ALTER TABLE `shequchangdi` DISABLE KEYS */;
INSERT INTO `shequchangdi` VALUES (81,'2022-07-31 23:36:58','场地名称1','场地设施1','upload/shequchangdi_changditupian1.jpg','场地区域1','场地安排1','13823888881','场地详情1','使用时间1','2022-08-01 07:36:58',1),(82,'2022-07-31 23:36:58','场地名称2','场地设施2','upload/shequchangdi_changditupian2.jpg','场地区域2','场地安排2','13823888882','场地详情2','使用时间2','2022-08-01 07:36:58',2),(83,'2022-07-31 23:36:58','场地名称3','场地设施3','upload/shequchangdi_changditupian3.jpg','场地区域3','场地安排3','13823888883','场地详情3','使用时间3','2022-08-01 07:36:58',3),(84,'2022-07-31 23:36:58','场地名称4','场地设施4','upload/shequchangdi_changditupian4.jpg','场地区域4','场地安排4','13823888884','场地详情4','使用时间4','2022-08-01 07:36:58',4),(85,'2022-07-31 23:36:58','场地名称5','场地设施5','upload/shequchangdi_changditupian5.jpg','场地区域5','场地安排5','13823888885','场地详情5','使用时间5','2022-08-01 07:36:58',5),(86,'2022-07-31 23:36:58','场地名称6','场地设施6','upload/shequchangdi_changditupian6.jpg','场地区域6','场地安排6','13823888886','场地详情6','使用时间6','2022-08-01 07:36:58',6);
/*!40000 ALTER TABLE `shequchangdi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shequgonggao`
--

DROP TABLE IF EXISTS `shequgonggao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shequgonggao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) DEFAULT NULL COMMENT '标题',
  `neirong` longtext COMMENT '内容',
  `fabushijian` date DEFAULT NULL COMMENT '发布时间',
  `faburen` varchar(200) DEFAULT NULL COMMENT '发布人',
  `tupian` varchar(200) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='社区公告';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shequgonggao`
--

LOCK TABLES `shequgonggao` WRITE;
/*!40000 ALTER TABLE `shequgonggao` DISABLE KEYS */;
INSERT INTO `shequgonggao` VALUES (91,'2022-07-31 23:36:58','标题1','内容1','2022-08-01','发布人1','upload/shequgonggao_tupian1.jpg'),(92,'2022-07-31 23:36:58','标题2','内容2','2022-08-01','发布人2','upload/shequgonggao_tupian2.jpg'),(93,'2022-07-31 23:36:58','标题3','内容3','2022-08-01','发布人3','upload/shequgonggao_tupian3.jpg'),(94,'2022-07-31 23:36:58','标题4','内容4','2022-08-01','发布人4','upload/shequgonggao_tupian4.jpg'),(95,'2022-07-31 23:36:58','标题5','内容5','2022-08-01','发布人5','upload/shequgonggao_tupian5.jpg'),(96,'2022-07-31 23:36:58','标题6','内容6','2022-08-01','发布人6','upload/shequgonggao_tupian6.jpg');
/*!40000 ALTER TABLE `shequgonggao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shequhuodong`
--

DROP TABLE IF EXISTS `shequhuodong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shequhuodong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `huodongmingcheng` varchar(200) NOT NULL COMMENT '活动名称',
  `huodongleixing` varchar(200) DEFAULT NULL COMMENT '活动类型',
  `huodongfengmian` varchar(200) DEFAULT NULL COMMENT '活动封面',
  `huodongdidian` varchar(200) NOT NULL COMMENT '活动地点',
  `kaishishijian` datetime DEFAULT NULL COMMENT '开始时间',
  `huodongneirong` longtext COMMENT '活动内容',
  `jieshushijian` datetime DEFAULT NULL COMMENT '结束时间',
  `baomingjiezhi` date DEFAULT NULL COMMENT '报名截止',
  `baomingrenshu` int(11) DEFAULT NULL COMMENT '报名人数',
  `lianxiren` varchar(200) DEFAULT NULL COMMENT '联系人',
  `lianluodianhua` varchar(200) DEFAULT NULL COMMENT '联络电话',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='社区活动';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shequhuodong`
--

LOCK TABLES `shequhuodong` WRITE;
/*!40000 ALTER TABLE `shequhuodong` DISABLE KEYS */;
INSERT INTO `shequhuodong` VALUES (21,'2022-07-31 23:36:58','活动名称1','活动类型1','upload/shequhuodong_huodongfengmian1.jpg','活动地点1','2022-08-01 07:36:58','活动内容1','2022-08-01 07:36:58','2022-08-01',1,'联系人1','13823888881',1,1,'2022-08-01 07:36:58',1),(22,'2022-07-31 23:36:58','活动名称2','活动类型2','upload/shequhuodong_huodongfengmian2.jpg','活动地点2','2022-08-01 07:36:58','活动内容2','2022-08-01 07:36:58','2022-08-01',2,'联系人2','13823888882',2,2,'2022-08-01 07:36:58',2),(23,'2022-07-31 23:36:58','活动名称3','活动类型3','upload/shequhuodong_huodongfengmian3.jpg','活动地点3','2022-08-01 07:36:58','活动内容3','2022-08-01 07:36:58','2022-08-01',3,'联系人3','13823888883',3,3,'2022-08-01 07:36:58',3),(24,'2022-07-31 23:36:58','活动名称4','活动类型4','upload/shequhuodong_huodongfengmian4.jpg','活动地点4','2022-08-01 07:36:58','活动内容4','2022-08-01 07:36:58','2022-08-01',4,'联系人4','13823888884',4,4,'2022-08-01 07:36:58',4),(25,'2022-07-31 23:36:58','活动名称5','活动类型5','upload/shequhuodong_huodongfengmian5.jpg','活动地点5','2022-08-01 07:36:58','活动内容5','2022-08-01 07:36:58','2022-08-01',5,'联系人5','13823888885',5,5,'2022-08-01 07:36:58',5),(26,'2022-07-31 23:36:58','活动名称6','活动类型6','upload/shequhuodong_huodongfengmian6.jpg','活动地点6','2022-08-01 07:36:58','活动内容6','2022-08-01 07:36:58','2022-08-01',6,'联系人6','13823888886',6,6,'2022-08-01 07:36:58',6);
/*!40000 ALTER TABLE `shequhuodong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '收藏id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '收藏名称',
  `picture` varchar(200) NOT NULL COMMENT '收藏图片',
  `type` varchar(200) DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩)',
  `inteltype` varchar(200) DEFAULT NULL COMMENT '推荐类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Add时间',
  `expiratedtime` timestamp NOT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toupiaotongji`
--

DROP TABLE IF EXISTS `toupiaotongji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `toupiaotongji` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) DEFAULT NULL COMMENT '标题',
  `toupiaoxuanxiang` varchar(200) NOT NULL COMMENT '投票选项',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `dengjishijian` datetime DEFAULT NULL COMMENT '登记时间',
  `juminhao` varchar(200) DEFAULT NULL COMMENT '居民号',
  `juminxingming` varchar(200) DEFAULT NULL COMMENT '居民姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='投票统计';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toupiaotongji`
--

LOCK TABLES `toupiaotongji` WRITE;
/*!40000 ALTER TABLE `toupiaotongji` DISABLE KEYS */;
INSERT INTO `toupiaotongji` VALUES (71,'2022-07-31 23:36:58','标题1','赞成','备注1','2022-08-01 07:36:58','居民号1','居民姓名1'),(72,'2022-07-31 23:36:58','标题2','赞成','备注2','2022-08-01 07:36:58','居民号2','居民姓名2'),(73,'2022-07-31 23:36:58','标题3','赞成','备注3','2022-08-01 07:36:58','居民号3','居民姓名3'),(74,'2022-07-31 23:36:58','标题4','赞成','备注4','2022-08-01 07:36:58','居民号4','居民姓名4'),(75,'2022-07-31 23:36:58','标题5','赞成','备注5','2022-08-01 07:36:58','居民号5','居民姓名5'),(76,'2022-07-31 23:36:58','标题6','赞成','备注6','2022-08-01 07:36:58','居民号6','居民姓名6');
/*!40000 ALTER TABLE `toupiaotongji` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toupiaoxinxi`
--

DROP TABLE IF EXISTS `toupiaoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `toupiaoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `toupiaobiaoti` varchar(200) NOT NULL COMMENT '投票标题',
  `kaishishijian` date DEFAULT NULL COMMENT '开始时间',
  `jiezhishijian` date DEFAULT NULL COMMENT '截止时间',
  `fengmian` varchar(200) DEFAULT NULL COMMENT '封面',
  `toupiaoneirong` longtext COMMENT '投票内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='投票信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toupiaoxinxi`
--

LOCK TABLES `toupiaoxinxi` WRITE;
/*!40000 ALTER TABLE `toupiaoxinxi` DISABLE KEYS */;
INSERT INTO `toupiaoxinxi` VALUES (61,'2022-07-31 23:36:58','投票标题1','2022-08-01','2022-08-01','upload/toupiaoxinxi_fengmian1.jpg','投票内容1'),(62,'2022-07-31 23:36:58','投票标题2','2022-08-01','2022-08-01','upload/toupiaoxinxi_fengmian2.jpg','投票内容2'),(63,'2022-07-31 23:36:58','投票标题3','2022-08-01','2022-08-01','upload/toupiaoxinxi_fengmian3.jpg','投票内容3'),(64,'2022-07-31 23:36:58','投票标题4','2022-08-01','2022-08-01','upload/toupiaoxinxi_fengmian4.jpg','投票内容4'),(65,'2022-07-31 23:36:58','投票标题5','2022-08-01','2022-08-01','upload/toupiaoxinxi_fengmian5.jpg','投票内容5'),(66,'2022-07-31 23:36:58','投票标题6','2022-08-01','2022-08-01','upload/toupiaoxinxi_fengmian6.jpg','投票内容6');
/*!40000 ALTER TABLE `toupiaoxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT 'administered' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Add时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abo','abo','administered','2022-07-31 23:36:58');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-01  7:40:12
-- 创建交通表
CREATE TABLE 交通 (
                    userId INT NOT NULL AUTO_INCREMENT,
                    用户名 VARCHAR(50),
                    手机号 VARCHAR(15),
                    电子邮箱 VARCHAR(100),
                    地点 VARCHAR(100),
                    时间 DATETIME,
                    描述 VARCHAR(200),
                    type VARCHAR(50),
                    PRIMARY KEY (userId)
);

-- 插入示例数据
INSERT INTO 交通 (用户名, 手机号, 电子邮箱, 地点, 时间, 描述, type)
VALUES
    ('张三', '123456789', 'zhangsan@example.com', '北京', '2023-05-20 09:00:00', '乘坐地铁到公司', '地铁'),
    ('李四', '987654321', 'lisi@example.com', '上海', '2023-05-20 08:30:00', '开车去上班', '私家车'),
    ('王五', '555555555', 'wangwu@example.com', '广州', '2023-05-20 10:15:00', '坐公交去购物中心', '公交车');


-- 创建犯罪报告表
CREATE TABLE 犯罪报告 (
                      userId INT,
                      用户名 VARCHAR(50),
                      手机号 VARCHAR(15),
                      电子邮箱 VARCHAR(100),
                      地点 VARCHAR(100),
                      时间 DATETIME,
                      描述 VARCHAR(200),
                      type VARCHAR(50)
);

-- 插入示例数据
INSERT INTO 犯罪报告 (userId, 用户名, 手机号, 电子邮箱, 地点, 时间, 描述, type)
VALUES
    (1, '张三', '123456789', 'zhangsan@example.com', '北京', '2023-05-20 09:00:00', '目击抢劫案发生', '抢劫'),
    (2, '李四', '987654321', 'lisi@example.com', '上海', '2023-05-20 08:30:00', '车辆被盗', '盗窃'),
    (3, '王五', '555555555', 'wangwu@example.com', '广州', '2023-05-20 10:15:00', '遭遇电信诈骗', '电信诈骗');


-- 创建求救信息表
CREATE TABLE help_messages (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               sender_name VARCHAR(255),
                               sender_email VARCHAR(255),
                               sender_phone VARCHAR(20),
                               message TEXT,
                               latitude FLOAT,
                               longitude FLOAT,
                               timestamp DATETIME
);

-- 插入示例信息
INSERT INTO help_messages (sender_name, sender_email, sender_phone, message, latitude, longitude, timestamp)
VALUES ('John Doe', 'john@example.com', '1234567890', 'Help! I''m trapped in a building.', 40.7128, -74.0060, NOW());

INSERT INTO help_messages (sender_name, sender_email, sender_phone, message, latitude, longitude, timestamp)
VALUES ('Jane Smith', 'jane@example.com', '9876543210', 'Urgent assistance needed at my location.', 37.7749, -122.4194, NOW());

INSERT INTO help_messages (sender_name, sender_email, sender_phone, message, latitude, longitude, timestamp)
VALUES ('Samuel Lee', 'sam@example.com', '5555555555', 'Emergency situation, please send help immediately.', 35.6895, 139.6917, NOW());

