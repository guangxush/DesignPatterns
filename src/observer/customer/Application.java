package observer.customer;

import observer.shop.ShopSubject;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class Application {
    public static void main(String[] args) {
        ShopSubject shop = new ShopSubject();
        CustomerOne customerOne = new CustomerOne(shop, "张三");
        CustomerTwo customerTwo = new CustomerTwo(shop, "李四");
        shop.setDiscountGoods("Photo", 123, 223);
        shop.setDiscountGoods("iPhone", 8999, 5999);
    }
}
