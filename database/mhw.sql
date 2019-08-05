
create table if not exists `weapon_melody_notes` (`base_name_en` varchar(70) DEFAULT NULL,`notes` varchar(5) NOT NULL,PRIMARY KEY (`notes`));
insert into `weapon_melody_notes` (`base_name_en`,`notes`) values ('Self-improvement','PP'),('Self-improvement','WW'),('Attack Up (S)','WRR'),('Attack Up (S)','PRY'),('Attack Up (S)','YPR'),('Attack Up (S)','RYP'),('Attack Up (L)','PRBP'),('Attack Up (L)','PRGP'),('Attack Up (L)','PRCP'),('Attack Up (L)','POOR'),('Health Boost (S)','RBW'),('Health Boost (L)','RBRP'),('Stamina Use Reduced (S)','WCB'),('Stamina Use Reduced (S)','WYB'),('Stamina Use Reduced (S)','WGB'),('Stamina Use Reduced (L)','PCBC'),('Stamina Use Reduced (L)','PYB'),('Stamina Use Reduced (L)','PGBG'),('Stamina Use Reduced (L)','POBO'),('Wind Pressure Negated','BBR'),('Wind Pressure Negated','BBG'),('Wind Pressure Negated','BBC'),('All Wind Pressure Negated','BBYP'),('All Wind Pressure Negated','BBO'),('Defense Up (S)','WBB'),('Defense Up (L)','PBBP'),('Tool Use Drain Reduced (S)','WBC'),('Tool Use Drain Reduced (L)','PBC'),('Health Rec. (S)','WGW'),('Health Rec. (S)','PGP'),('Health Rec. (L)','GGPC'),('Health Rec. (S) + Antidote','GBWB'),('Health Rec. (M) + Antidote','GBPB'),('Recovery Speed (S)','GGRW'),('Recovery Speed (S)','GGY'),('Recovery Speed (L)','GGRP'),('Earplugs (S)','CCRW'),('Earplugs (S)','CCRP'),('Earplugs (S)','CCGW'),('Earplugs (L)','CCGP'),('Earplugs (L)','OOGP'),('Divine Protection','GYPY'),('Divine Protection','POPC'),('Scoutfly Power Up','CCC'),('Envir. Damage Negated','RRC'),('Stun Negated','CBP'),('Paralysis Negated','CYW'),('Paralysis Negated','CYP'),('Tremors Negated','CCY'),('Muck Res','CRC'),('Fire Res Boost (S)','YRW'),('Fire Res Boost (L)','YRP'),('Water Res Boost (S)','YCW'),('Water Res Boost (L)','YCP'),('Thunder Res Boost (S)','YGW'),('Thunder Res Boost (L)','YGP'),('Ice Res Boost (S)','YBW'),('Ice Res Boost (L)','YBP'),('Dragon Res Boost (S)','WYC'),('Dragon Res Boost (L)','PYC'),('Elemental Attack Boost','PGYG'),('Elemental Attack Boost','YCYC'),('Elemental Attack Boost','POYO'),('Blight Negated','OYYO'),('Sonic Waves','YYY'),('All Melody Effects Extended','ORO'),('Knockbacks Negated','RORP'),('Attack and Defense Up (S)','OBPB'),('Attack and Defense Up (S)','PBOO'),('Blight Res Up','YOP'),('Affinity Up and Health Rec. (S)','GOPO'),('All Ailments Negated','CPOO'),('Earplugs (S) / Wind Pressure Negated','PYOY'),('Abnormal Status Atk. Increased','COOP'),('Health Recovery (M)','GWCG');
create table if not exists `weapon_melody_base` (`id` smallint NOT NULL,`duration` varchar(20) DEFAULT NULL,`extension` varchar(20) DEFAULT NULL,`name_en` varchar(50) DEFAULT NULL,`effect1` varchar(70) DEFAULT NULL,`effect2` varchar(70) DEFAULT NULL,PRIMARY KEY (`id`));
insert into `weapon_melody_base` (`id`,`duration`,`extension`,`name_en`,`effect1`,`effect2`) values (0,'180(240)','+90(+120)','Self-improvement','Movement Speed Up','Attack Up + Deflected Attack Prevention'),(1,'120(150)','+60(+90)','Attack Up (S)','Attack Up (S)','Attack Up (L)'),(2,'90(120)','+30(+60)','Attack Up (L)','Attack Up (L)','Attack Up (XL)'),(3,'180(240)','+120(+180)','Health Boost (S)','Health Boost (S)','Health Boost Extended'),(4,'180(240)','+120(+180)','Health Boost (L)','Health Boost (L)','Health Boost Extended'),(5,'90(120)','+30(+60)','Stamina Use Reduced (S)','Stamina Use Reduced (S)','Stamina Use Reduction Extended'),(6,'120(150)','+60(+90)','Stamina Use Reduced (L)','Stamina Use Reduced (L)','Stamina Use Reduction Extended'),(7,'180(240)','+90(+120)','Wind Pressure Negated','Wind Pressure Negated','Wind Pressure Negation Extended'),(8,'180(240)','+90(+120)','All Wind Pressure Negated','All Wind Pressure Negated','All Wind Pressure Negation Extended'),(9,'120(150)','+60(+90)','Defense Up (S)','Defense Up (S)','Defense Up (L)'),(10,'90(120)','+60(+90)','Defense Up (L)','Defense Up (L)','Defense Up (XL)'),(11,'30(60)','+30(+60)','Tool Use Drain Reduced (S)','Tool Use Drain Reduced (S)','Tool Use Drain Reduction Extended'),(12,'60(90)','+60(+90)','Tool Use Drain Reduced (L)','Tool Use Drain Reduced (L)','Tool Use Drain Reduction Extended'),(13,'N/A','N/A','Health Rec. (S)','Health Rec. (S)','N/A'),(14,'N/A','N/A','Health Rec. (L)','Health Rec. (L)','N/A'),(15,'N/A','N/A','Health Rec. (S) + Antidote','Health Rec. (S) + Antidote','N/A'),(16,'N/A','N/A','Health Rec. (M) + Antidote','Health Rec. (M) + Antidote','N/A'),(18,'120(180)','+120(+150)','Recovery Speed (S)','Recovery Speed (S)','Recovery Speed Extended'),(19,'120(180)','+120(+150)','Recovery Speed (L)','Recovery Speed (L)','Recovery Speed Extended'),(20,'180(210)','+120(+150)','Earplugs (S)','Earplugs (S)','Earplugs (S) Extended'),(21,'180(210)','+120(+150)','Earplugs (L)','Earplugs (L)','Earplugs (L) Extended'),(22,'120(150)','+90(+120)','Divine Protection','Divine Protection','Divine Protection Extended'),(23,'180(240)','+180(+240)','Scoutfly Power Up','Scoutfly Level +1','Scoutfly Level +1 Extended'),(24,'120(180)','+120(+180)','Envir. Damage Negated','Envir. Damage Negated','Envir. Damage Negation Extended'),(25,'180(210)','+120(+180)','Stun Negated','Stun Negated','Stun Negation Extended'),(26,'180(210)','+120(+180)','Paralysis Negated','Paralysis Negated','Paralysis Negation Extended'),(27,'180(210)','+180(+210)','Tremors Negated','Tremors Negated','Tremor Negation Extended'),(28,'180(240)','+180(+240)','Muck Res','Muck Res','Muck Res Extended'),(29,'120(180)','+120(+180)','Fire Res Boost (S)','Fire Res Boost (S)','Fire Res Boost (L)'),(30,'120(180)','+120(+180)','Fire Res Boost (L)','Fire Res Boost (L)','Fire Res Boost (XL)'),(31,'120(180)','+120(+180)','Water Res Boost (S)','Water Res Boost (S)','Water Res Boost (L)'),(32,'120(180)','+120(+180)','Water Res Boost (L)','Water Res Boost (L)','Water Res Boost (XL)'),(33,'120(180)','+120(+180)','Thunder Res Boost (S)','Thunder Res Boost (S)','Thunder Res Boost (L)'),(34,'120(180)','+120(+180)','Thunder Res Boost (L)','Thunder Res Boost (L)','Thunder Res Boost (XL)'),(35,'120(180)','+120(+180)','Ice Res Boost (S)','Ice Res Boost (S)','Ice Res Boost (L)'),(36,'120(180)','+120(+180)','Ice Res Boost (L)','Ice Res Boost (L)','Ice Res Boost (XL)'),(37,'120(180)','+120(+180)','Dragon Res Boost (S)','Dragon Res Boost (S)','Dragon Res Boost (L)'),(38,'120(180)','+120(+180)','Dragon Res Boost (L)','Dragon Res Boost (L)','Dragon Res Boost (XL)'),(39,'120(150)','+90(+120)','Elemental Attack Boost','Elemental Attack Boost (S)','Elemental Attack Boost (L)'),(40,'120(150)','+120(+150)','Blight Negated','Blight Negated','Blight Negation Extended'),(41,'N/A','N/A','Sonic Waves','Sonic Waves','N/A'),(42,'N/A','N/A','All Melody Effects Extended','All Melody Effects Extended','N/A'),(43,'45(60)','+25(+40)','Knockbacks Negated','Knockbacks Negated','Knockback Negation Extended'),(44,'120(150)','+60(+90)','Attack and Defense Up (S)','Attack and Defense Up (S)','Attack Up (L) / Defense Up (L)'),(45,'90(120)','+120(+150)','Blight Res Up','Blight Res Up (S)','Blight Res Up (L)'),(46,'120(150)','+60(+90)','Affinity Up and Health Rec. (S)','Affinity Up (S) / Health Rec. (S)','Affinity Up (L) / Health Rec. (S)'),(47,'120(150)','+60(+90)','All Ailments Negated','All Ailments Negated','Ailment Negation Extended'),(48,'180(210)','+90(+150)','Earplugs (S) / Wind Pressure Negated','Earplugs (S) / Wind Pressure Negated','Earplugs (S) / Wind Pressure Negation Extended'),(49,'90(120)','+60(+90)','Abnormal Status Atk. Increased','Abnormal Status Atk. Up (S)','Abnormal Status Atk. Up (L)'),(50,'N/A','N/A','Health Recovery (M)','Health Recovery (M)','N/A');