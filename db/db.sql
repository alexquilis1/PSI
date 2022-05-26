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
id_c1 int,
nombre_c varchar(50),
primary key(id_c1)
);

insert into categoria (id_c1,nombre_c)
values('1','Observación de aves');

insert into categoria (id_c1,nombre_c)
values('2','Familia con niños');

insert into categoria (id_c1,nombre_c)
values('3','Ciclismo');

insert into categoria (id_c1,nombre_c)
values('4','Accesibilidad');

insert into categoria (id_c1,nombre_c)
values('5','Equitación');

insert into categoria (id_c1,nombre_c)
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
select * from senda where nombre like '%gua%';

select count(*) as id_senda from senda;
-- Hay 71 sendas --
select * from senda where dificultad='Baja';
select count(*) from senda where dificultad='Baja';
select ((select count(*) from senda where dificultad='Baja')/(select count(*) from senda)*100) as "Porcentaje de sendas de dificultad baja";
select * from senda where dificultad='Alta';
select count(*) from senda where dificultad='Alta';
select ((select count(*) from senda where dificultad='Alta')/(select count(*) from senda)*100) as "Porcentaje de sendas de dificultad alta";
select * from senda where dificultad='Media';
select count(*) from senda where dificultad='Media';
select ((select count(*) from senda where dificultad='Media')/(select count(*) from senda)*100) as "Porcentaje de sendas de dificultad media";
select * from senda where dificultad='Baja-Media';
select count(*) from senda where dificultad='Baja-Media';
select ((select count(*) from senda where dificultad='Baja-Media')/(select count(*) from senda)*100) as "Porcentaje de sendas de dificultad baja-media";
select * from senda where dificultad='Media-Alta';
select count(*) from senda where dificultad='Media-Alta';
select ((select count(*) from senda where dificultad='Media-Alta')/(select count(*) from senda)*100) as "Porcentaje de sendas de dificultad media-alta";

create table pertenecen
(
id_s int,
id_c int,
foreign key(id_s) references senda(id),
foreign key(id_c) references categoria(id_c1)
);

insert into pertenecen(id_s,id_c)values('2','1');

insert into pertenecen(id_s,id_c)values('3','1');
insert into pertenecen(id_s,id_c)values('3','2');

insert into pertenecen(id_s,id_c)values('8','1');
insert into pertenecen(id_s,id_c)values('8','2');

insert into pertenecen(id_s,id_c)values('9','1');
insert into pertenecen(id_s,id_c)values('9','2');

insert into pertenecen(id_s,id_c)values('12','1');
insert into pertenecen(id_s,id_c)values('12','2');

insert into pertenecen(id_s,id_c)values('13','1');
insert into pertenecen(id_s,id_c)values('13','6');

insert into pertenecen(id_s,id_c)values('14','1');
insert into pertenecen(id_s,id_c)values('14','6');

insert into pertenecen(id_s,id_c)values('15','1');

insert into pertenecen(id_s,id_c)values('16','1');

insert into pertenecen(id_s,id_c)values('17','1');
insert into pertenecen(id_s,id_c)values('17','2');

insert into pertenecen(id_s,id_c)values('18','1');
insert into pertenecen(id_s,id_c)values('18','2');

insert into pertenecen(id_s,id_c)values('19','1');

insert into pertenecen(id_s,id_c)values('20','1');

insert into pertenecen(id_s,id_c)values('21','1');

insert into pertenecen(id_s,id_c)values('22','1');

insert into pertenecen(id_s,id_c)values('28','1');

insert into pertenecen(id_s,id_c)values('32','1');
insert into pertenecen(id_s,id_c)values('32','2');
insert into pertenecen(id_s,id_c)values('32','5');
insert into pertenecen(id_s,id_c)values('32','6');

insert into pertenecen(id_s,id_c)values('33','1');
insert into pertenecen(id_s,id_c)values('33','2');
insert into pertenecen(id_s,id_c)values('33','5');
insert into pertenecen(id_s,id_c)values('33','6');

insert into pertenecen(id_s,id_c)values('34','1');
insert into pertenecen(id_s,id_c)values('34','6');

insert into pertenecen(id_s,id_c)values('35','1');
insert into pertenecen(id_s,id_c)values('35','2');
insert into pertenecen(id_s,id_c)values('35','4');

insert into pertenecen(id_s,id_c)values('36','1');
insert into pertenecen(id_s,id_c)values('36','2');
insert into pertenecen(id_s,id_c)values('36','6');

insert into pertenecen(id_s,id_c)values('37','1');
insert into pertenecen(id_s,id_c)values('37','2');
insert into pertenecen(id_s,id_c)values('37','6');

insert into pertenecen(id_s,id_c)values('39','1');
insert into pertenecen(id_s,id_c)values('39','2');

insert into pertenecen(id_s,id_c)values('40','1');
insert into pertenecen(id_s,id_c)values('40','2');

insert into pertenecen(id_s,id_c)values('41','1');
insert into pertenecen(id_s,id_c)values('41','2');

