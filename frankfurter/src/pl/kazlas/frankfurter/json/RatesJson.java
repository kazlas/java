package pl.kazlas.frankfurter.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ratesjson")
public class RatesJson {
	private String date;
	private Rate rates;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Rate getRates() {
		return rates;
	}
	public void setRates(Rate rates) {
		this.rates = rates;
	}
}
