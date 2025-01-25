package com.example.Twitter.Controller;

import com.example.Twitter.Entity.Follow;
import com.example.Twitter.Service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follows")
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping
    public List<Follow> getAllFollows() {
        return followService.getAllFollows();
    }

//    @PostMapping
//    public Follow createFollow(@RequestBody Follow follow) {
//        return followService.createFollow(follow);
//    }

    // Endpoint for following a user by their IDs
    @PostMapping("/{followerId}/follow/{followeeId}")
    public Follow followUser(@PathVariable Long followerId, @PathVariable Long followeeId) {
        return followService.followUser(followerId, followeeId);
    }
}
