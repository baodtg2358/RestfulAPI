package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class MainController {
	public static Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	private AccountService service;
	
	@RequestMapping(value = "/account/",method = RequestMethod.GET)
	public ResponseEntity<List<Account>> showAll(){
		List<Account> account = service.findAll();
		if(account.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Account>>(account,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/account/{id}",method=RequestMethod.GET)
	public Account findAccount(@PathVariable("id") int ID) {
		Account account  = service.findByID(ID);
		if(account == null) {
			ResponseEntity.notFound().build();
		}
		return account;
	}
	
	@RequestMapping(value="/account/", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Account saveAcc(@Validated @RequestBody Account account) {
		return service.save(account);
	}
	
	@RequestMapping(value="/account/{id}",method=RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> updateAcc(@PathVariable(value="id") int ID, @Validated @RequestBody Account accountForm){
		Account account = service.findByID(ID);
		if(account== null) {
			return  ResponseEntity.notFound().build();
		}
		account.setUsername(accountForm.getUsername());
		account.setPassword(accountForm.getPassword());
		Account acz = service.save(account);
		return ResponseEntity.ok(acz);
	}
	
	@RequestMapping(value="/account/{id}", method =RequestMethod.DELETE)
	public ResponseEntity<Account> deleteAccount(@PathVariable("id") Integer ID){
		Account account = service.findByID(ID);
		if(account == null) {
			return ResponseEntity.notFound().build();
		}
		service.delByID(ID);
		return ResponseEntity.ok().build();
	}
	
}
