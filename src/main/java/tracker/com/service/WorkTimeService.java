package tracker.com.service;

import org.springframework.stereotype.Service;
import tracker.com.entity.User;
import tracker.com.service.camunda.WorkTimeCamundaService;
import tracker.com.service.dto.WorkTimeDTO;
import tracker.com.service.dto.WorkTimeDetailsDTO;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkTimeService {

    private final WorkTimeCamundaService workTimeCamundaService;

    public WorkTimeService(WorkTimeCamundaService workTimeCamundaService) {
        this.workTimeCamundaService = workTimeCamundaService;
    }

    public void create(Long employeeId, YearMonth yearMonth) {
        workTimeCamundaService.create(employeeId, yearMonth);
    }

    public List<WorkTimeDTO> findAllByUserId(Long userId) {
        return new ArrayList<>();
    }

    public WorkTimeDetailsDTO finDetails(Long workId) {
        return new WorkTimeDetailsDTO();
    }

}
