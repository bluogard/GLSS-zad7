package com.example.jpa.controller;


import com.example.jpa.model.Student;
import com.example.jpa.repository.StudentRepository;
import com.example.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    StudentRepository studentrepository;
    public StudentController(StudentService studentService){this.studentService = studentService;}

    @PostMapping()
    public ResponseEntity<Student> save(@RequestBody Student student) {
        student= studentService.addStudent(student);
            return new ResponseEntity<>(studentrepository.save(student), HttpStatus.CREATED);
    }
     @GetMapping
        public ResponseEntity<List> list(){
         List<Student> list = StudentService.list(studentrepository);
         return new ResponseEntity<>(list,HttpStatus.OK);
     }
    @GetMapping(value="{lastName}")
    public ResponseEntity<List> getStudentByLastName(@PathVariable String lastName){
        List<Student> list = studentService.getStudentByLastName(studentrepository,lastName);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @DeleteMapping(value="{id}")
    public  ResponseEntity<Student> delete(@PathVariable final Long id) {
       Student student = studentService.deleteStudent(id);
         return new ResponseEntity<>(student,HttpStatus.OK);
    }
}
