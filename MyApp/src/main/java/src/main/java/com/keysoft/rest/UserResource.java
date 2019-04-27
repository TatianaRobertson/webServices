package src.main.java.com.keysoft.rest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import src.main.java.com.keysoft.model.User;
import src.main.java.com.keysoft.utils.Database;

@Path("users")
@Produces("application/json")
@Consumes("application/json")
public class UserResource {

        @POST
	    public Response addUser(User user) throws SQLException {
	            Statement statement = Database.getConnection().createStatement();
	            statement.executeUpdate("INSERT INTO TZA_USER " +
	                    " VALUES (" + user.getId() + ",'" + user.getFirstName() +
	                    "','" + user.getLastName()+ "','"+user.getAddress()+"')");
	        return Response.status(201).build();
	    }



        @GET
        @Path("{id}")
        public Response getUser(@PathParam("id") int id) {
            User user = new User();

            try {

                Statement statement = Database.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("select * from tza_user where id = " + id);

                while(resultSet.next()) {
                    user = new User(resultSet.getInt(1),
                            resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            return Response.status(200).entity(user).build();
        }
        
        
        @GET
        @Path("{firstName}/{lastName}")
        public Response getUserX(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
       	    User user = new User();
            try {

                Statement statement = Database.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("select * from tza_user where first_name = '" + firstName + "' and last_name = '" + lastName +"'");

                while(resultSet.next()) {
                	user = new User(resultSet.getInt(1),
                            resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return Response.status(200).entity(user).build();
        }

        @GET
        public Response getAllUsers() { //http://localhost:8080/javaee-7.0/rest/applications
            List<User> userArray = new ArrayList<User>();

            try {
                Statement statement = Database.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("select * from tza_user");

                while(resultSet.next()) {
                    userArray.add(new User(resultSet.getInt(1),
                            resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            return Response.status(200).entity(userArray).build();
        }

        @PUT
        public Response updateUser(User user) {
            try {
                Statement statement = Database.getConnection().createStatement();
                statement.executeUpdate("UPDATE TZA_user " +
                        " SET first_name = '" + user.getFirstName() + "', " +
                        " last_name = '" + user.getLastName() + "'" +
                        " WHERE id=" + user.getId());
            } catch (Exception exception) {
                exception.printStackTrace();
                return Response.status(403).build();
            }

            return Response.status(200).build();
        }
        
        @DELETE
        @Path("{id}")
        public Response deleteUser(@PathParam("id") int id) {
            try {
                Statement statement = Database.getConnection().createStatement();
                statement.executeUpdate("DELETE FROM TZA_user " +
                        " WHERE id=" + id);
            } catch (Exception exception) {
                exception.printStackTrace();
                return Response.status(403).build();
            }

            return Response.status(204).build();

        }
        
        @DELETE
        public Response deleteUser(User user) {
            try {
                Statement statement = Database.getConnection().createStatement();
                statement.executeUpdate("DELETE FROM TZA_user " +
                        " WHERE id=" + user.getId());
            } catch (Exception exception) {
                exception.printStackTrace();
                return Response.status(403).build();
            }

            return Response.status(204).build();

        }

}
