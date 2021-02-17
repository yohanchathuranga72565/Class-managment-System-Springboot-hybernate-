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
public class StudentController {

		@Autowired
		private StudentService studentService;
		@Autowired
		private ParentService parentService;
		
		@GetMapping("/")
		public String index() {
//			model.addAttribute("listStudents", studentService.getAllStudents());
			return "index";
		}
	
		@GetMapping("/viewStudents")
		public String viewStudentList(Model model) {
			model.addAttribute("listStudents", studentService.getAllStudents());
			return "listStudent";
		}
		
		@GetMapping("/showNewStudentForm/{id}")
		public String showNewStudentForm(@PathVariable( value = "id") long pid, Model model) {
			Student student = new Student();
			model.addAttribute("student", student);
			model.addAttribute("pid", pid);
			return "newStudent";
		}
		
		@PostMapping("/saveStudent/{id}")
		public String saveStudent(@PathVariable( value = "id") long id, @ModelAttribute("student") Student student) {
			
			Parent parent = parentService.getParentById(id);
			parent.getStudents().add(student);
			this.parentService.saveParent(parent);
			
//			studentService.saveStudent(student);
			return "redirect:/viewStudents";
		}
		
		@PostMapping("/updateStudent")
		public String updateStudent(@ModelAttribute("student") Student student) {
			studentService.saveStudent(student);
			return "redirect:/viewStudents";
		}
		
		
		@GetMapping("/showFormForUpdate/{id}")
		public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
			Student student = studentService.getStudentById(id);
			model.addAttribute("student", student);
			return "updateStudent";	
		}
		
		@GetMapping("/deleteStudent/{id}")
		public String deleteStudent(@PathVariable( value = "id") long id) {
			this.studentService.deleteStudentById(id);
			return "redirect:/viewStudents";
			
		}
}
