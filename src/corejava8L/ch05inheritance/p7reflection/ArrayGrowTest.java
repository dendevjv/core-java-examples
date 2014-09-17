/*
 * Listing 5-8.
 */
package corejava8L.ch05inheritance.p7reflection;

import java.lang.reflect.Array;

public class ArrayGrowTest {

	public static void main(String[] args) {
		double[] a = {1, 2, 3};
		arrayPrint(a);
		
		String[] b = {"Tom", "Dick", "Harry"};
		b = (String[]) goodArrayGrow(b);
		arrayPrint(b);
//		b = (String[]) badArrayGrow(b);
//		Object[] c = badArrayGrow(b);
//		arrayPrint(c);
	}
	
	/**
	 * Grows an array by allocating a new array of the same type
	 * and copying all elements.
	 * @param a the array to grow
	 * @return a larger array that contains all elements of a
	 */
	static Object goodArrayGrow(Object a) {
		Class<? extends Object> cl = a.getClass();
		if (!cl.isArray()) return null;
		Class<?> componentType = cl.getComponentType();
		int length = Array.getLength(a);
		int newLength = length * 11 / 10 + 10;
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray, 0, length);
		return newArray;
	}
	
	static Object[] badArrayGrow(Object[] a) {
		int newLength = a.length * 11 / 10 + 10;
		Object[] newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, a.length);
		return newArray;
	}

	/**
	 * A convenience method to print all elements in an array.
	 * @param a the array to print (object array or primitive type array)
	 */
	static void arrayPrint(Object a) {
		Class<? extends Object> cl = a.getClass();
		if (!cl.isArray()) return;
		Class<?> componentType = cl.getComponentType();
		int length = Array.getLength(a);
		System.out.print(componentType.getName() + "[" + length + "] = {");
		for (int i = 0; i < length; i++) {
			System.out.print(Array.get(a, i) + " ");
		}
		System.out.println("}");
	}
}
