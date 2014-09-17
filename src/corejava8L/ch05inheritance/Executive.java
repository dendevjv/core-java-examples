package corejava8L.ch05inheritance;

public class Executive extends Manager {

	public Executive(String name, double salary) {
		super(name, salary);
	}
	
	public final void goToMonako() {
		System.out.println(getName() + " is going to Monako");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Executive e = new Executive("BigBoss", 1000000);
		System.out.println(e);
		e.goToMonako();
	}

}
