package by.htp.easyfly.bin;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Flight implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8813143772387838912L;
	private int flightId;
	private Direction fromDirection;
	private Date departureDate;
	private Time departureTime;
	private Direction fromCode;

	private Direction toDirection;
	private Date arrivalDate;
	private Time arrivalTime;
	private Plane plane;
	private double basicTariff;
	private String flightCode;
    private String departureAirport;
    private String arrivalAirport;

	public Flight() {

	}
	public Flight(Direction fromCode, Direction fromDirection, Date departureDate, Time departureTime, Direction toDirection,
                  Date arrivalDate, Time arrivalTime, int flightId, String flightCode) {
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

	public Flight(Direction fromCode, Direction fromDirection, Date departureDate, Time departureTime, Direction toDirection,
			Date arrivalDate, Time arrivalTime, int flightId, Plane plane, String flightCode) {
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
        this.flightCode=flightCode;
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

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Direction getFromCode() {
		return fromCode;
	}

	public void setFromCode(Direction fromCode) {
		this.fromCode = fromCode;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
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

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (Double.compare(flight.basicTariff, basicTariff) != 0) return false;
        if (flightId != flight.flightId) return false;
        if (arrivalAirport != null ? !arrivalAirport.equals(flight.arrivalAirport) : flight.arrivalAirport != null)
            return false;
        if (arrivalDate != null ? !arrivalDate.equals(flight.arrivalDate) : flight.arrivalDate != null) return false;
        if (arrivalTime != null ? !arrivalTime.equals(flight.arrivalTime) : flight.arrivalTime != null) return false;
        if (departureAirport != null ? !departureAirport.equals(flight.departureAirport) : flight.departureAirport != null)
            return false;
        if (departureDate != null ? !departureDate.equals(flight.departureDate) : flight.departureDate != null)
            return false;
        if (departureTime != null ? !departureTime.equals(flight.departureTime) : flight.departureTime != null)
            return false;
        if (flightCode != null ? !flightCode.equals(flight.flightCode) : flight.flightCode != null) return false;
        if (fromCode != null ? !fromCode.equals(flight.fromCode) : flight.fromCode != null) return false;
        if (fromDirection != null ? !fromDirection.equals(flight.fromDirection) : flight.fromDirection != null)
            return false;
        if (plane != null ? !plane.equals(flight.plane) : flight.plane != null) return false;
        if (toDirection != null ? !toDirection.equals(flight.toDirection) : flight.toDirection != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = flightId;
        result = 31 * result + (fromDirection != null ? fromDirection.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (fromCode != null ? fromCode.hashCode() : 0);
        result = 31 * result + (toDirection != null ? toDirection.hashCode() : 0);
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (plane != null ? plane.hashCode() : 0);
        temp = Double.doubleToLongBits(basicTariff);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (flightCode != null ? flightCode.hashCode() : 0);
        result = 31 * result + (departureAirport != null ? departureAirport.hashCode() : 0);
        result = 31 * result + (arrivalAirport != null ? arrivalAirport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", fromDirection=" + fromDirection +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                ", fromCode=" + fromCode +
                ", toDirection=" + toDirection +
                ", arrivalDate=" + arrivalDate +
                ", arrivalTime=" + arrivalTime +
                ", plane=" + plane +
                ", basicTariff=" + basicTariff +
                ", flightCode='" + flightCode + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                '}';
    }
}
