package sia.knights;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sia.knights.config.KnightConfig;

public class KnightMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = applicationContext.getBean(Knight.class);
        knight.embarkOnQuest();
        applicationContext.close();
    }
}
