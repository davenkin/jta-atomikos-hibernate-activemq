package davenkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created with IntelliJ IDEA.
 * User: davenkin
 * Date: 3/12/13
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld {
          private final static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public String sayHello(){
        logger.info("Saying Hello World.");
        return "Hello World.";
    }

    public static void main(String[] args){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
              return   session.createTextMessage("this is a test message");
            }
        });
    }
}
