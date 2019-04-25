package src.main.java.com.keysoft.soap;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class userClient {
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
			
	        System.out.println("in main method:"+appService.getAll());
	        
			
	    }
}
