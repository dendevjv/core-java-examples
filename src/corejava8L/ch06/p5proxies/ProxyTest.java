/*
 * Listing 6-7
 */
package corejava8L.ch06.p5proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
	public static void main(String[] args) {
		Object[] elements = new Object[1000];
		
		@SuppressWarnings("rawtypes")
		Class[] interfaces = new Class[] {Comparable.class};
		for (int i = 0; i < elements.length; i++) {
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, interfaces, handler);
			elements[i] = proxy;
		}
		Integer key = new Random().nextInt(elements.length) + 1;
		int result = Arrays.binarySearch(elements, key);
		if (result >= 0) {
			System.out.println(elements[result]);
		}
	}
}

/**
 * An invocation handler that prints out the method name and parameters,
 * then invokes the original method.
 */
class TraceHandler implements InvocationHandler {
	private Object target;
	
	public TraceHandler(Object t) {
		target = t;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// print implicit argument
		System.out.print(target);
		// print method name
		System.out.print("." + method.getName() + "(");
		// print explicit arguments
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]);
				if (i < args.length - 1) {
					System.out.print(", ");
				}
			}
		}
		System.out.println(")");
		// invoke actual method
		return method.invoke(target, args);
	}
}