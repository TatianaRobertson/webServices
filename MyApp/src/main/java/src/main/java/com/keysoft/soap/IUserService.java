package src.main.java.com.keysoft.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import src.main.java.com.keysoft.model.User;


@WebService
public interface IUserService {
	
	@WebMethod
    public String getAll();

	@WebMethod
	public User getUser(int id);
	
	@WebMethod
	public boolean addUser(User user);
	

	@WebMethod
	public boolean updateUser(User user);
	
	@WebMethod
	public boolean deleteUser(int id);
}
