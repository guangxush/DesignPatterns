package composite;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application {
    public static void main(String args[]) throws NoSuchMethodException {
        MilitaryPerson 连长 = new MilitaryOfficer("连长", 5000);
        MilitaryPerson 排长1 = new MilitaryOfficer("一排长", 4000);
        MilitaryPerson 排长2 = new MilitaryOfficer("二排长", 4000);
        MilitaryPerson 班长11 = new MilitaryOfficer("一班长", 2000);
        MilitaryPerson 班长12 = new MilitaryOfficer("二班长", 2000);
        MilitaryPerson 班长13 = new MilitaryOfficer("三班长", 2000);
        MilitaryPerson 班长21 = new MilitaryOfficer("一班长", 2000);
        MilitaryPerson 班长22 = new MilitaryOfficer("二班长", 2000);
        MilitaryPerson 班长23 = new MilitaryOfficer("三班长", 2000);
        MilitaryPerson[] 士兵 = new MilitarySoldier[60];
        for (int i = 0; i < 士兵.length; i++) {
            士兵[i] = new MilitarySoldier("小兵", 1000);
        }
        连长.add(排长1);
        连长.add(排长2);
        排长1.add(班长11);
        排长1.add(班长12);
        排长1.add(班长13);
        排长2.add(班长21);
        排长2.add(班长22);
        排长2.add(班长23);
        for (int i = 0; i <= 9; i++) {
            班长11.add(士兵[i]);
            班长12.add(士兵[i + 10]);
            班长13.add(士兵[i + 20]);
            班长21.add(士兵[i + 30]);
            班长22.add(士兵[i + 40]);
            班长23.add(士兵[i + 50]);
        }
        System.out.println("一排的军饷:" + ComputerSalary.computerSalary(排长1));
        System.out.println("一班的军饷:" + ComputerSalary.computerSalary(班长11));
        System.out.println("全连的军饷:" + ComputerSalary.computerSalary(连长));
    }
}
