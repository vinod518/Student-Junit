package com.org.wipro.service;

import com.org.wipro.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public void createStudentController(Student student);
    public void updateStudentController(Student student);
    public List<Student> getAll();
    public Optional<Student> getById(Integer id);
    public String deleteById(Integer id);
    public String updateParticularRecord(Integer id, String address);
}
