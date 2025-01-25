package com.example.Twitter.Service;

import com.example.Twitter.Entity.Follow;
import com.example.Twitter.Entity.User;
import com.example.Twitter.Repository.FollowRepository;
import com.example.Twitter.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Follow> getAllFollows() {
        return followRepository.findAll();
    }

    public Follow createFollow(Follow follow) {
        return followRepository.save(follow);
    }

    // Add more methods as needed
    public Follow followUser(Long followerId, Long followeeId) {
        // Retrieve follower and followee users
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new IllegalArgumentException("Follower with ID " + followerId + " not found."));
        User followee = userRepository.findById(followeeId)
                .orElseThrow(() -> new IllegalArgumentException("Followee with ID " + followeeId + " not found."));

        // Create a new Follow relationship
        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowee(followee);

        return followRepository.save(follow);
    }
}
