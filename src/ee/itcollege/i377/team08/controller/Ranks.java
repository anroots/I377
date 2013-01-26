package ee.itcollege.i377.team08.controller;

import java.util.List;

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

import ee.itcollege.i377.team08.dao.RankDao;
import ee.itcollege.i377.team08.dao.RankTypeDao;
import ee.itcollege.i377.team08.editor.RankTypeEditor;
import ee.itcollege.i377.team08.model.Rank;
import ee.itcollege.i377.team08.model.RankType;

@Controller
@RequestMapping("/ranks")
public class Ranks extends EntityController implements CrudEntityController {

	@Resource
	private RankDao rankDao;

	@Resource
	private RankTypeDao rankTypeDao;
	
	@Override
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("ranks", rankDao.getAll());
		return "Ranks/List";
	}

	@Override
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new Rank());
		model.addAttribute("rankTypes",getRankTypes());
		
		return "Ranks/Add";
	}

	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(Model model, @ModelAttribute @Valid Rank rank,
			BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("rankTypes",getRankTypes());
			return "Ranks/Add";
		}

		rankDao.save(rank);
		return "redirect:list";
	}

	 
	@Override
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(Model model,
			@RequestParam(required = true, value = "id") Integer entityId) {
		Rank rank = rankDao.find(entityId);

		if (rank == null || rank.getRemoved() != null)
			return "redirect:list";

		model.addAttribute(rank);
		model.addAttribute("rankTypes",getRankTypes());
		return "Ranks/Edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editPost(Model model, @ModelAttribute @Valid Rank rank,
			BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("rankTypes",getRankTypes());
			return "Rank/Edit";
		}

		rankDao.update(rank);
		return "redirect:list";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(Model model,
			@RequestParam(required = true, value = "id") Integer rankID) {

		rankDao.delete(rankID);
		return "redirect:list";
	}
	
	private List<RankType> getRankTypes() {
		return rankTypeDao.getAll();
	}
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(RankType.class, new RankTypeEditor(rankTypeDao));
    }
}
