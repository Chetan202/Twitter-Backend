package com.example.Twitter.Service;

import com.example.Twitter.Entity.Follow;
import com.example.Twitter.Repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    public List<Follow> getAllFollows() {
        return followRepository.findAll();
    }

    public Follow createFollow(Follow follow) {
        return followRepository.save(follow);
    }

    // Add more methods as needed
}
