package application;

public class _STAFF {
	
	private String FIO;
	private String floorList;
	private String dayList;
	
	_STAFF(){
		
	}

	public _STAFF(String fIO, String floorList, String dayList) {
		super();
		FIO = fIO;
		this.floorList = floorList;
		this.dayList = dayList;
	}

	public String getFIO() {
		return FIO;
	}

	public void setFIO(String fIO) {
		FIO = fIO;
	}

	public String getFloorList() {
		return floorList;
	}

	public void setFloorList(String floorList) {
		this.floorList = floorList;
	}

	public String getDayList() {
		return dayList;
	}

	public void setDayList(String dayList) {
		this.dayList = dayList;
	}
	
	

}
