package it.prova.gestionesmartphoneapp.service;

import java.util.List;

import it.prova.gestionesmartphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface SmartphoneService {
	public List<Smartphone> listAll() throws Exception;

	public Smartphone caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Smartphone smartphoneInstance) throws Exception;

	public void inserisciNuovo(Smartphone smartphoneInstance) throws Exception;

	public void rimuovi(Long smartphoneId) throws Exception;
	
	// per injection
	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO);
}
