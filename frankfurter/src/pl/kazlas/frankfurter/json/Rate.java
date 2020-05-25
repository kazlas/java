package pl.kazlas.frankfurter.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rate")
public class Rate {
	private Float USD;

	public Float getUSD() {
		return USD;
	}
	public void setUSD(Float uSD) {
		USD = uSD;
	}
}
