package application;

public class _CLIENT {
	
	private String FIO;
	private String passport;
	private String whereFrom;
	private String room;
	private String place;
	private String date;
	private String countDays;
	
	_CLIENT(){	
	}

	public _CLIENT(String fIO, String passport, String whereFrom, String room, String place, String date, String countDays) {
		super();
		FIO = fIO;
		this.passport = passport;
		this.whereFrom = whereFrom;
		this.room = room;
		this.place = place;
		this.date = date;
		this.countDays = countDays;
	}

	public String getFIO() {
		return FIO;
	}

	public void setFIO(String fIO) {
		FIO = fIO;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getWhereFrom() {
		return whereFrom;
	}

	public void setWhereFrom(String whereFrom) {
		this.whereFrom = whereFrom;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCountDays() {
		return countDays;
	}

	public void setCountDays(String countDays) {
		this.countDays = countDays;
	}
	
	

}
