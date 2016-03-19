
package pl.kazlas.microservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import pl.kazlas.ejb.HelloTeller;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
@Stateless
public class MyResource {
    
	@EJB HelloTeller HelloTeller;
	
    /** Method processing HTTP GET requests, producing "application/json" MIME media
     * type.
     * @return JsonHelloAnswer a response of type "application/json".
     */
    @GET 
    @Produces("application/json")
    public Response getIt() {

    	JsonHelloAnswer jsonResonse = new JsonHelloAnswer("Hello JSON!");
        return Response.ok()
        		.entity(jsonResonse)
        		.header("Access-Control-Allow-Origin", "*")
        		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        		.build();
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
