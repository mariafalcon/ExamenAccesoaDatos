package salmantino.es.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import salmantino.es.controlador.entity.vPedidos;
import salmantino.es.controlador.entity.Pedidos;

@Repository
public class vPedidoDAOclase implements vPedidoDAO {

	@Override
	@Transactional
	public List<vPedidos> getPedidos() {
		
		Session miSession = sessionFactory.getCurrentSession();
		Query<vPedidos> miQuery=miSession.createQuery("from vPedidos order by fecha desc", vPedidos.class);
		List<vPedidos>  pedidos = miQuery.getResultList();
		
	return pedidos;
	}
	
	@Autowired
	private SessionFactory sessionFactory;


}
