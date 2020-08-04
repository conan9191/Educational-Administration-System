-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: edu_system
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `role_menu`
--

DROP TABLE IF EXISTS `role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_menu` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(2) unsigned NOT NULL,
  `menu_id` int(2) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用来存储模块对应菜单信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_menu`
--

LOCK TABLES `role_menu` WRITE;
/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
INSERT INTO `role_menu` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,2,5),(6,2,6),(7,2,7),(8,3,8),(9,3,9),(10,4,10),(11,4,11),(12,4,12),(13,4,13);
/*!40000 ALTER TABLE `role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_argument`
--

DROP TABLE IF EXISTS `t_argument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_argument` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(255) NOT NULL COMMENT '系统名称',
  `copyright` varchar(255) NOT NULL COMMENT '版权',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用来存储参数信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_argument`
--

LOCK TABLES `t_argument` WRITE;
/*!40000 ALTER TABLE `t_argument` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_argument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_attendance`
--

DROP TABLE IF EXISTS `t_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_attendance` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `student_id` int(2) unsigned NOT NULL,
  `clock_date` datetime NOT NULL COMMENT '打卡时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用来存储考勤信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_attendance`
--

LOCK TABLES `t_attendance` WRITE;
/*!40000 ALTER TABLE `t_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_center`
--

DROP TABLE IF EXISTS `t_center`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_center` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `city` varchar(50) NOT NULL COMMENT '中心城市名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用来存储培训中心信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_center`
--

LOCK TABLES `t_center` WRITE;
/*!40000 ALTER TABLE `t_center` DISABLE KEYS */;
INSERT INTO `t_center` VALUES (1,'无锡'),(2,'重庆'),(3,'贵州'),(4,'青岛'),(5,'泉州');
/*!40000 ALTER TABLE `t_center` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_class`
--

DROP TABLE IF EXISTS `t_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_class` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) NOT NULL COMMENT '班级名',
  `center_id` int(2) unsigned NOT NULL,
  `school_year_id` int(2) unsigned NOT NULL,
  `profession_id` int(2) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用来存储班级信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_class`
--

LOCK TABLES `t_class` WRITE;
/*!40000 ALTER TABLE `t_class` DISABLE KEYS */;
INSERT INTO `t_class` VALUES (1,'java01',1,2,1),(2,'php01',2,2,2),(3,'java02',3,3,1),(4,'java03',2,1,2);
/*!40000 ALTER TABLE `t_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_classroom`
--

DROP TABLE IF EXISTS `t_classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_classroom` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(225) NOT NULL COMMENT '教室名称',
  `center_id` int(2) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用来存储各中心教室信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_classroom`
--

LOCK TABLES `t_classroom` WRITE;
/*!40000 ALTER TABLE `t_classroom` DISABLE KEYS */;
INSERT INTO `t_classroom` VALUES (1,'class1',1),(2,'class2',1),(3,'class3',1),(4,'class1',2),(5,'class2',2),(6,'class1',3),(7,'class2',3),(8,'class3',3),(9,'class4',3),(10,'class1',4),(11,'class2',4),(12,'class4',4);
/*!40000 ALTER TABLE `t_classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_company`
--

DROP TABLE IF EXISTS `t_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_company` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `offer` varchar(45) DEFAULT NULL COMMENT '岗位',
  `count` varchar(45) DEFAULT NULL COMMENT '招聘数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存储企业公司信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_company`
--

LOCK TABLES `t_company` WRITE;
/*!40000 ALTER TABLE `t_company` DISABLE KEYS */;
INSERT INTO `t_company` VALUES (1,'贪玩蓝月','游戏体验师','5'),(2,'腾讯王者荣耀','代打','10'),(3,'神舟专车','熟练司机','100'),(4,'青岛大学','程序猿','20');
/*!40000 ALTER TABLE `t_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_course`
--

DROP TABLE IF EXISTS `t_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_course` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) NOT NULL COMMENT '课程名',
  `course_hour` varchar(50) NOT NULL COMMENT '课时',
  `course_file` varchar(225) NOT NULL COMMENT '课件URL',
  `proportion` float NOT NULL COMMENT '考核成绩占比数',
  `course_type_id` int(2) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用来存储课程信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course`
--

LOCK TABLES `t_course` WRITE;
/*!40000 ALTER TABLE `t_course` DISABLE KEYS */;
INSERT INTO `t_course` VALUES (1,'Spring','50','#',0.2,1),(2,'mysql','20','#',0.32,2),(3,'html&css','30','#',0.3,1),(4,'oracle','20','#',0.2,1);
/*!40000 ALTER TABLE `t_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_course_chapter`
--

DROP TABLE IF EXISTS `t_course_chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_course_chapter` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) NOT NULL COMMENT '课程章节名',
  `content` varchar(255) NOT NULL COMMENT '课程章节内容',
  `chapter_file` varchar(225) NOT NULL COMMENT '课程章节附件URL',
  `course_id` int(2) unsigned NOT NULL COMMENT '课程ID',
  `superior_id` int(2) unsigned NOT NULL COMMENT '上一章节ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用来存储课程章节信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course_chapter`
--

LOCK TABLES `t_course_chapter` WRITE;
/*!40000 ALTER TABLE `t_course_chapter` DISABLE KEYS */;
INSERT INTO `t_course_chapter` VALUES (1,'mysql','一门数据库系统软件','#',1,1),(2,'html&css','网页设计语言','#',2,1),(3,'jsp','凉凉，过时没人用啦','#',1,2),(4,'servlet','基础要好好学呦','#',2,1);
/*!40000 ALTER TABLE `t_course_chapter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_course_type`
--

DROP TABLE IF EXISTS `t_course_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_course_type` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) NOT NULL COMMENT '课程类型名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用来存储课程类型信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course_type`
--

LOCK TABLES `t_course_type` WRITE;
/*!40000 ALTER TABLE `t_course_type` DISABLE KEYS */;
INSERT INTO `t_course_type` VALUES (1,'SLT授课'),(2,'面对面授课'),(3,'项目实践'),(4,'云课堂'),(5,'网络直播');
/*!40000 ALTER TABLE `t_course_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_department`
--

DROP TABLE IF EXISTS `t_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_department` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(225) NOT NULL COMMENT '培训部门名',
  `center_id` int(2) unsigned NOT NULL,
  `superior_id` int(2) unsigned NOT NULL COMMENT '上级部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='用来存储培训部门信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_department`
--

LOCK TABLES `t_department` WRITE;
/*!40000 ALTER TABLE `t_department` DISABLE KEYS */;
INSERT INTO `t_department` VALUES (1,'教学部',1,0),(2,'人力资源',1,0),(3,'财务部',1,0),(4,'市场营销部',1,0),(5,'技术研发',1,0),(6,'社会教学部',1,1),(7,'校园教学部',1,1),(8,'教学部',2,0),(9,'人力资源',2,0),(10,'财务部',2,0),(11,'市场营销部',2,0),(12,'技术研发',2,0),(13,'社会教学部',2,8),(14,'校园教学部',2,8),(15,'教学部',3,0),(16,'人力资源',3,0),(17,'财务部',3,0),(18,'市场营销部',3,0),(19,'技术研发',3,0),(20,'社会教学部',3,15),(21,'校园教学部',4,15),(22,'教学部',4,0),(23,'人力资源',4,0),(24,'财务部',4,0),(25,'市场营销部',4,0),(26,'技术研发',4,0),(27,'社会教学部',4,22),(28,'校园教学部',4,22);
/*!40000 ALTER TABLE `t_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_employment`
--

DROP TABLE IF EXISTS `t_employment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_employment` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `student_id` int(2) unsigned NOT NULL COMMENT '学生ID',
  `job` varchar(50) NOT NULL COMMENT '工作去向',
  `company` varchar(50) NOT NULL COMMENT '公司名称',
  `resume` varchar(225) NOT NULL COMMENT '简历附件URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='用来存储就业信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_employment`
--

LOCK TABLES `t_employment` WRITE;
/*!40000 ALTER TABLE `t_employment` DISABLE KEYS */;
INSERT INTO `t_employment` VALUES (15,10,'','',''),(16,10,'','',''),(17,10,'','',''),(18,10,'','',''),(19,10,'','',''),(20,10,'','',''),(21,10,'java','阿里巴巴','');
/*!40000 ALTER TABLE `t_employment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_equipment`
--

DROP TABLE IF EXISTS `t_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_equipment` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `category` varchar(225) NOT NULL COMMENT '设备类型',
  `center_id` int(2) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用来存储各中心设备信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_equipment`
--

LOCK TABLES `t_equipment` WRITE;
/*!40000 ALTER TABLE `t_equipment` DISABLE KEYS */;
INSERT INTO `t_equipment` VALUES (1,'课桌',1),(2,'电脑',1),(3,'投影仪',1),(4,'椅子',1),(5,'电脑',2),(6,'投影仪',2),(7,'课桌',2),(8,'椅子',2),(9,'空调',2),(10,'课桌',3),(11,'电脑',3),(12,'椅子',3),(13,'空调',3),(14,'课桌',4),(15,'椅子',4);
/*!40000 ALTER TABLE `t_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_grade`
--

DROP TABLE IF EXISTS `t_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentNo` varchar(45) DEFAULT NULL COMMENT '学生学号',
  `courseName` varchar(45) DEFAULT NULL COMMENT '课程名字',
  `grade` int(11) DEFAULT NULL COMMENT '成绩分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='学生成绩';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_grade`
--

LOCK TABLES `t_grade` WRITE;
/*!40000 ALTER TABLE `t_grade` DISABLE KEYS */;
INSERT INTO `t_grade` VALUES (1,'201440703634','Spring',100),(2,'201440703635','Spring',100),(3,'201440703679','Spring',100);
/*!40000 ALTER TABLE `t_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_group`
--

DROP TABLE IF EXISTS `t_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_group` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(225) NOT NULL COMMENT '小组名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用来存储各小组信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_group`
--

LOCK TABLES `t_group` WRITE;
/*!40000 ALTER TABLE `t_group` DISABLE KEYS */;
INSERT INTO `t_group` VALUES (1,'组1'),(2,'组2'),(3,'组3');
/*!40000 ALTER TABLE `t_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_leave`
--

DROP TABLE IF EXISTS `t_leave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_leave` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(2) DEFAULT NULL,
  `leaveType` varchar(45) DEFAULT NULL COMMENT '请假类型',
  `photo` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT b'0' COMMENT '请假是否通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='请假表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_leave`
--

LOCK TABLES `t_leave` WRITE;
/*!40000 ALTER TABLE `t_leave` DISABLE KEYS */;
INSERT INTO `t_leave` VALUES (15,10,'事假','D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\leave.jpg',NULL),(16,10,NULL,NULL,NULL);
/*!40000 ALTER TABLE `t_leave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_menu`
--

DROP TABLE IF EXISTS `t_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_menu` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `item` varchar(255) NOT NULL COMMENT '菜单项名',
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  `parentId` int(2) unsigned DEFAULT NULL COMMENT '父菜单Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='用来存储菜单信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_menu`
--

LOCK TABLES `t_menu` WRITE;
/*!40000 ALTER TABLE `t_menu` DISABLE KEYS */;
INSERT INTO `t_menu` VALUES (1,'模块管理','',NULL),(2,'菜单管理','',NULL),(3,'角色管理','',NULL),(4,'用户管理','',NULL),(5,'组织管理','',NULL),(6,'资产管理','',NULL),(7,'人事管理',NULL,NULL),(8,'学生管理',NULL,NULL),(9,'教务管理',NULL,NULL),(10,'考勤管理','',NULL),(11,'学习管理',NULL,NULL),(12,'成绩查询','',NULL),(13,'就业管理',NULL,NULL),(14,'区域管理','organization',5),(15,'部门管理','department',5),(16,'教室管理','classroom',6),(17,'教学设备管理','equipment',6),(18,'职位管理','position',7),(19,'职员管理','staff',7),(20,'学生档案管理','studentInfo',8),(21,'学生分组管理','studentGroup',8),(22,'成绩录入','inputGrade',8),(23,'学年管理','schoolYear',9),(24,'学期管理','semester',9),(25,'专业管理','profession',9),(26,'班级管理','class',9),(27,'课程管理','course',9),(28,'考勤','sign',10),(29,'请假','leave',10),(30,'笔记管理','note',11),(31,'项目管理','project',11),(32,'企业查询','company',13),(33,'入职备案','signOffer',13),(34,'上传简历','resume',13),(35,'查询成绩','outputGrade',12),(36,'模块','module',1),(37,'菜单','menu',2),(38,'角色','role',3),(39,'用户','user',4);
/*!40000 ALTER TABLE `t_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_module`
--

DROP TABLE IF EXISTS `t_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_module` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) NOT NULL COMMENT '模块名',
  `status` bit(2) DEFAULT b'1' COMMENT '默认为1 删除则记作0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用来存储模块信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_module`
--

LOCK TABLES `t_module` WRITE;
/*!40000 ALTER TABLE `t_module` DISABLE KEYS */;
INSERT INTO `t_module` VALUES (1,'系统管理','\0'),(2,'组织管理',''),(3,'资产管理','\0'),(4,'人事管理',''),(5,'学生管理',''),(6,'考勤管理',''),(7,'教务管理',''),(8,'学习管理',''),(9,'成绩管理',''),(10,'就业管理','\0');
/*!40000 ALTER TABLE `t_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_note`
--

DROP TABLE IF EXISTS `t_note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_note` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) NOT NULL COMMENT '笔记名',
  `student_id` int(2) unsigned NOT NULL COMMENT '学生ID',
  `schedule_id` int(2) unsigned NOT NULL COMMENT '课程表ID',
  `content` varchar(225) NOT NULL COMMENT '笔记内容',
  `project_file` varchar(225) NOT NULL COMMENT '课程章节附件URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用来存储课程笔记信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_note`
--

LOCK TABLES `t_note` WRITE;
/*!40000 ALTER TABLE `t_note` DISABLE KEYS */;
INSERT INTO `t_note` VALUES (1,'关于spring',10,1,'Spring是一个开放源代码的设计层面框架，他解决的是业务逻辑层和其他各层的松耦合问题，因此它将面向接口的编程思想贯穿整个系统应用。Spring是于2003 年兴起的一个轻量级的Java 开发框架，由Rod Johnson创建。简单来说，Spring是一个分层的JavaSE/EEfull-stack(一站式) 轻量级开源框架。hi','#');
/*!40000 ALTER TABLE `t_note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_notice`
--

DROP TABLE IF EXISTS `t_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_notice` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `content` varchar(255) NOT NULL COMMENT '公告内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用来存储公告信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_notice`
--

LOCK TABLES `t_notice` WRITE;
/*!40000 ALTER TABLE `t_notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_position`
--

DROP TABLE IF EXISTS `t_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_position` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(225) NOT NULL COMMENT '职位名称',
  `department_id` int(2) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用来存储各部门职业信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_position`
--

LOCK TABLES `t_position` WRITE;
/*!40000 ALTER TABLE `t_position` DISABLE KEYS */;
INSERT INTO `t_position` VALUES (1,'讲师',1),(2,'辅导员',1),(3,'销售人员',4),(4,'HR',2),(5,'会计',3),(6,'领导',2);
/*!40000 ALTER TABLE `t_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_profession`
--

DROP TABLE IF EXISTS `t_profession`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_profession` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) NOT NULL COMMENT '专业方向名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用来存储专业方向信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_profession`
--

LOCK TABLES `t_profession` WRITE;
/*!40000 ALTER TABLE `t_profession` DISABLE KEYS */;
INSERT INTO `t_profession` VALUES (1,'java'),(2,'php'),(3,'python');
/*!40000 ALTER TABLE `t_profession` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_project`
--

DROP TABLE IF EXISTS `t_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(2) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL COMMENT '项目url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='项目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_project`
--

LOCK TABLES `t_project` WRITE;
/*!40000 ALTER TABLE `t_project` DISABLE KEYS */;
INSERT INTO `t_project` VALUES (3,10,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\project.zip');
/*!40000 ALTER TABLE `t_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_resume`
--

DROP TABLE IF EXISTS `t_resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(2) DEFAULT NULL COMMENT '学生学号',
  `resume` varchar(255) DEFAULT NULL COMMENT '简历地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='简历表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_resume`
--

LOCK TABLES `t_resume` WRITE;
/*!40000 ALTER TABLE `t_resume` DISABLE KEYS */;
INSERT INTO `t_resume` VALUES (1,1,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\a.doc'),(2,1,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\a.doc'),(3,1,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\a.doc'),(4,1,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\a.doc'),(5,1,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\a.doc'),(6,1,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\a.doc'),(7,1,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\a.doc'),(8,1,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\a.doc'),(9,10,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\resume.doc'),(10,10,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\resume.doc'),(11,10,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\1.doc'),(12,10,'D:\\Apache_Software_Foundation\\Tomcat7.0\\webapps\\edu_system\\upload\\file\\\\resume.doc');
/*!40000 ALTER TABLE `t_resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(255) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用来存储角色信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'管理员'),(2,'领导'),(3,'老师'),(4,'学生');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_schedule`
--

DROP TABLE IF EXISTS `t_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_schedule` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) NOT NULL COMMENT '课程表名',
  `class_time` varchar(50) NOT NULL COMMENT '上课时间',
  `course_id` int(2) unsigned NOT NULL COMMENT '课程ID',
  `teacher_id` int(2) unsigned NOT NULL COMMENT '老师ID',
  `student_id` int(2) unsigned NOT NULL COMMENT '学生ID',
  `classroom_id` int(2) unsigned NOT NULL COMMENT '教室ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用来存储课程表信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_schedule`
--

LOCK TABLES `t_schedule` WRITE;
/*!40000 ALTER TABLE `t_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_school_year`
--

DROP TABLE IF EXISTS `t_school_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_school_year` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) NOT NULL COMMENT '学年名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用来存储学年信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_school_year`
--

LOCK TABLES `t_school_year` WRITE;
/*!40000 ALTER TABLE `t_school_year` DISABLE KEYS */;
INSERT INTO `t_school_year` VALUES (1,'2016'),(2,'2017'),(3,'2018'),(4,'2019');
/*!40000 ALTER TABLE `t_school_year` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_semester`
--

DROP TABLE IF EXISTS `t_semester`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_semester` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `school_year_id` int(2) unsigned NOT NULL,
  `training_type` varchar(50) NOT NULL COMMENT '培训类型',
  `name` varchar(50) NOT NULL COMMENT '学期或阶段名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用来存储学期信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_semester`
--

LOCK TABLES `t_semester` WRITE;
/*!40000 ALTER TABLE `t_semester` DISABLE KEYS */;
INSERT INTO `t_semester` VALUES (1,2,'社会培训','初级'),(2,3,'校园授课','大一'),(3,4,'校园授课','大二'),(4,5,'社会培训','中级'),(6,6,'校园授课','苦逼的大四');
/*!40000 ALTER TABLE `t_semester` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_staff`
--

DROP TABLE IF EXISTS `t_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_staff` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_id` int(2) unsigned NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '教职工名',
  `position_id` int(2) unsigned NOT NULL,
  `department_id` int(2) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用来存储教职工信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_staff`
--

LOCK TABLES `t_staff` WRITE;
/*!40000 ALTER TABLE `t_staff` DISABLE KEYS */;
INSERT INTO `t_staff` VALUES (1,10,'陈宇',1,1),(2,11,'李劲华',1,1),(3,12,'胡超凡',2,1);
/*!40000 ALTER TABLE `t_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_student`
--

DROP TABLE IF EXISTS `t_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_student` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `studentNo` varchar(45) NOT NULL,
  `user_id` int(2) unsigned NOT NULL,
  `group_id` int(2) unsigned NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '学生名',
  `gender` varchar(50) NOT NULL COMMENT '学生性别',
  `birth_date` date NOT NULL COMMENT '生日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用来存储学生信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_student`
--

LOCK TABLES `t_student` WRITE;
/*!40000 ALTER TABLE `t_student` DISABLE KEYS */;
INSERT INTO `t_student` VALUES (9,'201440703634',10,0,'甄鹏','男','2017-12-31'),(10,'201440703679',14,3,'赵静锋','男','2018-01-02');
/*!40000 ALTER TABLE `t_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='用来存储用户信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'test','202cb962ac59075b964b07152d234b70'),(10,'201440703634','960CC4843EB090270B9F8A34B316BE11'),(11,'admin','21232f297a57a5a743894a0e4a801fc3'),(12,'boss','ceb8447cc4ab78d2ec34cd9f11e4bed2'),(13,'teacher','8d788385431273d11e8b43bb78f3aa41'),(14,'201440703679','B5E1388E315AB396E4B7D44085F84DE1');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(2) unsigned NOT NULL,
  `role_id` int(2) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用来存储用户对应角色信息,权限对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,4),(4,10,4),(5,11,1),(6,12,2),(7,13,3),(8,14,4);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-05  0:11:17
