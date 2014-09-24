/*
 * Listing 6-6
 */
package corejava8L.ch06.p4innerclasses;

import java.util.Arrays;

public class StaticInnerClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] d = new double[10];
		for (int i = 0; i < d.length; i++) {
			d[i] = Math.random();
		}
		System.out.println(Arrays.toString(d));
		ArrayAlg.Pair p = ArrayAlg.minmax(d);
		System.out.println("min=" + p.getFirst());
		System.out.println("max=" + p.getSecond());
	}

}

class ArrayAlg {
	public static class Pair {
		private double first;
		private double second;
		
		public Pair(double f, double s) {
			this.first = f;
			this.second = s;
		}

		public final double getFirst() {
			return first;
		}

		public final double getSecond() {
			return second;
		}
	}
	
	public static Pair minmax(double[] a) {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (double v : a) {
			if (v < min) {
				min = v;
			}
			if (v > max) {
				max = v;
			}
		}
		return new Pair(min, max);
	}
}
