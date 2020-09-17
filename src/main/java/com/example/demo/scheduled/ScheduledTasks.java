package com.example.demo.scheduled;

import com.example.demo.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final UserRepository repository;

    @Autowired
    public ScheduledTasks(UserRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        repository.findAll().forEach(x -> log.info(x.toString()));
    }
}
