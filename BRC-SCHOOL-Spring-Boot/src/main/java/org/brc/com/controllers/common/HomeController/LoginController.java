package org.brc.com.controllers.common.HomeController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.brc.com.authentication.model.Roles;
import org.brc.com.authentication.model.User;
import org.brc.com.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Sandeep Rana
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");
		return "authentication/login";
	}
	
	@GetMapping("/signup")
	public String signupPage() {
		return "authentication/signup";
	}
	
	
	@PostMapping(value = "/signup")
	public String signup(@RequestParam String userName,
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam String email,
			@RequestParam String phone,
			@RequestParam String role,
			@RequestParam String password
			) {
		
		Roles roles = new Roles();
		roles.setRoleName(role);
		
		User user = new User();
		user.setUserId(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhone(phone);
		user.setEmail(email);
		Set<Roles> rolesset = new HashSet();
		rolesset.add(roles);
		
		// 
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(password));
		user.setRoles(rolesset);
		userService.save(user);
		return "authentication/login";
	}
	
	
	@GetMapping("/dashboard")
	public String dashboardPage() {
		return "dashboard/dashboard";
	}
}
