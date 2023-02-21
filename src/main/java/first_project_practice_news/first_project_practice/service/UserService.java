package first_project_practice_news.first_project_practice.service;

import first_project_practice_news.first_project_practice.model.User;
import first_project_practice_news.first_project_practice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user==null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return user;
    }
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
