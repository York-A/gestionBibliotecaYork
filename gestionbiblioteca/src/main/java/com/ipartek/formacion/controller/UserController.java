package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.User;
import com.ipartek.formacion.service.interfaces.UserService;

@Controller
@RequestMapping(value="/users")
public class UserController  extends MultiActionController{
	
	@Autowired 
	private UserService uS=null;
	
	private ModelAndView mav=null;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){
		mav=new ModelAndView("books/list");
		List<User>users=uS.getAll();
		mav.addObject("users-list",users);
		return mav;
	}
	
	

}
