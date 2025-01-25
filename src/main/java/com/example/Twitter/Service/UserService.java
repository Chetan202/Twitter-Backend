package com.example.Twitter.Service;

import com.example.Twitter.Entity.Tweet;
import com.example.Twitter.Entity.User;
import com.example.Twitter.Repository.CommentRepository;
import com.example.Twitter.Repository.LikeRepository;
import com.example.Twitter.Repository.TweetRepository;
import com.example.Twitter.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;


    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikeRepository likeRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            // Update other fields as needed
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(Long id) {
        List<Tweet> tweets = tweetRepository.findByUserId(id);
        for (Tweet tweet : tweets) {
            tweetRepository.delete(tweet);
        }
        // Delete comments associated with the tweet
        commentRepository.deleteByTweetId(id);

        // Delete likes associated with the tweet
        likeRepository.deleteByTweetId(id);

        // Delete the tweet itself
        tweetRepository.deleteById(id);
        userRepository.deleteById(id);
    }
//    public void deleteTweet(Long tweetId) {
//        // Delete comments associated with the tweet
//        commentRepository.deleteByTweetId(tweetId);
//
//        // Delete likes associated with the tweet
//        likeRepository.deleteByTweetId(tweetId);
//
//        // Delete the tweet itself
//        tweetRepository.deleteById(tweetId);
//    }
}
