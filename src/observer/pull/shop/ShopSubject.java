package observer.pull.shop;

import observer.pull.Observer;
import observer.pull.Subject;

import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class ShopSubject implements Subject {


    private String goodsName;
    private double oldPrice, newPrice;
    private ArrayList<Observer> customerList;

    public ShopSubject() {
        this.customerList = new ArrayList<Observer>();
    }


    @Override
    public void addObserve(Observer observer) {
        if (!customerList.contains(observer)) {
            customerList.add(observer);
        }
    }

    @Override
    public void deleteObserver(Observer observer) {
        if (!customerList.contains(observer)) {
            customerList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < customerList.size(); i++) {
            Observer observer = customerList.get(i);
            // 仅仅通知观察者，不提供数据
            observer.update();
        }
    }

    /**
     * 设置打折商品
     *
     * @param name
     * @param oldP
     * @param newP
     */
    public void setDiscountGoods(String name, double oldP, double newP) {
        this.goodsName = name;
        this.oldPrice = oldP;
        this.newPrice = newP;
        notifyObserver();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }


}
