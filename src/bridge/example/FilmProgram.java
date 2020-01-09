package bridge.example;

import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class FilmProgram implements Program {
    ArrayList<String> content;

    FilmProgram() {
        content = new ArrayList<String>();
    }

    @Override
    public ArrayList<String> makeTVProgram() {
        content.clear();
        content.add("地道战");
        content.add("1937年鬼子侵略华北");
        content.add("八路军带领民兵展开地道站");
        content.add("把鬼子打地找不着北");
        content.add("鬼子最后被消灭了");
        return content;
    }
}