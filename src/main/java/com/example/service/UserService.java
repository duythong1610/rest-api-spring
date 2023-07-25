package com.example.service;

import com.example.model.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface UserService {

    List<Account> findAll();
   Account findById(String username);

}