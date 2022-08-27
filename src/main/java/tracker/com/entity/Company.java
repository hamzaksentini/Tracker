package tracker.com.entity;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Moritz Schulze
 */
@Data
@Entity
@Table(name = "T_COMPANY")
public class Company extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    private Integer timeForPayment;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "company")
    private List<Project> projects = new ArrayList<>();

}