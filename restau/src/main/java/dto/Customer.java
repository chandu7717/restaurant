package dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String fullname;
	private String password;
	private long mobileno;
	private String email;
	private LocalDate dob;
	private String gender;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] picture;
	private int age;
	private String country;

}
