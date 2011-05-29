package kg.study.zero.ui;

import kg.study.zero.api.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
        // TODO implement
        LOGGER.info("< save...Ok");
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
