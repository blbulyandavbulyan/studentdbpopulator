package com.blbulyandavbulyan.studentdbpopulator.entity;

import java.time.LocalDate;

public record Student(long studentId,
                      String name,
                      String surname,
                      LocalDate dateOfBirth,
                      String primarySkill) {
}
