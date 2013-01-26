package ee.itcollege.i377.team08.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = ("Piirivalvur"))
@NamedQueries({
		@NamedQuery(name = "Guard.findAll", query = "SELECT g FROM Guard g WHERE g.removed IS null"),
		@NamedQuery(name = "Guard.findWithDeleted", query = "SELECT g FROM Guard g") })
public class Guard extends DatabaseModel implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int MALE = 0;
	public static final int FEMALE = 1;

	@Column(name = "aadress")
	@NotNull
	@Size(min = 4, max = 255)
	private String address;

	@Column(name = "eesnimi")
	@NotNull
	@Size(min = 2, max = 255)
	private String firstName;

	@Column(name = "perekonnanimi")
	@NotNull
	@Size(min = 2, max = 255)
	private String lastName;

	@NotNull
	@Size(min = 4, max = 255)
	private String email;

	@Column(name = "isikukood")
	@NotNull
	@Size(min = 6, max = 20)
	private String socialSecurityNumber;

	@Column(name = "sodurikood")
	@NotNull
	@Size(min = 4, max = 50)
	private String code;

	@Column(name = "sugu")
	@Range(min = 0, max = 1)
	private int gender;

	@Column(name = "telefon")
	@NotNull
	@Size(min = 2, max = 255)
	private String phone;

	public String getAddress() {
		return address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public String getCode() {
		return code;
	}

	public Character getGender() {
		return gender == MALE ? 'M' : 'F';
	}

	public String getPhone() {
		return phone;
	}

	public String getFullName() {
		return firstName + ' ' + lastName;
	}

	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setGender(Character gender) {
		this.gender = gender.equals('M') ? MALE : FEMALE;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
