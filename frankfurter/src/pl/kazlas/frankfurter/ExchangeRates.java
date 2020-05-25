package pl.kazlas.frankfurter;

import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import pl.kazlas.frankfurter.entity.RateSearchEntity;
import pl.kazlas.frankfurter.json.RatesJson;

/**
 * Implementation of exchange rates
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
@Path("/rates")
@Produces(MediaType.APPLICATION_JSON)
public class ExchangeRates {
	private static final String REST_URI = "https://api.frankfurter.app";
	
	@EJB
	EventLog eventLog;

	@Path("/eurusd")
	@GET
	public Float getEurUsd(@QueryParam("date") String date) {
		RatesJson ratesJson = getEurUsdFromFrankurter(date);
		
		Optional<Float> usdRate = Optional.ofNullable(ratesJson)
        	.map(rates -> ratesJson.getRates())
        	.map(rate -> rate.getUSD());
		if (!usdRate.isPresent()) {
			return (float) 0;
		}
		
		eventLog.addSearching(new RateSearchEntity());

		return usdRate.get();
	}

	
	private RatesJson getEurUsdFromFrankurter(String date) {
		Client client = ClientBuilder.newClient();
		
		return client.target(REST_URI)
				.path(date)
				.queryParam("from", "EUR")
				.queryParam("to", "USD")
				.request(MediaType.APPLICATION_JSON)
				.get(RatesJson.class);
	}

}
