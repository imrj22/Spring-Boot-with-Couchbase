package com.couchbase.StudentDB.controller;

import com.couchbase.StudentDB.model.Student;
import com.couchbase.StudentDB.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/student")

public class StudentController
{
    @Autowired
    private StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get")
    public Iterable<Student> getAllStudents() {

        return studentService.findAll();
    }

    @PostMapping("/post")
    Student createStudent(@RequestBody Student newStudent) {

        return studentService.save(newStudent);
    }

    @GetMapping("/get/{id}")
    Student getStudentById(@PathVariable("id") Integer stId) {

        return studentService.findById(stId).get();
    }

    @PutMapping("/put/{id}")
    Student updateStudent(@RequestBody Student newStudent, @PathVariable("id") Integer stId) {
        return studentService.findById(stId).map(student -> {
            student.setStId(newStudent.getStId());
            student.setStName(newStudent.getStName());
            student.setCollegeId(newStudent.getCollegeId());
            return studentService.save(student);
        }).orElseGet(() -> {
            newStudent.setStId(stId);
            return studentService.save(newStudent);
        });
    }

    @DeleteMapping("/delete/{id}")
    void deleteStudent(@PathVariable("id") Integer stId) {

        studentService.deleteById(stId);
    }


}
