/*
 * Listing 5-7.
 */
package corejava8L.ch05inheritance.p7reflection;

import java.util.ArrayList;

public class ObjectAnalyzerTest {

	public static void main(String[] args) {
		ArrayList<Integer> squares = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			squares.add(i * i);
		}
		System.out.println(new ObjectAnalyzer().toString(squares));
	}

}
