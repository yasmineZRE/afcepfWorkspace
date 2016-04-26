package fr.afcepf.al26.tpwsrest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import fr.afcepf.al26.tpwsrest.service.DeviseRestWSImpl;
@ApplicationPath("/services/rest")
public class MyRestApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<>();
		classes.add(DeviseRestWSImpl.class);
		return super.getClasses();
	}
}
