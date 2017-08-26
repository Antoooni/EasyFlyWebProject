package by.htp.easyfly.bin;

import java.io.Serializable;

public class Ticket implements Serializable {
	private static final long serialVersionUID = -91264687964821166L;
	
	private int flightId;
	private int passengerId;
	private boolean primaryBoarding;
	private boolean onlineCheckIn;
	private double totalAmount;
    private User user;
	
	public Ticket(){
		
	}
    public Ticket(int flightId, int passengerId, boolean primaryBoarding, boolean onlineCheckIn, double totalAmount){
        super();
        this.flightId=flightId;
        this.passengerId=passengerId;
        this.primaryBoarding=primaryBoarding;
        this.onlineCheckIn=onlineCheckIn;
        this.totalAmount=totalAmount;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (flightId != ticket.flightId) return false;
        if (onlineCheckIn != ticket.onlineCheckIn) return false;
        if (passengerId != ticket.passengerId) return false;
        if (primaryBoarding != ticket.primaryBoarding) return false;
        if (Double.compare(ticket.totalAmount, totalAmount) != 0) return false;
        if (!user.equals(ticket.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = flightId;
        result = 31 * result + passengerId;
        result = 31 * result + (primaryBoarding ? 1 : 0);
        result = 31 * result + (onlineCheckIn ? 1 : 0);
        temp = Double.doubleToLongBits(totalAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "flightId=" + flightId +
                ", passengerId=" + passengerId +
                ", primaryBoarding=" + primaryBoarding +
                ", onlineCheckIn=" + onlineCheckIn +
                ", totalAmount=" + totalAmount +
                ", user=" + user +
                '}';
    }
}
