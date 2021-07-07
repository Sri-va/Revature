import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JDefaultConfig {
    private static final Logger
    LOGGER = LogManager.getLogger(Log4JDefaultConfig.class);
    public static void main(String[] args) {
    LOGGER.info("This is an INFO level log message!");
    LOGGER.error("This is an ERROR level log message!");
    MyObj obj = new MyObj();
    obj.s="hello str";
    LOGGER.trace("hello trace {}", obj.toString());
    }
}

class MyObj {
	public String s;
	
	@Override
	public String toString() {
		return s;
	}
}