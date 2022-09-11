package tracker.com.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * @author Moritz Schulze
 */
@Data
@Entity
@Table(name = "T_COMPANY")
public class Company extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    private Integer timeForPayment;

}