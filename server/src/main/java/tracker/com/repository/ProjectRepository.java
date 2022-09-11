package tracker.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tracker.com.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}