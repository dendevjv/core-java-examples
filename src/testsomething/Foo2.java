package testsomething;

public class Foo2 extends Foo1 {
	private int value;
	
	Foo2(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public int rank() {
		return value;
	}

	@Override
	public String toString() {
		return "[" + getValue() + "]";
	}
}
