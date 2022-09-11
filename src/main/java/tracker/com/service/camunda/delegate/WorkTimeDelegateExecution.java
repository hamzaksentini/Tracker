package tracker.com.service.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import java.time.Month;
import java.time.Year;

public class WorkTimeDelegateExecution {

    public static String PARAM_EMPLOYEE_ID = "employee-id";
    public static String PARAM_MONTH = "month";
    public static String PARAM_YEAR = "year";
    public static String PARAM_WORK_TIME_ID = "work-time-id";

    private final DelegateExecution delegateExecution;

    public WorkTimeDelegateExecution(DelegateExecution delegateExecution) {
        this.delegateExecution = delegateExecution;
    }

    public Long getEmployeeId() {
        return (Long) delegateExecution.getVariable(PARAM_EMPLOYEE_ID);
    }

    public void setWorkTimeId(Long workTimeId) {
        delegateExecution.setVariable(PARAM_WORK_TIME_ID, workTimeId);
    }

    public Month geMonth() {
        Integer month = (Integer) delegateExecution.getVariable(PARAM_MONTH);
        return Month.of(month);
    }

    public Year getYear() {
        Integer year = (Integer) delegateExecution.getVariable(PARAM_YEAR);
        return Year.of(year);
    }

    public Long getWorkTimeId() {
        return (Long) delegateExecution.getVariable(PARAM_WORK_TIME_ID);
    }
}
