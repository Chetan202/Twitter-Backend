package com.example.Twitter.Service;

import com.example.Twitter.Entity.Comment;
import com.example.Twitter.Entity.Likee;
import com.example.Twitter.Entity.Tweet;
import com.example.Twitter.Entity.User;
import com.example.Twitter.Repository.TweetRepository;
import com.example.Twitter.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;


    @Autowired
    private UserRepository userRepository;

    public Tweet createTweet(Tweet tweet, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        tweet.setUser(user);
        return tweetRepository.save(tweet);
    }

    public List<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }

    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    // Add more methods as needed
    public List<Comment> getCommentsForTweet(Long userId, Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(
                () -> new RuntimeException("Tweet not found"));

        if (!tweet.getUser().getId().equals(userId)) {
            throw new RuntimeException("Unauthorized access to this tweet");
        }

        return tweet.getComments();
    }

    public List<Likee> getLikesForTweet(Long userId, Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(
                () -> new RuntimeException("Tweet not found"));

        if (!tweet.getUser().getId().equals(userId)) {
            throw new RuntimeException("Unauthorized access to this tweet");
        }

        return tweet.getLikes();
    }
}
