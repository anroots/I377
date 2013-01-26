package ee.itcollege.i377.team08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {

	@RequestMapping("/login")
	public String login() {
		
		return "Login";
	}

	@RequestMapping(value = "/accessDenied")
	public String loginerror(Model model) {
		return "AccessDenied";
	}
}
