package model.dao.interfaces;

import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

import model.bean.AulaLibera;
import model.bean.GruppoDiStudio;
import model.bean.Orario;

public interface AulaLiberaDAO {



		public boolean doSave(AulaLibera aula); //metodo per inserire l'aula nel database

		public boolean doSaveOrUpdate(AulaLibera aula, String giorno, Orario o);//metodo per modificare un'aula nel database

		public boolean doDelete(AulaLibera aula);//metodo per cancellare un'aula nel database passando oggetto (GruppoDiStudio)

		public boolean doDeleteByKey(String nomeAula, String giorno, int idOrario);//metodo per cancellare un'aula nel database passando il nome(String)

		public boolean doDeleteByOrario(int idOrario);//metodo per cancellare un'aula nel database passando l`orario

		public AulaLibera doRetrieveByKey(String nomeAula, String giorno, int idOrario);//ricerca tramite chiave

		public List<AulaLibera> doRetrieveByName(String nomeAula);//metodo di ricerca aula tramite nome(String)

		public List<AulaLibera> doRetrieveByDate(Timestamp data);//metodo di ricerca  per data

		public List<AulaLibera> doRetrieveAll();//metodo di ricerca per ricavare tutti gli oggetti AulaLibera


}
