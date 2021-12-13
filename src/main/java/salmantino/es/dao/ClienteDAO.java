/**
 * 
 */
package salmantino.es.dao;

import java.util.List;

import salmantino.es.controlador.entity.Cliente;

/**
 * @author Alumno
 *
 */
public interface ClienteDAO {

	public List<Cliente> getClientes();
	
	public void insertarCliente(Cliente elCliente);
	
	public Cliente getCliente(int id);
	
	public void eliminarCliente(int id);
	
}
