package salmantino.es.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import salmantino.es.controlador.entity.Pedidos;
@Repository
public class PedidoDAOClase implements PedidoDAO{
	
	
	@Override
	@Transactional
	public void insertarPedido(Pedidos pedidos) {
		Session miSession = sessionFactory.getCurrentSession();
		miSession.saveOrUpdate(pedidos);
	}

	@Override
	@Transactional
	public Pedidos getPedido(int id) {
		Session miSession=sessionFactory.getCurrentSession();
		
		Pedidos elpedido=miSession.get(Pedidos.class, id);
		
		return elpedido;
		
	}
	
	@Override
	@Transactional
	public void eliminarPedido(int id) {
		Session miSession=sessionFactory.getCurrentSession();
		
		Query consulta=miSession.createQuery("DELETE FROM Pedidos WHERE idPedido=:idDelPedido");
		consulta.setParameter("idDelPedido", id);
		
		consulta.executeUpdate();
		
	}
	@Autowired
	private SessionFactory sessionFactory;
	

	
}
