package com.blbulyandavbulyan.studentdbpopulator.service;

import com.blbulyandavbulyan.studentdbpopulator.entity.ExamResult;
import com.blbulyandavbulyan.studentdbpopulator.entity.Student;
import com.blbulyandavbulyan.studentdbpopulator.entity.Subject;
import com.blbulyandavbulyan.studentdbpopulator.entity.Tutor;
import com.blbulyandavbulyan.studentdbpopulator.generators.ExamResultGenerator;
import com.blbulyandavbulyan.studentdbpopulator.generators.StudentGenerator;
import com.blbulyandavbulyan.studentdbpopulator.generators.SubjectGenerator;
import com.blbulyandavbulyan.studentdbpopulator.generators.TutorGenerator;
import com.blbulyandavbulyan.studentdbpopulator.repositories.StudentRepository;
import com.blbulyandavbulyan.studentdbpopulator.repositories.SubjectRepository;
import com.blbulyandavbulyan.studentdbpopulator.repositories.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbInitializationService {
    private static final int STUDENTS_COUNT = 100_000;
    private static final int TUTORS_COUNT = 100_000;
    private static final int SUBJECTS_COUNT = 1000;
    private static final int EXAM_RESULTS_COUNT = 1_000_000;

    private final StudentGenerator studentGenerator;
    private final TutorGenerator tutorGenerator;
    private final ExamResultGenerator examResultGenerator;
    private final SubjectGenerator subjectGenerator;

    private final StudentRepository studentRepository;
    private final TutorRepository tutorRepository;
    private final SubjectRepository subjectRepository;

    @Transactional
    public void initialize() {
        List<Student> students = studentGenerator.generate(STUDENTS_COUNT);
        List<Tutor> tutors = tutorGenerator.generate(TUTORS_COUNT);
        List<Subject> subjects = subjectGenerator.generateSubjects(SUBJECTS_COUNT, tutors);
        List<ExamResult> examResults = examResultGenerator.generateExamResults(EXAM_RESULTS_COUNT, subjects, students);
        studentRepository.save(students);
        tutorRepository.save(tutors);
        subjectRepository.save(subjects);

    }
}
