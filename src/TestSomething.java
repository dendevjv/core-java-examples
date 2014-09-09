public class TestSomething {

	public static void main(String[] args) {
		System.out.println("Starting main()");
		sleep(2);
		
		System.out.println("Defining Foo f");
		Foo f = new Foo();
		
		sleep(2);
//		Foo f2 = new Foo();
		System.out.println("Finishing main()");
	}

	private static void sleep(int sec) {
		System.out.printf("about to sleep %d sec%n", sec);
		long millis = sec * 1000;
		try {
			Thread.sleep(millis );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
