package it.prova.gestionesmartphoneapp.dao.app;

import it.prova.gestionesmartphoneapp.dao.IBaseDAO;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface AppDAO extends IBaseDAO<App>{
	public void updateApp(String nuovaVersione, App o) throws Exception;
	public void uinstall(Smartphone tel, App app) throws Exception;
}
