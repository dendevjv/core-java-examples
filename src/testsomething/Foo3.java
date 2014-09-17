package testsomething;

public class Foo3 extends Foo2 implements Cloneable {
	private int scale;

	Foo3(int value, int scale) {
		super(value);
		this.scale = scale;
	}
	
	Foo3(int value) {
		super(value);
		this.scale = DEFAULT_SCALE;
	}

	@Override
	public int rank() {
		return getValue() * scale;
	}
	
	@Override
	public String toString() {
		return "[" + getValue() + "x" + scale + "]";
	}
	
	@Override
	public Foo3 clone() {
		try {
			return (Foo3) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
