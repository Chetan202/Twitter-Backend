package com.example.Twitter.Controller;

import com.example.Twitter.Entity.Retweet;
import com.example.Twitter.Service.RetweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retweets")
public class RetweetController {

    @Autowired
    private RetweetService retweetService;

    @GetMapping
    public List<Retweet> getAllRetweets() {
        return retweetService.getAllRetweets();
    }

    @PostMapping
    public Retweet createRetweet(@RequestBody Retweet retweet) {
        return retweetService.createRetweet(retweet);
    }

    // Add more endpoints as needed
}
