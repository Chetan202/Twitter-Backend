package com.example.Twitter.Repository;

import com.example.Twitter.Entity.Comment;
import com.example.Twitter.Entity.Likee;
import com.example.Twitter.Entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Likee,Long> {

    List<Likee> findByTweet(Tweet tweet);

    List<Likee> findByComment(Comment comment);

    void deleteByTweetId(Long tweetId);
}
