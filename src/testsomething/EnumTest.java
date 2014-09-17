package testsomething;

import java.util.Scanner;

public class EnumTest {
	enum Size {
		SMALL, 
		MEDIUM("M"),
		LARGE("L"),
		EXTRA_LARGE("XL");
		
		private String abbreviation;
		
		Size() {
			String n = this.toString();
			this.abbreviation = n.substring(0, 1).toUpperCase();
		}
		
		Size(String abbreviation) {
			this.abbreviation = abbreviation;
		}
		
		public String getAbbreviation() {
			return abbreviation;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a size: ");
		String s = in.next().toUpperCase();
		Size sz = Enum.valueOf(Size.class, s);
		System.out.println("size=" + sz);
		System.out.println("abbrebiation=" + sz.getAbbreviation());
		if (sz == Size.EXTRA_LARGE) {
			System.out.println("Good job -- you paid attention to the _");
		}
		in.close();
	}

}
