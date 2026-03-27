package com.example.rest.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.example.model.Student;
import com.example.rest.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }
    
    @SuppressWarnings("deprecation")
	public Student getStudentById(int id) {
    	return repository.getById(id);
    }
    
    public Student updateStudent(int id, Student student) {

        Student existingStudent = repository.findById(id).orElse(null);

        if (existingStudent != null) {

            // update fields
            existingStudent.setName(student.getName());
            existingStudent.setId(student.getId());
            existingStudent.setCourse(student.getCourse());

            return repository.save(existingStudent);
        }

        return null; 
    }
}