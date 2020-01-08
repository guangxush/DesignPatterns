package facade.example;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application {
    public static void main(String[] args) {
        ReadAndWriteFacade facade;
        facade =  new ReadAndWriteFacade();
        String readFileName = "index.html";
        String delContent = "<[^>]*>";
        String savedFileName = "save.txt";
        facade.doOption(readFileName, delContent, savedFileName);
    }
}
