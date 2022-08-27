package tracker.com.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "T_DAILY_WORK_TIME")
public class DailyWorkTime extends AbstractAuditingEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Double hoursWorked;

    @NotNull
    private LocalDate date;




}
