package tracker.com.entity;

import lombok.Data;
import tracker.com.entity.converter.YearAttributeConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Month;
import java.time.Year;
import java.util.List;

/**
 * @author Moritz Schulze
 */
@Entity
@Data
@Table(name = "T_WORK_TIME")
public class WorkTime extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id")
    private User employee;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "project_id")
    private Project project;

    private String comment;

    @NotNull
    @Column(name = "month", columnDefinition = "smallint")
    @Enumerated
    private Month month;

    @NotNull
    @Column(name = "year", columnDefinition = "smallint")
    @Convert(converter = YearAttributeConverter.class)
    private Year year;

    @OneToMany
    @JoinColumn(name = "work_time_id")
    private List<RegularWorkTime> dailyWorkTimes;

}