package hu.ponte.upvote_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hu.ponte.upvote_project.domain.ApplicationUser;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {

}
