package tracker.com;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

@Data
@ConfigurationProperties(prefix = "tracker", ignoreUnknownFields = false)
public class TrackerProperties {

    private CorsConfiguration cors;
    private final Mail mail = new Mail();

    @Setter
    @Getter
    public static class Mail {
        private String from;
        private String baseUrl;
    }


}
