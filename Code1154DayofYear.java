/**
 * @Author: ybchen
 * @Date: 2021/6/24 13:39
 */
public class Code1154DayofYear {
    public final int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    //date = "2019-02-10" 41

    public int dayOfYear(String date) {
        int year = Integer.valueOf(date.substring(0, 5));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8));
        boolean isLeapYear = isLeapYear(year);
        int result = 0;
        for (int i = 0; i < month; i++) {
            result = result + daysOfMonth[i];
        }
        result = result + day;
        if (month > 2 && isLeapYear) {
            result = result + 1;
        }
        return result;
    }

    public boolean isLeapYear(int year) {

        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }
}
