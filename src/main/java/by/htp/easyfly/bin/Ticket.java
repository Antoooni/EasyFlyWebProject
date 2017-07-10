package by.htp.easyfly.bin;

import java.io.Serializable;

public class Ticket implements Serializable {
	private static final long serialVersionUID = -91264687964821166L;
	
	private int flightId;
	private int passengerId;
	private boolean primaryBoarding;
	private boolean onlineCheckIn;
	private double totalAmount;
	
	public Ticket(){
		
	}
	
	public Ticket(int flightId, int passengerId, boolean primaryBoarding, boolean onlineCheckIn,
			double totalAmount) {
		super();
		this.flightId = flightId;
		this.passengerId = passengerId;
		this.primaryBoarding = primaryBoarding;
		this.onlineCheckIn = onlineCheckIn;
		this.totalAmount = totalAmount;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public boolean isPrimaryBoarding() {
		return primaryBoarding;
	}

	public void setPrimaryBoarding(boolean primaryBoarding) {
		this.primaryBoarding = primaryBoarding;
	}

	public boolean isOnlineCheckIn() {
		return onlineCheckIn;
	}

	public void setOnlineCheckIn(boolean onlineCheckIn) {
		this.onlineCheckIn = onlineCheckIn;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flightId;
		result = prime * result + (onlineCheckIn ? 1231 : 1237);
		result = prime * result + passengerId;
		result = prime * result + (primaryBoarding ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Ticket other = (Ticket) obj;
		if (flightId != other.flightId)
			return false;
		if (onlineCheckIn != other.onlineCheckIn)
			return false;
		if (passengerId != other.passengerId)
			return false;
		if (primaryBoarding != other.primaryBoarding)
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double.doubleToLongBits(other.totalAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [flightId=" + flightId + ", passengerId=" + passengerId + ", primaryBoarding=" + primaryBoarding
				+ ", onlineCheckIn=" + onlineCheckIn + ", totalAmount=" + totalAmount + "]";
	}

	

	

}
