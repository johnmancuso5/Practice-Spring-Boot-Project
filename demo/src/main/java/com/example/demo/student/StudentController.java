package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController			// Used to take care of mapping request (get, post, update, delete)
@RequestMapping(path = "api/v1/students") // New port
public class StudentController {

    private final StudentService studentService;

    @Autowired  // This will be instantiated for us and put into the constructor for us
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // Serving it as a RESTFUL endpoint
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    // RequestBody - Taking request body and putting it into a student object
    @PostMapping // Post request
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId") // Deleting by StudentID
    public void deleteStudent(
            @PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }
}
