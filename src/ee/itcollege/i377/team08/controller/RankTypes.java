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

import ee.itcollege.i377.team08.dao.RankTypeDao;
import ee.itcollege.i377.team08.model.RankType;

@Controller
@RequestMapping("/ranktypes")
public class RankTypes extends EntityController implements CrudEntityController {

	@Resource
	private RankTypeDao rankTypeDao;

	@Override
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("rankTypes", rankTypeDao.getAll());
		return "RankTypes/List";
	}

	@Override
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new RankType());
		return "RankTypes/Add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(Model model, @ModelAttribute @Valid RankType rankType,
			BindingResult result) {

		if (result.hasErrors()) {
			return "RankTypes/Add";
		}

		rankTypeDao.save(rankType);
		return "redirect:list";
	}

	@Override
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(Model model,
			@RequestParam(required = true, value = "id") Integer entityId) {
		RankType rankType = rankTypeDao.find(entityId);

		if (rankType == null || rankType.getRemoved() != null)
			return "redirect:list";

		model.addAttribute(rankType);
		return "RankTypes/Edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editPost(Model model, @ModelAttribute @Valid RankType rankType,
			BindingResult result) {

		if (result.hasErrors()) {
			return "RankTypes/Edit";
		}

		rankTypeDao.update(rankType);
		return "redirect:list";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(Model model,
			@RequestParam(required = true, value = "id") Integer rankTypeID) {

		rankTypeDao.delete(rankTypeID);
		return "redirect:list";
	}
}
