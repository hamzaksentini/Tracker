package tracker.com.service.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tracker.com.entity.User;
import tracker.com.entity.WorkTime;
import tracker.com.repository.WorkTimeRepository;
import tracker.com.service.UserService;

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
    public void execute(WorkTimeDelegateExecution delegateExecution) throws Exception {
        WorkTime workTime = new WorkTime();
        User employee = userService.findById(delegateExecution.getEmployeeId());
        workTime.setEmployee(employee);

        workTimeRepository.save(workTime);
    }
}
