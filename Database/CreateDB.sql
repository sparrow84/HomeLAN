-- CREATE DATABASE home_lan_base;

/** /
USE home_lan_base;

CREATE TABLE Devices (
	id int auto_increment primary key not null,
	name varchar(200),
    placeId int default 000
);

CREATE TABLE Places (
	id int auto_increment primary key not null,
	name varchar(200),
    width int,
	length int,
	height int
);
/**/

/** /
-- Эту таблицу НЕ создал
-- Можно вынести соответсвие комноты и устройства в отдельную таблицу
CREATE TABLE DevInPlace (
	id int auto_increment primary key not null,
	deviceId int not null,
    placeId int not null
);
/**/

/** /
-- Наполняем таблицу Places
INSERT INTO places (name, width, length, height) VALUES ('Storage', 10000, 10000, 2500);
INSERT INTO places (name, width, length, height) VALUES ('Department of IT', 5000, 3000, 2500);
INSERT INTO places (name, width, length, height) VALUES ('Classroom', 10000, 15000, 2500);
INSERT INTO places (name, width, length, height) VALUES ('director office', 4000, 3000, 2500);
INSERT INTO places (name, width, length, height) VALUES ('Computer room', 5000, 10000, 2500);
/**/

/** /
-- Наполняем таблицу Devices
INSERT INTO Devices (name, placeId) VALUES ('Director-pc', 4);
INSERT INTO Devices (name, placeId) VALUES ('VladimirIT-pc', 2);
INSERT INTO Devices (name, placeId) VALUES ('DmitriyIT-pc', 2);
INSERT INTO Devices (name, placeId) VALUES ('Teacher-pc', 3);
INSERT INTO Devices (name, placeId) VALUES ('Projector', 3);
INSERT INTO Devices (name, placeId) VALUES ('Printer hp laserjet m1132 mfp', 4);
INSERT INTO Devices (name, placeId) VALUES ('Printer hp laserjet m1132 mfp', 5);
INSERT INTO Devices (name, placeId) VALUES ('Computer-room01', 5);
INSERT INTO Devices (name, placeId) VALUES ('Computer-room02', 5);
INSERT INTO Devices (name, placeId) VALUES ('Computer-room03', 5);
INSERT INTO Devices (name, placeId) VALUES ('Pentium133', 1);
INSERT INTO Devices (name, placeId) VALUES ('AMD-Athlon-II', 1);
/**/

