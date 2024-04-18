package review.collectionTest;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarExam {

    public static void prtMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        System.out.println(year + "년 " + month + "월");
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        cal.set(year, month - 1, 1);

        // 해당 월의 첫 번째 요일
        int week = cal.get(Calendar.DAY_OF_WEEK);
        // 해당 월의 마지막 날짜
        int last = cal.getActualMaximum(Calendar.DATE);

        // 첫 번째 요일 전까지 공백으로 채우기
        for (int i = 1; i < week; i++) {
            System.out.print("\t");
        }

        // 해당 월의 날짜 출력
        for (int i = 1; i <= last; i++) {
            System.out.print(i + "\t");
            if (week % 7 == 0) { // 토요일이면 다음 줄로 이동
                System.out.println();
            }
            week++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("연도를 입력하세요. : ");
        int year = sc.nextInt();
        System.out.println("월을 입력하세요. : ");
        int month = sc.nextInt();

        prtMonth(year, month);
    }
}
