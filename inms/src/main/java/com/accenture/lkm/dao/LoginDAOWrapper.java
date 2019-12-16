package com.accenture.lkm.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.entity.LoginEntity;

@Repository
public class LoginDAOWrapper {

	@Autowired
	LoginDAO loginDAO;
	
	public LoginDAOWrapper() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginBean validateLogin(LoginBean loginBean)
	{
		LoginEntity entity=new LoginEntity();
		LoginBean persistBean;
		BeanUtils.copyProperties(loginBean, entity);
		LoginEntity persistentity=loginDAO.findOne(loginBean.getUsername());
		if(persistentity!=null)
		{
		persistBean=new LoginBean();
		BeanUtils.copyProperties(persistentity, persistBean);
		}
		else
		{
			persistBean=null;
		}
		return(persistBean);
	}
	
	
}
