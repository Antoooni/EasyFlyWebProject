package by.htp.easyfly.bin;

import java.io.Serializable;
import java.util.Date;

public class Passenger implements Serializable {
	private static final long serialVersionUID = 6003874035003055719L;

	private int passengerId;
	private int age;

	private String name;
	private String surname;
	private String middleName;
	private Date dateOfBirth;
	private String passportId;
	private String sex;

	private Date passportExpiry;
	private Baggage baggage;

	public Passenger() {

	}

	public Passenger(int age, String name, String surname, String middleName, Date dateOfBirth, String passportId, String sex,
			Date passportExpiry, Baggage baggage) {
		super();
		this.age = age;
		this.name = name;
		this.surname = surname;
		this.middleName = middleName;
		this.dateOfBirth = dateOfBirth;
		this.passportId = passportId;
		this.sex=sex;
		this.passportExpiry = passportExpiry;
		this.baggage = baggage;
	}

	public Passenger(int passengerId, int age, String name, String surname, String middleName, Date dateOfBirth,
			String passportId, Date passportExpiry, Baggage baggage) {
		super();
		this.passengerId = passengerId;
		this.age = age;
		this.name = name;
		this.surname = surname;
		this.middleName = middleName;
		this.dateOfBirth = dateOfBirth;
		this.passportId = passportId;
		this.passportExpiry = passportExpiry;
		this.baggage = baggage;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassportId() {
		return passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getPassportExpiry() {
		return passportExpiry;
	}

	public void setPassportExpiry(Date passportExpiry) {
		this.passportExpiry = passportExpiry;
	}

	public Baggage getBaggage() {
		return baggage;
	}

	public void setBaggage(Baggage baggage) {
		this.baggage = baggage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((baggage == null) ? 0 : baggage.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + passengerId;
		result = prime * result + ((passportExpiry == null) ? 0 : passportExpiry.hashCode());
		result = prime * result + ((passportId == null) ? 0 : passportId.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if (age != other.age)
			return false;
		if (baggage != other.baggage)
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passengerId != other.passengerId)
			return false;
		if (passportExpiry == null) {
			if (other.passportExpiry != null)
				return false;
		} else if (!passportExpiry.equals(other.passportExpiry))
			return false;
		if (passportId == null) {
			if (other.passportId != null)
				return false;
		} else if (!passportId.equals(other.passportId))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", age=" + age + ", name=" + name + ", surname=" + surname
				+ ", middleName=" + middleName + ", dateOfBirth=" + dateOfBirth + ", passportId=" + passportId
				+ ", sex=" + sex + ", passportExpiry=" + passportExpiry + ", baggage=" + baggage + "]";
	}

	
}
