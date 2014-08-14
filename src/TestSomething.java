import java.util.Arrays;



public class TestSomething {

	public static void main(String[] args) {
		int[] sn = {2, 3, 5, 7, 11, 13};
		int[] ln = {101, 102, 103, 104, 105, 106, 107};
		System.arraycopy(sn, 2, ln, 3, 4);
		System.out.println(Arrays.toString(ln));
	}
	
}
