package davenkin;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created with IntelliJ IDEA.
 * User: davenkin
 * Date: 3/14/13
 * Time: 9:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultOrderService  implements OrderService{
    private JmsTemplate jmsTemplate;
    @Override
    public void makeOrder(Order order) {
      jmsTemplate.convertAndSend(order);
    }

    @Required
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
