package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CounterService {
    @Autowired CounterRepository repo;

    public void update(Counter counter) {
        repo.save(counter);
    }
    
    public Counter read() {
    	return repo.findById(1L).orElse(new Counter());
    }
}