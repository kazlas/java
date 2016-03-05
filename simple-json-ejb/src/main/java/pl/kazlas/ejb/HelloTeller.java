package pl.kazlas.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
public class HelloTeller {
	private static final String helloMessage = "Hello form EJB!";

	public String sayHallo (){
    	return helloMessage;		
	}
}
