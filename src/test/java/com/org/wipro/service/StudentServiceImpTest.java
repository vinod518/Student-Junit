package com.org.wipro.service;

import com.org.wipro.model.Student;
import com.org.wipro.repository.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceImpTest {
    @InjectMocks
    StudentServiceImp studentServiceImp;
    @Mock
    StudentRepo studentRepo;
    @Test
    void createStudentController() {
        Student student = new Student();
        student.setId(100);
        student.setName("vinod");
        student.setAddress("gulumuru");
        student.setMarks(99);
        studentServiceImp.createStudentController(student);
        Mockito.verify(studentRepo,Mockito.times(1)).save(student);

    }

    @Test
    void updateStudentController() {
        Student student = new Student();
        student.setId(100);
        student.setName("vinod");
        student.setAddress("gulumuru");
        student.setMarks(99);
        studentServiceImp.updateStudentController(student);
        Mockito.verify(studentRepo,Mockito.times(1)).save(student);

    }

    @Test
    void getAll() {
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setId(100);
        student.setName("vinod");
        student.setAddress("gulumuru");
        student.setMarks(99);
        Student student1 = new Student();
        student1.setId(101);
        student.setName("kumar");
        student.setAddress("hiramandalam");
        student.setMarks(98);
        list.add(student);
        list.add(student1);
        Mockito.when(studentRepo.findAll()).thenReturn(list);
        List<Student> list1 = studentServiceImp.getAll();
        Assertions.assertEquals(list,list1);
    }

    @Test
    void getById() {
        int id=100;
        Student  student = new Student();
        student.setId(100);
        student.setName("vinod");
        Optional<Student> optional = Optional.of(student);
        Mockito.when(studentRepo.findById(id)).thenReturn(optional);
        Optional<Student> optional1 = studentServiceImp.getById(id);
        Assertions.assertEquals(optional,optional1);
    }

    @Test
    void deleteById() {
        int id = 101;
        String str="success";
        String str1 = studentServiceImp.deleteById(id);
        Mockito.verify(studentRepo,Mockito.times(1)).deleteById(id);
        Assertions.assertEquals(str,str1);
    }

    @Test
    void updateParticularRecord() {
        int id =101;
        String address = "srikakulam";
        String str = "success";
        Student student = new Student();
        student.setId(101);
        student.setAddress("srikakulam");
        Optional<Student> optional = Optional.of(student);
        Mockito.when(studentRepo.findById(id)).thenReturn(optional);
        String str1 = studentServiceImp.updateParticularRecord(id,address);
        Assertions.assertEquals(str,str1);
    }
}















