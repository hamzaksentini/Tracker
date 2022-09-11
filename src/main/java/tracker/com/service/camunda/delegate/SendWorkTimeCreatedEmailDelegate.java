package tracker.com.service.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tracker.com.entity.WorkTime;
import tracker.com.repository.WorkTimeRepository;
import tracker.com.service.EmailService;

@Slf4j
@Component
public class SendWorkTimeCreatedEmailDelegate implements WorkTimeDelegate {

    private final EmailService emailService;
    private final WorkTimeRepository workTimeRepository;

    public SendWorkTimeCreatedEmailDelegate(EmailService emailService, WorkTimeRepository workTimeRepository) {
        this.emailService = emailService;
        this.workTimeRepository = workTimeRepository;
    }

    @Override
    public void execute(WorkTimeDelegateExecution delegateExecution) throws Exception {
        WorkTime workTime = workTimeRepository.getById(delegateExecution.getWorkTimeId());
        emailService.sendCreatedEmail(workTime);
    }
}
