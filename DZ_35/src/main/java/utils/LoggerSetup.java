package utils;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/*public class LoggerSetup {
    public static Logger setupLogger(Class<?> clazz) {
        Logger logger = Logger.getLogger(clazz);
        //PropertyConfigurator.configure("log4j.properties");
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        return Logger.getLogger(clazz);
    }
}*/


/*public class LoggerSetup {
    private static final Logger logger = LogManager.getLogger(FormTest.class);

    public static void main(String[] args) {
        logger.info("This is a log message.");
    }

    public static Logger setupLogger(Class<?> clazz) {
        return Logger.getLogger(clazz.getName());
    }
}*/

public class LoggerSetup {
    public static Logger setupLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }
}