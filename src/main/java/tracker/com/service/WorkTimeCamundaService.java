package tracker.com.service;

import org.springframework.stereotype.Service;
import tracker.com.entity.User;

import java.time.YearMonth;
import java.util.HashMap;

@Service
public class WorkTimeCamundaService {

    public static final String PROCESS_WORK_TIME = "Process_WorkTime";
    private final WorkflowEngine workflowEngine;

    public WorkTimeCamundaService(WorkflowEngine workflowEngine) {
        this.workflowEngine = workflowEngine;
    }

    public void create(User employee, YearMonth yearMonth) {
        workflowEngine.startProcessInstance(PROCESS_WORK_TIME, buildBusinessKey(employee, yearMonth), new HashMap<>());
    }

    private String buildBusinessKey(User employee, YearMonth yearMonth) {
        return employee.getLogin() + "_" + yearMonth.getMonth().getValue() + "_" + yearMonth.getYear() ;
    }
}
