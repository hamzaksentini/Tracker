package tracker.com.service.camunda;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.task.Task;
import org.springframework.stereotype.Component;
import tracker.com.service.InternalServerErrorException;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class WorkflowEngine {

    private final ProcessEngine camunda;

    public WorkflowEngine(ProcessEngine camunda) {
        this.camunda = camunda;
    }

    public void startProcessInstance(String key, String businessKey, Map<String, Object> processVariables) {
        camunda.getRuntimeService().startProcessInstanceByKey(key, businessKey, processVariables).getProcessDefinitionId();
    }

    public void completeTask(String processDefinitionKey, String businessKey, String taskDefinitionKey, Map<String, Object> variables) {
        Task task = getTask(processDefinitionKey, businessKey, taskDefinitionKey)
                .orElseThrow(() -> new InternalServerErrorException(taskNotFoundErrorMessage(processDefinitionKey, businessKey, taskDefinitionKey)));
        camunda.getTaskService().complete(task.getId(), variables);
    }


    private String taskNotFoundErrorMessage(String processDefinitionKey, String businessKey, String taskDefinitionKey) {
        return "No Task found with processDefinitionKey: '" + processDefinitionKey + "', businessKey: '" + businessKey + "' and taskDefinitionKey: '" + taskDefinitionKey + "'";
    }

    public Optional<Task> getTask(String processDefinitionKey, String businessKey, String taskDefinitionKey) {
        Task task = camunda.getTaskService().createTaskQuery()
                .processInstanceBusinessKeyIn(businessKey)
                .processDefinitionKey(processDefinitionKey)
                .taskDefinitionKey(taskDefinitionKey)
                .singleResult();
        return Optional.ofNullable(task);
    }

}
