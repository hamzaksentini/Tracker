package tracker.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents any employee of techdev.
 */
@Entity
@Getter
@Setter
@JsonIgnoreProperties({"credential", "workTimes", "billableTimes", "vacationRequests", "approvedRequests", "travelExpenseReports"})

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Column(unique = true)
    @Email
    @NotNull
    private String email;

    private String phoneNumber;

    private String title;

    private BigDecimal salary;

    private BigDecimal hourlyCostRate;

    @Temporal(TemporalType.DATE)
    private Date joinDate;

    @Temporal(TemporalType.DATE)
    private Date leaveDate;


    private Float vacationEntitlement;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "employee")
    private List<WorkTime> workTimes = new ArrayList<>();


    private boolean deleted;

    public String fullName() {
        return getFirstName() + " " + getLastName();
    }
}