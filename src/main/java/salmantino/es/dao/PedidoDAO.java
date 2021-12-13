package salmantino.es.dao;

import salmantino.es.controlador.entity.Pedidos;

public interface PedidoDAO {
	
	public void insertarPedido(Pedidos pedidos);
	
	public Pedidos getPedido(int id);
	
	public void eliminarPedido(int id);

}
