package tracker.com.service;

import org.zalando.problem.AbstractThrowableProblem;

import static org.zalando.problem.Status.INTERNAL_SERVER_ERROR;

public class InternalServerErrorException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public InternalServerErrorException(String message) {
        super(ErrorConstants.DEFAULT_TYPE, message, INTERNAL_SERVER_ERROR);
    }
}
