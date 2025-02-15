package com.blbulyandavbulyan.studentdbpopulator.generators;

import com.blbulyandavbulyan.studentdbpopulator.entity.Subject;
import com.blbulyandavbulyan.studentdbpopulator.entity.Tutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class SubjectGenerator {
    private final Random random;

    public List<Subject> generateSubjects(int amount, List<Tutor> tutors) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new Subject("Subject " + i, getRandomElement(tutors).tutorId()))
                .toList();
    }

    private <T> T getRandomElement(List<T> items) {
        return items.get(random.nextInt(items.size()));
    }
}
