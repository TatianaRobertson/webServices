package src.main.java.com.keysoft.rest;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import src.main.java.com.keysoft.model.Ticket;
import src.main.java.com.keysoft.model.TicketSearch;
import src.main.java.com.keysoft.utils.Database;

@Path("tickets")
@Produces("application/json")
@Consumes("application/json")
public class TicketResource {

	@POST
	@Path("search")
	public Response ticketSearch(TicketSearch ticketSearch) {
		// http://localhost:8080/javaee-7.0/rest/tickets/search
		List<Ticket> ticketList = new ArrayList<>();
		try {
			Statement statement = Database.getConnection().createStatement();
			
			String qry = "SELECT id, title, description, application_id, status, assignee_id, daysOpen  FROM tza_ticket " 
					+ " WHERE daysOpen BETWEEN "+ticketSearch.getDaysOpenFrom()+" and "+ticketSearch.getDaysOpenTo()+"  AND status in ( " +
                    ticketSearch.getStatusValues().toString().replace("[", "").replace("]", "")
                    + " )";
			System.out.println(qry);
			ResultSet resultSet = statement.executeQuery(qry);
			while (resultSet.next()) {
				Ticket ticket = new Ticket();
				ticket.setId(resultSet.getInt(1));
				ticket.setTitle(resultSet.getString(2));
				ticket.setDescription(resultSet.getString(3));
				ticket.setApplicationId( resultSet.getInt(4));
				ticket.setStatus(resultSet.getString(5));
				ticket.setAssigneeId( resultSet.getInt(6));
				ticket.setDaysOpen(resultSet.getInt(7));
				ticketList.add(ticket);
				//ticketList.add(new Ticket(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
			//			resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7)));
			}

				
		} catch (Exception exception) {
			System.out.println("got exception");
			exception.printStackTrace();
		}
		return Response.status(200).entity(ticketList).build();
	}

}
