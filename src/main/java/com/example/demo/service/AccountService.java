package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Account;

public interface AccountService {

	List<Account> findAll();
	
	Account findByID(int ID);
	
	Account save(Account account);
	
	void delByID(int ID);
	
	
	
}
