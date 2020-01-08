package builder.example;

import javax.swing.*;
import java.util.Calendar;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class CalendarProduct{
    Calendar calendar;
    String title;              //日历牌的标题
    String [] weekTitle;       //日历牌的星期标题
    String [][] dayOfMonth;    //用来存放一个月中的号码的数组
    int year=2008,month=1;
    public void showCalendarPad(){
        JTable table;
        table=new JTable(dayOfMonth,weekTitle);
        JDialog dialog=new JDialog();
        dialog.setTitle(title);
        dialog.add(new JScrollPane(table));
        dialog.setBounds(130,160,220,180);
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
