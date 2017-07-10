package by.htp.easyfly.bin;

import java.io.Serializable;

public class FlightDirection implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2726363883554358346L;
	private String directionCode;
	private String name;
	private String directionCountry;
	private String directionCity;

	public FlightDirection() {
	}

//	public FlightDirection(String cityDirection) {
//		
//	}
//	public FlightDirection(String directionCode, String name, String directionCountry, String directionCity) {
//		super();
//		this.directionCode = directionCode;
//		this.name = name;
//		this.directionCountry = directionCountry;
//		this.directionCity = directionCity;
//	}


	public FlightDirection(String directionCity) {
		super();
		this.directionCity = directionCity;
	}


	

	public String getDirectionCode() {
		return directionCode;
	}

	public void setDirectionCode(String directionCode) {
		this.directionCode = directionCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirectionCountry() {
		return directionCountry;
	}

	public void setDirectionCountry(String directionCountry) {
		this.directionCountry = directionCountry;
	}

	public String getDirectionCity() {
		return directionCity;
	}

	public void setDirectionCity(String directionCity) {
		this.directionCity = directionCity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((directionCity == null) ? 0 : directionCity.hashCode());
		result = prime * result + ((directionCode == null) ? 0 : directionCode.hashCode());
		result = prime * result + ((directionCountry == null) ? 0 : directionCountry.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		FlightDirection other = (FlightDirection) obj;
		if (directionCity == null) {
			if (other.directionCity != null)
				return false;
		} else if (!directionCity.equals(other.directionCity))
			return false;
		if (directionCode == null) {
			if (other.directionCode != null)
				return false;
		} else if (!directionCode.equals(other.directionCode))
			return false;
		if (directionCountry == null) {
			if (other.directionCountry != null)
				return false;
		} else if (!directionCountry.equals(other.directionCountry))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlightDirection [directionCode=" + directionCode + ", name=" + name + ", directionCountry="
				+ directionCountry + ", directionCity=" + directionCity + "]";
	}

}
