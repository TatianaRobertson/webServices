package src.main.java.com.keysoft.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "src.main.java.com.keysoft.soap.IUserService",
            serviceName = "UserServiceSOAP")
public class UserService implements IUserService {

	public UserService(){
		
	}
	
	@Override
	public String getAll() {
		return "Tat User getAll method";
	}

}
