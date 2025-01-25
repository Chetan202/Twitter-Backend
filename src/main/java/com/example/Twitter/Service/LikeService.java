package com.example.Twitter.Service;


import com.example.Twitter.Entity.Comment;
import com.example.Twitter.Entity.Likee;
import com.example.Twitter.Entity.Tweet;
import com.example.Twitter.Repository.CommentRepository;
import com.example.Twitter.Repository.LikeRepository;
import com.example.Twitter.Repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private CommentRepository commentRepository;

    // Get all likes
    public List<Likee> getAllLikes() {
        return likeRepository.findAll();
    }
    // Add a like to a tweet
    public Likee likeTweet(Long tweetId, Likee like) {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(
                () -> new RuntimeException("Tweet not found"));
        like.setTweet(tweet);
        return likeRepository.save(like);
    }

    // Add a like to a comment
    public Likee likeComment(Long commentId, Likee like) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new RuntimeException("Comment not found"));
        like.setComment(comment);
        return likeRepository.save(like);
    }

    // Get all likes for a specific tweet
    public List<Likee> getLikesForTweet(Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(
                () -> new RuntimeException("Tweet not found"));
        return likeRepository.findByTweet(tweet);
    }

    // Get all likes for a specific comment
    public List<Likee> getLikesForComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new RuntimeException("Comment not found"));
        return likeRepository.findByComment(comment);
    }
}
