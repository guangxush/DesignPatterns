package bridge.example;

import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class AthleticProgram implements Program {
    ArrayList<String> content;

    AthleticProgram() {
        content = new ArrayList<>();
    }

    @Override
    public ArrayList<String> makeTVProgram() {
        content.clear();
        content.add("足球直播");
        content.add("巴西足球队进场");
        content.add("阿根廷足球队进场");
        content.add("巴西足球队进球");
        content.add("比赛结束");
        return content;
    }
}