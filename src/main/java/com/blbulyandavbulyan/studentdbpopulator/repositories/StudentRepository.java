package com.blbulyandavbulyan.studentdbpopulator.repositories;

import com.blbulyandavbulyan.studentdbpopulator.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void save(List<Student> students) {
        students.forEach(student -> {
            jdbcTemplate.update("""
                    INSERT INTO students(student_id, name, surname, date_of_birth, primary_skill)
                    VALUES (:student_id, :name, :surname, :date_of_birth, :primary_skill)
                    """,
                    Map.of("student_id", student.studentId(),
                            "name", student.name(),
                            "surname", student.surname(),
                            "date_of_birth", student.dateOfBirth(),
                            "primary_skill", student.primarySkill()));
        });
    }
}
