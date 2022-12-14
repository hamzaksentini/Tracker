package tracker.com.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "T_PROJECT")
public class Project extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Min(0)
    private BigDecimal dailyRate;

}