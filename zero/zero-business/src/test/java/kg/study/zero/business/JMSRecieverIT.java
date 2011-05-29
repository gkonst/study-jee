package kg.study.zero.business;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.jms.MessageListener;

import static org.mockito.Mockito.mock;

/**
 * Integration test for {@link JMSReciever}.
 *
 * @author Konstantin_Grigoriev
 */
public class JMSRecieverIT {

    private JMSReciever service;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new JMSReciever("queue/ZeroQueue", mock(MessageListener.class));
    }

    @Test
    public void startShouldNotFail() throws Exception {
        // given
        // when
        service.start();
        // then
    }
}