insert into pertenecen(id_s,id_c)values('45','1');
insert into pertenecen(id_s,id_c)values('45','2');

insert into pertenecen(id_s,id_c)values('46','1');

insert into pertenecen(id_s,id_c)values('47','1');
insert into pertenecen(id_s,id_c)values('47','2');

insert into pertenecen(id_s,id_c)values('48','1');
insert into pertenecen(id_s,id_c)values('48','2');
insert into pertenecen(id_s,id_c)values('48','4');

insert into pertenecen(id_s,id_c)values('49','1');
insert into pertenecen(id_s,id_c)values('49','2');

insert into pertenecen(id_s,id_c)values('50','1');
insert into pertenecen(id_s,id_c)values('50','2');

insert into pertenecen(id_s,id_c)values('52','1');
insert into pertenecen(id_s,id_c)values('52','2');
insert into pertenecen(id_s,id_c)values('52','6');

insert into pertenecen(id_s,id_c)values('55','1');
insert into pertenecen(id_s,id_c)values('55','2');

insert into pertenecen(id_s,id_c)values('58','1');

insert into pertenecen(id_s,id_c)values('59','1');

insert into pertenecen(id_s,id_c)values('61','1');

insert into pertenecen(id_s,id_c)values('62','1');
insert into pertenecen(id_s,id_c)values('62','2');

insert into pertenecen(id_s,id_c)values('66','1');
insert into pertenecen(id_s,id_c)values('66','2');

insert into pertenecen(id_s,id_c)values('71','1');
insert into pertenecen(id_s,id_c)values('71','2');
insert into pertenecen(id_s,id_c)values('71','4');

insert into pertenecen(id_s,id_c)values('74','1');
insert into pertenecen(id_s,id_c)values('74','6');

insert into pertenecen(id_s,id_c)values('75','1');
insert into pertenecen(id_s,id_c)values('75','6');

insert into pertenecen(id_s,id_c)values('78','1');
insert into pertenecen(id_s,id_c)values('78','6');

insert into pertenecen(id_s,id_c)values('79','1');
insert into pertenecen(id_s,id_c)values('79','6');

insert into pertenecen(id_s,id_c)values('80','1');
insert into pertenecen(id_s,id_c)values('80','6');

insert into pertenecen(id_s,id_c)values('81','1');
insert into pertenecen(id_s,id_c)values('81','6');

insert into pertenecen(id_s,id_c)values('114','1');
insert into pertenecen(id_s,id_c)values('114','2');
insert into pertenecen(id_s,id_c)values('114','3');

insert into pertenecen(id_s,id_c)values('115','1');
insert into pertenecen(id_s,id_c)values('115','2');
insert into pertenecen(id_s,id_c)values('115','3');
insert into pertenecen(id_s,id_c)values('115','5');
insert into pertenecen(id_s,id_c)values('115','6');

insert into pertenecen(id_s,id_c)values('116','1');
insert into pertenecen(id_s,id_c)values('116','2');
insert into pertenecen(id_s,id_c)values('116','3');
insert into pertenecen(id_s,id_c)values('116','5');
insert into pertenecen(id_s,id_c)values('116','6');


insert into pertenecen(id_s,id_c)values('117','1');
insert into pertenecen(id_s,id_c)values('117','2');
insert into pertenecen(id_s,id_c)values('117','3');
insert into pertenecen(id_s,id_c)values('117','5');
insert into pertenecen(id_s,id_c)values('117','6');

insert into pertenecen(id_s,id_c)values('118','1');
insert into pertenecen(id_s,id_c)values('118','2');
insert into pertenecen(id_s,id_c)values('118','3');
insert into pertenecen(id_s,id_c)values('118','5');
insert into pertenecen(id_s,id_c)values('118','6');

insert into pertenecen(id_s,id_c)values('121','1');

insert into pertenecen(id_s,id_c)values('122','1');

insert into pertenecen(id_s,id_c)values('123','1');

insert into pertenecen(id_s,id_c)values('124','1');

insert into pertenecen(id_s,id_c)values('125','1');

insert into pertenecen(id_s,id_c)values('126','1');

insert into pertenecen(id_s,id_c)values('127','1');

insert into pertenecen(id_s,id_c)values('128','1');

insert into pertenecen(id_s,id_c)values('129','1');

insert into pertenecen(id_s,id_c)values('130','1');

insert into pertenecen(id_s,id_c)values('131','1');

insert into pertenecen(id_s,id_c)values('132','1');

insert into pertenecen(id_s,id_c)values('133','1');

insert into pertenecen(id_s,id_c)values('134','1');

insert into pertenecen(id_s,id_c)values('135','1');

insert into pertenecen(id_s,id_c)values('136','1');

insert into pertenecen(id_s,id_c)values('137','1');

insert into pertenecen(id_s,id_c)values('138','1');

insert into pertenecen(id_s,id_c)values('139','1');

insert into pertenecen(id_s,id_c)values('140','1');

select s.id, s.nombre, c.id_c1,nombre_c from senda as s, categoria as c, pertenecen as p where c.id_c1 = p.id_c and s.id = p.id_s;