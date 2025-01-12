package hu.ponte.upvote_project.config.security;

import hu.ponte.upvote_project.domain.ApplicationUser;
import hu.ponte.upvote_project.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final UserRepository userRepository;

    public CustomAuthenticationSuccessHandler(UserRepository customerRepository) {
        this.userRepository = customerRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        HttpSession session = request.getSession();

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        ApplicationUser user = userRepository.findByName(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        session.setAttribute("userId", user.getId());
    }
}
