package by.htp.easyfly.bin;

import java.io.Serializable;
import java.util.HashMap;

public class TicketList implements Serializable {
	private static final long serialVersionUID = 3413074416708211139L;

	private int ticketListId;
	private HashMap<User, Flight> flightList;

	public TicketList() {

	}

	public TicketList(int ticketListId,  HashMap<User, Flight> flight) {
		super();
		this.ticketListId = ticketListId;
		this.flightList = flight;
	}

	public int getTicketListId() {
		return ticketListId;
	}

	public void setTicketListId(int ticketListId) {
		this.ticketListId = ticketListId;
	}

	public HashMap<User, Flight> getFlight() {
		return flightList;
	}

	public void setFlight(HashMap<User, Flight> flight) {
		this.flightList = flight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightList == null) ? 0 : flightList.hashCode());
		result = prime * result + ticketListId;
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
		TicketList other = (TicketList) obj;
		if (flightList == null) {
			if (other.flightList != null)
				return false;
		} else if (!flightList.equals(other.flightList))
			return false;
		if (ticketListId != other.ticketListId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TicketList [ticketListId=" + ticketListId + ", flight=" + flightList + "]";
	}

}
