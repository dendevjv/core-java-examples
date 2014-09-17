package corejava8L.ch11.logging;

import java.io.OutputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestSomething {
	static Logger logDefaultHandler;
	static Logger logMyHandler;
	static {
		Handler handler = new ConsoleHandler() {
//			{
//				this.setOutputStream(System.out);
//			}
		};
		handler.setLevel(Level.FINER);
		
		logDefaultHandler = Logger.getLogger("corejava8.ch11.logging");
		logDefaultHandler.setUseParentHandlers(false);
		logDefaultHandler.setLevel(Level.INFO);
		logDefaultHandler.addHandler(handler);
		
		logMyHandler = Logger.getLogger("corejava8.ch11.logging.TestSomething");
		logMyHandler.setUseParentHandlers(false);
		logMyHandler.setLevel(Level.FINER);
		logMyHandler.addHandler(handler);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("before myLogger1");
		logDefaultHandler.info("myLogger1: main()");
		System.out.println("after myLogger1");
		
		System.out.println();
		
		foo(1);
		System.out.println("before myLogger2");
		logMyHandler.fine("myLogger2: main()");
		System.out.println("after myLogger2");
		foo(2);
	}
	
	public static void foo(int n) {
		logMyHandler.entering("TestSomething", "foo");
		System.out.println("foo(): " + n);
		logMyHandler.exiting("TestSomething", "foo");
	}

}
