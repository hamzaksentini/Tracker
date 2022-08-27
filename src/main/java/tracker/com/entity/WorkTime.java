package tracker.com.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Moritz Schulze
 */
@Entity
@Data
@Table(name = "T_WORK_TIME")
public class WorkTime extends AbstractAuditingEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id")
    private User employee;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany
    @JoinColumn(name = "work_time_id")
    private List<DailyWorkTime> dailyWorkTimes;

    private String comment;

}