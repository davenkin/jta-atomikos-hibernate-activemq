package davenkin;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;

public class DefaultOrderService  implements OrderService{
    private JmsTemplate jmsTemplate;
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void makeOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        jmsTemplate.convertAndSend(order);
        session.save(order);
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
