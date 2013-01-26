package ee.itcollege.i377.team08.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


public interface CrudEntityController {
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model);

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model);

	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(Model model,
			@RequestParam(required = true, value = "id") Integer entityId);
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(Model model,
			@RequestParam(required=true, value = "id") Integer entityID);
}
