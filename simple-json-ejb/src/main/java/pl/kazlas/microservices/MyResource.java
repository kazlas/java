
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
    
    /** Method processing HTTP GET requests, producing "application/json" MIME media
     * type.
     * @return JsonHelloAnswer a response of type "application/json".
     */
    @GET 
    @Produces("application/json")
    public JsonHelloAnswer getIt() {
    	
    	JsonHelloAnswer jsonResonse = new JsonHelloAnswer();
        return jsonResonse;
    }
}
