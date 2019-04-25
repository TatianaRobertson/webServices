import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restclient.User;

import java.util.List;
import java.util.concurrent.Future;

public class RestClient {
    public static void main(String[] args) throws Exception {
        Client client = ClientBuilder.newClient();

        //Return a single application
        Future<User> user = client
                .target("http://localhost:8080/javaee-7.0/rest/users/")
                .path("{id}")
                .resolveTemplate("id", 3)
                .request()
                .async()
                .get(new InvocationCallback<User>(){

					public void completed(User user) {
						System.out.println("Application name returned: " + user.getFirstName());						
					}

					public void failed(Throwable error) {
						System.out.println("Failed ");						
								// TODO Auto-generated method stub
						
					}
                	
                });

      
        //Creating a new application; confirm record created in the database
 /*       client.target("http://localhost:8080/javaee-7.0/rest/users/")
                .request()
                .post(Entity.entity(new User(57, "Andrew",
                                "Smith","23 Grenada road"), "application/json"),
                        User.class);


        System.out.println("user created created");
*/
        //Return a list of applications
/*        List<User> users = client.target("http://localhost:8080/javaee-7.0/rest")
                .path("users")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<User>>() {});
        System.out.println("The count of applications returned: " + users.size());
*/
    }

}
