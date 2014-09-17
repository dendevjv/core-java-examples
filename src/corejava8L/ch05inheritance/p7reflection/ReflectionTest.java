package corejava8L.ch05inheritance.p7reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;


/**
 * Listing 5-6. Core Java, volume I, ch05, p236.
 */
public class ReflectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name = null;
		if (args.length > 0) {
			name = args[0];
		} else {
			Scanner in = new Scanner(System.in);
			System.out.print("Enter class name (e.g. java.util.Date): ");
			name = in.next();
			in.close();
		}

		Class cl = null;
		try {
			cl = Class.forName(name);
			Class supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print("class " + name);
			if (supercl != null && supercl != Object.class) {
				System.out.print(" extends " + supercl.getName());
			}
			System.out.println("\n\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	
	/**
	 * Prints all fields of a class.
	 * @param cl a class
	 */
	private static void printFields(Class cl) {
		Field[] fields = cl.getDeclaredFields();
		
		for (Field f : fields) {
			Class type = f.getType();
			String name = f.getName();
			System.out.print("   ");
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.println(type.getName() + " " + name + ";");
		}
	}
	

	
	/**
	 * Prints all methods of a class.
	 * @param cl a class
	 */
	private static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();
		
		for (Method m : methods) {
			Class retType = m.getReturnType();
			String name = m.getName();

			System.out.print("   ");
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print(retType.getName() + " " + name + "(");
			
			Class[] paramTypes = m.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	/**
	 * Print all constructors of a class.
	 * @param cl a class
	 */
	private static void printConstructors(Class cl) {
		Constructor[] constructors = cl.getDeclaredConstructors();
		
		for (Constructor c : constructors) {
			String name = c.getName();
			System.out.print("   ");
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print(name + "(");
			
			// print parameter types
			Class[] paramTypes = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
		
	}

}
