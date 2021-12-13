package salmantino.es.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import salmantino.es.controlador.entity.Articulo;

@Repository
public class ArticuloDAOclase implements ArticuloDAO{

	@Override
	@Transactional
	public void insertarArticulo(Articulo articulo) {
		Session miSession = sessionFactory.getCurrentSession();
		miSession.saveOrUpdate(articulo);
		
	}

	@Override
	@Transactional
	public Articulo getArticulo(int id) {
		
		Session miSession=sessionFactory.getCurrentSession();
		
		Articulo elarticulo=miSession.get(Articulo.class, id);
		
		return elarticulo;
		
	}

	@Override
	@Transactional
	public void eliminarArticulo(int id) {
		
		Session miSession=sessionFactory.getCurrentSession();
		
		Query consulta=miSession.createQuery("DELETE FROM Articulo WHERE idArticulo=:idDelArticulo");
		consulta.setParameter("idDelArticulo", id);
		
		consulta.executeUpdate();
	}
	
	@Autowired
	private SessionFactory sessionFactory;

}
