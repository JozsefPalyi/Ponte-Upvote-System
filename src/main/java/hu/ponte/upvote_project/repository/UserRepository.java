package hu.ponte.upvote_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hu.ponte.upvote_project.domain.ApplicationUser;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {

    @Query("SELECT u FROM ApplicationUser u WHERE u.username = ?1")
    Optional <ApplicationUser> findByName(String username);

}
