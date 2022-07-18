package com.org.wipro.service;

import com.org.wipro.model.Student;
import com.org.wipro.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentRepo studentRepo;
    @Override
    public void createStudentController(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void updateStudentController(Student student) {
        studentRepo.save(student);
    }

    @Override
    public List<Student> getAll() {
        List<Student> ls = studentRepo.findAll();
        return ls;
    }

    @Override
    public Optional<Student> getById(Integer id) {
        Optional<Student> os = studentRepo.findById(id);
        return os;
    }

    @Override
    public String deleteById(Integer id) {
        studentRepo.deleteById(id);
        return "success";
    }

    @Override
    public String updateParticularRecord(Integer id, String address) {
        Optional<Student> os1 = studentRepo.findById(id);
        Student std = os1.get();
        std.setAddress(address);
        studentRepo.save(std);
        return "success";
    }
}
