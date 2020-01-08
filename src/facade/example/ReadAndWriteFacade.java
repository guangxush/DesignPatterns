package facade.example;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ReadAndWriteFacade {
    private ReadFile readFile;
    private AnalyzeInformation information;
    private WriteFile writeFile;

    public ReadAndWriteFacade() {
        readFile = new ReadFile();
        information = new AnalyzeInformation();
        writeFile = new WriteFile();
    }

    public void doOption(String fileName, String delContent, String savedFileName){
        String content = readFile.readFileContent(fileName);
        System.out.println("读取的文件是： "+fileName);
        System.out.println(content);
        String savedContent = information.getSavedContent(content,delContent);
        writeFile.writeToFile(savedFileName, savedContent);
        System.out.println("保存到文件"+savedFileName+"中的内容是：");
        System.out.println(savedContent);
    }
}
