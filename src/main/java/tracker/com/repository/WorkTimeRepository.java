package tracker.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tracker.com.entity.WorkTime;

import java.time.Month;
import java.time.Year;
import java.util.Optional;

public interface WorkTimeRepository extends JpaRepository<WorkTime, Long> {

    Optional<WorkTime> findByEmployeeIdAndMonthAndYear(Long id, Month month, Year year);
}