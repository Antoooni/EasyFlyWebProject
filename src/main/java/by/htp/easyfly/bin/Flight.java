package by.htp.easyfly.bin;

import java.io.Serializable;
public class Flight implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8813143772387838912L;
	private int flightId;
	private Direction fromDirection;
	private String departureDate;
	private String departureTime;
	private Direction fromCode;

	private Direction toDirection;
	private String arrivalDate;
	private String arrivalTime;
	private Plane plane;
	private double basicTariff;
	private String flightCode;

	public Flight() {

	}
	public Flight(Direction fromCode, Direction fromDirection, String departureDate, String departureTime, Direction toDirection,
			String arrivalDate, String arrivalTime, int flightId, String flightCode) {
		super(); 
		this.fromCode = fromCode;
		this.fromDirection = fromDirection;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.toDirection = toDirection;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.flightId=flightId;
		this.flightCode=flightCode;
	}

	public Flight(Direction fromCode, Direction fromDirection, String departureDate, String departureTime, Direction toDirection,
			String arrivalDate, String arrivalTime, int flightId, Plane plane, String flightCode) {
		super();
		this.fromCode = fromCode;
		this.fromDirection = fromDirection;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.toDirection = toDirection;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.plane=plane;
		this.flightId=flightId;
		this.fromCode=fromCode;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public Direction getFromDirection() {
		return fromDirection;
	}

	public void setFromDirection(Direction fromDirection) {
		this.fromDirection = fromDirection;
	}

	public Direction getToDirection() {
		return toDirection;
	}

	public void setToDirection(Direction toDirection) {
		this.toDirection = toDirection;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public Direction getFromCode() {
		return fromCode;
	}

	public void setFromCode(Direction fromCode) {
		this.fromCode = fromCode;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getBasicTariff() {
		return basicTariff;
	}

	public void setBasicTariff(double basicTariff) {
		this.basicTariff = basicTariff;
	}

	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		long temp;
		temp = Double.doubleToLongBits(basicTariff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((flightCode == null) ? 0 : flightCode.hashCode());
		result = prime * result + flightId;
		result = prime * result + ((fromCode == null) ? 0 : fromCode.hashCode());
		result = prime * result + ((fromDirection == null) ? 0 : fromDirection.hashCode());
		result = prime * result + ((plane == null) ? 0 : plane.hashCode());
		result = prime * result + ((toDirection == null) ? 0 : toDirection.hashCode());
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
		Flight other = (Flight) obj;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (Double.doubleToLongBits(basicTariff) != Double.doubleToLongBits(other.basicTariff))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (flightCode == null) {
			if (other.flightCode != null)
				return false;
		} else if (!flightCode.equals(other.flightCode))
			return false;
		if (flightId != other.flightId)
			return false;
		if (fromCode == null) {
			if (other.fromCode != null)
				return false;
		} else if (!fromCode.equals(other.fromCode))
			return false;
		if (fromDirection == null) {
			if (other.fromDirection != null)
				return false;
		} else if (!fromDirection.equals(other.fromDirection))
			return false;
		if (plane == null) {
			if (other.plane != null)
				return false;
		} else if (!plane.equals(other.plane))
			return false;
		if (toDirection == null) {
			if (other.toDirection != null)
				return false;
		} else if (!toDirection.equals(other.toDirection))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", fromDirection=" + fromDirection + ", departureDate=" + departureDate
				+ ", departureTime=" + departureTime + ", fromCode=" + fromCode + ", toDirection=" + toDirection
				+ ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", plane=" + plane
				+ ", basicTariff=" + basicTariff + ", flightCode=" + flightCode + "]";
	}
	

}
