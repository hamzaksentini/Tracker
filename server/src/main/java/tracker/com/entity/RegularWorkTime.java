package tracker.com.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;

@Data
@Entity
@Table(name = "T_REGULAR_WORK_TIME")
public class RegularWorkTime extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Double duration;

    @Enumerated(STRING)
    @NotNull
    private WorkUnitType type;

    @NotNull
    private LocalDate startDate;

}
