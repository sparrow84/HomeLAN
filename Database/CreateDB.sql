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
INSERT INTO places (name, width, length, height) VALUES ('storage', 10000, 10000, 2500);


/**/

INSERT INTO places (name, width, length, height) VALUES ('Department of IT', 10000, 10000, 2500);
INSERT INTO places (name, width, length, height) VALUES ('storage', 10000, 10000, 2500);
INSERT INTO places (name, width, length, height) VALUES ('storage', 10000, 10000, 2500);
INSERT INTO places (name, width, length, height) VALUES ('storage', 10000, 10000, 2500);