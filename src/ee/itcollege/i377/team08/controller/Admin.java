package ee.itcollege.i377.team08.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.i377.team08.dao.GuardDao;

@Controller
@RequestMapping("/admin")
public class Admin {

	@Resource
	GuardDao guardDao;

	@RequestMapping(value = "resetDb", method = RequestMethod.GET)
	public String resetDb(Model model) {

		guardDao.truncate();
		return "redirect:/";
	}

}
