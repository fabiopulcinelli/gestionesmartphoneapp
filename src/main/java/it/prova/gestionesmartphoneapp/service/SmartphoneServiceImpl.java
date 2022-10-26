package it.prova.gestionesmartphoneapp.service;

import java.util.List;

import it.prova.gestionesmartphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public class SmartphoneServiceImpl implements SmartphoneService{
	private SmartphoneDAO smartphoneDAO;

	@Override
	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO) {
		this.smartphoneDAO = smartphoneDAO;
	}
	
	@Override
	public List<Smartphone> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Smartphone caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Smartphone smartphoneInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(Smartphone smartphoneInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuovi(Long smartphoneId) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
