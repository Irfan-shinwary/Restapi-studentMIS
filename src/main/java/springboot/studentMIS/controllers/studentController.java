package springboot.studentMIS.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.studentMIS.model.student;
import springboot.studentMIS.repository.StudentRepository;
import springboot.studentMIS.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/student")
public class studentController {
	
	private final StudentRepository studentRepository;

	public studentController(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	@GetMapping ("getAll")
	public ResponseEntity  getStudents() {
		return ResponseEntity.ok(this.studentRepository.findAll());
	}
	@PostMapping("/create")
	public student createStudent(@RequestBody student std) {
		return studentRepository.save(std);	
	}
	//get student By ID
	@GetMapping ("/get/{id}")
	public  student getStudentById(@PathVariable("id") Long id) {
//		try {
//		Optional <student> std= studentRepository.findById(id);
//			if(std.isPresent())
//				{
//					return  std.get();
//				}
//			}
//		catch(Exception e) {
//			 throw new ResourceNotFoundException(e, String.format("Element with Id: %d not found",id));
//	
//	 }
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("student",id));
		
  }
	//update Student
	@PutMapping("/update/{id}")
	public student updatStudent(@PathVariable ("id")long id,@RequestBody student Student) {
		student  std= studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException ("student",id));
		std.setName(Student.getName());
		std.setAddress(Student.getAddress());
		studentRepository.save(std);
		return std;
		
  }
	//delete student
	@DeleteMapping("delete/{id}")
	public ResponseEntity <String> deleteStudent(@PathVariable ("id") long id) {
		 studentRepository.deleteById(id);
		 return new ResponseEntity <String>("Record Has been successfully deleted !!",HttpStatus.OK);
	}
	
}
