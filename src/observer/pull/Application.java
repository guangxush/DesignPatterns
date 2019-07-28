package observer.pull;

import observer.pull.customer.CustomerOne;
import observer.pull.customer.Customer;
import observer.pull.shop.ShopSubject;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class Application {
    public static void main(String[] args) {
        ShopSubject shop = new ShopSubject();
        CustomerOne customerOne = new CustomerOne(shop, "张三");
        Customer customerTwo = new Customer(shop, "李四");
        shop.setDiscountGoods("Photo", 123, 223);
        shop.setDiscountGoods("iPhone", 8999, 5999);
    }
}
