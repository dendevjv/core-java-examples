import java.text.DateFormatSymbols;
import java.util.Locale;



public class TestSomething {

	public static void main(String[] args) {
		DateFormatSymbols dfs = new DateFormatSymbols(new Locale("ru", "RU"));
		String[] months = dfs.getMonths();
		for (String m : months) {
			System.out.print(m + " ");
		}
		System.out.println();
		
		String[] wd = dfs.getWeekdays();
		for (String d : wd) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
}
