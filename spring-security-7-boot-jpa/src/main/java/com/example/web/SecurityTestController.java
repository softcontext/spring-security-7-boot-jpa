package com.example.web;

import org.springframework.security.core.Authentication;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityTestController {

//	@Autowired
//	UserDetailsService userService;

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage(Authentication auth) {

		ModelAndView model = new ModelAndView();
		if (auth != null && auth.getName() != null) {
			model.addObject("message", "welcome "+auth.getName()+" user");
		} else {
			model.addObject("message", "welcome anonymous user");
		}
		model.setViewName("home");

		return model;
	}

	/*
		Authentication
		spring security automatically redirect to the /login page for the authentication. 
		We have not configured that context path in our application, 
		that is implemented by spring security’e web based authentication.
		
		1. A user is prompted to log in with a username and password.
		2. The system verifies that the password is correct for the username.
		3. The context information for that user is obtained and list of roles. etc.
		
		When a user successfully logs in, 
		they will be redirected to the previously requested page 
		that requires authentication.
	 */
//	@RequestMapping(value = "/user**", method = RequestMethod.GET)
//	public ModelAndView userPage() {
//
//		UserDetails userDetails = userService.loadUserByUsername("user");
//		System.out.println("userDetails.getUsername(): "+userDetails.getUsername());
//
//		// If you want to know the currently authenticated user
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String name = auth.getName();
//
//		ModelAndView model = new ModelAndView();
//		model.addObject("message", "welcome member");
//		model.addObject("name", name);
//		model.setViewName("user");
//
//		return model;
//	}
	
//	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
//	public ModelAndView adminPage() {
//
//		UserDetails userDetails = userService.loadUserByUsername("admin");
//		System.out.println("userDetails.getUsername(): "+userDetails.getUsername());
//		
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String name = "";
//		if (principal instanceof UserDetails) {
//		    name = ((UserDetails)principal).getUsername();
//		} else {
//		    name = principal.toString();
//		} 
//
//		ModelAndView model = new ModelAndView();
//		model.addObject("message", "welcome administrator");
//		model.addObject("name", name);
//		model.setViewName("admin");
//
//		return model;
//	}

//	@RequestMapping(value = "/super**", method = RequestMethod.GET)
//	public ModelAndView superPage() {
//		
//		UserDetails userDetails = userService.loadUserByUsername("super");
//		System.out.println("userDetails.getUsername(): "+userDetails.getUsername());
//		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String name = auth.getName();
//		
//		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
//		for (GrantedAuthority g : authorities) {
//			System.out.println(g.getAuthority().toString());
//		}
//
//		ModelAndView model = new ModelAndView();
//		model.addObject("message", "welcome super manager");
//		model.addObject("name", name);
//		model.setViewName("super");
//
//		return model;
//	}

}