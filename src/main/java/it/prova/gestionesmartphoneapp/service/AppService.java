package it.prova.gestionesmartphoneapp.service;

import java.util.List;

import it.prova.gestionesmartphoneapp.dao.app.AppDAO;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface AppService {
	public List<App> listAll() throws Exception;

	public App caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(App appInstance) throws Exception;

	public void inserisciNuovo(App appInstance) throws Exception;

	public void rimuovi(Long appId) throws Exception;
	
	public void aggiornaApp(String nuovaVersione, App o) throws Exception;
	
	public void disinstalla(Smartphone tel, App app) throws Exception;
	
	// per injection
	public void setAppDAO(AppDAO appDAO);

	void aggiungiSmartphone(App appInstance, Smartphone smartphoneInstance) throws Exception;
}
