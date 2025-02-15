package com.blbulyandavbulyan.studentdbpopulator.generators;

import com.blbulyandavbulyan.studentdbpopulator.entity.Tutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TutorGenerator {
    private final DateOfBirthGenerator dateOfBirthGenerator;

    private Tutor createRandomTutor(int index) {
        return new Tutor(index,
                "Student name " + index,
                "Student surname " + index,
                dateOfBirthGenerator.generateDateOfBirth(),
                "random skill " + index);
    }

    public List<Tutor> generate(int amount) {
        List<Tutor> result = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            result.add(createRandomTutor(i));
        }
        return result;
    }
}
