package kg.study.zero.ui;

import kg.study.zero.api.FacadeException;
import kg.study.zero.api.Person;
import kg.study.zero.api.PersonFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 * Managed Bean for working with {@link Person} entity.
 *
 * @author Konstantin_Grigoriev
 */
public class PersonBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonBean.class);

    private Person person;

    public PersonBean() {
        person = new Person();
    }

    public void save() {
        LOGGER.info("> save...{}", person);
        PersonFacade facade = PersonFacadeClient.getInstance().getPersonFacade();
        try {
            String id = facade.save(person);
            addMessage(FacesMessage.SEVERITY_INFO, "Person successfully saved with id " + id);
        } catch (FacadeException e) {
            LOGGER.error("Error in facade invocation", e);
            addMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage());
        }
        LOGGER.info("< save...Ok");
    }

    private static void addMessage(FacesMessage.Severity severity, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, message, message));
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
