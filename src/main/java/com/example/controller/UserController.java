package com.example.controller;

import com.example.model.Account;
import com.example.repository.AccountDAO;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AccountDAO adao;
    @RequestMapping("/")
    public String hello() {
        return "hello nhe";
    }

    @GetMapping("/account")
    public List<Account> getAll(){
        System.out.println("alo");
        return userService.findAll();

    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") String username) {
        Optional<Account> userData = Optional.ofNullable(userService.findById(username));

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/account")
    public ResponseEntity<Account> createTutorial(@RequestBody Account account) {
        try {
            Account _tutorial = adao
                    .save(account);
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("bug");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
