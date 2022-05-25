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

create table categoria
(
id_c int,
nombre_c varchar(50),
primary key(id_c)
);

insert into categoria (id_c,nombre_c)
values('1','Observación de aves');

insert into categoria (id_c,nombre_c)
values('2','Familia con niños');

insert into categoria (id_c,nombre_c)
values('3','Ciclismo');

insert into categoria (id_c,nombre_c)
values('4','Accesibilidad');

insert into categoria (id_c,nombre_c)
values('5','Equitación');

insert into categoria (id_c,nombre_c)
values('6','Montañismo');

select * from categoria;

create table senda
(
	id int,
    nombre varchar(500),
    dificultad varchar(500),
    inicio varchar(500),
    final varchar(500),
    señales varchar(500),
    longitud varchar(500),
    cota_max varchar(500),
    cota_min varchar(500),
    user_id int,
    primary key (id),
    foreign key (user_id) references user(user_id)
);

describe senda;

select * from senda;

select count(*) as id_senda from senda;
-- Hay 71 sendas --

create table pertenecen
(
id_s int,
id_c int,
foreign key(id_s) references senda(id),
foreign key(id_c) references categoria(id_c)
);