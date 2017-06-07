import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by lichengzhao@foxmail.com on 2015/9/24.
 */
public class Launcher {
    private final static Logger logger = LoggerFactory.getLogger(Launcher.class);
    public static void main(String[] args) throws InterruptedException, IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        context.start();
        logger.info("service publish success...");
        while (true) {
            int read = System.in.read();
            logger.info("System.in.read : ", read);
            if (read == '9') {
                logger.info("EXIST.");
                context.close();
                break;
            }
        }
    }

}
