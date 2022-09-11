package tracker.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tracker.com.entity.Company;
import tracker.com.entity.Project;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}