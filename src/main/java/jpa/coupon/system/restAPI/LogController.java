package jpa.coupon.system.restAPI;

import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogController {

	private Logger logger;

	public LogController(Class cls) {
		logger = (Logger) LogManager.getLogger(cls);
	}

	public Logger getLogger() {
		return logger;
	}

	public void debug(String debug) {
		logger.debug(debug);
	}

	public void info(String info) {
		logger.info(info);
	}

	public void warn(String warn) {
		logger.warn(warn);
	}

	public void error(String error) {
		logger.warn(error);
	}

	public String getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		Date s = cal.getTime();
		return "[ Date: " + s + " ]:";
	}

}
