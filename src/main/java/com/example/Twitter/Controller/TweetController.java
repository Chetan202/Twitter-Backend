package com.example.Twitter.Controller;

import com.example.Twitter.Entity.Comment;
import com.example.Twitter.Entity.Likee;
import com.example.Twitter.Entity.Tweet;
import com.example.Twitter.Repository.UserRepository;
import com.example.Twitter.Service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;


    @PostMapping("/{userId}")
    public Tweet createTweet(@PathVariable Long userId, @RequestBody Tweet tweet) {
        return tweetService.createTweet(tweet, userId);
    }

    @GetMapping
    public List<Tweet> getAllTweets() {
        return tweetService.getAllTweets();
    }

    @PostMapping
    public Tweet createTweet(@RequestBody Tweet tweet) {
        return tweetService.createTweet(tweet);
    }

    // Add more endpoints as needed
    @GetMapping("/{userId}/{tweetId}/comments")
    public List<Comment> getCommentsForTweet(
            @PathVariable Long userId,
            @PathVariable Long tweetId) {
        return tweetService.getCommentsForTweet(userId, tweetId);
    }

    // Get all likes for a particular tweet of a specific user
    @GetMapping("/{userId}/{tweetId}/likes")
    public List<Likee> getLikesForTweet(
            @PathVariable Long userId,
            @PathVariable Long tweetId) {
        return tweetService.getLikesForTweet(userId, tweetId);
    }

}
