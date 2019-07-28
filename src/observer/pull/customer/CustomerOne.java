package observer.pull.customer;

import observer.pull.Observer;
import observer.pull.Subject;
import observer.pull.shop.ShopSubject;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class CustomerOne implements Observer {
    private Subject subject;
    private String goodName;
    private String personName;

    public CustomerOne(Subject subject, String personName){
        this.subject = subject;
        this.personName = personName;
        subject.addObserve(this);
    }

    @Override
    public void update(){
        if(subject instanceof ShopSubject){
            goodName = ((ShopSubject) subject).getGoodsName();
            System.out.println(personName+"打折的商品名称："+goodName);
        }
    }
}
