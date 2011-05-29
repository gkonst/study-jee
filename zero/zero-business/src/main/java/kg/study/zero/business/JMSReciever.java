package kg.study.zero.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Class used for receive messages from given destination using given {@link MessageListener} instance.
 *
 * @author Konstantin_Grigoriev
 */
public class JMSReciever {

    private static final Logger LOGGER = LoggerFactory.getLogger(JMSReciever.class);

    private String connectionFactoryName = "/ConnectionFactory";
    private String destinationName;

    private MessageListener listener;

    public JMSReciever(String destinationName, MessageListener listener) {
        this.destinationName = destinationName;
        this.listener = listener;
    }

    public JMSReciever(String connectionFactoryName, String destinationName, MessageListener listener) {
        this.connectionFactoryName = connectionFactoryName;
        this.destinationName = destinationName;
        this.listener = listener;
    }

    public void start() throws BusinessException {
        InitialContext ctx = null;
        Connection connection = null;
        try {
            ctx = new InitialContext();
            ConnectionFactory factory = (ConnectionFactory) ctx.lookup(connectionFactoryName);
            Destination destination = (Destination) ctx.lookup(destinationName);
            connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer receiver = session.createConsumer(destination);
            receiver.setMessageListener(listener);
            connection.start();
        } catch (NamingException e) {
            throw new BusinessException("Error during ctx communication", e);
        } catch (JMSException e) {
            throw new BusinessException("Error during jms communication", e);
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException e) {
                    LOGGER.error("Error during closing ctx", e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    LOGGER.error("Error during closing connection", e);
                }
            }
        }
    }
}
