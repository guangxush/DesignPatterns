package observer.customer;

import observer.ObserverTwo;
import observer.Subject;
import observer.SubjectTwo;
import observer.shop.ShopSubject;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class CustomerOne implements ObserverTwo {
    private SubjectTwo subject;
    private String goodName;
    private String personName;

    public CustomerOne(SubjectTwo subject, String personName){
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
