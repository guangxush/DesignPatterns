package singleton;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Champion {
    private static Champion uniqueChampion;
    String message;

    private Champion(String message) {
        uniqueChampion = this;
        this.message = message;
    }

    public static synchronized Champion getChampion(String message) {   //这是一个同步方法
        if (uniqueChampion == null) {
            uniqueChampion = new Champion(message + "是冠军");
        }
        return uniqueChampion;
    }

    public static void initChampion() {
        uniqueChampion = null;
    }

    public String getMess() {
        return message;
    }
}
