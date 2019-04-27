package src.main.java.com.keysoft.soap;

import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import src.main.java.com.keysoft.model.User;
import src.main.java.com.keysoft.utils.Database;

@WebService(endpointInterface = "src.main.java.com.keysoft.soap.IUserService", serviceName = "UserServiceSOAP")
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class UserService implements IUserService {

	public UserService() {

	}

	@Override
	@SuppressWarnings("Duplicates")
	public String getAll() {
		List<User> users = new ArrayList<>();
		try {
			Statement statement = Database.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from tza_user");
			System.out.println("in getAll before while");
			while (resultSet.next()) {
				users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4)));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return users.get(0).getLastName();
	}

	@Override
	@SuppressWarnings("Duplicates")
	public User getUser(int id) {
		User user = new User();

		try {
			Statement statement = Database.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from tza_user where id = " + id);

			while (resultSet.next()) {
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		// return Response.status(200).entity(application).build();
		return user;
	}

	@Override
	public boolean addUser(User user) {
		try {
			Statement statement = Database.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO TZA_USER " + " VALUES (" + user.getId() + ",'" + user.getFirstName()
					+ "','" + user.getLastName() + "','" + user.getAddress() + "')");
		} catch (SQLIntegrityConstraintViolationException exception) {
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean updateUser(User user) {
		try {
			Statement statement = Database.getConnection().createStatement();
			statement.executeUpdate("UPDATE TZA_user " + " SET first_name = '" + user.getFirstName() + "', "
					+ " last_name = '" + user.getLastName() + "'" + " WHERE id=" + user.getId());
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean deleteUser(int id) {
		try {
			Statement statement = Database.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM TZA_user " + " WHERE id=" + id);
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

		return true;

	}

}
