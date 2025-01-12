package hu.ponte.upvote_project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.ponte.upvote_project.service.VoteService;

@RestController
@RequestMapping
@Slf4j
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }
}
