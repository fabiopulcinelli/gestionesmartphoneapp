package it.prova.gestionesmartphoneapp.dao.smartphone;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public class SmartphoneDAOImpl implements SmartphoneDAO{
	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Smartphone> list() throws Exception {
		return entityManager.createQuery("from Smartphone", Smartphone.class).getResultList();
	}

	@Override
	public Smartphone get(Long id) throws Exception {
		return entityManager.find(Smartphone.class, id);
	}

	@Override
	public void update(Smartphone o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Smartphone o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(o);
	}

	@Override
	public void delete(Smartphone o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	public void updateOS(String nuovaVersione, Smartphone o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		
		o.setVersioneOS(nuovaVersione);
		o = entityManager.merge(o);
	}
}
