package corejava8L.ch05inheritance;

public final class Tsar extends Executive {

	public Tsar(String name) {
		super(name, Double.MAX_VALUE);
	}
	
//	@Override
//	public void goToMonako() {
//		System.out.println(getName() + " is teleporting to Monako");
//	}

	public static void main(String[] args) {
		Tsar t = new Tsar("IvanIV");
		System.out.println(t);
		t.goToMonako();
	}
}
