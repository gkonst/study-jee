package kg.study.zero.facade;

import kg.study.zero.api.FacadeException;
import kg.study.zero.api.Person;
import kg.study.zero.api.PersonFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.jws.WebService;

/**
 * Facade implementation for working with {@link Person}.
 *
 * @author Konstantin_Grigoriev
 */
@WebService(endpointInterface = "kg.study.zero.api.PersonFacade", serviceName = PersonFacade.SERVICE,
        portName = PersonFacade.PORT, targetNamespace = PersonFacade.NAMESPACE)
public class PersonFacadeImpl implements PersonFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonFacadeImpl.class);

    @Override
    public String save(Person person) throws FacadeException {
        LOGGER.info("save...{}", person);
        // TODO implement
        LOGGER.info("save...Ok");
        throw new NotImplementedException();
    }
}
