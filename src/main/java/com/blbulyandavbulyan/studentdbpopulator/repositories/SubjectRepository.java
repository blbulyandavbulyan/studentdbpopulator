package com.blbulyandavbulyan.studentdbpopulator.repositories;

import com.blbulyandavbulyan.studentdbpopulator.entity.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class SubjectRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void save(List<Subject> subjects) {
        subjects.forEach(subject -> jdbcTemplate.update("""
                        INSERT INTO subjects(subject_name, tutor_id)
                        VALUES (:subject_name, :tutor_id)
                        """,
                Map.of("subject_name", subject.subjectName(),
                        "tutor_id", subject.tutorId())));
    }
}
