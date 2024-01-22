package com.dailycodework.service;

import com.dailycodework.exceptions.StudentAlreadyExistsException;
import com.dailycodework.exceptions.StudentNotFoundException;
import com.dailycodework.model.Student;
import com.dailycodework.repository.StudentRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;
    //Find all students
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //Add new student
    @Override
    public Student addStudent(Student student) {
        if(studentAlreadyExist(student.getEmail())) {
            throw new StudentAlreadyExistsException(student.getEmail() + "Student already exists");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(student1 -> {
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            student1.setEmail(student.getEmail());
            student1.setDepartment(student.getDepartment());
            return studentRepository.save(student1);
        }).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("No student found with this id."));
    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("This student cannot be found.");
        }

    }
    private boolean studentAlreadyExist(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }

}
