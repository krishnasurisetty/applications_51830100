package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.AppUser;
import com.bankapp.model.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(path="allusers")
	public String getUsers(ModelMap map){
		map.addAttribute("users", userService.findAll());
		return "allusers";
	}
	
	@GetMapping(path="create")
	public String createUser(ModelMap map){
		map.addAttribute("user",new AppUser());
		return "createuser";
	}
	@PostMapping(path="create")
	public String createUserPost(ModelMap map,AppUser user){
		userService.addUser(user);
		return "redirect:allusers";
	}
}
