package tracker.com.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tracker.com.entity.Authority;
import tracker.com.entity.Company;
import tracker.com.entity.Project;
import tracker.com.entity.User;
import tracker.com.repository.*;
import tracker.com.security.AuthoritiesConstants;

import java.math.BigDecimal;
import java.time.Year;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@SpringBootTest
@ActiveProfiles("test")
class WorkTimeServiceTest {

    @Autowired
    private WorkTimeService workTimeService;
    @Autowired
    private UserService userService;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WorkTimeRepository workTimeRepository;

    @BeforeEach
    public void beforeEach() {
        workTimeRepository.deleteAll();
        userRepository.deleteAll();
        authorityRepository.deleteAll();
        projectRepository.deleteAll();
        companyRepository.deleteAll();
    }

    @Test
    void should_create_work_time() {
        // Given
        Company company = new Company();
        company.setName("SG");
        company.setTimeForPayment(2);
        Company createdCompany = companyRepository.save(company);
        Project project = new Project();
        project.setName("SG-HAMZA");
        project.setDailyRate(BigDecimal.TEN);
        project.setCompany(createdCompany);
        Project createdProject = projectRepository.save(project);
        User employee = new User();
        employee.setEmail("hamza@gmail.com");
        employee.setLogin("hamzaKs");
        employee.setFirstName("Hamza");
        employee.setLastName("Kessentini");
        employee.setPassword("password");
        Set<Authority> userAuthorities = new HashSet<>();
        Authority employeeAuthority = new Authority();
        employeeAuthority.setName(AuthoritiesConstants.EMPLOYEE);
        Authority authority = authorityRepository.save(employeeAuthority);
        userAuthorities.add(authority);
        employee.setAuthorities(userAuthorities);
        employee.setProject(createdProject);
        User createdEmployee = userRepository.save(employee);
        YearMonth yearMonth = YearMonth.of(2022, 9);

        // When
        workTimeService.create(createdEmployee.getId(), yearMonth);
        // Then

        await()
                .timeout(10, TimeUnit.SECONDS)
                .until(() ->
                        workTimeRepository.findByEmployeeIdAndMonthAndYear(
                                createdEmployee.getId(),
                                yearMonth.getMonth(),
                                Year.of(yearMonth.getYear())
                        ).isPresent()
                );

    }
}