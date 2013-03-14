package davenkin;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jms.core.JmsTemplate;

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
        System.out.println(order.getBuyerName());
    }

    @Required
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
