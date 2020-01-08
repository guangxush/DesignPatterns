package builder.example;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public interface Builder {
    void buildTitle();

    boolean buildWeekTitle();

    boolean buildCalendar(int year, int month);

    void buildDayOfMonth();

    CalendarProduct getCalendarProduct();
}
