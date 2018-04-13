package by.grsu.nekrevich.datamodel;

import java.util.Date;

import by.grsu.nekrevich.datamodel.AbstractModel;
import by.grsu.nekrevich.datamodel.UserCredentials;

public class UserProfile extends AbstractModel {

	private UserCredentials credentials;

	private String firstName;

	private String lastName;

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public UserCredentials getCredentials() {
		return credentials;
	}

	public void setCredentials(UserCredentials credentials) {
		this.credentials = credentials;
	}

}

