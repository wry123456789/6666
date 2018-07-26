package com.neuedu.dao;

import com.neuedu.entity.Account;

//�ӿڸ���ԭ��
public interface ILoginDao {

	public  Account   doLogin(String _username, String _password);
	public boolean register(Account c);
	public void addToken(Account c, String token);
	public String findTokenByAccountId(int accountid);
	
	
	
}
