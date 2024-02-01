package ca.sheridancollege.tevar.beans;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
		
			private String firstName;
			private String familyName;
			private Date dob;

	

}
