package com.rami.Project;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@Controller
public class ViewController {
	
	@Autowired
	UserRepository service;
	
	
	public ViewController(UserRepository service) {
		this.service = service;
	}

	@RequestMapping("/")
	String index(Model model){
		model.addAttribute("users", service.findAll());
        return "index";
	}
	
	@GetMapping("/userList")
	String userList(Model model){
		model.addAttribute("users", service.findAll());
        return "user_list";
	}
	
	@GetMapping("/new")
	String registration(Model model) {
		 User user = new User();
		 model.addAttribute("user", user);
		 return "registration";
	}
	@PostMapping("/reg")
	String regUser(@Valid User user, BindingResult bindingResult){
		        if (bindingResult.hasErrors())
		        	return "registration";
		        service.save(user);
		        return "redirect:/index";
		 }
	
	@RequestMapping("/add")
	String show(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user_add";		
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User user, Model model) {
		service.save(user);
		List<User> userList = (List<User>) service.findAll();
		model.addAttribute("userList",userList);
		return userList(model);
	}
	@RequestMapping(value= "/delete/{id}" , method= DELETE)
	String delete(@PathVariable(name = "id") int id, Model model){
		if(service.existsById(id)) service.deleteById(id);
		else throw new ErrorController();
		return userList(model);
	}

	@GetMapping("/edit")
	String redirectEditUser(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "user_edit";
	}
	@PostMapping("/update")
	public String editUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()) {
			return "user_edit";
		}
		service.save(user);
		return userList(model);
	}
	@GetMapping("/Failed")
	String loginFail(){
		return "LoginFail";
	}
	
}
