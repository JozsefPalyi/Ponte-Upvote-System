package hu.ponte.upvote_project.controller;

import hu.ponte.upvote_project.dto.incoming.LoginCommand;
import hu.ponte.upvote_project.dto.incoming.UserRegisterCommand;
import hu.ponte.upvote_project.dto.outgoing.ApplicationUserDetails;
import hu.ponte.upvote_project.dto.outgoing.CustomUserDetails;
import hu.ponte.upvote_project.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApplicationUserDetails> register(@RequestBody @Valid UserRegisterCommand command) {
        log.info("Post register customer {}", command);
        ApplicationUserDetails response = userService.registerUser(command);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<CustomUserDetails> login(@RequestBody @Valid LoginCommand command) {
        log.info("Post login customer {}", command);
        CustomUserDetails userDetails = userService.loginUser(command.getUsername(), command.getPassword());
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }
}
