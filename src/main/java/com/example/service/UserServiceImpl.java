package com.example.service;

import java.util.List;

import com.example.model.Account;
import com.example.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    AccountDAO udao;


    @Override
    public List<Account> findAll() {
        return udao.findAll();
    }
    @Override
    public Account findById(String username) {
        return udao.findById(username).get();
    }


}
