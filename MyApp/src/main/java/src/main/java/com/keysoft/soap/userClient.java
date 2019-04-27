package src.main.java.com.keysoft.soap;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import src.main.java.com.keysoft.soap.generated.User;



public class UserClient {
	 public static void main(String[] args) throws Exception {
		    URL wsdlURL = new URL("http://localhost:8080/javaee-7.0/UserServiceSOAP?wsdl");

	        //first argument is namespaceURI; second argument is service name (both values retrieved from WSDL)
	        QName qualifiedName = new QName("http://soap.keysoft.com.java.main.src/",
	                "UserServiceSOAP");
			
	        Service webService = Service.create(wsdlURL, qualifiedName);
	         System.out.println("3="+webService.getServiceName());
	        System.out.println("3,5 ="+webService.getWSDLDocumentLocation());
	        //if using an interface, use interface name here, if not using service class name
	        src.main.java.com.keysoft.soap.generated.IUserService appService =  webService.getPort(src.main.java.com.keysoft.soap.generated.IUserService.class);
			
	   //     System.out.println("in main method:"+appService.getAll());
	  //      System.out.println("in main method:"+appService.getUser(2).getAddress());
	        
	        User user = new User("Bob", "Paparangi 4",103,"Smith");
	       System.out.println(appService.addUser(user));
	        
	      //  System.out.println(appService.updateUser(user));
	        
	        //System.out.println(appService.deleteUser(2));
	        
	 //       appService.getUser(57).toXML();
	 
	  //      appService.getUser(57)
	 }
}
