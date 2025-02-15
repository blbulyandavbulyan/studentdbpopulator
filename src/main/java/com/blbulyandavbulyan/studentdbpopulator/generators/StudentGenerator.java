package com.blbulyandavbulyan.studentdbpopulator.generators;

import com.blbulyandavbulyan.studentdbpopulator.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentGenerator {
    private final DateOfBirthGenerator dateOfBirthGenerator;

    private Student createRandomStudent(int index) {
        return new Student(index,
                "Student name " + index,
                "Student surname " + index,
                dateOfBirthGenerator.generateDateOfBirth(),
                "random skill " + index);
    }

    public List<Student> generate(int amount) {
        List<Student> result = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            result.add(createRandomStudent(i));
        }
        return result;
    }
}
