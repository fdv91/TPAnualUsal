package edu.usal.dao.factory;

import edu.usal.negocio.interfaces.ClienteDAO;
import usal.edu.negocio.dto.implementaciones.ClienteDAOImplArchivo;
import usal.edu.negocio.dto.implementaciones.ClienteDAOImplSerializacion;

public class ClienteFactory {
	
	public static ClienteDAO GetImplementation (String source) {
		if (source.equals("Archivo")) {
			return new ClienteDAOImplArchivo();
		}
		else if (source.equals("Serializacion")) {
			return new ClienteDAOImplSerializacion();
		}
		return null;
	}
}
