package tracker.com.service.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public interface WorkTimeDelegate extends JavaDelegate {

    default void execute(DelegateExecution var1) throws Exception {
        WorkTimeDelegateExecution workTimeDelegateExecution = new WorkTimeDelegateExecution(var1);
        execute(workTimeDelegateExecution);
    }

    void execute(WorkTimeDelegateExecution var1) throws Exception;

}
