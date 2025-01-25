package com.example.Twitter.Controller;

import com.example.Twitter.Entity.Likee;
import com.example.Twitter.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    // Get all likes
    @GetMapping
    public List<Likee> getAllLikes() {
        return likeService.getAllLikes();
    }

    // Add a like to a specific tweet
    @PostMapping("/tweet/{tweetId}")
    public Likee likeTweet(@PathVariable Long tweetId, @RequestBody Likee like) {
        return likeService.likeTweet(tweetId, like);
    }

    // Add a like to a specific comment
    @PostMapping("/comment/{commentId}")
    public Likee likeComment(@PathVariable Long commentId, @RequestBody Likee like) {
        return likeService.likeComment(commentId, like);
    }

    // Get all likes for a specific tweet
    @GetMapping("/tweet/{tweetId}")
    public List<Likee> getLikesForTweet(@PathVariable Long tweetId) {
        return likeService.getLikesForTweet(tweetId);
    }

    // Get all likes for a specific comment
    @GetMapping("/comment/{commentId}")
    public List<Likee> getLikesForComment(@PathVariable Long commentId) {
        return likeService.getLikesForComment(commentId);
    }
}