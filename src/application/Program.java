package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.VacinaDao;
import model.entities.Paciente;
import model.entities.Vacina;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VacinaDao vacinaDao = DaoFactory.createVacinaDao();

		System.out.println("=== TEST 1: vacina findByCpf ====");
		
		Vacina vacina = vacinaDao.findByCpf(123);
		
		System.out.println(vacina);
		
		System.out.println("\n=== TEST 2: vacina findByPaciente ====");
		
		Paciente paciente = new Paciente(123);
		
		List<Vacina> list = vacinaDao.findByPaciente(paciente);
		
		for (Vacina obj : list) {
			System.out.println(obj);
		}

		
	}

}
