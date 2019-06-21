package io.java.projectapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@Autowired
	private StudentSevices stservice;
	
 @RequestMapping("/")
	public String viewHomePage(Model model)
	{
		List<Student> listStudents =stservice.listAll();
		model.addAttribute("listStudents",listStudents);
		return "index";
		
	}
	
	

}
