package com.orosift.userservice.model;

import java.security.SecureRandom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_details")
public class User {

    private static final String NUMBERS = "0123456789";
    private static final String NUMERIC = NUMBERS;
    private static final int ID_LENGTH = 04; 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "email_id")
	private String email;

	@Column(name = "Contact")
	private String contact;

	@Column(name = "dob")
	private String DOB;
	
	@Column(name = "Password")
	private String password;

	@Column(name = "UserId")
	private String userId ;
	
	public static String generateAlphanumericID() {
        StringBuilder idBuilder = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < ID_LENGTH; i++) {
            int randomIndex = random.nextInt(NUMERIC.length());
            char randomChar = NUMERIC.charAt(randomIndex);
            idBuilder.append(randomChar);
        }

        return idBuilder.toString();
    }

}
