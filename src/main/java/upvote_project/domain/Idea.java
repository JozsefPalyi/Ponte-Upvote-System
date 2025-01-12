package upvote_project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "idea")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private Boolean approved = false;

    @Column(nullable = false)
    private Integer voteCounter = 0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "idea_id")
    private List<Vote> votes;

    public Idea(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void upvote() {
        this.voteCounter++;
    }

    public void approve() {
        this.approved = true;
    }

    public void disapprove() {
        this.approved = false;
    }
}
