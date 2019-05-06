package edu.usal.main;

import java.io.Serializable;
import java.util.List;

import edu.usal.dao.factory.ClienteFactory;
import edu.usal.negocio.dto.Cliente;
import edu.usal.negocio.interfaces.ClienteDAO;

public class Principal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente();
		cliente1.setApellido("Villanueva");
		cliente1.setNombre("Francisco");
		
		ClienteDAO impDAO = ClienteFactory.GetImplementation("Serializacion");
		try {
			impDAO.AgregarCliente(cliente1);
			cliente1.setApellido("Gimenez");
			cliente1.setNombre("Fernando");
			impDAO.AgregarCliente(cliente1);
			
			List <Cliente> listado = impDAO.GetAll();
			for (Cliente clien : listado) {
				System.out.println(clien.getApellido()+ "" + clien.getNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
