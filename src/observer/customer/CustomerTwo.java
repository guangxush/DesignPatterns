package observer.customer;

import observer.ObserverTwo;
import observer.SubjectTwo;
import observer.shop.ShopSubject;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class CustomerTwo implements ObserverTwo{
    private SubjectTwo subject;
    private String goodName;
    private String personName;
    private double oldPrice, newPrice;

    public CustomerTwo(SubjectTwo subject, String personName){
        this.subject = subject;
        this.personName = personName;
        subject.addObserve( this);
    }

    @Override
    public void update(){
        if(subject instanceof ShopSubject){
            oldPrice = ((ShopSubject) subject).getOldPrice();
            newPrice = ((ShopSubject) subject).getNewPrice();
            goodName = ((ShopSubject) subject).getGoodsName();
            System.out.println(personName+"打折的商品名称："+goodName+", 原价是："+oldPrice+",现价是："+newPrice);
        }
    }
}
