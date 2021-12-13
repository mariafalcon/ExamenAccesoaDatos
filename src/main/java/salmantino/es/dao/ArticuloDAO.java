package salmantino.es.dao;

import salmantino.es.controlador.entity.Articulo;

public interface ArticuloDAO {

	public void insertarArticulo(Articulo articulo);
	
	public Articulo getArticulo(int id);
	
	public void eliminarArticulo(int id);
	
}
