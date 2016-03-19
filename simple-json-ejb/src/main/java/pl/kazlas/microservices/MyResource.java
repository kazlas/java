
package pl.kazlas.microservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import pl.kazlas.ejb.HelloTeller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
@Stateless
public class MyResource {
    
	@EJB HelloTeller HelloTeller;
	@Context HttpServletResponse response;
	
    /** Method processing HTTP GET requests, producing "application/json" MIME media
     * type.
     * @return JsonHelloAnswer a response of type "application/json".
     */
    @GET 
    @Produces("application/json")
    public JsonHelloAnswer getIt() {
    	response.addHeader("Access-Control-Allow-Origin", "*");
    	response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    	
    	JsonHelloAnswer jsonResonse = new JsonHelloAnswer("Hello JSON!");
        return jsonResonse;
    }
    
    @GET
    @Path("/ejb")
    @Produces("application/json")
    public JsonHelloAnswer getAnswerFromEJB(){
    	JsonHelloAnswer jsonResonse;
    	String ejbResponse = HelloTeller.sayHallo();
    	jsonResonse = new JsonHelloAnswer(ejbResponse);
    	
    	return jsonResonse;
    }
    
}
