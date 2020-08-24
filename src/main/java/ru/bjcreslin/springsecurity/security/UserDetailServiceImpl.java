package ru.bjcreslin.springsecurity.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.bjcreslin.springsecurity.model.User;
import ru.bjcreslin.springsecurity.repository.UserRepository;


@Service("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            throw new UsernameNotFoundException("User " + email + " does not exist");
        });
        return SecurityUser.fromUser(user);
    }
}
