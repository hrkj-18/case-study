package com.accenture.lkm.web.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.service.LoginService;


@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	/*
	 * public LoginController() { // TODO Auto-generated constructor stub }
	 */
	
	@RequestMapping("login.html")
	public ModelAndView loadLoginPage()
	{
		ModelAndView mv=new ModelAndView();
		LoginBean loginBean=new LoginBean();
		mv.addObject("loginBean",loginBean);
		mv.setViewName("login");
		return(mv);
	}
	
	@RequestMapping(value="validatelogin.html")
	public ModelAndView validateLogin(@Valid @ModelAttribute("loginBean")LoginBean bean,BindingResult result,HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		if(result.hasErrors())
		{
				mv.setViewName("login");
		}
		else
		{
			LoginBean loginBean=loginService.validateLogin(bean);
			if(loginBean!=null)
			{
				session.setAttribute("userName",loginBean.getUsername());
				mv.setViewName("welcome");
			}
			else
			{
				mv.addObject("falseDetails",true);
				mv.setViewName("login");
			}
		}
			return(mv);
	}
	
	
	@RequestMapping(value="logout.html")
	public ModelAndView logout(HttpSession httpSession)
	{
		ModelAndView mv=new ModelAndView();
		LoginBean loginBean=new LoginBean();
		httpSession.removeAttribute("userName");
		httpSession.invalidate();
		mv.addObject("loginBean",loginBean);
		
		mv.setViewName("login");
		return(mv);
	}
	
	
}
