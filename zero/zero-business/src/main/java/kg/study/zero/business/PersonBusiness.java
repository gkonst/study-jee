package kg.study.zero.business;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Business implementation for {@link kg.study.zero.api.Person} entity.
 *
 * @author Konstantin_Grigoriev
 */
public class PersonBusiness implements MessageListener {
    @Override
    public void onMessage(Message message) {
        // TODO implement
    }
}
