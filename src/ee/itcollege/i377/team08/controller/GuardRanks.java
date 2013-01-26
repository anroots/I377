package ee.itcollege.i377.team08.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.i377.team08.dao.GuardDao;
import ee.itcollege.i377.team08.dao.GuardRankDao;
import ee.itcollege.i377.team08.dao.RankDao;
import ee.itcollege.i377.team08.editor.DateEditor;
import ee.itcollege.i377.team08.editor.GuardEditor;
import ee.itcollege.i377.team08.editor.RankEditor;
import ee.itcollege.i377.team08.model.Guard;
import ee.itcollege.i377.team08.model.GuardRank;
import ee.itcollege.i377.team08.model.Rank;

@Controller
@RequestMapping("/guardranks")
public class GuardRanks extends EntityController implements CrudEntityController{

	@Resource
	private GuardRankDao guardRankDao;

	@Resource
	private RankDao rankDao;
	
	@Resource
	private GuardDao guardDao;
	
	@Override
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("guardRanks", guardRankDao.getAll());
		return "GuardRanks/List";
	}

	@Override
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new GuardRank());
		model.addAttribute("ranks",rankDao.getAll());
		model.addAttribute("guards",guardDao.getAll());
		return "GuardRanks/Add";
	}
	

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(Model model,
			@ModelAttribute @Valid GuardRank guardRank, BindingResult result) {
		
		if (result.hasErrors()) {
			model.addAttribute("ranks",rankDao.getAll());
			model.addAttribute("guards",guardDao.getAll());
			return "GuardRanks/Add";
		}
		
		guardRankDao.save(guardRank);
		return "redirect:list";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(Model model,
			@RequestParam(required=true, value = "id") Integer guardRankID) {		
		
		GuardRank guardRank = guardRankDao.find(guardRankID);
		
		if (guardRank == null || guardRank.getRemoved() != null) 
			return "redirect:list";
		
		model.addAttribute("ranks",rankDao.getAll());
		model.addAttribute("guards",guardDao.getAll());
		model.addAttribute(guardRank);
		return "GuardRanks/Edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editPost(Model model,
			@ModelAttribute @Valid GuardRank guardRank, BindingResult result) {				

		if(result.hasErrors()) {
			model.addAttribute("ranks",rankDao.getAll());
			model.addAttribute("guards",guardDao.getAll());
			return "GuardRanks/Edit";
		}
		
		guardRankDao.update(guardRank);		
		return "redirect:list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(Model model,
			@RequestParam(required=true, value = "id") Integer guardRankID) {		
		
		guardRankDao.delete(guardRankID);	
		return "redirect:list";
	}
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Rank.class, new RankEditor(rankDao));
		binder.registerCustomEditor(Guard.class, new GuardEditor(guardDao));
		binder.registerCustomEditor(Date.class,new DateEditor());
    }
}
