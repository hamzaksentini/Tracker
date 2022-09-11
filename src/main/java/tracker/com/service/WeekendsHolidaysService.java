package tracker.com.service;

import org.springframework.stereotype.Service;
import tracker.com.service.dto.WeekEndsHolidaysDTO;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeekendsHolidaysService {

    public List<WeekEndsHolidaysDTO> findByMonthAndYear(YearMonth yearMonth) {
        return new ArrayList<>();
    }

}
