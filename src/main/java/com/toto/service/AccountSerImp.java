package com.toto.service;

import com.toto.mapper.AccountMapper;
import com.toto.mapper.ProfileMapper;
import com.toto.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
@Service
@Transactional
public class AccountSerImp {
    @Autowired
    AccountMapper dao;
    @Autowired
    ProfileMapper pdao;
    public Account login(String username,String password){
        return  dao.login(username,password);
    }

    public boolean register(Account account){
        account.getProfile().setUsername(account.getUsername());
        return dao.insert(account)>0&&pdao.insert(account.getProfile())>0;
    }
    public  Account verfiry(String username){
         return dao.selectByPrimaryKey(username);
    }
}
