package tracker.com;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

@Data
@ConfigurationProperties(prefix = "tracker", ignoreUnknownFields = false)
public class TrackerProperties {

    private CorsConfiguration cors;

}
