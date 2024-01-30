package com.dailycodework.studentdatabase.controller;

import com.dailycodework.studentdatabase.model.Student;
import com.dailycodework.studentdatabase.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private final IStudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable(name = "id") Long id) {
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable(name = "id") Long id) {
       studentService.deleteStudent(id);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable(name="id") Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
