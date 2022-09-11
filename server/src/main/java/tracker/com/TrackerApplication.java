package tracker.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({TrackerProperties.class})
@SpringBootApplication
public class TrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackerApplication.class, args);
    }


}
