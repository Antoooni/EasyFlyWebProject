package by.htp.easyfly.bin;

import java.io.Serializable;

public class Direction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6390090317477963187L;
	private String directionCode;
	private String directionName;
	private String country;
	private String city;

	public Direction() {

	}

	public Direction(String directionCode, String directionName, String country, String city) {
		super();
		this.directionCode = directionCode;
		this.directionName = directionName;
		this.country = country;
		this.city = city;
	}

	public String getDirectionCode() {
		return directionCode;
	}

	public void setDirectionCode(String directionCode) {
		this.directionCode = directionCode;
	}

	public String getDirectionName() {
		return directionName;
	}

	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((directionCode == null) ? 0 : directionCode.hashCode());
		result = prime * result + ((directionName == null) ? 0 : directionName.hashCode());
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
		Direction other = (Direction) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (directionCode == null) {
			if (other.directionCode != null)
				return false;
		} else if (!directionCode.equals(other.directionCode))
			return false;
		if (directionName == null) {
			if (other.directionName != null)
				return false;
		} else if (!directionName.equals(other.directionName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Direction [directionCode=" + directionCode + ", directionName=" + directionName + ", country=" + country
				+ ", city=" + city + "]";
	}

}
