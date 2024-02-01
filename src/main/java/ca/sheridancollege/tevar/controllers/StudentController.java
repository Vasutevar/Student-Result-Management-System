package ca.sheridancollege.tevar.controllers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.tevar.beans.Student;
import ca.sheridancollege.tevar.repositories.StudentRepository;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor

public class StudentController {
	
	  private StudentRepository stuRepo;
	
	    //route for home page
		@GetMapping("/")
		 public String myHome() {
			return "home";
		}
		
		//student page routing and method calls
		@GetMapping("/addStudent")
		public String addStudent(Model model) {
			
			
			
			model.addAttribute("studentRecords", stuRepo.getStudents());
			model.addAttribute("student" , new Student());
			return "Student.html";
		}
		
		@PostMapping("/addStudent")
		public String processAdd(Model model, @ModelAttribute Student student) {
		    if (isAtLeastTenYearsOld(student.getDob())) {
		        stuRepo.addStudent(student);
		        model.addAttribute("notification", "Student added successfully");
		    } else {
		        model.addAttribute("error", "Student must be at least 10 years old");
		    }
		    model.addAttribute("studentRecords", stuRepo.getStudents());
		    model.addAttribute("student", new Student());
		    return "Student.html";
		}

		
		private boolean isAtLeastTenYearsOld(Date dob) {
		    try {
		        // Convert the Date object to LocalDate
		        Instant instant = dob.toInstant();
		        ZoneId zoneId = ZoneId.systemDefault();
		        LocalDate birthDate = instant.atZone(zoneId).toLocalDate();

		        LocalDate currentDate = LocalDate.now();
		        int age = Period.between(birthDate, currentDate).getYears();

		        return age >= 10;
		    } catch (Exception e) {
		        // Handle parsing exceptions or invalid date format
		        return false;
		    }
		}
		

	
}
