package com.ipartek.formacion.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistence.Book;
import com.ipartek.formacion.dao.persistence.Copy;
import com.ipartek.formacion.dao.persistence.User;
import com.ipartek.formacion.service.interfaces.BookService;
import com.ipartek.formacion.service.interfaces.CopyService;
import com.ipartek.formacion.service.interfaces.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	CopyService cS;
	
	@Autowired 
	UserService uS;
	
	@Autowired 
	BookService bS;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		ModelAndView mav=new ModelAndView("home");
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		List<Book>books=bS.getAll();
		List<Copy>copies=cS.getAll();
		List<User>users=uS.getAll();
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		mav.addObject("books-list",books);
		mav.addObject("copies-list",copies);
		mav.addObject("users-list",users);
		
		
		return mav;
	}
	
}
