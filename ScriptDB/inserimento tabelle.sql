
insert into credenziali(matricola,email,password,amministratore) values
("0512101769", "l.califano22@studenti.unisa.it",123456,1),
("0512103853", "a.crispo6studenti.unisa.it",123456,1),
("0512103593", "a.capodanno5@studenti.unisa.it",123456,1),
("0512103647", "a.panico19@studenti.unisa.it",123456,1),
("0512102855", "f.megliola@studenti.unisa.it",123456,1),
("0512102865", "f.megliola1@studenti.unisa.it",123456,0),
("0512102565", "a.lino@studenti.unisa.it",123456,0),
("0512102765", "c.iao@studenti.unisa.it",123456,0),
("0512102665", "b.ello@studenti.unisa.it",123456,0);


insert into amministratore(matricola, nome,cognome) values
("0512101769", "Luigi","Califano"),
("0512103853", "Alessia","Crispo"),
("0512103593", "Alessandro","Capodanno"),
("0512103647", "Antonio","Panico"),
("0512102855", "Filippo","Megliola");

insert into studente(matricola, nome,cognome) values

("0512102865", "Filippo","Megliola"),
("0512102565", "Antonio","Lino"),
("0512102765", "Carmine","Iao"),
("0512102665", "Bautista","Ello"),
("0512101769", "Luigi","Califano"),
("0512103853", "Alessia","Crispo"),
("0512103593", "Alessandro","Capodanno"),
("0512103647", "Antonio","Panico"),
("0512102855", "Filippo","Megliola");


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

insert into giorno (giorno)value
("Lunedì"),
("Martedì"),
("Mercoledì"),
("Gioveì"),
("Venerdì"),
("Sabato"),
("Domenica");





insert into libera (aula,giorno,orario)value
("P1",,"lunedi","non so che mettere come orario");






insert into gds(nome,creatore,materia,oraInizio,oraFine,giorno,aula) values
("Gruppo di is","0512102865","Ingegneria Del software","2018-12-21, 15:00:00", "2018-12-21, 17:30:00","lunedì" ,"F1"),

("Gruppo di pd","0512103647","Programmazione Distribuita","2018-12-21, 15:00:00", "2018-12-21, 17:30:00","lunedì" ,"F8"),

("Gruppo di ium","0512103593","Interazione Uomo Macchina","2018-12-21, 15:00:00", "2018-12-21, 17:30:00","lunedì" ,"P1"),

("Gruppo di so","0512103593","Sistemi Operativi","2018-12-21, 15:00:00", "2018-12-21, 17:30:00","lunedì" ,"P12"),

("Gruppo di analisi","0512102865","Analisi Matematica","2018-12-21, 15:00:00", "2018-12-21, 17:30:00","lunedì" ,"F2"),
("Gruppo di psd","0512102865","Programmazione e strutture di dati","2018-12-21, 15:00:00", "2018-12-21, 17:30:00","lunedì" ,"P4");