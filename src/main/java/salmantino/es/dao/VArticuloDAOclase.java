package salmantino.es.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import salmantino.es.controlador.entity.VArticulo;


@Repository
public class VArticuloDAOclase implements VArticuloDAO{

	@Override
	@Transactional
	public List<VArticulo> getArticulos() {

		Session miSession = sessionFactory.getCurrentSession();
		Query<VArticulo> miQuery=miSession.createQuery("from VArticulo", VArticulo.class);
		List<VArticulo>  articulos = miQuery.getResultList();
		return articulos;
	}

	@Autowired
	private SessionFactory sessionFactory;
	
}
