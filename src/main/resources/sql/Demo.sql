DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo`
(
    `uid`         int(11) NOT NULL AUTO_INCREMENT,
    `Name`        varchar(255) NOT NULL,
    `Desc`        varchar(255) NOT NULL,
    `Create_Time` datetime(0) NOT NULL,
    `Age`         int(11) NOT NULL,
    PRIMARY KEY (`uid`) USING BTREE
)
