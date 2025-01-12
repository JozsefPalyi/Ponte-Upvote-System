package hu.ponte.upvote_project.config.security;

import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class AuthenticatedAccountDetails {

    private String name;

    private List<String> roles;

    public AuthenticatedAccountDetails(UserDetails user) {
        this.name = user.getUsername();
        this.roles = mapRoles(user);
    }

    private List<String> mapRoles(UserDetails user) {
        return user.getAuthorities().stream().filter(authority -> authority.getAuthority().startsWith("ROLE_"))
                .map(Object::toString).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public List<String> getRoles() {
        return roles;
    }
}
