package fr.afcepf.al26.tpwsrest.entity;

import javax.xml.bind.annotation.XmlRootElement;
//@Entity
@XmlRootElement(name="devise") //si java->xml
public class Devise {
	private String code;
	private String monnaie;
	private Double change;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMonnaie() {
		return monnaie;
	}
	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}
	public Double getChange() {
		return change;
	}
	public void setChange(Double change) {
		this.change = change;
	}
	public Devise(String code, String monnaie, Double change) {
		super();
		this.code = code;
		this.monnaie = monnaie;
		this.change = change;
	}
	public Devise() {
		super();
	}


}
