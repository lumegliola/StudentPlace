drop database studentplaceDB;
create database StudentPlaceDB;
use StudentPlaceDB;

create table credenziali(
email varchar(45) primary key,
matricola varchar(10) unique not null,
password varchar(45) not null,
amministratore smallint not null
);

create table amministratore(
matricola varchar(10) primary key,
nome varchar(45) not null,
cognome varchar(45)not null,
foreign key (matricola) references credenziali(matricola)
);
create table studente(
matricola varchar(10) primary key,
nome varchar(45) not null,
cognome varchar(45)not null,
foreign key (matricola) references credenziali(matricola)
);

create table gds(
id int primary key auto_increment,
nome varchar(45) not null,
creatore varchar(45) not null,
materia varchar(45) not null,
oraInizio timestamp not null,
oraFine timestamp not null,
giorno varchar(10) not  null,
aula varchar(45) not  null
);
create table iscrizione(
studente varchar(10),
gruppo int (10),
primary key(studente,gruppo),
foreign key (studente) references studente(matricola),
foreign key (gruppo) references gds(id) 
);
create table aula(
nome varchar(10) primary key,
edificio varchar(2)
);
create table giorno(
giorno varchar(10) primary key
);
create table orario(
id int (10) primary key auto_increment,
inzio timestamp not null,
fine timestamp not null
);