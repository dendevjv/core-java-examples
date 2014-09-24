package testsomething;

public interface AnInterface {
	class Foo {
		private String s = "JustSimpleFoo";
		
		@Override
		public String toString() {
			return s;
		}
	}
	
	Foo getFoo();
}
