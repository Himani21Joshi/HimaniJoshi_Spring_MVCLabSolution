package com.greatlearning.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentmanagement.entity.Student;
import com.greatlearning.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String listStudents(Model model) {
		System.out.println("Hello");
		List<Student> students = studentService.findAll();
		model.addAttribute("Students",students);
		return "list-Students";
		
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id")int id,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("course") String course,
			@RequestParam("country") String country
			) 
	{
		Student student;
		if(id!=0) {
			student = studentService.findById(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
		}
		else {
			student = new Student(firstName,lastName,course,country);
		}
		studentService.save(student);
		return "redirect:/student/list";
		
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id) {
		
		studentService.deleteById(id);
		return "redirect:/student/list";
		
	}
	
	@RequestMapping("/showFormForAdd")
	public String deleteStudent(Model model) {
		
		Student student = new Student();
		model.addAttribute("Student",student);
		return "Student-form";
		
	}
	
	@RequestMapping("/showFormForUpdate")
	public String deleteStudent(@RequestParam("id") int id, Model model) {
		
		Student student = studentService.findById(id);
		model.addAttribute("Student",student);
		return "Student-form";
		
	}
}
