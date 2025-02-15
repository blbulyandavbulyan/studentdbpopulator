package com.blbulyandavbulyan.studentdbpopulator.generators;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DateOfBirthGenerator {
    private final Random random;
    private final LocalDate currentDate = LocalDate.now();

    public LocalDate generateDateOfBirth() {
        int year = random.nextInt(1900, currentDate.getYear());
        int month = random.nextInt(1, currentDate.getMonthValue() + 1);
        int dayOfMonth = random.nextInt(1, currentDate.getDayOfMonth() + 1);
        return LocalDate.of(year, month, dayOfMonth);
    }
}
