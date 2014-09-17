package testsomething;

import java.util.Arrays;


public class TestSomething {
	

	public static void main(String... args) throws Exception, SecurityException  {
		int[] a = {3, 5, 7};
		int[] b = (int[]) a.clone();
		System.out.println(a.equals(b));
		System.out.println(Arrays.equals(a, b));
		System.out.println(Arrays.toString(b));
	}
}
