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
    private String email;

	private Date passportExpiry;
	private Baggage baggage;

	public Passenger() {

	}

	public Passenger(int age, String name, String surname, String middleName, Date dateOfBirth, String passportId, String sex,
			Date passportExpiry, Baggage baggage, String email) {
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
        this.email=email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (age != passenger.age) return false;
        if (passengerId != passenger.passengerId) return false;
        if (baggage != passenger.baggage) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(passenger.dateOfBirth) : passenger.dateOfBirth != null)
            return false;
        if (email != null ? !email.equals(passenger.email) : passenger.email != null) return false;
        if (middleName != null ? !middleName.equals(passenger.middleName) : passenger.middleName != null) return false;
        if (name != null ? !name.equals(passenger.name) : passenger.name != null) return false;
        if (passportExpiry != null ? !passportExpiry.equals(passenger.passportExpiry) : passenger.passportExpiry != null)
            return false;
        if (passportId != null ? !passportId.equals(passenger.passportId) : passenger.passportId != null) return false;
        if (sex != null ? !sex.equals(passenger.sex) : passenger.sex != null) return false;
        return !(surname != null ? !surname.equals(passenger.surname) : passenger.surname != null);

    }

    @Override
    public int hashCode() {
        int result = passengerId;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (passportId != null ? passportId.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (passportExpiry != null ? passportExpiry.hashCode() : 0);
        result = 31 * result + (baggage != null ? baggage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportId='" + passportId + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", passportExpiry=" + passportExpiry +
                ", baggage=" + baggage +
                '}';
    }
}
