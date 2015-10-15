
package pl.kazlas.microservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ejb.Stateless;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
@Stateless
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces("application/json")
    public JsonHelloAnswer getIt() {
    	
    	JsonHelloAnswer jsonResonse = new JsonHelloAnswer();
        return jsonResonse;
    }
}
