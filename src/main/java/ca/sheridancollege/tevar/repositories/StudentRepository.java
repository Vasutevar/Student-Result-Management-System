package ca.sheridancollege.tevar.repositories;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.tevar.beans.Student;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor

public class StudentRepository {
	
private NamedParameterJdbcTemplate jdbc;
	
	//imp to initialize with AllArgsConstructor   
    //Map is a key-value pair
   
    //method for adding a student in db
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		MapSqlParameterSource parameters = new MapSqlParameterSource();
    	String query = "INSERT INTO student (firstName, familyName, dob) VALUES " 
		             + "(:ftn, :fln, :dob)";
    	
    	parameters.addValue("ftn", student.getFirstName());
    	parameters.addValue("fln", student.getFamilyName());  
    	parameters.addValue("dob", student.getDob());
        jdbc.update(query, parameters);
		
	}
	
	public ArrayList<Student> getStudents(){
		 
		 MapSqlParameterSource parameters = new MapSqlParameterSource();
		 String query = "SELECT * FROM student";
		 
		 //make sure to match names of object and column name in database
		 ArrayList<Student> Students = (ArrayList<Student>)jdbc.query(query, parameters, new BeanPropertyRowMapper<Student>(Student.class));
		
		 
		 return Students;
	
	
	
}

}
