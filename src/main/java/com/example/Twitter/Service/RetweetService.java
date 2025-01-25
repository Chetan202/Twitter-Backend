package com.example.Twitter.Service;

import com.example.Twitter.Entity.Retweet;
import com.example.Twitter.Repository.RetweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetweetService {

    @Autowired
    private RetweetRepository retweetRepository;

    public List<Retweet> getAllRetweets() {
        return retweetRepository.findAll();
    }

    public Retweet createRetweet(Retweet retweet) {
        return retweetRepository.save(retweet);
    }

    // Add more methods as needed
}
