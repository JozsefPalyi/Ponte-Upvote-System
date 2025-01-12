package hu.ponte.upvote_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hu.ponte.upvote_project.domain.Idea;

public interface IdeaRepository extends JpaRepository<Idea, Long> {
}
