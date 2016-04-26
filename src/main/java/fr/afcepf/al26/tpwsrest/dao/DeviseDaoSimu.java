package fr.afcepf.al26.tpwsrest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import fr.afcepf.al26.tpwsrest.entity.Devise;
@Named() // ou bien @stateless ou nom par defaut 
public class DeviseDaoSimu implements IDeviseDao {
	//EntityManager avec un vra Dao et une vraie Base des données
	private Map<String, Devise> mapDevises = new HashMap<>();

	private static DeviseDaoSimu uniqueInstance = null;
	public static DeviseDaoSimu getInstance(){
		if(uniqueInstance==null)
			uniqueInstance = new DeviseDaoSimu();
		return uniqueInstance;
	}
	public DeviseDaoSimu() {
		mapDevises.put("EUR", new Devise("EUR", "euro", 0.92));
		mapDevises.put("USD", new Devise("USD", "dollar", 1.0));
		mapDevises.put("LIV", new Devise("LIV", "livre", 0.8));
		mapDevises.put("JPY", new Devise("JPY", "yen", 112.0));



	}

	@Override
	public Devise getDeviseByCode(String code) {
		return mapDevises.get(code);
	}

	@Override
	public List<Devise> getAllDivises() {
		return new ArrayList<>(mapDevises.values());
	}

	@Override
	public void addDevise(Devise d) {
		mapDevises.put(d.getCode(), d);

	}

	@Override
	public void deleteDevise(String code) {
		mapDevises.remove(code);
	}

}
