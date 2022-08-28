package tracker.com.service;

import lombok.experimental.UtilityClass;

import java.net.URI;

@UtilityClass
public class ErrorConstants {

    public static final String PROBLEM_BASE_URL = "https://www.tracker.com/problem";
    public static final URI DEFAULT_TYPE = URI.create(PROBLEM_BASE_URL + "/problem-with-message");

}
