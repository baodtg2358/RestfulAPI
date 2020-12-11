package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository repo;
	
	@Override
	public List<Account> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Account findByID(int ID) {
		
		return repo.findById(ID).get();
	}

	@Override
	public Account save(Account account) {
		return repo.save(account);
		
	}

	@Override
	public void delByID(int ID) {
		
		repo.deleteById(ID);
		
	}

	
	
}
