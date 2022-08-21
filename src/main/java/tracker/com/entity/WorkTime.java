package tracker.com.entity;

import liquibase.hub.model.Project;
import lombok.Getter;
import lombok.Setter;
import tracker.com.entity.Employee;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * @author Moritz Schulze
 */
@Entity
@Getter
@Setter
public class WorkTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "employee")
    private Employee employee;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "project")
    private Project project;


    @NotNull
    @Temporal(TemporalType.DATE)
    private List<DayWorkTime> dayWorkTime ;



    private String comment;

}