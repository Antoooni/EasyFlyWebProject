package by.htp.bin;

import java.io.Serializable;

public class Plane implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7252675129032177273L;
	private String planeName;
	private int planeCapacity;

	public Plane() {

	}

	public Plane(String planeName, int planeCapacity) {
		super();
		this.planeName = planeName;
		this.planeCapacity = planeCapacity;
	}

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getPlaneCapacity() {
		return planeCapacity;
	}

	public void setPlaneCapacity(int planeCapacity) {
		this.planeCapacity = planeCapacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + planeCapacity;
		result = prime * result + ((planeName == null) ? 0 : planeName.hashCode());
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
		Plane other = (Plane) obj;
		if (planeCapacity != other.planeCapacity)
			return false;
		if (planeName == null) {
			if (other.planeName != null)
				return false;
		} else if (!planeName.equals(other.planeName))
			return false;
		return true;
	}

}
