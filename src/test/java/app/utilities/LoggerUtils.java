package app.utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoggerUtils {
    //    This Util class is used to log info in Test classes
    private static Logger logger = LogManager.getLogger(LoggerUtils.class.getName());
    public static void debug(String message){
        logger.debug(message);
    }
    public static void info(String message){
        logger.info(message);
    }
    public static void warn(String message){
        logger.warn(message);
    }
    public static void error(String message){
        logger.error(message);
    }
    public static void fatal(String message){
        logger.fatal(message);
    }
}