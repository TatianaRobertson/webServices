import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import restclient.Ticket;
import restclient.TicketSearch;
import restclient.User;

public class RestClient {
	public static void main(String[] args) throws Exception {
		Client client = ClientBuilder.newClient();
		TicketSearch ticketSearch = new TicketSearch();

	/*	List<String> statusValues = new ArrayList<String>();
		statusValues.add("'Open'");
		statusValues.add("'In Process'");
		ticketSearch.setStatusValues(statusValues);
		ticketSearch.setDaysOpenFrom(10);
		ticketSearch.setDaysOpenTo(50);

		List<Ticket> tickets = client.target("http://localhost:8080/javaee-7.0/rest/").path("tickets/search")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(ticketSearch, "application/json"), new GenericType<List<Ticket>>() {
				});
		tickets.stream().forEach(
				ticket -> System.out.println(ticket.getId() + "-" + ticket.getTitle() + "-" + ticket.getAssigneeId()));

		// Return a single application
		Future<User> user = client.target("http://localhost:8080/javaee-7.0/rest/users/").path("{id}")
				.resolveTemplate("id", 3).request().async().get(new InvocationCallback<User>() {

					public void completed(User user) {
						System.out.println("Application name returned: " + user.getFirstName());
					}

					public void failed(Throwable error) {
						System.out.println("Failed ");
						// TODO Auto-generated method stub

					}

				});
		*/
		User userX = new User(23,"Mike","Ford","Grenada village");
		Response response = client
				.target("http://localhost:8080/javaee-7.0/rest/users/")
				.request()
				.post(Entity.entity(userX, "application/json"),Response.class);

		if(response.getStatus() == Response.Status.CONFLICT.getStatusCode()){
			System.out.println("That user already exists");
		}
	}

}
