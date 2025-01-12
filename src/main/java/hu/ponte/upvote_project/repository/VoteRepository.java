package hu.ponte.upvote_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hu.ponte.upvote_project.domain.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
