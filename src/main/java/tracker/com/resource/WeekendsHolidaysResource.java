package tracker.com.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tracker.com.service.WeekendsHolidaysService;
import tracker.com.service.dto.WeekEndsHolidaysDTO;

import java.time.YearMonth;
import java.util.List;

@RestController("api/weekendsHolidays")
public class WeekendsHolidaysResource {

    private final WeekendsHolidaysService weekendsHolidaysService;

    public WeekendsHolidaysResource(WeekendsHolidaysService weekendsHolidaysService) {
        this.weekendsHolidaysService = weekendsHolidaysService;
    }

    @GetMapping("/{year}/{month}")
    public ResponseEntity<List<WeekEndsHolidaysDTO>> getWorkTimesDetails(@PathVariable Integer month, @PathVariable Integer year) {
        List<WeekEndsHolidaysDTO> weekEndsHolidaysDTOS = weekendsHolidaysService.findByMonthAndYear(YearMonth.of(year, month));
        return ResponseEntity.ok(weekEndsHolidaysDTOS);
    }


}
