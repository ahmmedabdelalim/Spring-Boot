package com.lemo.demo.rest;

import com.lemo.demo.Exception.StudentNotFoundException;
import com.lemo.demo.Exception.StudentErorrResponse;
import com.lemo.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @ExceptionHandler
    public ResponseEntity<StudentErorrResponse> handleException(StudentNotFoundException exc)
    {
        StudentErorrResponse error = new StudentErorrResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeSatmp(System.currentTimeMillis());

        return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);

    }
    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Smith"));
    }


    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    // define endpoint or "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
//         exception
        if((studentId >= theStudents.size())||(studentId < 0 ))
        {
            throw new StudentNotFoundException("Student id not found  - " + studentId);
        }
        // just index into the list ... keep it simple for now

        return theStudents.get(studentId);
    }
}






