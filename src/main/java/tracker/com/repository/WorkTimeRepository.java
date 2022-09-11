package tracker.com.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import tracker.com.entity.User;
import tracker.com.entity.WorkTime;

import java.util.Optional;

public interface WorkTimeRepository extends JpaRepository<WorkTime, Long> {

}