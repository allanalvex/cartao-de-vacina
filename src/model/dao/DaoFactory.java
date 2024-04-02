package model.dao;

import model.dao.impl.VacinaDaoJDBC;

public class DaoFactory {
	
	public static VacinaDaoJDBC createVacinaDao() {
		return new VacinaDaoJDBC();
	}

}
