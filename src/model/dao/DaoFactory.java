package model.dao;

import db.DB;
import model.dao.impl.VacinaDaoJDBC;

public class DaoFactory {
	
	public static VacinaDaoJDBC createVacinaDao() {
		return new VacinaDaoJDBC(DB.getConnection());
	}

}
