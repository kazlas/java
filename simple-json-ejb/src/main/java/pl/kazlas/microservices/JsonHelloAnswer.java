package pl.kazlas.microservices;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JsonHelloAnswer {
	
	@XmlElement
	private String welcomePhrase = "Hi Json!";
	
}
