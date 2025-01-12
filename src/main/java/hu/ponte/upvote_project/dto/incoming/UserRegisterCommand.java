package hu.ponte.upvote_project.dto.incoming;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterCommand {

    @NotBlank(message = "Can't be empty")
    private String username;

    @NotBlank(message = "Can't be empty")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$",
            message = "The password must contain at least one lowercase letter, one uppercase letter," +
                    " one number and must be at least 8 characters long!"
    )
    private String password;
}
