package builder.example;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Director {
    private Builder builder;
    int year, month;

    Director(Builder builder, int year, int month) {
        this.builder = builder;
        this.year = year;
        this.month = month;
    }

    public void constructProduct() {
        boolean ok = false;
        ok = builder.buildWeekTitle();
        if (ok) {
            ok = builder.buildCalendar(year, month);
        }
        if (ok) {
            builder.buildTitle();
            builder.buildDayOfMonth();
        }
        if (ok) {
            CalendarProduct prodcut = builder.getCalendarProduct();
            prodcut.showCalendarPad();
        }
    }
}
