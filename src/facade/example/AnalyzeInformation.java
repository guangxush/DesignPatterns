package facade.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class AnalyzeInformation {
    public String getSavedContent(String content, String deleteContent){
        Pattern p;
        Matcher m;
        p = Pattern.compile(deleteContent);
        m = p.matcher(content);
        String savedContent = m.replaceAll("");
        return savedContent;
    }
}
