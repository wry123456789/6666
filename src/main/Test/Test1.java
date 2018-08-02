import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.dao.com.mybatisimpl.OrderItemMImpl;
import com.neuedu.dao.com.mybatisimpl.OrderMImpl;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import org.junit.Test;

import java.util.List;

public class Test1 {
    OrderItemDao or3 = new OrderItemMImpl();
    OrderDao or = new OrderMImpl();
    @Test
    public void create(){


        UserOrder userOrder = new UserOrder();
        long or1 =System.currentTimeMillis();
        userOrder.setOrder_no(or1);
        or.createOrder(userOrder);


    }
    @Test
public void OrderItem(){

    UserOrderItem u = new UserOrderItem();
    u.setProduct_name("222");
    or3.addOrderItems(u);
}
    @Test
public void testSelect(){
       long s =1532950324840L;
        List<UserOrderItem> ll=or3.selectItem(s);
           System.out.println(ll);
}
@Test
public void test(){
       List<UserOrder>list= or.selectOrder(4);
       for(UserOrder l:list){
           System.out.println(l.getPostage());
       }
       System.out.println(list);
}
}
