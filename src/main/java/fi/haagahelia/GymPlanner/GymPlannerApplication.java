package fi.haagahelia.GymPlanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.GymPlanner.domain.Exercise;
import fi.haagahelia.GymPlanner.domain.ExerciseRepository;
import fi.haagahelia.GymPlanner.domain.Type;
import fi.haagahelia.GymPlanner.domain.TypeRepository;

@SpringBootApplication
public class GymPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymPlannerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ExerciseRepository erepository, TypeRepository trepository) {
		return (args) -> {
			
			trepository.save(new Type("Cardio", "Step Mill", "Machine", 9.8));
			trepository.save(new Type("Chest", "Bench Press Barbell", "Barbell", 9.7));
			
			erepository.save(new Exercise(1, trepository.findByName("Cardio").get(0), "Step Mill", 1, "15 mins"));
			erepository.save(new Exercise(1, trepository.findByName("Chest").get(0), "Bench Press Barbell", 1, "12-14"));
			
		};
	}
}
