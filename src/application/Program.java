package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.VacinaDao;
import model.entities.Paciente;
import model.entities.Vacina;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paciente obj = new Paciente(1, "Books");

		
		Vacina vacina = new Vacina(21, "João", 1, "COVID", 2, new Date(), "OIE");
		
		VacinaDao vacinaDao = DaoFactory.createVacinaDao();
		
		System.out.println(vacina);
	}

}
