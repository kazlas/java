package pl.kazlas.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloTeller {

	public String sayHallo() {
		return "Hello from EJB!";
	}
}
