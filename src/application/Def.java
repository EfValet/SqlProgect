package application;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class Def {
	
	
	public static final String CLIENT_TABLE = "client";
	
	public static final String CLIENT_FIRST = "firstName";
	public static final String CLIENT_SECOND = "secondName";
	public static final String CLIENT_PATRONYMIC = "patronymic";
	public static final String CLIENT_WHEREFROM = "whereFrom";
	public static final String CLIENT_ROOM = "room";
	public static final String CLIENT_FLOOR = "floor";
	public static final String CLIENT_DATE = "date";
	public static final String CLIENT_COUNTDAYS = "countDays";
	public static final String CLIENT_PASSPORT = "passport";
	
	public static final String HOTEL_TABLE = "hotel";
	
	public static final String HOTEL_ROOM = "room";
	public static final String HOTEL_FLOOR = "floor";
	public static final String HOTEL_ROOMTYPE = "roomType";
	public static final String HOTEL_PRICEDAY = "priceDay";
	public static final String HOTEL_CLIENTLIST = "clientList";
	public static final String HOTEL_PERSONALLIST = "personalList";
	
	
	public static final String STAFF_TABLE = "personnel";
	
	public static final String STAFF_FIRST = "firstName";
	public static final String STAFF_SECOND = "secondName";
	public static final String STAFF_PATRONYMIC = "patronymic";
	public static final String STAFF_FLOORLIST = "floorList";
	public static final String STAFF_DAYLIST = "dayList";
	
	
	//Переменные, которые будут хранить в себе текущую и предыдущую сцены, для перехода между окнами:
	public static Scene mainScene;
	public static Parent PrevWindow;
			
		public static String searchFloor;
		public static String searchRroom;
		public static String searchTown;
		public static String searchDay;
		public static String searchDayRoom;
		
		public static int countPlace = 18;
}
