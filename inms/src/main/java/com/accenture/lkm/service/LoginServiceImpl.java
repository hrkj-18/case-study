package com.accenture.lkm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.dao.LoginDAOWrapper;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAOWrapper daoWrapper;
	
	
	public LoginServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public LoginBean validateLogin(LoginBean loginBean) {
		// TODO Auto-generated method stub
		LoginBean login= daoWrapper.validateLogin(loginBean);
		boolean isMatch=false;
		if(login!=null)
		{
			String passwordCheck=loginBean.getPassword();
			String isPassword=login.getPassword();
			String usernameCheck=loginBean.getUsername();
			String isName=login.getUsername();
			if( (passwordCheck.equals(isPassword)) && (usernameCheck.equals(isName)) )
			{
				isMatch=true;
			}
		}
		if(isMatch)
		{
			return(login);
		}
		else
		{
			return(null);
		}
	
	}
	
}
