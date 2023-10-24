package com.assignment3.kyn_project;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	

    @GetMapping("/login")
    public String onLogin() {
        return "login";
    }


    @GetMapping("/login_error")
    public String onLoginError(Model model) {
        String error_msg = "Incorrect username or password. Try Again.";
        model.addAttribute("error_string", error_msg);
		return "login";
		
    }
//    
//    @RequestMapping(value="/register_form")
//	public String registerUserForm(Map<String, Object> model) {
//    	System.out.println("Register Controller");
//		User user = new User();
//		model.put("user", user);
//
//		return "new_user";
//	}
    
	
	
	
	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "aboutUs";
	}
	
	@GetMapping("/contactUs")
	public String contactUs() {
		return "contactUs";
	}
    
    
}
