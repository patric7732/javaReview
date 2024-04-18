package review.collectionTest;

import java.util.Calendar;
import java.util.Date;

public class DateExam {
    public static void main(String[] args) {
        Date date = new Date(2020, 1, 1);
        Date date2 = new Date();

        System.out.println(date);
        if(date2.after(date)) {
            System.out.println("date2는 date1 이후의 날짜입니다.");
        }

        Calendar calendar =  Calendar.getInstance();

        System.out.println(calendar);

        System.out.println(calendar.get(Calendar.MONTH) + 1);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.DATE));

        calendar.set(2020, Calendar.JANUARY, 1);

        System.out.println(calendar.MONTH);
    }
}
