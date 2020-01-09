package flyweight.example;

import java.util.HashMap;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class ElementFactory {
    private HashMap<String, Element> hashMap;
    static ElementFactory factory = new ElementFactory();

    private ElementFactory() {
        hashMap = new HashMap<String, Element>();
    }

    public static ElementFactory getFactory() {
        return factory;
    }

    public synchronized Element getElement(String key) {
        if (hashMap.containsKey(key))
            return hashMap.get(key);
        else {
            char elementOne = '\0', elementTwo = '\0';
            elementOne = key.charAt(0);
            elementTwo = key.charAt(1);
            Element element = new TwoElement(elementOne, elementTwo);
            hashMap.put(key, element);
            return element;
        }
    }

    class TwoElement implements Element {  // TwoElement是内部类
        char elementOne, elementTwo;

        private TwoElement(char elementOne, char elementTwo) {
            this.elementOne = elementOne;
            this.elementTwo = elementTwo;
        }

        @Override
        public void printMess(String name, int elementOneNumber, int elementTwoNumber) {
            System.out.print(name + "由" + elementOne + "和" + elementTwo + "组成"); //输出内部数据
            System.out.println(" 含有" + elementOneNumber + "个" + elementOne + "元素" +
                    "和" + elementTwoNumber + "个" + elementTwo + "元素"); //输出外部数据
        }
    }
}
