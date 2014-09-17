package corejava8L.ch06.p1interfaces;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
	private static Logger logger;
	private static final Level LOGGING_LEVEL = Level.FINE;
//	private static final Level LOGGING_LEVEL = Level.FINEST;

	static {
		logger = Logger.getLogger(Log.class.getPackage().getName());
		logger.setLevel(LOGGING_LEVEL);

		// Initialize handler
		logger.setUseParentHandlers(false);
		Handler handler = new ConsoleHandler();
		handler.setLevel(LOGGING_LEVEL);
		logger.addHandler(handler);
	}

	public static void info(String msg) {
		logger.info(msg);
	}

	public static void severe(String msg) {
		logger.severe(msg);
	}

	public static void warning(String msg) {
		logger.warning(msg);
	}

	public static void fine(String msg) {
		logger.fine(msg);
	}

	public static void finer(String msg) {
		logger.finer(msg);
	}

	public static void finest(String msg) {
		logger.finest(msg);
	}

	private Log() {
	}
}
