package fi.haagahelia.GymPlanner.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long typeid;
		private String type, name, equipment;
		private double rating;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
		private List<Exercise> exercises;

		public Type () {}
		

		public Type(String type, String name, String equipment, double rating) {
			super();
			this.type = type;
			this.name = name;
			this.equipment = equipment;
			this.rating = rating;
		}


		public Long getTypeid() {
			return typeid;
		}


		public void setTypeid(Long typeid) {
			this.typeid = typeid;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getEquipment() {
			return equipment;
		}


		public void setEquipment(String equipment) {
			this.equipment = equipment;
		}


		public double getRating() {
			return rating;
		}


		public void setRating(double rating) {
			this.rating = rating;
		}


		public List<Exercise> getExercises() {
			return exercises;
		}


		public void setExercises(List<Exercise> exercises) {
			this.exercises = exercises;
		}


		
}
