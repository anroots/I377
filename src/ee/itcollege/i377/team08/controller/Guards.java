package ee.itcollege.i377.team08.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.i377.team08.dao.GuardDao;
import ee.itcollege.i377.team08.model.Guard;

@Controller
@RequestMapping("/guards")
public class Guards extends EntityController implements CrudEntityController{

	@Resource
	private GuardDao guardDao;

	@Override
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("guards", guardDao.getAll());
		return "Guards/List";
	}

	@Override
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new Guard());
		return "Guards/Add";
	}
	

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(Model model,
			@ModelAttribute @Valid Guard guard, BindingResult result) {
		
		if (result.hasErrors()) {
			return "Guards/Add";
		}
		
		guardDao.save(guard);
		return "redirect:list";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(Model model,
			@RequestParam(required=true, value = "id") Integer guardID) {		
		
		Guard guard = guardDao.find(guardID);
		
		if (guard == null || guard.getRemoved() != null) 
			return "redirect:list";

		model.addAttribute(guard);
		return "Guards/Edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editPost(Model model,
			@ModelAttribute @Valid Guard guard, BindingResult result) {				

		if(result.hasErrors()) {
			return "Guards/Edit";
		}
		
		guardDao.update(guard);		
		return "redirect:list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(Model model,
			@RequestParam(required=true, value = "id") Integer guardID) {		
		
		guardDao.delete(guardID);	
		return "redirect:list";
	}
}
