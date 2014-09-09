public class Foo {
	private static int nextId;
	
	static {
		System.out.println("Static block in Foo");
		System.out.println("nextId = " + nextId);
		nextId = initNextId();
	}
	
	private int id = initId();
	
	public Foo() {
		System.out.println("Constructor Foo()");
		System.out.println("nextId = " + nextId);
	}
	
	private static int initNextId() {
		int n = (int) (Math.random() * 100);
		System.out.println("Initializing nextId: " + n);
		return n;
	}
	
	private int initId() {
		int n = nextId;
//		System.out.println("Initializing id: " + n);
		nextId++;
		return n;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
