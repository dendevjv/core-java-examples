package corejava8L.ch04classes.p2;

import corejava8L.ch04classes.p1.*;

public class TestFoo {
	public void useInp2() {
		Inp2 i2 = new Inp2();
		i2.display();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("TestFoo class, main() method");
		Bar bar = new Bar();
		bar.display();
		Foo foo = new Foo();
		foo.display();
		Inp2 i2 = new Inp2();
		i2.display();
	}

}
