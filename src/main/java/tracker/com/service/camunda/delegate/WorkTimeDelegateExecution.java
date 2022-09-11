package tracker.com.service.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class WorkTimeDelegateExecution {

    public static String PARAM_EMPLOYEE_ID = "employee-id";
    public static String PARAM_MONTH = "month";
    public static String PARAM_YEAR = "year";

    private final DelegateExecution delegateExecution;

    public WorkTimeDelegateExecution(DelegateExecution delegateExecution) {
        this.delegateExecution = delegateExecution;
    }

    public Long getEmployeeId() {
        return (Long) delegateExecution.getVariable(PARAM_EMPLOYEE_ID);
    }
}
