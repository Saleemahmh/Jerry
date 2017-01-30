package com.niit.bjeweledfrontend.controller;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.bjeweledbackend.dao.CategoryDAO;
import com.niit.bjeweledbackend.dao.ProductDAO;
import com.niit.bjeweledbackend.dao.RegisterDAO;
import com.niit.bjeweledbackend.dao.SupplierDAO;
import com.niit.bjeweledbackend.model.Category;
import com.niit.bjeweledbackend.model.Product;
import com.niit.bjeweledbackend.model.Register;
import com.niit.bjeweledbackend.model.Supplier;





@Controller
public class LoginController {
	
	@Autowired
	Register register;
	
	@Autowired
	RegisterDAO registerDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/loginsuccess")
	public String showMessage(@RequestParam(value="UserName")String name,@RequestParam(value="Password")String password, 
			HttpSession session,Model model) {
String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String page="";
		
		String role="ROLE_USER";
		for (GrantedAuthority authority:authorities) 
		{
		 System.out.println(authority.getAuthority());
		
		 if (authority.getAuthority().equals(role)) 
	     {
	    	 session.setAttribute("categoryList",categoryDAO.listCategory());
	    	 session.setAttribute("supplierList",supplierDAO.listSupplier());
	    	 session.setAttribute("productList",productDAO.listProduct());
			 session.setAttribute("username",register.getUserName());
			 session.setAttribute("category",category);
			 session.setAttribute("supplier",supplier);
			 session.setAttribute("product",product);
	         session.setAttribute("username",username);
	    	 page="product";
	    	 
	    	 
	    	 break;
	     }
	     else 
	     {
	  
	    page="admin";
	    	 break;
	    }
		}
		 return page;
		}

	@RequestMapping("/welcome")
	public ModelAndView showMessage(@RequestParam(value = "Username") String username,
			@RequestParam(value = "Password") String password,HttpSession Session) {
		System.out.println("in controller");

		String message;
		ModelAndView mv ;
		if (registerDAO.isValidUser(username,password)) 
		{
			message = "Successfully Logged in";
			 mv = new ModelAndView("index");
			 Session.setAttribute("SuccessMessage","Login Successful");
		} else{

			if((username.equals("admin@gmail.com")&&password.equals("admin1")))
			{
				Session.setAttribute("SuccessMessage","Login Successful");
				mv = new ModelAndView("admin");
				return mv;
			}
			else
			{
				message="Please enter a valid username and password";
				Session.setAttribute("ErrorMessage","Invalid Credentials");
				mv=new ModelAndView("login");
			}
			message="Please enter a valid username and password";
			Session.setAttribute("ErrorMessage","Invalid Credentials");
			mv=new ModelAndView("login");
		}
	
		mv.addObject("message", message);
		mv.addObject("username", username);
		return mv;
	}
	
	
	@RequestMapping("/mobile_phones")
	public ModelAndView onLoadProductView(Model model)
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", this.categoryDAO.listCategory());
		model.addAttribute("product", new Product());
		model.addAttribute("productList",this.productDAO.listProduct());
		ModelAndView mv=new ModelAndView("product");

		return mv;

	}

	@RequestMapping("/viewCustomers")
	public ModelAndView customers()
	{
		ModelAndView mv = new ModelAndView("customerdetails");
		mv.addObject("register", register);
	
		mv.addObject("ListRegister", registerDAO.list());
		return mv;
	}
	@RequestMapping("/login")
	public String showLogin()
	{
	System.out.println("login");
	return "login";
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session)
	{
		ModelAndView mv=new ModelAndView("index");
		session.invalidate();
		session=request.getSession(true);
		mv.addObject("logoutMessage","you are successfully logged out");
		mv.addObject("loggedOut","true");
		return mv;
	}
	@RequestMapping(value="/register",method =RequestMethod.GET)
	public ModelAndView submitRegister(@ModelAttribute("Register")Register register) 
	{
		System.out.println("Register");
		ModelAndView model=new ModelAndView("register");
		return model; 
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView Success(Register reg, Model m)
	{
		registerDAO.save(reg);
		System.out.println("success");
		ModelAndView model=new ModelAndView("login","register", new Register());
		return model;
	}
}
	


