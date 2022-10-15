package org.brc.com.controllers.admin;

import org.brc.com.authentication.model.User;
import org.brc.com.authentication.service.UserService;
import org.brc.com.exceptions.UserCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sandeep Rana
 *
 */
@Controller
@RequestMapping("/admin/user")
public class UserManagementController {

	
	@Autowired
	private UserService userService;
	
	@GetMapping("user-list")
	public ModelAndView userRegistrationPage() {
		ModelAndView mav = new ModelAndView("admin/user-list");
		mav.addObject("selectedId","user_list");
		return mav;
	}
	
	
	@RequestMapping(value="/save-update", method = {RequestMethod.POST, RequestMethod.PUT})
	@ResponseBody
	public User saveUpdate(@RequestBody User user) throws UserCreationException {
		return userService.saveUpdateUser(user);
	}
}
