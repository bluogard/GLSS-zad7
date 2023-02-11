package com.example.jpa.service;



import com.example.jpa.model.Student;
import com.example.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public static List<Student> list(StudentRepository studentRepository) {
        return studentRepository.findAll();
    }
    public  Student getStudent(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException());

    }
    public  List<Student> getStudentByLastName(StudentRepository studentRepository,String lastName){
        try{
            return studentRepository.findByLastName(lastName);
       }
        catch(RuntimeException e){
            return null;
       }

  }

    public  Student deleteStudent(Long id){
        Student student = getStudent(id);
        studentRepository.delete(student);
        return student;
    }

}