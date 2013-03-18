package davenkin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: davenkin
 * Date: 3/14/13
 * Time: 10:19 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class DefaultOrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void makeOrder(){
        Order order = new Order();
//        order.setId(123l);
        order.setBuyerName("davenkin");
        order.setItemName("book");
        order.setMailAddress("chengdu");
        order.setPrice(10.00);
        orderService.makeOrder(order);
    }
}
