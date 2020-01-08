package iterator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application {
    public static void main(String[] args) {
        int n = 20;
        int sum = 0;
        Collection<RenMinMoney> set = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            if (i == n / 2 || i == n / 5 || i == n / 6) {
                set.add(new RenMinMoney(100, false));
            } else {
                set.add(new RenMinMoney(100, true));
            }
        }
        Iterator<RenMinMoney> iterator = set.iterator();
        System.out.println("保险箱中共有" + set.size() + "张人民币。");
        int k = 0;
        while (iterator.hasNext()) {
            RenMinMoney money = iterator.next();
            k++;
            if (!money.isTrue()) {
                System.out.println("第" + k + "张是假币，被销毁");
                iterator.remove();
            }
        }
        System.out.print("保险箱中有真币" + set.size() + "张，共：");
        iterator = set.iterator();
        while (iterator.hasNext()) {
            RenMinMoney money = iterator.next();
            sum += money.getValue();
        }
        System.out.println(sum + "元");
    }
}

class RenMinMoney {
    int value;
    private boolean isTrue;

    public RenMinMoney(int value, boolean isTrue) {
        this.value = value;
        this.isTrue = isTrue;
    }

    public int getValue() {
        return value;
    }

    public boolean isTrue() {
        return isTrue;
    }
}
