package com.example.machinetets.service;

import com.example.machinetets.models.Student;
import com.example.machinetets.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public final IStudentRepository iStudentRepository;

    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    public List<Student> getStudents() {
        return iStudentRepository.findAll();
    }
    public Student getById(Long id) {
        return iStudentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not Found!"));
    }

    public boolean isNameValid(Student student) {
        return student.getStrudentName()!=null && student.getStrudentName().length()>=3 && student.getStrudentName().length()<=30;
    }
    public boolean isCollegeValid(Student student) {
        return student.getCollegeName()!=null && student.getCollegeName().length()>=3 && student.getCollegeName().length()<=50;
    }
    public boolean isRound1Valid(Student student) {
        return student.getRound1Marks()>=0 &&  student.getRound1Marks()<=10;
    }
    public boolean isRound2Valid(Student student) {
        return student.getRound1Marks()>=0 &&  student.getRound1Marks()<=10;
    }
    public boolean isRound3Valid(Student student) {
        return student.getRound1Marks()>=0 &&  student.getRound1Marks()<=10;
    }
    public boolean isTechnicalValid(Student student) {
        return student.getTechnicalRoundMarks()>=0 && student.getTechnicalRoundMarks()<=20;
    }




    public Student addStudent(Student student) {
        if(!isNameValid(student)) {
            throw new RuntimeException("Student name is invalid!!!");
        }
        if(!isCollegeValid(student)) {
            throw new RuntimeException("Student college is invalid!!!");
        }
        if(!isRound1Valid(student)) {
            throw new RuntimeException("Student round1 is invalid!!!");
        }
        if(!isRound2Valid(student)) {
            throw new RuntimeException("Student round2 is invalid!!!");
        }
        if (!isRound3Valid(student)) {
           throw new RuntimeException("Student round3 is invalid!!!");
        }
        if(!isTechnicalValid(student)) {
            throw new RuntimeException("Student technical is invalid!!!");
        }
        float totalMarks = student.getRound1Marks()+ student.getRound2Marks()+ student.getRound3Marks()+ student.getTechnicalRoundMarks();
        student.setTotalMarks(totalMarks);

        String result = "";
        if(totalMarks < 35) {
            result = "Rejected";
        }else{
            result = "Selected";
        }

        student.setResult(result);
        student.setRank(rankOfStudent(totalMarks));

        return iStudentRepository.save(student);
    }

    public int rankOfStudent(float totalMarks) {
        if(totalMarks >=90) {
            return 1;
        } else if (totalMarks >= 80) {
            return 2;
        }else if (totalMarks >= 70) {
            return 3;
        } else if (totalMarks >= 60) {
            return 4;
        }else if (totalMarks >= 50) {
            return 5;
        } else if (totalMarks >=40) {
            return 6;
        }else if (totalMarks >= 35) {
            return 7;
        }else{
            return 10;
        }
    }

}
