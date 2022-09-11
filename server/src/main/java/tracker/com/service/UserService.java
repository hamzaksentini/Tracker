package tracker.com.service;

import tracker.com.entity.User;
import tracker.com.repository.UserRepository;
import tracker.com.security.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public User findCurrent() {
        String login = SecurityUtils.getCurrentUserName()
                .orElseThrow(() -> new IllegalStateException("Current user login not found"));
        return userRepository.findOneByLogin(login).get();
    }

    @Transactional(readOnly = true)
    public User findById(Long userId) {
        return userRepository.getById(userId);
    }

}
