package tracker.com.service;

import org.springframework.stereotype.Service;
import tracker.com.entity.User;

import java.time.YearMonth;

@Service
public class WorkTimeService {

    private final WorkTimeCamundaService workTimeCamundaService;

    public WorkTimeService(WorkTimeCamundaService workTimeCamundaService) {
        this.workTimeCamundaService = workTimeCamundaService;
    }

    public void create(User employee, YearMonth yearMonth){
        workTimeCamundaService.create(employee, yearMonth);
    }

}
