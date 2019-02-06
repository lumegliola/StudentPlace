package model.dao;

import model.dao.implementation.*;
import model.dao.interfaces.*;

public class DAOFactory {
		
	private DAOFactory() {}
	
		public static AulaDAO getAulaDAO() {
			return new AulaDAOimpl();
		}
		
		public static GdSDAO getGdSDAO() {
			return new GdSDAOimpl();
        }

		public static UserDAO getUserDAO() {
			return new UserDAOimpl();
		}
	
		public static OrarioDAO getOrarioDAO() {
			return new OrarioDAOimpl();
		}
		
		public static AulaLiberaDAO getAulaLiberaDAO() {
			return new AulaLiberaDAOimpl();
		}
		
		public static IscrizioneDAO getIscrizioneDAO() {
			return new IscrizioneDAOImpl();
		}

}
