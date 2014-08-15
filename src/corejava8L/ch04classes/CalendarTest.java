package corejava8L.ch04classes;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalendarTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale ruLocale = new Locale("ru", "RU");
		Locale.setDefault(ruLocale);
		GregorianCalendar d = new GregorianCalendar();
		
		// Capture the current day and month
		int today = d.get(Calendar.DAY_OF_MONTH);
		int month = d.get(Calendar.MONTH);
		
		// Get the weekday of the first of the month
		d.set(Calendar.DAY_OF_MONTH, 1);
		int weekday = d.get(Calendar.DAY_OF_WEEK);
		
		// Determine the required indentation
		int firstDayOfWeek = d.getFirstDayOfWeek();
		int indent = 0;
		while (weekday != firstDayOfWeek) {
			indent++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}
		// Print the header
		String[] weekdaysNames = new DateFormatSymbols(ruLocale).getShortWeekdays();
		do {
			System.out.printf("%4s", weekdaysNames[weekday]);
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		} while (weekday != firstDayOfWeek);
		System.out.println();
		
		for (int i = 1; i <= indent; i++) {
			System.out.printf("    ");
		}
		d.set(Calendar.DAY_OF_MONTH, 1);
		do {
			int day = d.get(Calendar.DAY_OF_MONTH); 
			System.out.printf("%3d", day);
			if (day == today) {
				System.out.print("*");
			} else {
				System.out.print(" ");
			}
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
			if (weekday == firstDayOfWeek) {
				System.out.println();
			}
		} while (month == d.get(Calendar.MONTH));
		if (weekday != firstDayOfWeek) {
			System.out.println();
		}
	}

}
