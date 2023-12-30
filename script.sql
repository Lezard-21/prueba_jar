#show databases;
create database veterinaria;
CREATE USER yo IDENTIFIED BY '123';
GRANT ALL PRIVILEGES ON veterinaria.* TO 'yo'@'%';
use veterinaria;
#show tables;
create table cliente (
					 id_cliente varchar(255) primary key,
                     nombre varchar(255) not null,
                     contraseña varchar(255) not null
                     );
create table dueño (
					 id_dueño varchar(255) primary key,
                     nombre varchar(255) not null,
                     telefono varchar(255) not null
                     );
create table animal (
					id_animal varchar(255) primary key,
                    especie varchar(255) not null,
                    nombre varchar(255),
                    motivo varchar(255),
                    id_dueño varchar(255),
                    foreign key (id_dueño) references dueño(id_dueño)
                    );
DELIMITER $$
CREATE TRIGGER delete_related_animals 
BEFORE DELETE ON dueño 
FOR EACH ROW 
BEGIN
   DELETE FROM animal WHERE id_dueño = OLD.id_dueño;
END$$
DELIMITER ;

#insert into dueño (id_dueño,nombre,telefono) values ("1234","david","12312312");
#insert into animal (id_animal,especie,nombre,id_dueño) values ("1234ssadas","gato","jjj","1234");
#insert into cliente (id_cliente,nombre,contraseña) values ("12345","david","12345");

#drop trigger delete_related_animals;

#drop table dueño;
#drop table animal;

#describe animal;
#describe cliente;
#describe dueño;

#select * from animal;
#select * from cliente;
#select * from dueño;
#SELECT * from cliente where nombre="david" and contraseña="12345";
#delete from dueño where id_dueño = "1234"; 
