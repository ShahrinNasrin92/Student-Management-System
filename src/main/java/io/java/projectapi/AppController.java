package io.java.projectapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private StudentSevices stservice;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Student> listStudents = stservice.listAll();
		model.addAttribute("listStudents", listStudents);
		return "index";

	}

	@RequestMapping("/new")
	public String createStudentPage(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "createStudent";

	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editInfo(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_info");
		Student student = stservice.get(id);
		mav.addObject("student", student);

		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteInfo(@PathVariable(name = "id") int id) {
		stservice.delete(id);

		return "redirect:/";
	}

}
