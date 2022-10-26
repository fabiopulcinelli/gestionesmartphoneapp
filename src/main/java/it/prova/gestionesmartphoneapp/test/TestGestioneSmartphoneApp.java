package it.prova.gestionesmartphoneapp.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.service.AppService;
import it.prova.gestionesmartphoneapp.service.SmartphoneService;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;
import it.prova.gestionesmartphoneapp.service.AppService;
import it.prova.gestionesmartphoneapp.service.MyServiceFactory;

public class TestGestioneSmartphoneApp {

	public static void main(String[] args) {
		AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();
		SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstance();

		try {

			System.out.println("In tabella Smartphone ci sono " + smartphoneServiceInstance.listAll().size() + " elementi.");
			System.out.println("In tabella App ci sono " + appServiceInstance.listAll().size() + " elementi.");
			System.out.println(
					"**************************** inizio batteria di test ********************************************");
			System.out.println(
					"*************************************************************************************************");

			testInserimentoNuovaApp(appServiceInstance);
			
			testInserimentoNuovoSmartphone(smartphoneServiceInstance);
			
			testCollegaSmartphoneAApp(appServiceInstance, smartphoneServiceInstance);
			
			testAggiornaOS(smartphoneServiceInstance);
			
			System.out.println(
					"****************************** fine batteria di test ********************************************");
			System.out.println(
					"*************************************************************************************************");
			System.out.println("In tabella Smartphone ci sono " + smartphoneServiceInstance.listAll().size() + " elementi.");
			System.out.println("In tabella App ci sono " + appServiceInstance.listAll().size() + " elementi.");

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}
	
	private static void testInserimentoNuovaApp(AppService appServiceInstance) throws Exception {
		System.out.println(".......testInserimentoNuovoApp inizio.............");

		App appInstance = new App("Calcolatrice",new Date(), new Date(), "0.0.1");
		appServiceInstance.inserisciNuovo(appInstance);
		if (appInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovoApp fallito ");

		System.out.println(".......testInserimentoNuovoApp fine: PASSED.............");
	}
	
	private static void testInserimentoNuovoSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
		System.out.println(".......testInserimentoNuovoSmartphone inizio.............");

		Smartphone smartphoneInstance = new Smartphone("OnePlus","9 Pro", 999, "0.0.1");
		smartphoneServiceInstance.inserisciNuovo(smartphoneInstance);
		if (smartphoneInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovoSmartphone fallito ");

		System.out.println(".......testInserimentoNuovoSmartphone fine: PASSED.............");
	}
	
	private static void testCollegaSmartphoneAApp(AppService appServiceInstance, SmartphoneService smartphoneServiceInstance)
			throws Exception {
		System.out.println(".......testCollegaSmartphoneAApp inizio.............");

		long nowInMillisecondi = new Date().getTime();
		// inserisco un cd
		App appInstance = new App("Calcolatrice" + nowInMillisecondi,new Date(), new Date(), "0.0.1");
		appServiceInstance.inserisciNuovo(appInstance);
		if (appInstance.getId() == null)
			throw new RuntimeException("testCollegaSmartphoneAApp fallito: inserimento cd non riuscito ");

		Smartphone nuovoSmartphone = new Smartphone("Marca" + nowInMillisecondi, "Modello" + nowInMillisecondi, 10, "0.0.1");
		smartphoneServiceInstance.inserisciNuovo(nuovoSmartphone);
		if (nuovoSmartphone.getId() == null)
			throw new RuntimeException("testCollegaSmartphoneAApp fallito: genere non inserito ");

		// collego
		appServiceInstance.aggiungiSmartphone(appInstance, nuovoSmartphone);

		System.out.println(".......testCollegaGenereACd fine: PASSED.............");
	}
	
	public static void testAggiornaOS(SmartphoneService smartphoneServiceInstance) throws Exception {
		System.out.println(".......testAggiornaOS inizio.............");
		
		//prendo il primo smartphone e gli aggiorno il sistem operativo
		Smartphone smartphoneDaAggiornare = smartphoneServiceInstance.listAll().get(0);
		if (smartphoneDaAggiornare.getId() == null)
			throw new RuntimeException("testAggiornaOS fallito ");
		
		smartphoneServiceInstance.aggiornaOS("0.1.1", smartphoneDaAggiornare);
		smartphoneServiceInstance.aggiorna(smartphoneDaAggiornare);
		
		if( !smartphoneServiceInstance.listAll().get(0).getVersioneOS().equals("0.1.1"))
			throw new RuntimeException("testAggiornaOS fallito ");
		
		System.out.println(".......testAggiornaOS fine: PASSED.............");
	}
}