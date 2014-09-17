package testsomething;

import java.util.Arrays;

public abstract class Foo1 implements Comparable<Foo1>, HavingRank {
	@Override
	public abstract int rank();

	@Override
	final public int compareTo(Foo1 o) {
		return rank() - o.rank();
	}
	
	public static void main(String[] args) {
		Foo1 f1 = new Foo2(10);
		Foo1 f2 = new Foo2(1);
		Foo1 f3 = new Foo3(4, 2);
		Foo1 f4 = new Foo3(2, 10);
		
		
		Foo1[] a = new Foo1[] {f1, f2, f3, f4};
		System.out.println(Arrays.toString(a));
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		Foo3 f5 = (Foo3) f3;
		System.out.println(f5);
		Foo3 f6 = f5.clone();
		System.out.println(f6);
	}
}
