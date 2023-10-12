package com.banco.bancoJava2.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessMessage {
	String msg;
	
	public SuccessMessage(String msg) {
		this.msg = msg;
	}
	
}
