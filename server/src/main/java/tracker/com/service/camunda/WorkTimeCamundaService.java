package tracker.com.service.camunda;

import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.HashMap;

import static tracker.com.service.camunda.delegate.WorkTimeDelegateExecution.*;

@Service
public class WorkTimeCamundaService {

    public static final String PROCESS_WORK_TIME = "Process_WorkTime";
    private final WorkflowEngine workflowEngine;

    public WorkTimeCamundaService(WorkflowEngine workflowEngine) {
        this.workflowEngine = workflowEngine;
    }

    public void create(Long employeeId, YearMonth yearMonth) {
        HashMap<String, Object> processVariables = new HashMap<>();

        processVariables.put(PARAM_EMPLOYEE_ID, employeeId);
        processVariables.put(PARAM_MONTH, yearMonth.getMonth().getValue());
        processVariables.put(PARAM_YEAR, yearMonth.getYear());

        workflowEngine.startProcessInstance(PROCESS_WORK_TIME, buildBusinessKey(employeeId, yearMonth), processVariables);
    }

    private String buildBusinessKey(Long employeeId, YearMonth yearMonth) {
        return employeeId + "_" + yearMonth.getMonth().getValue() + "_" + yearMonth.getYear() ;
    }
}
