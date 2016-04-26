package fr.afcepf.al26.tpwsrest.dao;

import java.util.List;

import fr.afcepf.al26.tpwsrest.entity.Devise;

public interface IDeviseDao {
	Devise getDeviseByCode(String code);
	List<Devise> getAllDivises();
	void addDevise(Devise d);
	void deleteDevise(String code);
}
