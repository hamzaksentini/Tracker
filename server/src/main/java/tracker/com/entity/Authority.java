package tracker.com.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_authority")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String name;

}