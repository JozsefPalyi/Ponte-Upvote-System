package hu.ponte.upvote_project.dto.outgoing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApplicationUserDetails {

        private Long id;

        private String username;

        private String role;
}
