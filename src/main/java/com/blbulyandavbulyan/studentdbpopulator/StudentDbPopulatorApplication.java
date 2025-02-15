package com.blbulyandavbulyan.studentdbpopulator;

import com.blbulyandavbulyan.studentdbpopulator.service.DbInitializationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentDbPopulatorApplication implements CommandLineRunner{
	private final DbInitializationService dbInitializationService;

    public StudentDbPopulatorApplication(DbInitializationService dbInitializationService) {
        this.dbInitializationService = dbInitializationService;
    }

    public static void main(String[] args) {
		SpringApplication.run(StudentDbPopulatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dbInitializationService.initialize();
	}
}
