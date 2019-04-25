package src.main.java.com.keysoft.soap;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;


import src.main.java.com.keysoft.model.User;
import src.main.java.com.keysoft.utils.Database;

@WebService(endpointInterface = "src.main.java.com.keysoft.soap.IUserService",
            serviceName = "UserServiceSOAP")
public class UserService implements IUserService {

	public UserService(){
		
	}
	
	@Override
	public String getAll() {
	  List<User> users = new ArrayList<>();
	        try {
	            Statement statement = Database.getConnection().createStatement();
	            ResultSet resultSet = statement.executeQuery("select * from tza_user");
	            System.out.println("in getAll before while");
	            while(resultSet.next()) {
	                users.add(new User(resultSet.getInt(1),
	                        resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return users.get(0).getLastName();
	}

//	@Override
//	public String getAll() {
//	   return "Hello tat";
//	}
	
	}
