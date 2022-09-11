package tracker.com.service.dto;

import lombok.Data;

@Data
public class WeekEndsHolidaysDTO {

    private final String date;
    private final Boolean isWeekEnd;
    private final Boolean isHoliday;

}
