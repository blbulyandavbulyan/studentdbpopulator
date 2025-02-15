package com.blbulyandavbulyan.studentdbpopulator.generators;

import com.blbulyandavbulyan.studentdbpopulator.entity.ExamResult;
import com.blbulyandavbulyan.studentdbpopulator.entity.Student;
import com.blbulyandavbulyan.studentdbpopulator.entity.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class ExamResultGenerator {
    private final Random random;

    public List<ExamResult> generateExamResults(int amount, List<Subject> subjects, List<Student> students) {
        return IntStream.range(0, amount)
                .mapToObj(i -> generateExamResult(subjects, students))
                .toList();
    }

    private ExamResult generateExamResult(List<Subject> subjects, List<Student> students) {
        return new ExamResult(getRandomElement(students).studentId(), getRandomElement(subjects).subjectName(), random.nextInt(1, 6));
    }

    private <T> T getRandomElement(List<T> items) {
        return items.get(random.nextInt(items.size()));
    }
}
