drop database studentplaceDB;
create database StudentPlaceDB;
use StudentPlaceDB;


create table utente(
matricola varchar(10),
nome varchar(45) not null,
cognome varchar(45)not null,
email varchar(45) primary key,
password varchar(45) not null,
amministratore smallint not null
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
inizio timestamp not null,
fine timestamp not null
);
create table libera(
aula varchar(10) not null,
giorno varchar(10) not null,
orario int(10) not null,
primary key(aula,giorno,orario),
foreign key (aula) references aula(nome),
foreign key (giorno) references giorno(giorno),
foreign key (orario) references orario(id)
);

