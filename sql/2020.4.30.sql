/*
 Navicat Premium Data Transfer

 Source Server         : 120.26.65.52
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 120.26.65.52:3306
 Source Schema         : city

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 30/04/2020 13:41:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city_camera
-- ----------------------------
DROP TABLE IF EXISTS `city_camera`;
CREATE TABLE `city_camera`  (
  `camera_id` int(11) NOT NULL AUTO_INCREMENT,
  `camera_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `coordinate_id` int(11) NULL DEFAULT NULL,
  `position_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`camera_id`) USING BTREE,
  INDEX `camera_coordinate_id`(`coordinate_id`) USING BTREE,
  CONSTRAINT `camera_coordinate_id` FOREIGN KEY (`coordinate_id`) REFERENCES `city_coordinate` (`coordinate_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_camera
-- ----------------------------
INSERT INTO `city_camera` VALUES (1, '北京', 1, 1);
INSERT INTO `city_camera` VALUES (2, '测试', 1, 1);
INSERT INTO `city_camera` VALUES (3, '测试摄像头名称1', 15, 1);
INSERT INTO `city_camera` VALUES (4, '测试摄像头名称2', 17, 4);

-- ----------------------------
-- Table structure for city_city
-- ----------------------------
DROP TABLE IF EXISTS `city_city`;
CREATE TABLE `city_city`  (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(11) NOT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`city_id`) USING BTREE,
  INDEX `city_province_id`(`province_id`) USING BTREE,
  CONSTRAINT `city_province_id` FOREIGN KEY (`province_id`) REFERENCES `city_province` (`province_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_city
-- ----------------------------
INSERT INTO `city_city` VALUES (1, 1, '上饶');
INSERT INTO `city_city` VALUES (2, 1, '南昌');
INSERT INTO `city_city` VALUES (3, 2, '杭州');
INSERT INTO `city_city` VALUES (4, 2, '宁波');
INSERT INTO `city_city` VALUES (5, 2, '温州');
INSERT INTO `city_city` VALUES (6, 1, '赣州');
INSERT INTO `city_city` VALUES (7, 1, '九江');
INSERT INTO `city_city` VALUES (8, 1, '吉安');
INSERT INTO `city_city` VALUES (9, 1, '抚州');
INSERT INTO `city_city` VALUES (10, 1, '萍乡');
INSERT INTO `city_city` VALUES (11, 1, '景德镇');
INSERT INTO `city_city` VALUES (12, 1, '鹰潭');
INSERT INTO `city_city` VALUES (13, 1, '宜春');
INSERT INTO `city_city` VALUES (14, 1, '新余');
INSERT INTO `city_city` VALUES (15, 2, '绍兴');
INSERT INTO `city_city` VALUES (16, 2, '湖州');
INSERT INTO `city_city` VALUES (17, 2, '嘉兴');
INSERT INTO `city_city` VALUES (18, 2, '金华');
INSERT INTO `city_city` VALUES (19, 2, '衢州');
INSERT INTO `city_city` VALUES (20, 2, '台州');
INSERT INTO `city_city` VALUES (21, 2, '丽水');
INSERT INTO `city_city` VALUES (22, 2, '舟山');
INSERT INTO `city_city` VALUES (23, 3, '北京');
INSERT INTO `city_city` VALUES (24, 4, '天津');
INSERT INTO `city_city` VALUES (25, 5, '上海');
INSERT INTO `city_city` VALUES (26, 6, '重庆');
INSERT INTO `city_city` VALUES (27, 7, '石家庄');
INSERT INTO `city_city` VALUES (28, 7, '唐山');
INSERT INTO `city_city` VALUES (29, 7, '秦皇岛');
INSERT INTO `city_city` VALUES (30, 7, '邯郸');
INSERT INTO `city_city` VALUES (31, 7, '邢台');
INSERT INTO `city_city` VALUES (32, 7, '保定');
INSERT INTO `city_city` VALUES (33, 7, '张家口');
INSERT INTO `city_city` VALUES (34, 7, '承德');
INSERT INTO `city_city` VALUES (35, 7, '沧州');
INSERT INTO `city_city` VALUES (36, 7, '廊坊');
INSERT INTO `city_city` VALUES (37, 7, '衡水');

-- ----------------------------
-- Table structure for city_coordinate
-- ----------------------------
DROP TABLE IF EXISTS `city_coordinate`;
CREATE TABLE `city_coordinate`  (
  `coordinate_id` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`coordinate_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_coordinate
-- ----------------------------
INSERT INTO `city_coordinate` VALUES (1, '116.395645', '39.929986');
INSERT INTO `city_coordinate` VALUES (2, '110.35', '40.00');
INSERT INTO `city_coordinate` VALUES (3, '110', '15');
INSERT INTO `city_coordinate` VALUES (4, '111.25', '32.01');
INSERT INTO `city_coordinate` VALUES (5, '125.112', '45.12');
INSERT INTO `city_coordinate` VALUES (6, '114.12', '24.12');
INSERT INTO `city_coordinate` VALUES (7, '134.148', '45.684');
INSERT INTO `city_coordinate` VALUES (8, '123.456', '15.464');
INSERT INTO `city_coordinate` VALUES (9, '243.125', '12.545');
INSERT INTO `city_coordinate` VALUES (11, '121.125', '45.12');
INSERT INTO `city_coordinate` VALUES (12, '115.45', '12.45');
INSERT INTO `city_coordinate` VALUES (13, '125.112', '15.464');
INSERT INTO `city_coordinate` VALUES (14, '110.35', '12.545');
INSERT INTO `city_coordinate` VALUES (15, '243.125', '24.12');
INSERT INTO `city_coordinate` VALUES (16, '117.95546388', '28.45762255');
INSERT INTO `city_coordinate` VALUES (17, '120.13', '30.27');
INSERT INTO `city_coordinate` VALUES (18, '120.17', '30.28');

-- ----------------------------
-- Table structure for city_district
-- ----------------------------
DROP TABLE IF EXISTS `city_district`;
CREATE TABLE `city_district`  (
  `district_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `district` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`district_id`) USING BTREE,
  INDEX `district_city_id`(`city_id`) USING BTREE,
  CONSTRAINT `district_city_id` FOREIGN KEY (`city_id`) REFERENCES `city_city` (`city_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 277 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_district
-- ----------------------------
INSERT INTO `city_district` VALUES (1, 1, '信州区');
INSERT INTO `city_district` VALUES (2, 2, '南昌县');
INSERT INTO `city_district` VALUES (3, 1, '广丰区');
INSERT INTO `city_district` VALUES (4, 1, '玉山县');
INSERT INTO `city_district` VALUES (5, 3, '上城区');
INSERT INTO `city_district` VALUES (6, 3, '下城区');
INSERT INTO `city_district` VALUES (7, 3, '西湖区');
INSERT INTO `city_district` VALUES (8, 4, '江北区');
INSERT INTO `city_district` VALUES (9, 4, '象山县');
INSERT INTO `city_district` VALUES (10, 4, '北仑区');
INSERT INTO `city_district` VALUES (11, 2, '东湖区');
INSERT INTO `city_district` VALUES (12, 2, '西湖区');
INSERT INTO `city_district` VALUES (13, 2, '新建区');
INSERT INTO `city_district` VALUES (14, 2, '青云谱区');
INSERT INTO `city_district` VALUES (15, 2, '青山湖区');
INSERT INTO `city_district` VALUES (16, 2, '红谷滩区');
INSERT INTO `city_district` VALUES (17, 2, '进贤县');
INSERT INTO `city_district` VALUES (18, 2, '安义县');
INSERT INTO `city_district` VALUES (19, 6, '章贡区');
INSERT INTO `city_district` VALUES (20, 6, '南康区');
INSERT INTO `city_district` VALUES (21, 6, '赣县区');
INSERT INTO `city_district` VALUES (22, 6, '石城县');
INSERT INTO `city_district` VALUES (23, 6, '安远县');
INSERT INTO `city_district` VALUES (24, 6, '宁都县');
INSERT INTO `city_district` VALUES (25, 6, '寻乌县');
INSERT INTO `city_district` VALUES (26, 6, '兴国县');
INSERT INTO `city_district` VALUES (27, 6, '定南县');
INSERT INTO `city_district` VALUES (28, 6, '上犹县');
INSERT INTO `city_district` VALUES (29, 6, '于都县');
INSERT INTO `city_district` VALUES (30, 6, '龙南县');
INSERT INTO `city_district` VALUES (31, 6, '崇义县');
INSERT INTO `city_district` VALUES (32, 6, '信丰县');
INSERT INTO `city_district` VALUES (33, 6, '全南县');
INSERT INTO `city_district` VALUES (34, 6, '大余县');
INSERT INTO `city_district` VALUES (35, 6, '会昌县');
INSERT INTO `city_district` VALUES (36, 6, '瑞金市');
INSERT INTO `city_district` VALUES (37, 1, '广信区');
INSERT INTO `city_district` VALUES (38, 1, '鄱阳县');
INSERT INTO `city_district` VALUES (39, 1, '婺源县');
INSERT INTO `city_district` VALUES (40, 1, '铅山县');
INSERT INTO `city_district` VALUES (41, 1, '余干县');
INSERT INTO `city_district` VALUES (42, 1, '横峰县');
INSERT INTO `city_district` VALUES (43, 1, '弋阳县');
INSERT INTO `city_district` VALUES (44, 1, '万年县');
INSERT INTO `city_district` VALUES (45, 1, '德兴市');
INSERT INTO `city_district` VALUES (46, 7, '浔阳区');
INSERT INTO `city_district` VALUES (47, 7, '濂溪区');
INSERT INTO `city_district` VALUES (48, 7, '柴桑区');
INSERT INTO `city_district` VALUES (49, 7, '武宁县');
INSERT INTO `city_district` VALUES (50, 7, '彭泽县');
INSERT INTO `city_district` VALUES (51, 7, '永修县');
INSERT INTO `city_district` VALUES (52, 7, '修水县');
INSERT INTO `city_district` VALUES (53, 7, '湖口县');
INSERT INTO `city_district` VALUES (54, 7, '德安县');
INSERT INTO `city_district` VALUES (55, 7, '都昌县');
INSERT INTO `city_district` VALUES (56, 7, '瑞昌市');
INSERT INTO `city_district` VALUES (57, 7, '共青城市');
INSERT INTO `city_district` VALUES (58, 7, '庐山市');
INSERT INTO `city_district` VALUES (59, 8, '吉州区');
INSERT INTO `city_district` VALUES (60, 8, '青原区');
INSERT INTO `city_district` VALUES (61, 8, '吉安县');
INSERT INTO `city_district` VALUES (62, 8, '永丰县');
INSERT INTO `city_district` VALUES (63, 8, '永新县');
INSERT INTO `city_district` VALUES (64, 8, '新干县');
INSERT INTO `city_district` VALUES (65, 8, '泰和县');
INSERT INTO `city_district` VALUES (66, 8, '峡江县');
INSERT INTO `city_district` VALUES (67, 8, '遂川县');
INSERT INTO `city_district` VALUES (68, 8, '安福县');
INSERT INTO `city_district` VALUES (69, 8, '吉水县');
INSERT INTO `city_district` VALUES (70, 8, '万安县');
INSERT INTO `city_district` VALUES (71, 8, '井冈山市');
INSERT INTO `city_district` VALUES (72, 9, '临川区');
INSERT INTO `city_district` VALUES (73, 9, '东乡区');
INSERT INTO `city_district` VALUES (74, 9, '南丰县');
INSERT INTO `city_district` VALUES (75, 9, '乐安县');
INSERT INTO `city_district` VALUES (76, 9, '金溪县');
INSERT INTO `city_district` VALUES (77, 9, '南城县');
INSERT INTO `city_district` VALUES (78, 9, '资溪县');
INSERT INTO `city_district` VALUES (79, 9, '宜黄县');
INSERT INTO `city_district` VALUES (80, 9, '广昌县');
INSERT INTO `city_district` VALUES (81, 9, '黎川县');
INSERT INTO `city_district` VALUES (82, 9, '崇仁县');
INSERT INTO `city_district` VALUES (83, 10, '安源区');
INSERT INTO `city_district` VALUES (84, 10, '湘东区');
INSERT INTO `city_district` VALUES (85, 10, '莲花县');
INSERT INTO `city_district` VALUES (86, 10, '上栗县');
INSERT INTO `city_district` VALUES (87, 10, '芦溪县');
INSERT INTO `city_district` VALUES (88, 11, '珠山区');
INSERT INTO `city_district` VALUES (89, 11, '昌江区');
INSERT INTO `city_district` VALUES (90, 11, '浮梁县');
INSERT INTO `city_district` VALUES (91, 11, '乐平市');
INSERT INTO `city_district` VALUES (92, 12, '月湖区');
INSERT INTO `city_district` VALUES (93, 12, '余江区');
INSERT INTO `city_district` VALUES (94, 12, '贵溪市');
INSERT INTO `city_district` VALUES (95, 13, '袁州区');
INSERT INTO `city_district` VALUES (96, 13, '铜鼓县');
INSERT INTO `city_district` VALUES (97, 13, '靖安县');
INSERT INTO `city_district` VALUES (98, 13, '宜丰县');
INSERT INTO `city_district` VALUES (99, 13, '奉新县');
INSERT INTO `city_district` VALUES (100, 13, '万载县');
INSERT INTO `city_district` VALUES (101, 13, '上高县');
INSERT INTO `city_district` VALUES (102, 13, '丰城市');
INSERT INTO `city_district` VALUES (103, 13, '樟树市');
INSERT INTO `city_district` VALUES (104, 13, '高安市');
INSERT INTO `city_district` VALUES (105, 14, '渝水区');
INSERT INTO `city_district` VALUES (106, 14, '分宜县');
INSERT INTO `city_district` VALUES (107, 3, '江干区');
INSERT INTO `city_district` VALUES (108, 3, '拱墅区');
INSERT INTO `city_district` VALUES (109, 3, '滨江区');
INSERT INTO `city_district` VALUES (110, 3, '余杭区');
INSERT INTO `city_district` VALUES (111, 3, '萧山区');
INSERT INTO `city_district` VALUES (112, 3, '富阳区');
INSERT INTO `city_district` VALUES (113, 3, '临安区');
INSERT INTO `city_district` VALUES (114, 3, '建德市');
INSERT INTO `city_district` VALUES (115, 3, '桐庐县');
INSERT INTO `city_district` VALUES (116, 3, '淳安县');
INSERT INTO `city_district` VALUES (117, 4, '海曙区');
INSERT INTO `city_district` VALUES (118, 4, '镇海区');
INSERT INTO `city_district` VALUES (119, 4, '鄞州区');
INSERT INTO `city_district` VALUES (120, 4, '奉化区');
INSERT INTO `city_district` VALUES (121, 4, '余姚市');
INSERT INTO `city_district` VALUES (122, 4, '慈溪市');
INSERT INTO `city_district` VALUES (123, 4, '宁海县');
INSERT INTO `city_district` VALUES (124, 5, '鹿城区');
INSERT INTO `city_district` VALUES (125, 5, '龙湾区');
INSERT INTO `city_district` VALUES (126, 5, '瓯海区');
INSERT INTO `city_district` VALUES (127, 5, '洞头区');
INSERT INTO `city_district` VALUES (128, 5, '瑞安市');
INSERT INTO `city_district` VALUES (129, 5, '乐清市');
INSERT INTO `city_district` VALUES (130, 5, '永嘉县');
INSERT INTO `city_district` VALUES (131, 5, '平阳县');
INSERT INTO `city_district` VALUES (132, 5, '苍南县');
INSERT INTO `city_district` VALUES (133, 5, '文成县');
INSERT INTO `city_district` VALUES (134, 5, '泰顺县');
INSERT INTO `city_district` VALUES (135, 5, '龙港市');
INSERT INTO `city_district` VALUES (136, 15, '越城区');
INSERT INTO `city_district` VALUES (137, 15, '柯桥区');
INSERT INTO `city_district` VALUES (138, 15, '上虞区');
INSERT INTO `city_district` VALUES (139, 15, '诸暨市');
INSERT INTO `city_district` VALUES (140, 15, '嵊州市');
INSERT INTO `city_district` VALUES (141, 15, '新昌县');
INSERT INTO `city_district` VALUES (142, 16, '吴兴区');
INSERT INTO `city_district` VALUES (143, 16, '南浔区');
INSERT INTO `city_district` VALUES (144, 16, '德清县');
INSERT INTO `city_district` VALUES (145, 16, '长兴县');
INSERT INTO `city_district` VALUES (146, 16, '安吉县');
INSERT INTO `city_district` VALUES (147, 17, '南湖区');
INSERT INTO `city_district` VALUES (148, 17, '秀洲区');
INSERT INTO `city_district` VALUES (149, 17, '海宁市');
INSERT INTO `city_district` VALUES (150, 17, '平湖市');
INSERT INTO `city_district` VALUES (151, 17, '桐乡市');
INSERT INTO `city_district` VALUES (152, 17, '嘉善县');
INSERT INTO `city_district` VALUES (153, 17, '海盐县');
INSERT INTO `city_district` VALUES (154, 18, '婺城区');
INSERT INTO `city_district` VALUES (155, 18, '金东区');
INSERT INTO `city_district` VALUES (156, 18, '兰溪市');
INSERT INTO `city_district` VALUES (157, 18, '东阳市');
INSERT INTO `city_district` VALUES (158, 18, '永康市');
INSERT INTO `city_district` VALUES (159, 18, '义乌市');
INSERT INTO `city_district` VALUES (160, 18, '武义县');
INSERT INTO `city_district` VALUES (161, 18, '浦江县');
INSERT INTO `city_district` VALUES (162, 18, '磐安县');
INSERT INTO `city_district` VALUES (163, 19, '柯城区');
INSERT INTO `city_district` VALUES (164, 19, '衢江区');
INSERT INTO `city_district` VALUES (165, 19, '江山市');
INSERT INTO `city_district` VALUES (166, 19, '常山县');
INSERT INTO `city_district` VALUES (167, 19, '开化县');
INSERT INTO `city_district` VALUES (168, 19, '龙游县');
INSERT INTO `city_district` VALUES (169, 20, '椒江区');
INSERT INTO `city_district` VALUES (170, 20, '黄岩区');
INSERT INTO `city_district` VALUES (171, 20, '路桥区');
INSERT INTO `city_district` VALUES (172, 20, '临海市');
INSERT INTO `city_district` VALUES (173, 20, '温岭市');
INSERT INTO `city_district` VALUES (174, 20, '玉环市');
INSERT INTO `city_district` VALUES (175, 20, '三门县');
INSERT INTO `city_district` VALUES (176, 20, '天台县');
INSERT INTO `city_district` VALUES (177, 20, '仙居县');
INSERT INTO `city_district` VALUES (178, 21, '莲都区');
INSERT INTO `city_district` VALUES (179, 21, '龙泉市');
INSERT INTO `city_district` VALUES (180, 21, '青田县');
INSERT INTO `city_district` VALUES (181, 21, '缙云县');
INSERT INTO `city_district` VALUES (182, 21, '遂昌县');
INSERT INTO `city_district` VALUES (183, 21, '松阳县');
INSERT INTO `city_district` VALUES (184, 21, '云和县');
INSERT INTO `city_district` VALUES (185, 21, '庆元县');
INSERT INTO `city_district` VALUES (186, 21, '景宁畲族自治县');
INSERT INTO `city_district` VALUES (187, 22, '定海区');
INSERT INTO `city_district` VALUES (188, 22, '普陀区');
INSERT INTO `city_district` VALUES (189, 22, '岱山县');
INSERT INTO `city_district` VALUES (190, 22, '嵊泗县');
INSERT INTO `city_district` VALUES (191, 23, '东城区');
INSERT INTO `city_district` VALUES (192, 23, '西城区');
INSERT INTO `city_district` VALUES (193, 23, '朝阳区');
INSERT INTO `city_district` VALUES (194, 23, '丰台区');
INSERT INTO `city_district` VALUES (195, 23, '石景山区');
INSERT INTO `city_district` VALUES (196, 23, '海淀区');
INSERT INTO `city_district` VALUES (197, 23, '顺义区');
INSERT INTO `city_district` VALUES (198, 23, '通州区');
INSERT INTO `city_district` VALUES (199, 23, '大兴区');
INSERT INTO `city_district` VALUES (200, 23, '房山区');
INSERT INTO `city_district` VALUES (201, 23, '门头沟区');
INSERT INTO `city_district` VALUES (202, 23, '昌平区');
INSERT INTO `city_district` VALUES (203, 23, '平谷区');
INSERT INTO `city_district` VALUES (204, 23, '密云区');
INSERT INTO `city_district` VALUES (205, 23, '怀柔区');
INSERT INTO `city_district` VALUES (206, 23, '延庆区');
INSERT INTO `city_district` VALUES (207, 24, '和平区');
INSERT INTO `city_district` VALUES (208, 24, '河东区');
INSERT INTO `city_district` VALUES (209, 24, '河西区');
INSERT INTO `city_district` VALUES (210, 24, '南开区');
INSERT INTO `city_district` VALUES (211, 24, '河北区');
INSERT INTO `city_district` VALUES (212, 24, '红桥区');
INSERT INTO `city_district` VALUES (213, 24, '滨海新区');
INSERT INTO `city_district` VALUES (214, 24, '东丽区');
INSERT INTO `city_district` VALUES (215, 24, '西青区');
INSERT INTO `city_district` VALUES (216, 24, '津南区');
INSERT INTO `city_district` VALUES (217, 24, '北辰区');
INSERT INTO `city_district` VALUES (218, 24, '武清区');
INSERT INTO `city_district` VALUES (219, 24, '宝坻区');
INSERT INTO `city_district` VALUES (220, 24, '宁河区');
INSERT INTO `city_district` VALUES (221, 24, '静海区');
INSERT INTO `city_district` VALUES (222, 24, '蓟州区');
INSERT INTO `city_district` VALUES (223, 25, '黄浦区');
INSERT INTO `city_district` VALUES (224, 25, '徐汇区');
INSERT INTO `city_district` VALUES (225, 25, '长宁区');
INSERT INTO `city_district` VALUES (226, 25, '静安区');
INSERT INTO `city_district` VALUES (227, 25, '普陀区');
INSERT INTO `city_district` VALUES (228, 25, '虹口区');
INSERT INTO `city_district` VALUES (229, 25, '杨浦区');
INSERT INTO `city_district` VALUES (230, 25, '闵行区');
INSERT INTO `city_district` VALUES (231, 25, '宝山区');
INSERT INTO `city_district` VALUES (232, 25, '嘉定区');
INSERT INTO `city_district` VALUES (233, 25, '浦东新区');
INSERT INTO `city_district` VALUES (234, 25, '金山区');
INSERT INTO `city_district` VALUES (235, 25, '松江区');
INSERT INTO `city_district` VALUES (236, 25, '青浦区');
INSERT INTO `city_district` VALUES (237, 25, '奉贤区');
INSERT INTO `city_district` VALUES (238, 25, '崇明区');
INSERT INTO `city_district` VALUES (239, 26, '渝中区');
INSERT INTO `city_district` VALUES (240, 26, '万州区');
INSERT INTO `city_district` VALUES (241, 26, '涪陵区');
INSERT INTO `city_district` VALUES (242, 26, '大渡口区');
INSERT INTO `city_district` VALUES (243, 26, '江北区');
INSERT INTO `city_district` VALUES (244, 26, '沙坪坝区');
INSERT INTO `city_district` VALUES (245, 26, '九龙坡区');
INSERT INTO `city_district` VALUES (246, 26, '南岸区');
INSERT INTO `city_district` VALUES (247, 26, '北碚区');
INSERT INTO `city_district` VALUES (248, 26, '綦江区');
INSERT INTO `city_district` VALUES (249, 26, '大足区');
INSERT INTO `city_district` VALUES (250, 26, '渝北区');
INSERT INTO `city_district` VALUES (251, 26, '巴南区');
INSERT INTO `city_district` VALUES (252, 26, '黔江区');
INSERT INTO `city_district` VALUES (253, 26, '长寿区');
INSERT INTO `city_district` VALUES (254, 26, '江津区');
INSERT INTO `city_district` VALUES (255, 26, '合川区');
INSERT INTO `city_district` VALUES (256, 26, '永川区');
INSERT INTO `city_district` VALUES (257, 26, '南川区');
INSERT INTO `city_district` VALUES (258, 26, '璧山区');
INSERT INTO `city_district` VALUES (259, 26, '铜梁区');
INSERT INTO `city_district` VALUES (260, 26, '潼南区');
INSERT INTO `city_district` VALUES (261, 26, '荣昌区');
INSERT INTO `city_district` VALUES (262, 26, '开州区');
INSERT INTO `city_district` VALUES (263, 26, '梁平区');
INSERT INTO `city_district` VALUES (264, 26, '武隆区');
INSERT INTO `city_district` VALUES (265, 26, '城口县');
INSERT INTO `city_district` VALUES (266, 26, '丰都县');
INSERT INTO `city_district` VALUES (267, 26, '垫江县');
INSERT INTO `city_district` VALUES (268, 26, '忠县');
INSERT INTO `city_district` VALUES (269, 26, '云阳县');
INSERT INTO `city_district` VALUES (270, 26, '奉节县');
INSERT INTO `city_district` VALUES (271, 26, '巫山县');
INSERT INTO `city_district` VALUES (272, 26, '巫溪县');
INSERT INTO `city_district` VALUES (273, 26, '石柱土家族自治县');
INSERT INTO `city_district` VALUES (274, 26, '秀山土家族苗族自治县');
INSERT INTO `city_district` VALUES (275, 26, '酉阳土家族苗族自治县');
INSERT INTO `city_district` VALUES (276, 26, '彭水苗族土家族自治县');

-- ----------------------------
-- Table structure for city_image
-- ----------------------------
DROP TABLE IF EXISTS `city_image`;
CREATE TABLE `city_image`  (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position_id` int(11) NULL DEFAULT NULL,
  `result_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `coordinate_id` int(11) NULL DEFAULT NULL,
  `image_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`image_id`) USING BTREE,
  INDEX `image_position_id`(`position_id`) USING BTREE,
  INDEX `image_result_id`(`result_id`) USING BTREE,
  INDEX `image_user_id`(`user_id`) USING BTREE,
  INDEX `image_coordinate_id`(`coordinate_id`) USING BTREE,
  CONSTRAINT `image_coordinate_id` FOREIGN KEY (`coordinate_id`) REFERENCES `city_coordinate` (`coordinate_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `image_position_id` FOREIGN KEY (`position_id`) REFERENCES `city_position` (`position_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `image_result_id` FOREIGN KEY (`result_id`) REFERENCES `city_result` (`result_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `image_user_id` FOREIGN KEY (`user_id`) REFERENCES `city_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_image
-- ----------------------------
INSERT INTO `city_image` VALUES (4, '测试王五1', 'http://120.26.65.52:80/group1/M00/00/00/rBAc3l6ei-6AZUZuAAAL9PJVLeE894.jpg', '1', '测试王五1', '用户', 1, 1, 7, 3, '2020-04-21 14:00:15');
INSERT INTO `city_image` VALUES (5, '测试王五2', 'http://120.26.65.52:80/group1/M00/00/00/rBAc3l6ekdKAStVPAAAM9FtpgnE479.jpg', '1', '测试王五2', '用户', 1, 1, 7, 4, '2020-04-21 14:25:22');
INSERT INTO `city_image` VALUES (12, '测试张三1', 'http://120.26.65.52:80/group1/M00/00/00/rBAc3l6fzwGAd9foAAAN67Ix7W4849.jpg', '1', '测试张三1', '用户', 1, 1, 6, 12, '2020-04-22 12:58:41');
INSERT INTO `city_image` VALUES (13, '测试王五3', 'http://120.26.65.52:80/group1/M00/00/00/rBAc3l6j3bCAHP81AAAMTzSBZoc860.jpg', '1', '测试王五3', '用户', 1, 1, 7, 16, '2020-04-25 14:50:43');
INSERT INTO `city_image` VALUES (14, '王五测试4', 'http://120.26.65.52:80/group1/M00/00/00/rBAc3l6j3rCACmF0AAANIJ_E2Vs730.jpg', '1', '王五测试4', '用户', 4, 1, 7, 17, '2020-04-25 14:54:44');
INSERT INTO `city_image` VALUES (15, '识别测试1', 'http://120.26.65.52:80/group1/M00/00/00/rBAc3l6qPpiAcOxgAAAQ0mPCJlg586.jpg', '2', '识别测试描述1', '用户', 5, 2, 7, 18, '2020-04-30 10:57:31');

-- ----------------------------
-- Table structure for city_manager
-- ----------------------------
DROP TABLE IF EXISTS `city_manager`;
CREATE TABLE `city_manager`  (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`manager_id`) USING BTREE,
  UNIQUE INDEX `manager_name`(`manager_name`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_manager
-- ----------------------------
INSERT INTO `city_manager` VALUES (1, '张三', 'e10adc3949ba59abbe56e057f20f883e', 'http://120.26.65.52:80/group1/M00/00/00/rBAc3l6RhCKANmBPAAIvYDWV9Lg468.jpg', '1746661428@qq.com', '2020-04-11 16:47:31');

-- ----------------------------
-- Table structure for city_message
-- ----------------------------
DROP TABLE IF EXISTS `city_message`;
CREATE TABLE `city_message`  (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `message_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `coordinate_id` int(11) NULL DEFAULT NULL,
  `position_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_message
-- ----------------------------
INSERT INTO `city_message` VALUES (7, '测试名字1', '测试描述1', 13, 1, '2020-04-24 13:20:32', '无积水', '管理员');
INSERT INTO `city_message` VALUES (8, '测试名称2', '测试描述2', 14, 1, '2020-04-24 13:28:53', '无积水', '管理员');
INSERT INTO `city_message` VALUES (10, '测试消息名称1', '测试消息描述1', 17, 4, '2020-04-25 15:13:38', '无积水', '管理员');

-- ----------------------------
-- Table structure for city_position
-- ----------------------------
DROP TABLE IF EXISTS `city_position`;
CREATE TABLE `city_position`  (
  `position_id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `district_id` int(11) NOT NULL,
  PRIMARY KEY (`position_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_position
-- ----------------------------
INSERT INTO `city_position` VALUES (1, 1, 1, 1);
INSERT INTO `city_position` VALUES (3, 1, 2, 2);
INSERT INTO `city_position` VALUES (4, 2, 3, 7);
INSERT INTO `city_position` VALUES (5, 2, 3, 6);

-- ----------------------------
-- Table structure for city_province
-- ----------------------------
DROP TABLE IF EXISTS `city_province`;
CREATE TABLE `city_province`  (
  `province_id` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`province_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_province
-- ----------------------------
INSERT INTO `city_province` VALUES (1, '江西省');
INSERT INTO `city_province` VALUES (2, '浙江省');
INSERT INTO `city_province` VALUES (3, '北京市');
INSERT INTO `city_province` VALUES (4, '天津市');
INSERT INTO `city_province` VALUES (5, '上海市');
INSERT INTO `city_province` VALUES (6, '重庆市');
INSERT INTO `city_province` VALUES (7, '河北省');
INSERT INTO `city_province` VALUES (8, '山西省');
INSERT INTO `city_province` VALUES (9, '辽宁省');
INSERT INTO `city_province` VALUES (10, '吉林省');
INSERT INTO `city_province` VALUES (11, '黑龙江省');
INSERT INTO `city_province` VALUES (12, '江苏省');
INSERT INTO `city_province` VALUES (13, '安徽省');
INSERT INTO `city_province` VALUES (14, '福建省');
INSERT INTO `city_province` VALUES (15, '山东省');
INSERT INTO `city_province` VALUES (16, '河南省');
INSERT INTO `city_province` VALUES (17, '湖北省');
INSERT INTO `city_province` VALUES (18, '湖南省');
INSERT INTO `city_province` VALUES (19, '广东省');
INSERT INTO `city_province` VALUES (20, '海南省');
INSERT INTO `city_province` VALUES (21, '四川省');
INSERT INTO `city_province` VALUES (22, '贵州省');
INSERT INTO `city_province` VALUES (23, '云南省');
INSERT INTO `city_province` VALUES (24, '陕西省');
INSERT INTO `city_province` VALUES (25, '甘肃省');
INSERT INTO `city_province` VALUES (26, '青海省');
INSERT INTO `city_province` VALUES (27, '台湾省');
INSERT INTO `city_province` VALUES (28, '内蒙古自治区');
INSERT INTO `city_province` VALUES (29, '广西壮族自治区');
INSERT INTO `city_province` VALUES (30, '西藏自治区');
INSERT INTO `city_province` VALUES (31, '宁夏回族自治区');
INSERT INTO `city_province` VALUES (32, '新疆维吾尔自治区');
INSERT INTO `city_province` VALUES (33, '香港特别行政区');
INSERT INTO `city_province` VALUES (34, '澳门特别行政区');

-- ----------------------------
-- Table structure for city_result
-- ----------------------------
DROP TABLE IF EXISTS `city_result`;
CREATE TABLE `city_result`  (
  `result_id` int(11) NOT NULL AUTO_INCREMENT,
  `result_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`result_id`) USING BTREE,
  UNIQUE INDEX `result_name`(`result_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_result
-- ----------------------------
INSERT INTO `city_result` VALUES (2, '内涝');
INSERT INTO `city_result` VALUES (4, '冰雪');
INSERT INTO `city_result` VALUES (1, '无积水');
INSERT INTO `city_result` VALUES (3, '积水');

-- ----------------------------
-- Table structure for city_user
-- ----------------------------
DROP TABLE IF EXISTS `city_user`;
CREATE TABLE `city_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id(数据库自增)|int',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名(不可重复，用于登录)|varchar(255)',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码|varchar(255)',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像(存url)|varchar(255)',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱(不可重复)|varchar(255)',
  `flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '激活状态(1or2)|char',
  `create_time` datetime(0) NOT NULL COMMENT '注册时间|datetime',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`user_name`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_user
-- ----------------------------
INSERT INTO `city_user` VALUES (6, '张三', 'e10adc3949ba59abbe56e057f20f883e', 'http://120.26.65.52:80/group1/M00/00/00/rBAc3l6RZLmALwgcAAIvYDWV9Lg854.jpg', '344962079@qq', '1', '2020-04-11 14:33:29');
INSERT INTO `city_user` VALUES (7, '王五', 'e10adc3949ba59abbe56e057f20f883e', 'http://120.26.65.52:80/group1/M00/00/00/rBAc3l6dLy6AfTEHAAamktmMelo212.jpg', '1234567@qq', '1', '2020-04-20 13:12:15');
INSERT INTO `city_user` VALUES (8, '王二麻子', 'e10adc3949ba59abbe56e057f20f883e', 'http://120.26.65.52:80/group1/M00/00/00/rBAc3l6f9cOAPvIPAAAPSiZ-HKE550.jpg', '12345678@qq', '1', '2020-04-22 15:44:03');
INSERT INTO `city_user` VALUES (9, '李四', 'e10adc3949ba59abbe56e057f20f883e', 'http://120.26.65.52:80/group1/M00/00/00/rBAc3l6mlJyAZwiiAAamktmMelo463.jpg', '51411651@qq', '1', '2020-04-27 16:15:24');

SET FOREIGN_KEY_CHECKS = 1;
