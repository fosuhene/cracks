package com.fosuhene.cracks.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    //create reference to student repository
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
       Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

       if(studentByEmail.isPresent()){
           throw new IllegalStateException("Email already taken!");
       }
       studentRepository.save(student);

       //System.out.println(student);
    }

    public void deleteStudent(Long studentId){
            boolean studentExist = studentRepository.existsById(studentId);
            if(!studentExist){
                throw new IllegalStateException("No record found for with ID : " + studentId);
            }
            studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId,
                              String fname,
                              String lname,
                              String email,
                              LocalDate dob,
                              LocalDate datejoined,
                              String gender) {

        Student student  = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + studentId + " does not exist"
                ));

        if(fname != null && fname.length() > 0 && !Objects.equals(student.getFname(), fname)){
                            student.setFname(fname);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentEmail =  studentRepository.findStudentByEmail(email);

            if(studentEmail.isPresent()){
                throw new IllegalStateException("Email already taken");
            }

            student.setEmail(email);
        }
    }
}
