package fi.haagahelia.GymPlanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.GymPlanner.domain.Exercise;
import fi.haagahelia.GymPlanner.domain.ExerciseRepository;
import fi.haagahelia.GymPlanner.domain.Type;
import fi.haagahelia.GymPlanner.domain.TypeRepository;
import fi.haagahelia.GymPlanner.domain.User;
import fi.haagahelia.GymPlanner.domain.UserRepository;

@SpringBootApplication
public class GymPlannerApplication {
	private static final Logger log = LoggerFactory.getLogger(GymPlannerApplication.class);
	
	public static void main(String[] args) throws Throwable {
		SpringApplication.run(GymPlannerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ExerciseRepository erepository, TypeRepository trepository, UserRepository urepository) {
		return (args) -> {
			
			trepository.save(new Type("Abdominals"));
			trepository.save(new Type("Abductors"));
			trepository.save(new Type("Adductors"));
			trepository.save(new Type("Biceps"));
			trepository.save(new Type("Calves"));
			trepository.save(new Type("Cardio"));
			trepository.save(new Type("Chest"));
			trepository.save(new Type("Forearms"));
			trepository.save(new Type("Glutes"));
			trepository.save(new Type("Hamstrings"));
			trepository.save(new Type("Lats"));
			trepository.save(new Type("Lower Back"));
			trepository.save(new Type("Middle Back"));
			trepository.save(new Type("Neck"));
			trepository.save(new Type("Quadriceps"));
			trepository.save(new Type("Shoulders"));
			trepository.save(new Type("Traps"));
			trepository.save(new Type("Triceps"));
			
			
			
			erepository.save(new Exercise(1, trepository.findByName("Cardio").get(0), "Step Mill", 1, "15 mins", ""));
			erepository.save(new Exercise(1, trepository.findByName("Chest").get(0), "Dumbbell Press Bench", 3, "8-12", "16"));
			
			User user1 = new User("tonyastro77", "$2a$10$VLosq78Oq8baxQViTjTmkO/q64DoTgqmDVHdjpIkGkW/c1Csp/w7i", "USER"); 
			//password1
			User user2 = new User("administrator", "$2a$10$u6UgXR6WNiwx8q93jZ.tw.1ltJlsl1uaDWsihfBi5H5chKtdUb9EC", "ADMIN"); 
			//Qwerty789
			//https://www.browserling.com/tools/bcrypt
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all the exercises");
			for (Exercise exercise : erepository.findAll()) {
				log.info(exercise.toString());
			}
		};
	}
}
