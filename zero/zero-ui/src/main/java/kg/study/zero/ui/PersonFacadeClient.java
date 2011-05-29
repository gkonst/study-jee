package kg.study.zero.ui;

import kg.study.zero.api.PersonFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Client for {@link PersonFacade} service.
 *
 * @author Konstantin_Grigoriev
 */
public class PersonFacadeClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonFacadeClient.class);

    private final static URL WSDL_LOCATION;
    private final static QName SERVICE = new QName("http://api.study.epam.com/", "PersonFacadeService");
    private final static QName PersonFacadePort = new QName("http://api.study.epam.com/", "PersonFacadePort");

    private static PersonFacadeClient instance;

    public static final String DEFAULT_WSDL_LOCATION = "http://localhost:8080/zero-facade-1.0-SNAP/PersonFacade?wsdl";

    static {
        URL url = null;
        try {
            // TODO load from file
            url = new URL(DEFAULT_WSDL_LOCATION);
        } catch (MalformedURLException e) {
            LOGGER.error("Can not initialize the default wsdl from {}", e, DEFAULT_WSDL_LOCATION);
        }
        WSDL_LOCATION = url;
    }

    private PersonFacadeClient() {
    }

    public synchronized static PersonFacadeClient getInstance() {
        if (instance == null) {
            instance = new PersonFacadeClient();
        }
        return instance;
    }

    public PersonFacade getPersonFacade() {
        Service service = Service.create(WSDL_LOCATION, SERVICE);
        return service.getPort(PersonFacadePort, PersonFacade.class);
    }
}