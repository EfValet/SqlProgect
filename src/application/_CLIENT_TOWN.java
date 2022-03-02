package application;

public class _CLIENT_TOWN {
	
	private String FIO;
	private String town;
	
	_CLIENT_TOWN(){}

	public _CLIENT_TOWN(String fIO, String town) {
		super();
		FIO = fIO;
		this.town = town;
	}

	public String getFIO() {
		return FIO;
	}

	public void setFIO(String fIO) {
		FIO = fIO;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	

}
