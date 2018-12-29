package dao;

import dao.interfaces.*;
import dao.implementation.*;

public sTATIC class DAOFactory {
		
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
	
		public static CredenzialiDAO getCredenzialiDAO() {
			return new CredenzialiDAOimpl();
		}
	
		public static OrarioDAO getOrarioDAO() {
			return new OrarioDAOimpl();
		}

}
