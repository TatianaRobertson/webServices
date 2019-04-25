package src.main.java.com.keysoft.soap.generated;

public class UserClientGen {
	 public static void main(String[] args) throws Exception {

	        UserServiceSOAP applicationService = new UserServiceSOAP();

	        IUserService proxy = applicationService.getUserServicePort();

	        System.out.println(proxy.getAll());

	    }
}
