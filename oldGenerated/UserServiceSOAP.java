
package src.main.java.com.keysoft.soap.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "UserServiceSOAP", targetNamespace = "http://soap.keysoft.com.java.main.src/", wsdlLocation = "http://localhost:8080/javaee-7.0/UserServiceSOAP?wsdl")
public class UserServiceSOAP
    extends Service
{

    private final static URL USERSERVICESOAP_WSDL_LOCATION;
    private final static WebServiceException USERSERVICESOAP_EXCEPTION;
    private final static QName USERSERVICESOAP_QNAME = new QName("http://soap.keysoft.com.java.main.src/", "UserServiceSOAP");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/javaee-7.0/UserServiceSOAP?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        USERSERVICESOAP_WSDL_LOCATION = url;
        USERSERVICESOAP_EXCEPTION = e;
    }

    public UserServiceSOAP() {
        super(__getWsdlLocation(), USERSERVICESOAP_QNAME);
    }

    public UserServiceSOAP(WebServiceFeature... features) {
        super(__getWsdlLocation(), USERSERVICESOAP_QNAME, features);
    }

    public UserServiceSOAP(URL wsdlLocation) {
        super(wsdlLocation, USERSERVICESOAP_QNAME);
    }

    public UserServiceSOAP(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, USERSERVICESOAP_QNAME, features);
    }

    public UserServiceSOAP(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserServiceSOAP(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IUserService
     */
    @WebEndpoint(name = "UserServicePort")
    public IUserService getUserServicePort() {
        return super.getPort(new QName("http://soap.keysoft.com.java.main.src/", "UserServicePort"), IUserService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IUserService
     */
    @WebEndpoint(name = "UserServicePort")
    public IUserService getUserServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.keysoft.com.java.main.src/", "UserServicePort"), IUserService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (USERSERVICESOAP_EXCEPTION!= null) {
            throw USERSERVICESOAP_EXCEPTION;
        }
        return USERSERVICESOAP_WSDL_LOCATION;
    }

}
