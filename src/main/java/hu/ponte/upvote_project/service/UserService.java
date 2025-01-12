package hu.ponte.upvote_project.service;

import hu.ponte.upvote_project.domain.ApplicationUser;
import hu.ponte.upvote_project.dto.incoming.UserRegisterCommand;
import hu.ponte.upvote_project.dto.outgoing.ApplicationUserDetails;
import hu.ponte.upvote_project.dto.outgoing.CustomUserDetails;
import hu.ponte.upvote_project.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public ApplicationUserDetails registerUser(UserRegisterCommand command) {
        validateUsername(command);
        String hashedPassword = hashPassword(command.getPassword());

        ApplicationUser user = new ApplicationUser(command.getUsername(), hashedPassword);
        userRepository.save(user);

        return modelMapper.map(user, ApplicationUserDetails.class);
    }

    public CustomUserDetails loginUser(String username, String password) {
        ApplicationUser user = userRepository.findByName(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Bad credentials");
        }

        return new CustomUserDetails(user);
    }

    private void validateUsername(UserRegisterCommand command) {
        if (userRepository.findByName(command.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already registered");
        }
    }

    private String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
