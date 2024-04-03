package application;

import model.dao.DaoFactory;
import model.dao.VacinaDao;
import model.entities.Vacina;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VacinaDao vacinaDao = DaoFactory.createVacinaDao();

		System.out.println("=== TEST 1: vacina findByCpf ====");
		
		Vacina vacina = vacinaDao.findByCpf(3);
		
		System.out.println(vacina);
	}

}
