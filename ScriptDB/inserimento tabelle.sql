
insert into credenziali(matricola,email,password,amministratore) values
("0512101769", "email di luigi",123456,1),
("0512103853", "a.crispo6studenti.unisa.it",123456,1),
("0512103593", "a.capodanno5@studenti.unisa.it",123456,1),
("0512103647", "a.panico19@studenti.unisa.it",123456,1),
("0512102855", "f.megliola@studenti.unisa.it",123456,1),
("0512102865", "f.megliola1@studenti.unisa.it",123456,0);


insert into amministratore(matricola, nome,cognome) values
("0512101769", "Luigi","Califano"),
("0512103853", "Alessia","Crispo"),
("0512103593", "Alessandro","Capodanno"),
("0512103647", "Antonio","Panico"),
("0512102855", "Filippo","Megliola");

insert into studente(matricola, nome,cognome) values

("0512102865", "Filippo","Megliola");

insert into aula(nome,edificio) values

("P1", "F3"),
("P2", "F3"),
("P3", "F3"),
("P4", "F3"),
("P5", "F3"),
("P6", "F3"),
("P7", "F3"),
("P8", "F3"),
("P9", "F3"),
("P10", "F3"),
("P11", "F3"),
("P12", "F3"),
("P13", "F3"),
("P14", "F3"),
("P15", "F3"),
("P16", "F3"),
("P17", "F3"),
("P19", "F3"),
("P20", "F3"),
("P21", "F3"),



("S1", "F"),
("S2", "F"),
("S3", "F"),
("S4", "F"),
("S5", "F"),
("S6", "F"),


("F1", "F2"),
("F2", "F2"),
("F3", "F2"),
("F4", "F2"),
("F5", "F2"),
("F6", "F2"),
("F7", "F2"),
("F8", "F2");



insert into gds(nome,creatore,materia,oraInizio,oraFine,giorno,aula) values

("Gruppo di is","f.megliola1@studenti.unisa.it","Ingegneria Del software","2018-12-21, 15:00:00", "2018-12-21, 17:30:00","lunedì" ,"F1")
