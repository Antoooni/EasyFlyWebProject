package by.htp.easyfly.bin;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 5699222310780018128L;
	private int userId;
	private String userName;
	private String userSurname;
	private String userEmail;
	private LogonData logonData;
	private String role;
	private Ticket ticket;

	public User() {

	}

	public User(int userId, String userName, String userSurname, String userEmail, Ticket ticket) {
		super();
		this.userId=userId;
		this.userName = userName;
		this.userSurname = userSurname;
		this.userEmail = userEmail;
		this.ticket = ticket;
	}

	public User(String userName, String userSurname, String userEmail, Ticket ticket, LogonData logonData) {
		super();
		this.userName = userName;
		this.userSurname = userSurname;
		this.userEmail = userEmail;
		this.ticket = ticket;
		this.logonData = logonData;
	}

	public User(String userName, String userSurname, String role) {
		super();
		this.userName = userName;
		this.userSurname = userSurname;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public LogonData getLogonData() {
		return logonData;
	}

	public void setLogonData(LogonData logonData) {
		this.logonData = logonData;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logonData == null) ? 0 : logonData.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userSurname == null) ? 0 : userSurname.hashCode());
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
		User other = (User) obj;
		if (logonData == null) {
			if (other.logonData != null)
				return false;
		} else if (!logonData.equals(other.logonData))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (ticket == null) {
			if (other.ticket != null)
				return false;
		} else if (!ticket.equals(other.ticket))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userSurname == null) {
			if (other.userSurname != null)
				return false;
		} else if (!userSurname.equals(other.userSurname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSurname=" + userSurname + ", userEmail="
				+ userEmail + ", logonData=" + logonData + ", role=" + role + ", ticket=" + ticket + "]";
	}

	
	
}