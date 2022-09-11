package tracker.com.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tracker.com.resource.request.SubmitWorkTimeRequest;
import tracker.com.service.WorkTimeService;
import tracker.com.service.dto.WorkTimeDetailsDTO;

@RestController("api/workTimes")
public class WorkTimeResource {

    private final WorkTimeService workTimeService;

    public WorkTimeResource(WorkTimeService workTimeService) {
        this.workTimeService = workTimeService;
    }

    @GetMapping("/{workTimeId}")
    public ResponseEntity<WorkTimeDetailsDTO> getWorkTimesDetails(@PathVariable long workTimeId) {
        WorkTimeDetailsDTO workTimeDetailsDTO = workTimeService.finDetails(workTimeId);
        return ResponseEntity.ok(workTimeDetailsDTO);
    }

    public void submitWorkTime(SubmitWorkTimeRequest submitWorktimeRequest) {
    }
}
