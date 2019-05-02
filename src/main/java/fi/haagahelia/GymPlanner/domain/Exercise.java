package fi.haagahelia.GymPlanner.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Exercise {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;	
	private int day, sets;
	private String name, reps;
	private String weight;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "typeid")
	private Type type;
		
	public Exercise() {};
	
	public Exercise(int day, Type type, String name, int sets, String reps, String weight) {
		super();
		this.day = day;
		this.type = type;
		this.name = name;
		this.sets = sets;
		this.reps = reps;
		this.weight = weight;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReps() {
		return reps;
	}

	public void setReps(String reps) {
		this.reps = reps;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
}
