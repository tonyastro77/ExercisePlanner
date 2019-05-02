package fi.haagahelia.GymPlanner.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.GymPlanner.domain.Exercise;
import fi.haagahelia.GymPlanner.domain.ExerciseRepository;
import fi.haagahelia.GymPlanner.domain.TypeRepository;

@Controller
public class ExerciseController {

	@Autowired
	private ExerciseRepository repository;
	
	@Autowired
	private TypeRepository trepository;
	
	// Login page
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    } 

	//Main page
	@RequestMapping(value="/exerciselist")
	public String exerciseList(Model model) {
		model.addAttribute("exercises", repository.findAll());
		return "exerciselist";
	}
		
	//Restful service to get all students
	@RequestMapping(value = "/exercises", method = RequestMethod.GET)
	public @ResponseBody List<Exercise> exerciseListRest() {
		return (List<Exercise>) repository.findAll();
	}
	
	//Rest service to get student by id
	@RequestMapping(value = "/exercise/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Exercise> findExerciseRest(@PathVariable("id") Long exerciseId){
		return repository.findById(exerciseId);
	}
	
	//Add new exercise
	@RequestMapping(value="/add")
	public String addExercise(Model model) {
	model.addAttribute("exerciseObj", new Exercise());
	model.addAttribute("types", trepository.findAll());
	return "add";
	}
	
	//Save the exercise
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String save(Exercise exercise) {
	repository.save(exercise);
	return "redirect:exerciselist";
	}
	
	//Delete one exercise
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{id}", method= RequestMethod.GET)
	public String deleteRow(@PathVariable("id") Long idRow){
	repository.deleteById(idRow);
	return "redirect:../exerciselist";
	}

}