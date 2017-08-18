package com.toto.control;

import com.toto.model.Account;
import com.toto.service.AccountSerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountControl {
    @Autowired
    AccountSerImp service;
    @RequestMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account account){
       Account a= service.login(account.getUsername(),account.getPassword());
        if(a!=null){
            return new ResponseEntity<Account>(a, HttpStatus.OK);
        }else {
            return new ResponseEntity<Account>( HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public ResponseEntity<Void> register(@RequestBody Account account){
        if(service.register(account)){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/verify/{username}",method = RequestMethod.GET)
    public ResponseEntity<Void> verifyUsename(@PathVariable String username){
        if (service.verfiry(username)!=null){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }else {
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }
}
