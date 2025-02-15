package com.blbulyandavbulyan.studentdbpopulator.entity;

import java.time.LocalDate;

public record Tutor (long tutorId,
                     String name,
                     String surname,
                     LocalDate dateOfBirth,
                     String primarySkill){
}
