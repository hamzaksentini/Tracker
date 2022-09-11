package tracker.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tracker.com.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

}