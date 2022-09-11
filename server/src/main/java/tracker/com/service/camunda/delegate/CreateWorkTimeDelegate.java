package tracker.com.service.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tracker.com.entity.User;
import tracker.com.entity.WorkTime;
import tracker.com.repository.WorkTimeRepository;
import tracker.com.service.UserService;

import java.util.ArrayList;

@Slf4j
@Component
public class CreateWorkTimeDelegate implements WorkTimeDelegate {

    private final WorkTimeRepository workTimeRepository;
    private final UserService userService;

    public CreateWorkTimeDelegate(WorkTimeRepository workTimeRepository, UserService userService) {
        this.workTimeRepository = workTimeRepository;
        this.userService = userService;
    }

    @Override
    public void execute(WorkTimeDelegateExecution delegateExecution) {
        WorkTime workTime = new WorkTime();
        User employee = userService.findById(delegateExecution.getEmployeeId());
        workTime.setEmployee(employee);
        workTime.setProject(employee.getProject());
        workTime.setDailyWorkTimes(new ArrayList<>());
        workTime.setMonth(delegateExecution.geMonth());
        workTime.setYear(delegateExecution.getYear());
        WorkTime createdWorkTime = workTimeRepository.save(workTime);
        delegateExecution.setWorkTimeId(createdWorkTime.getId());
    }
}
