package com.firstproject.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentrepo; 
	
	@GetMapping("/studentdetails")
    public List<Student> getstudentdetails() {
        return studentrepo.findAll();
    }
	
	@PostMapping("/addstudents")
	public Student addStudent(@RequestBody Student student) {
		return studentrepo.save(student);
	}
	
	@PutMapping("/student/{studentID}")
	public ResponseEntity<Student> updateStudent(@PathVariable("studentID") int studentID , @RequestBody Student student) {
	
		  Student existingStudent = studentrepo.findById(studentID)
	                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentID));

	        // Update the fields of the existing student with the fields from the updatedStudent
	        existingStudent.setFirstname(student.getFirstname());
	        existingStudent.setAge(student.getAge());
	        existingStudent.setLastname(student.getLastname());
	        existingStudent.setGender(student.getGender());
	        existingStudent.setAddress(student.getAddress());
	        existingStudent.setSection(student.getSection());
	        existingStudent.setStandard(student.getStandard());

	        // Save the updated student
	        studentrepo.save(existingStudent);

	        return ResponseEntity.ok(existingStudent);
}
	
	@DeleteMapping("/student/{studentID}")
	public void deleteStudent(@PathVariable("studentID") int studentID) {
		studentrepo.deleteById(studentID);
	}
	
}

   