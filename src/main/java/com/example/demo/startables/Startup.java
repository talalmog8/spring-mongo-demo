package com.example.demo.startables;

import com.example.demo.Models.Permissions;
import com.example.demo.Models.User;
import com.example.demo.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Startup implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(Startup.class);

    private final UserRepository repository;

    @Autowired
    public Startup(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws InterruptedException {
        repository.insert(Arrays.asList(new User(Permissions.READ), new User(Permissions.READ_WRITE)));
        Thread.sleep(1000 * 10);
    }
}