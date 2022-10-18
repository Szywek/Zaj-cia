package com.jsfcourse.calc;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
//@SessionScoped

public class CreditBB {

	private String x;
	private String y;
	private String z;

	private Double result;

	@Inject
	FacesContext ctx;



	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getZ() {
		return z;
	}

	public void setZ(String z) {
		this.z = z;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}


	public boolean doTheMath() {
		try {
			double x = Double.parseDouble(this.x);
			double y = Double.parseDouble(this.y);
			double z = Double.parseDouble(this.z);

			double w = (x / (y*12));
			result = w + (w*(z/100));

			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd  przetwarzania parametrów", null));
			return false;
		}
	}


	public String calc() {
		if (doTheMath()) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Wynik: " + result, null));
		}
		return null;
	}
	
}
