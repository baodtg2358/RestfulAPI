package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Account {
	@Id
	@Column(name = "STT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int STT;
	
	@Column(name="TENTK")
	private String Username;
	
	@Column(name= "MATKHAU")
	private String Password;
	

}
