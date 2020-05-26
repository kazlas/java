package pl.kazlas.frankfurter.json;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rate")
public class Rate {
	private BigDecimal USD;

	public BigDecimal getUSD() {
		return USD;
	}
	public void setUSD(BigDecimal usdRate) {
		USD = usdRate;
	}
}
