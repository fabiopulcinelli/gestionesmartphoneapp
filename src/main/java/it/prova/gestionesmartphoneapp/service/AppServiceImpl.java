package it.prova.gestionesmartphoneapp.service;

import java.util.List;

import it.prova.gestionesmartphoneapp.dao.app.AppDAO;
import it.prova.gestionesmartphoneapp.model.App;

public class AppServiceImpl implements AppService{
	private AppDAO appDAO;

	@Override
	public void setAppDAO(AppDAO appDAO) {
		this.appDAO = appDAO;
	}

	@Override
	public List<App> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public App caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(App appInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(App appInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuovi(Long appId) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
