package com.dailycodework.studentdatabase.service;

import com.dailycodework.studentdatabase.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();
    Student addStudent(Student student);

    Student updateStudent(Student student, Long id);

    Student getStudentById(Long id);
    void deleteStudent(Long id);

}
