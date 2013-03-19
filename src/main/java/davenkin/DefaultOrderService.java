package davenkin;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: davenkin
 * Date: 3/14/13
 * Time: 9:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultOrderService  implements OrderService{
    private JmsTemplate jmsTemplate;
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void makeOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
        jmsTemplate.convertAndSend(order);

    }

    @Required
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
