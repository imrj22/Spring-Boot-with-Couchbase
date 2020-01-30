package com.couchbase.StudentDB.service;

import com.couchbase.StudentDB.dao.StudentRepository;
import com.couchbase.StudentDB.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Iterable<Student> findAll()
    {
        Iterable<Student> students = studentRepository.findAll();
        return students;
    }

    public Optional<Student> findById(Integer stId) {

        return studentRepository.findById(stId);
    }

    public Student save(Student student) {

        return studentRepository.save(student);


    }

    public void deleteById(Integer stId) {
        studentRepository.deleteById(stId);

    }
}
