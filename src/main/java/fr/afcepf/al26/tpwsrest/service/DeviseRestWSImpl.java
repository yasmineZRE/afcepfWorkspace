package fr.afcepf.al26.tpwsrest.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.afcepf.al26.tpwsrest.dao.DeviseDaoSimu;
import fr.afcepf.al26.tpwsrest.dao.IDeviseDao;
import fr.afcepf.al26.tpwsrest.entity.Devise;

@Path("/deviseService")
//@Produces("application/xml")//typeMIMES
@Produces("application/json")//typeMIMES
public class DeviseRestWSImpl {
	//@Inject //Injection de dépendance via CDI
	private IDeviseDao deviseDao = DeviseDaoSimu.getInstance();

	@GET
	@Path("devise/{code}")
	//http://localhost:8080/TpWsRest/services/rest/deviseService/devise/EUR
	public Devise rechercherDeviseParCode(@PathParam("code")String code){
		//vi sans base de données*
		//		Devise dev = new Devise();
		//		dev.setCode(code);
		//		dev.setMonnaie("monnaie euro ou dollar");
		//		dev.setChange(1.123);
		//		return dev;
		Devise dev = deviseDao.getDeviseByCode(code);
		return dev;
	}
	//	@GET
	//	@Path("/devise")
	//	@Produces("application/xml")
	//	public List<Devise>rechercherToutesDevises(){
	//		return deviseDao.getAllDivises();
	//	}
	@GET
	@Path("/devise")
	//@Produces("application/xml")
	//fin URL en deviseService/devise
	//ou bien deviseService/devise?changeMini=1&param2=val2
	public List<Devise> rechercherDevises(@QueryParam("changeMini")Double changeMini){
		if (changeMini==null)
			return deviseDao.getAllDivises();
		else{
			List<Devise> sousListe = new ArrayList<>();
			for (Devise d : deviseDao.getAllDivises())
				if(d.getChange()>=changeMini) sousListe.add(d);
			return sousListe;
		}
	}

	@GET
	@Path("/convert")
	@Produces("text/plain")
	//fin d'URL convert?amount=50&scr=EUR&target=USD
	public double convertir(@QueryParam("amount")double amount, @QueryParam("src")String src, @QueryParam("target")String target){
		double res = 0;
		Devise srcDevise = deviseDao.getDeviseByCode(src);
		Devise targetDevice = deviseDao.getDeviseByCode(target);
		res = amount*targetDevice.getChange()/srcDevise.getChange();
		return res;
	}

	@PUT
	@Path("/devise")
	   @Consumes(MediaType.APPLICATION_JSON)
	public Devise updateDevise(Devise dev){
		Devise updatedDevise = null;
		deviseDao.addDevise(dev);
		updatedDevise = dev;
		return updatedDevise;
	}
}
