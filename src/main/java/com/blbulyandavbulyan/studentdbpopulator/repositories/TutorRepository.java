package com.blbulyandavbulyan.studentdbpopulator.repositories;

import com.blbulyandavbulyan.studentdbpopulator.entity.Tutor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class TutorRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void save(List<Tutor> students) {
        students.forEach(student -> {
            jdbcTemplate.update("""
                    INSERT INTO tutors(tutor_id, name, surname, date_of_birth, primary_skill)
                    VALUES (:tutor_id, :name, :surname, :date_of_birth, :primary_skill)
                    """,
                    Map.of("tutor_id", student.tutorId(),
                            "name", student.name(),
                            "surname", student.surname(),
                            "date_of_birth", student.dateOfBirth(),
                            "primary_skill", student.primarySkill()));
        });
    }
}
