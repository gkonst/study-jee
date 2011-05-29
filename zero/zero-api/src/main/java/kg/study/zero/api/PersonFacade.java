package kg.study.zero.api;

import javax.jws.WebService;

/**
 * Facade SEI for {@link Person} entity.
 *
 * @author Konstantin_Grigoriev
 */
@WebService(wsdlLocation = "classpath:PersonFacade.wsdl")
public interface PersonFacade {
    /**
     * Target namespace for this facade.
     */
    String NAMESPACE = "http://api.study.epam.com/";
    /**
     * Service name.
     */
    String SERVICE = "PersonFacadeService";
    /**
     * Service port.
     */
    String PORT = "PersonFacadePort";

    /**
     * Saves person.
     *
     * @param person given person
     * @return generated person identifier
     * @throws FacadeException if smth wrong
     */
    String save(Person person) throws FacadeException;
}
