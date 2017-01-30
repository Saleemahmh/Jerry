package com.niit.bjeweledfrontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String gotoHome(Model model) {
		model.addAttribute("header", "true");
		return "index";
	}

	@RequestMapping("/validate")

	public String validate(@RequestParam(name = "Username") String id, @RequestParam(name = "Password") String pwd,
			Model model, HttpSession session) {
		// validate - hit the database to validate
		// NIIT

		if (id.equals("sal@gmail.com") && pwd.equals("niitdt")) {
			session.setAttribute("SuccessMessage", "You sucessfully logged in");
			return "index";
		} else if (id.equals("admin@gmail.com") && pwd.equals("admin1")) {
			session.setAttribute("successadmin", "login as admin");
			return "admin";
		} else {
			session.setAttribute("ErrorMessage", "Invalid Credentials ");
			return "index";
		}
	}

	/*@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("userClickedLogin", "true");
		return "login";
	}
*/
	/*@RequestMapping("/supplier")
	public String supplier(Model model) {
		model.addAttribute("userClickedsupplier", "true");
		return "admin";
	}

	@RequestMapping("/product")
	public String product(Model model) {
		model.addAttribute("userClickedproduct", "true");
		return "admin";
	}

	@RequestMapping("/category")
	public String category(Model model) {
		model.addAttribute("userClickedcategory", "true");
		return "admin";
	}*/
	@RequestMapping("/registeration")
	public String registeration(Model model)
	{
	
		//Boolean userClickedLogin=true
		model.addAttribute("userClickedRegister", "true");
			return "register";
		
	}
	// @RequestMapping("/login")
	// public ModelAndView login(Model model)
	// {
	// ModelAndView mv=new ModelAndView("home");
	// mv.addObject("userClickedLogin", "true");
	// return mv;
	// //String name="NIIT"
	// ${name} -String EL -Expression language
	// Boolean userClickedLogin=true
	// model.addAttribute("userClickedLogin", "true");
	// return "index";
	// }
	

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("userClickedhome", "true");
		return "index";
	}

	@RequestMapping("/contactus")
	public String contactus(Model model) {
		model.addAttribute("userClickedcontactus", "true");
		return "contactus";
	}

	@RequestMapping("/aboutus")
	public String aboutus(Model model) {
		model.addAttribute("userClickedaboutus", "true");
		return "aboutus";
	}

	@RequestMapping("/silver")
	public String silver(Model model) {
		model.addAttribute("userClickedsilver", "true");
		return "silver";
	}

	@RequestMapping("/f-earring")
	public String fearring(Model model) {
		model.addAttribute("userClickedfearring", "true");
		return "f-earring";
	}

	@RequestMapping("/f-necklace")
	public String fnecklace(Model model) {
		model.addAttribute("userClickedfnecklace", "true");
		return "f-necklace";
	}

	@RequestMapping("/f-rings")
	public String frings(Model model) {
		model.addAttribute("userClickedfrings", "true");
		return "f-rings";
	}

	@RequestMapping("/s-earring")
	public String searring(Model model) {
		model.addAttribute("userClickedsearring", "true");
		return "s-earring";
	}

	@RequestMapping("/s-necklace")
	public String snecklace(Model model) {
		model.addAttribute("userClickedsnecklace", "true");
		return "s-necklace";
	}

	@RequestMapping("/s-rings")
	public String srings(Model model) {
		model.addAttribute("userClickedsrings", "true");
		return "s-rings";
	}

	@RequestMapping("/g-rings")
	public String grings(Model model) {
		model.addAttribute("userClickedgrings", "true");
		return "g-rings";
	}

	@RequestMapping("/g-necklace")
	public String gnecklace(Model model) {
		model.addAttribute("userClickedgnecklace", "true");
		return "g-necklace";
	}

	@RequestMapping("/g-earring")
	public String gearring(Model model) {
		model.addAttribute("userClickedgearring", "true");
		return "g-earring";
	}

	@RequestMapping("/d-rings")
	public String drings(Model model) {
		model.addAttribute("userClickeddrings", "true");
		return "d-rings";
	}

	@RequestMapping("/d-necklace")
	public String dnecklace(Model model) {
		model.addAttribute("userClickeddnecklace", "true");
		return "d-necklace";
	}

	@RequestMapping("/d-earring")
	public String dearring(Model model) {
		model.addAttribute("userClickeddearring", "true");
		return "d-earring";
	}
	@RequestMapping("/addtocart")
	public String addtocart(Model model) {
		model.addAttribute("userClickedaddtocart", "true");
		return "addtocart";
	}
	/*@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
*/
}
