package com.example.Twitter.Repository;

import com.example.Twitter.Entity.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetweetRepository extends JpaRepository<Retweet,Long> {
}
