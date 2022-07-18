package com.org.wipro.controller;

import com.org.wipro.model.Student;
import com.org.wipro.repository.StudentRepo;
import com.org.wipro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public void createStudentController(@RequestBody Student student){
        studentService.createStudentController(student);
    }
    @PutMapping("/update")
    public void updateStudentController(@RequestBody Student student){
        studentService.updateStudentController(student);
    }
    @GetMapping("/getAll")
    public List<Student> getAll(){
        List<Student> ls=studentService.getAll();
        return ls;
    }
    @GetMapping("/getById/{id}")
    public Optional<Student> getById(@PathVariable Integer id){
        Optional<Student> s = studentService.getById(id);
        return s;
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Integer id){
        studentService.deleteById(id);
        return "success";
    }
    @PatchMapping("/updateParticularRecord/{id}/{address}")
    public String updateParticularRecord(@PathVariable Integer id, @PathVariable String address){
       String os1 = studentService.updateParticularRecord(id, address);
       return os1;
    }
}
