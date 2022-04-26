package zhugaru.dcl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import zhugaru.dcl.entity.access.Role;
import zhugaru.dcl.entity.access.Status;
import zhugaru.dcl.entity.UserEntity;
import zhugaru.dcl.repository.UserRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUser(UserEntity user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new IllegalArgumentException("An account with that email is already exists:" + user.getEmail());
        user.setRole(Role.USER);
        user.setStatus(Status.ENABLED);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public UserEntity getLoggedInUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return findByEmail(((UserDetails) principal).getUsername());
        } else {
            throw new UsernameNotFoundException("User doesn't exists");
        }
    }

    public UserEntity findByEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isPresent())
            return user.get();
        throw new NoSuchElementException();
    }
}