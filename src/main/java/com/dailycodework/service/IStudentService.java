package com.dailycodework.service;

import com.dailycodework.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();
    Student addStudent(Student student);

    Student updateStudent(Student student, Long id);

    Student getStudentById(Long id);
    void deleteStudent(Long id);

}
