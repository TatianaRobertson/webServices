package src.main.java.com.keysoft.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import src.main.java.com.keysoft.model.User;


@WebService
public interface IUserService {
	
	@WebMethod
    public String getAll();

}
