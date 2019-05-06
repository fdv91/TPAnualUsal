package edu.usal.negocio.interfaces;

import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dto.Cliente;

public interface ClienteDAO {
	
	void AgregarCliente (Cliente cliente) throws IOException;
	
	void EliminarCliente (Cliente cliente);
	
	void ModificarCliente (Cliente cliente);
	
	List <Cliente> GetAll () throws IOException;	

}
