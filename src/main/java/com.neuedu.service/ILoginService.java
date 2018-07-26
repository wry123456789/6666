package com.neuedu.service;

import com.neuedu.entity.Account;

public interface ILoginService {

	public Account  doLogin(String username, String password);
	public boolean register(Account c);
	public void addToken(String token, Account c);
	public String findTokenByAccountId(int accountid);
}
