package it.prova.gestionesmartphoneapp.dao.app;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public class AppDAOImpl implements AppDAO{
	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<App> list() throws Exception {
		return entityManager.createQuery("from App", App.class).getResultList();
	}

	@Override
	public App get(Long id) throws Exception {
		return entityManager.find(App.class, id);
	}

	@Override
	public void update(App o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(App o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(o);
	}

	@Override
	public void delete(App o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public void updateApp(String nuovaVersione, App o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		
		o.setVersione(nuovaVersione);
		o.setDataUltimoAggiornamento(new Date());
		o = entityManager.merge(o);
	}
	
	@Override
	public void uinstall(Smartphone tel, App app) throws Exception {
		if (tel == null || app == null) {
			throw new Exception("Problema valore in input");
		}
		
		Set<App> appsSenzaDisinstallata = tel.getApps();
		appsSenzaDisinstallata.remove(app);
		tel.setApps(null);
	
		entityManager.createNativeQuery("DELETE FROM app_smartphone WHERE app_id=? AND smartphone_id=?;")
		.setParameter(1, app.getId())
		.setParameter(2, tel.getId()).executeUpdate();
	}
}
