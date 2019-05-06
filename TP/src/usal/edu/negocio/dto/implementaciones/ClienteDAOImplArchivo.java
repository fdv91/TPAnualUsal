package usal.edu.negocio.dto.implementaciones;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dto.Cliente;
import edu.usal.negocio.interfaces.ClienteDAO;

public class ClienteDAOImplArchivo implements ClienteDAO {
	
	public void AgregarCliente (Cliente cliente) throws IOException{
		archivo = new File ("cliente.txt");
		archivoWriter = new FileWriter(archivo);
		archivoBufferWriter = new BufferedWriter (archivoWriter);
		
		String str = SaveCliente(cliente);
		
		archivoBufferWriter.write (str);
		archivoBufferWriter.close();
		archivoWriter.close();
	}
	
	public void EliminarCliente(Cliente cliente) {
		
	}
	
	public List<Cliente> GetAll() throws IOException {
		
		archivo = new File ("cliente.txt");
		archivoReader = new FileReader (archivo);
		archivoBufferReader = new BufferedReader (archivoReader);
		String linea;
		List <Cliente> listadoCliente = new ArrayList<Cliente>();
		
		while ((linea = archivoBufferReader.readLine())!= null) {
			
			listadoCliente.add(ParseCliente(linea));
			
		}
		
		return null;
			
	}
	
	private Cliente ParseCliente (String linea) {
		String[] atributos = linea.split(";");
		Cliente cliente = new Cliente();
		cliente.setApellido(atributos[0]);
		cliente.setNombre(atributos[1]);
		return cliente;
		
	}
	
	public void ModificarCliente (Cliente cliente) {
		
	}
	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;
	
	private String SaveCliente (Cliente cliente) {
		return cliente.getApellido()+";" + cliente.getNombre() +"\n";
		
	}
}
