drop database if exists db;
create database db;
use db;

create table user
(
	user_id int auto_increment,
	username varchar(30) not null unique,
    name varchar(50),
	gender varchar(15),
    password varchar(20) not null,
    cpassword varchar(20) not null,
    city varchar(50),
	email varchar(50) not null unique,
    primary key (user_id)
);

describe user;

select * from user;

create table senda
(
	id int,
    nombre varchar(500),
    categoría varchar(50),
    dificultad varchar(500),
    inicio varchar(500),
    final varchar(500),
    señales varchar(500),
    longitud varchar(500),
    cota_max varchar(500),
    cota_min varchar(500),
    primary key (id)
);

describe senda;

select * from senda;

select count(*) as id_senda from senda;
-- Hay 72 sendas --
