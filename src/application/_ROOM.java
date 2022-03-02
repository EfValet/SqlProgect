package application;

public class _ROOM {
	
	private String room;
	private String floor;
	private String roomType;
	private int priceDay;
	private String clientList;
	private String personalList;
	
	public _ROOM() {
		
	}
	
	public _ROOM(String room, String floor, String roomType, int priceDay, String clientList, String personalList) {
		super();
		this.room = room;
		this.floor = floor;
		this.roomType = roomType;
		this.priceDay = priceDay;
		this.clientList = clientList;
		this.personalList = personalList;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getPriceDay() {
		return priceDay;
	}

	public void setPriceDay(int priceDay) {
		this.priceDay = priceDay;
	}

	public String getClientList() {
		return clientList;
	}

	public void setClientList(String clientList) {
		this.clientList = clientList;
	}

	public String getPersonalList() {
		return personalList;
	}

	public void setPersonalList(String personalList) {
		this.personalList = personalList;
	}
}