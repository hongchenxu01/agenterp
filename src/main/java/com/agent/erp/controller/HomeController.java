package com.agent.erp.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agent.erp.model.InnerManageVo;
import com.agent.erp.model.User;
import com.agent.erp.service.InnerManageService;
import com.agent.erp.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController{

	@Autowired
	private UserService userService;
	
	@Autowired
	private InnerManageService innerManageService;
	
	@RequestMapping("")
	public String root(Model model) {
		
		User u = new User();
		u.setName("xhc2");
		u.setPassword("123456");
		u.setCreateTime(new Date());
		
//		String savedUserId = userService.save(u);
		model.addAttribute("user", u);
		
		List<InnerManageVo> in = innerManageService.selectSt();
		
		
		return "index";
		
	}
	
	@RequestMapping("index")
	public String index(Model model) {
		
		User u = new User();
		u.setName("xhc2");
		u.setPassword("123456");
		u.setCreateTime(new Date());
		
//		String savedUserId = userService.save(u);
		model.addAttribute("user", u);
		return "index";
		
	}
	
	@RequestMapping("api")
	@ResponseBody
	public List<InnerManageVo> api(Model model) {
		
		List<InnerManageVo> in = innerManageService.selectSt();
		
		return in;
		
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam Optional<String> error, Model model) {
		
		if(error.isPresent()) {
			model.addAttribute("error", error.get());
		}
		
		
		return "login";
	}
}
