package com.neuedu.service.impl;

import com.neuedu.dao.ILoginDao;
import com.neuedu.dao.impl.jdbc.LoginDaoImpl;
import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;

public class LoginServiceImpl implements ILoginService{

	
	ILoginDao loginDao=new LoginDaoImpl();
	public Account  doLogin(String  username,String password) {
		//进行登录的业务逻辑处理
		 //LoginDao loginDao=new LoginDao(); 
		//LoginDaoMysql loginDao=new LoginDaoMysql();
	
		return loginDao.doLogin(username,password);
		
		
	}
	@Override
	public boolean register(Account c) {
		// TODO Auto-generated method stub
	    return loginDao.register(c);	
	}
	@Override
	public void addToken(String token, Account c) {
		// TODO Auto-generated method stub
		loginDao.addToken(c, token);
	}
	public String findTokenByAccountId(int accountid) {
		return (loginDao.findTokenByAccountId(accountid));
	}
	
}
