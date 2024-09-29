package com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> getStudentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(getStudentByEmail.isPresent()){
            throw new IllegalStateException("Email Already Taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudentById(Long studentId) {
        Boolean isStudentExists = studentRepository.existsById(studentId);
        if(!isStudentExists){
            throw new IllegalStateException("Student id does not exist");
        }else{
            studentRepository.deleteById(studentId);
        }
    }
}
