package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Parent;
import com.example.demo.model.Student;
import com.example.demo.service.ParentService;
import com.example.demo.service.StudentService;

@Controller
public class ParentController {

		@Autowired
		private ParentService parentService;
		
		@Autowired
		private StudentService studentService;
		
		@GetMapping("/viewParents")
		public String viewStudentList(Model model) {
			model.addAttribute("listParents", parentService.getAllParents());
			return "listParent";
		}
		
		@GetMapping("/showNewParentForm")
		public String showNewParentForm(Model model) {
			Parent parent = new Parent();
			model.addAttribute("parent", parent);
			return "newParent";
		}
		
		@PostMapping("/saveParent")
		public String saveParent(@ModelAttribute("parent") Parent parent) {
			parentService.saveParent(parent);
			return "redirect:/showParent";
		}
		
		@GetMapping("/showParent")
		public String showFormForUpdate( Model model) {
			model.addAttribute("listParents", this.parentService.getAllParents());
			return "listParent";	
		}

		@GetMapping("/showParent/{id}")
		public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
			Student student = new Student();
			student = 	this.studentService.getStudentById(id);
			Parent parent = student.getParent();
			model.addAttribute("parent", parent);
			return "showParent";	
		}
		
		@GetMapping("/deleteParent/{id}")
		public String deleteparent(@PathVariable( value = "id") long id) {
			this.parentService.deleteParentById(id);
			return "redirect:/viewParents";
			
		}
}
