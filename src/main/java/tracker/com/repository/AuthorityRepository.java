package tracker.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tracker.com.entity.Authority;
import tracker.com.entity.Company;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

}