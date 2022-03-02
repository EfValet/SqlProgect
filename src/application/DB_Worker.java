package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DB_Worker {
	
	public static Connection getConnection() throws  Exception
    {
		//Создаём соединение
        try
        {
        	//ссылка на драйвер
            String driver = "com.mysql.cj.jdbc.Driver";
            
            //ссылка на базу данных
            String url = "jdbc:mysql://localhost/hotel?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
            
            //указываем логин пароль для БД
            String user = "root";
            String password = "admin";
            Class.forName(driver);
            //Производим соединение
            Connection conn = DriverManager.getConnection(url,user,password);
            return conn;

        } catch (Exception e) {System.out.println(e);}
        return null;
    }
	
	public ObservableList<_CLIENT> getListClient(){
		
		//Создаём соединение с базой данных
		try {
			Connection connection;
			connection = getConnection();
			//Создаём список объектов типа абитуриент
		ObservableList<_CLIENT> list = FXCollections.observableArrayList();
		
		try {
			//Создаём текст запроса в БД
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + Def.CLIENT_TABLE);
			
			//Получаем результат запроса
			ResultSet rs = ps.executeQuery();
			
			//Проходимся по всем строкам таблицы-результата
			while(rs.next())
			{
				//Добавляет в список результаты запроса
				list.add(new _CLIENT(rs.getString(Def.CLIENT_FIRST) + " " + 
						rs.getString(Def.CLIENT_SECOND) + " " + rs.getString(Def.CLIENT_PATRONYMIC), 
						rs.getString(Def.CLIENT_PASSPORT), rs.getString(Def.CLIENT_WHEREFROM), 
						rs.getString(Def.CLIENT_ROOM), rs.getString(Def.CLIENT_FLOOR),
						rs.getString(Def.CLIENT_DATE), rs.getString(Def.CLIENT_COUNTDAYS)));
				}
			//Возвращает список-результат
			return list;
			} catch (Exception e1) {System.out.println(e1);}
		
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public ObservableList<_STAFF> getListSTAFF(){
			
			//Создаём соединение с базой данных
			try {
				Connection connection;
				connection = getConnection();
				//Создаём список объектов типа абитуриент
			ObservableList<_STAFF> list = FXCollections.observableArrayList();
			
			try {
				//Создаём текст запроса в БД
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + Def.STAFF_TABLE);
				
				//Получаем результат запроса
				ResultSet rs = ps.executeQuery();
				
				//Проходимся по всем строкам таблицы-результата
				while(rs.next())
				{
					//Добавляет в список результаты запроса
					list.add(new _STAFF(rs.getString(Def.STAFF_FIRST) + " " + 
					rs.getString(Def.STAFF_SECOND) + " " + rs.getString(Def.STAFF_PATRONYMIC),
					rs.getString(Def.STAFF_FLOORLIST), rs.getString(Def.STAFF_DAYLIST)));
					}
				
				//Возвращает список-результат
				return list;
				} catch (Exception e1) {System.out.println(e1);}
				
			} catch (Exception e1) {System.out.println(e1);}
			return null;
		}

	public ObservableList<_ROOM> getListRoom(){
		
		//Создаём соединение с базой данных
		try {
			Connection connection;
			connection = getConnection();
			//Создаём список объектов типа абитуриент
		ObservableList<_ROOM> list = FXCollections.observableArrayList();
		
		try {
			//Создаём текст запроса в БД
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + Def.HOTEL_TABLE);
			
			//Получаем результат запроса
			ResultSet rs = ps.executeQuery();
			
			//Проходимся по всем строкам таблицы-результата
			while(rs.next())
			{
				//Добавляет в список результаты запроса
				list.add(new _ROOM(rs.getString(Def.HOTEL_ROOM), rs.getString(Def.HOTEL_FLOOR), 
						rs.getString(Def.HOTEL_ROOMTYPE),rs.getInt(Def.HOTEL_PRICEDAY),
						rs.getString(Def.HOTEL_CLIENTLIST),rs.getString(Def.HOTEL_PERSONALLIST)));
				}
			
			//Возвращает список-результат
			return list;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public ObservableList<_CLIENT_TOWN> getListClientTown(){
		
		//Создаём соединение с базой данных
		try {
			Connection connection;
			connection = getConnection();
			//Создаём список объектов типа абитуриент
		ObservableList<_CLIENT_TOWN> list = FXCollections.observableArrayList();
		
		try {
			//Создаём текст запроса в БД
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + Def.CLIENT_TABLE + 
																" WHERE " + Def.CLIENT_WHEREFROM + " = "
																+ "\"" + Def.searchTown + "\"");
			
			//Получаем результат запроса
			ResultSet rs = ps.executeQuery();
			
			//Проходимся по всем строкам таблицы-результата
			while(rs.next())
			{
				//Добавляет в список результаты запроса
				list.add(new _CLIENT_TOWN(rs.getString(Def.CLIENT_FIRST) + " " + rs.getString(Def.CLIENT_SECOND) + 
										" " + rs.getString(Def.CLIENT_PATRONYMIC), rs.getString(Def.CLIENT_WHEREFROM)));
				}
			
			//Возвращает список-результат
			return list;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public ObservableList<_ONE> getListSTAFFSearch(){
		
		//Создаём соединение с базой данных
		try {
			Connection connection;
			connection = getConnection();
			//Создаём список объектов типа абитуриент
		ObservableList<_ONE> list = FXCollections.observableArrayList();
		
		try {
			//Создаём текст запроса в БД
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + Def.STAFF_TABLE);
			System.out.println("Запрос прошёл");
			//Получаем результат запроса
			ResultSet rs = ps.executeQuery();
			//Проходимся по всем строкам таблицы-результата
			
			while(rs.next())
			{
				String[] strDay = rs.getString(Def.STAFF_DAYLIST).split(", ");
				String[] strFloor = rs.getString(Def.STAFF_FLOORLIST).split(", ");
				
				for(int i = 0; i < strDay.length;i++){
					
					if(strDay[i].equals(Def.searchDay)){
												
						for(int s = 0; s < strFloor.length; s++){
							
							if(strFloor[s].equals(Def.searchDayRoom)) {
								
								//Добавляет в список результаты запроса
								list.add(new _ONE(rs.getString(Def.STAFF_FIRST) + " " + 
								rs.getString(Def.STAFF_SECOND) + " " + rs.getString(Def.STAFF_PATRONYMIC)));
							}}}}
				}
			//Возвращает список-результат
			return list;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public String getStringPriceRoom(){
		
		//Создаём соединение с базой данных
		try {
			Connection connection;
			connection = getConnection();
		
		try {
			//Создаём текст запроса в БД
			PreparedStatement ps = connection.prepareStatement(
								"SELECT * FROM " + Def.HOTEL_TABLE + " WHERE " + 
								Def.HOTEL_ROOM + " = " + Def.searchRroom + 
								" and " + Def.HOTEL_FLOOR + " = " + Def.searchFloor);
			
			//Получаем результат запроса
			String priceText = "Выбранный номер не существует";
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
					priceText = "     Стоимость номера равна " + rs.getString(Def.HOTEL_PRICEDAY);
			}
			
			return priceText;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public String getInfoForFreeRoom(){
		
		//Создаём соединение с базой данных
		try {
			Connection connection;
			connection = getConnection();
		
		try {
			//Создаём текст запроса в БД
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + Def.CLIENT_TABLE);
			
			//Получаем результат запроса
			
			ResultSet rs = ps.executeQuery();
			
			String priceText = "Свободных мест нет";
			int count = 0;
				while(rs.next()) {
					count++;
				}
			count = Def.countPlace - count;
			
				if(count > 0) {
					priceText = "   Свободных мест в гостинице " + count;
				}
				else priceText = "   Свободных мест в гостинице нет";
				
			return priceText;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public String getInfoAllMoney(){
		
		//Создаём соединение с базой данных
		try {
			Connection connection;
			connection = getConnection();
		
		try {
			//Создаём текст запроса в БД
			PreparedStatement ps = connection.prepareStatement("SELECT countDays, priceDay FROM client "
					+ "JOIN hotel ON (client.room = hotel.room and client.floor = hotel.floor); ");
			//Получаем результат запроса
			
			ResultSet rs = ps.executeQuery();
			
			String priceText = "Проблема с подчётом выручки";
			int countMoney = 0;
				while(rs.next()) {
					countMoney = countMoney + (rs.getInt(Def.CLIENT_COUNTDAYS)* rs.getInt(Def.HOTEL_PRICEDAY));
				}
				if(countMoney > 0) {
					priceText = "  Выручка гостинной равна " + countMoney;
				}
				else priceText = "Проблема с подчётом выручки";
				
			return priceText;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public ObservableList<_ONE> getListOnlyLived(){
		
		//Создаём соединение с базой данных
		try {
			Connection connection;
			connection = getConnection();
			//Создаём список объектов типа абитуриент
		ObservableList<_ONE> list = FXCollections.observableArrayList();
		
		try {
			//Создаём текст запроса в БД
			PreparedStatement ps = connection.prepareStatement("SELECT firstName, secondName, patronymic, roomType \r\n"
					+ "FROM client\r\n"
					+ "INNER JOIN hotel ON client.room = hotel.room and client.floor = hotel.floor\r\n"
					+ "WHERE roomType = \"Одноместный\";" );
			//Получаем результат запроса
			ResultSet rs = ps.executeQuery();
			//Проходимся по всем строкам таблицы-результата
			
			while(rs.next())
			{	
				//Добавляет в список результаты запроса
				list.add(new _ONE(rs.getString(Def.CLIENT_FIRST) + " " + 
				rs.getString(Def.CLIENT_SECOND) + " " + rs.getString(Def.CLIENT_PATRONYMIC)));
			}
			//Возвращает список-результат
			return list;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public void addSTAFF(String firstName,String secondName,
			String patronymic,String floorList,String dayList){
			
			//Создаём соединение с базой данных
			try {
				Connection connection;
				connection = getConnection();
			try {
				//Создаём текст запроса в БД
				PreparedStatement ps = connection.prepareStatement(
									"INSERT INTO `personnel` (`" + Def.STAFF_FIRST + "`, `" + 
				Def.STAFF_SECOND + "`, `" + Def.STAFF_PATRONYMIC + "`, `" +
				Def.STAFF_FLOORLIST + "`, `" + Def.STAFF_DAYLIST + "`) VALUES ('" + firstName +
				"', '" + secondName + "', '" + patronymic + "', '" + patronymic + "', '" + dayList + "');");
				
				//Получаем результат запроса
				
				ps.executeUpdate();
				} catch (Exception e1) {System.out.println(e1);}
				
			} catch (Exception e1) {System.out.println(e1);}
		}
}
