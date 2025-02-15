package com.blbulyandavbulyan.studentdbpopulator.repositories;

import com.blbulyandavbulyan.studentdbpopulator.entity.ExamResult;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ExamResultRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void save(List<ExamResult> examResults) {
        examResults.forEach(examResult -> {
            jdbcTemplate.update("""
                    INSERT INTO exam_results (student_id, subject_name, mark)
                    VALUES (:student_id, :subject_name, :mark)
                    """, Map.of(
                    "student_id", examResult.studentId(),
                    "subject_name", examResult.subjectName(),
                    "mark", examResult.mark()
            ));
        });
    }
}
