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
		//������ ����������
        try
        {
        	//������ �� �������
            String driver = "com.mysql.cj.jdbc.Driver";
            
            //������ �� ���� ������
            String url = "jdbc:mysql://localhost/hotel?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
            
            //��������� ����� ������ ��� ��
            String user = "root";
            String password = "admin";
            Class.forName(driver);
            //���������� ����������
            Connection conn = DriverManager.getConnection(url,user,password);
            return conn;

        } catch (Exception e) {System.out.println(e);}
        return null;
    }
	
	public ObservableList<_CLIENT> getListClient(){
		
		//������ ���������� � ����� ������
		try {
			Connection connection;
			connection = getConnection();
			//������ ������ �������� ���� ����������
		ObservableList<_CLIENT> list = FXCollections.observableArrayList();
		
		try {
			//������ ����� ������� � ��
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + Def.CLIENT_TABLE);
			
			//�������� ��������� �������
			ResultSet rs = ps.executeQuery();
			
			//���������� �� ���� ������� �������-����������
			while(rs.next())
			{
				//��������� � ������ ���������� �������
				list.add(new _CLIENT(rs.getString(Def.CLIENT_FIRST) + " " + 
						rs.getString(Def.CLIENT_SECOND) + " " + rs.getString(Def.CLIENT_PATRONYMIC), 
						rs.getString(Def.CLIENT_PASSPORT), rs.getString(Def.CLIENT_WHEREFROM), 
						rs.getString(Def.CLIENT_ROOM), rs.getString(Def.CLIENT_FLOOR),
						rs.getString(Def.CLIENT_DATE), rs.getString(Def.CLIENT_COUNTDAYS)));
				}
			//���������� ������-���������
			return list;
			} catch (Exception e1) {System.out.println(e1);}
		
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public ObservableList<_STAFF> getListSTAFF(){
			
			//������ ���������� � ����� ������
			try {
				Connection connection;
				connection = getConnection();
				//������ ������ �������� ���� ����������
			ObservableList<_STAFF> list = FXCollections.observableArrayList();
			
			try {
				//������ ����� ������� � ��
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + Def.STAFF_TABLE);
				
				//�������� ��������� �������
				ResultSet rs = ps.executeQuery();
				
				//���������� �� ���� ������� �������-����������
				while(rs.next())
				{
					//��������� � ������ ���������� �������
					list.add(new _STAFF(rs.getString(Def.STAFF_FIRST) + " " + 
					rs.getString(Def.STAFF_SECOND) + " " + rs.getString(Def.STAFF_PATRONYMIC),
					rs.getString(Def.STAFF_FLOORLIST), rs.getString(Def.STAFF_DAYLIST)));
					}
				
				//���������� ������-���������
				return list;
				} catch (Exception e1) {System.out.println(e1);}
				
			} catch (Exception e1) {System.out.println(e1);}
			return null;
		}

	public ObservableList<_ROOM> getListRoom(){
		
		//������ ���������� � ����� ������
		try {
			Connection connection;
			connection = getConnection();
			//������ ������ �������� ���� ����������
		ObservableList<_ROOM> list = FXCollections.observableArrayList();
		
		try {
			//������ ����� ������� � ��
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + Def.HOTEL_TABLE);
			
			//�������� ��������� �������
			ResultSet rs = ps.executeQuery();
			
			//���������� �� ���� ������� �������-����������
			while(rs.next())
			{
				//��������� � ������ ���������� �������
				list.add(new _ROOM(rs.getString(Def.HOTEL_ROOM), rs.getString(Def.HOTEL_FLOOR), 
						rs.getString(Def.HOTEL_ROOMTYPE),rs.getInt(Def.HOTEL_PRICEDAY),
						rs.getString(Def.HOTEL_CLIENTLIST),rs.getString(Def.HOTEL_PERSONALLIST)));
				}
			
			//���������� ������-���������
			return list;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public ObservableList<_CLIENT_TOWN> getListClientTown(){
		
		//������ ���������� � ����� ������
		try {
			Connection connection;
			connection = getConnection();
			//������ ������ �������� ���� ����������
		ObservableList<_CLIENT_TOWN> list = FXCollections.observableArrayList();
		
		try {
			//������ ����� ������� � ��
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + Def.CLIENT_TABLE + 
																" WHERE " + Def.CLIENT_WHEREFROM + " = "
																+ "\"" + Def.searchTown + "\"");
			
			//�������� ��������� �������
			ResultSet rs = ps.executeQuery();
			
			//���������� �� ���� ������� �������-����������
			while(rs.next())
			{
				//��������� � ������ ���������� �������
				list.add(new _CLIENT_TOWN(rs.getString(Def.CLIENT_FIRST) + " " + rs.getString(Def.CLIENT_SECOND) + 
										" " + rs.getString(Def.CLIENT_PATRONYMIC), rs.getString(Def.CLIENT_WHEREFROM)));
				}
			
			//���������� ������-���������
			return list;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public ObservableList<_ONE> getListSTAFFSearch(){
		
		//������ ���������� � ����� ������
		try {
			Connection connection;
			connection = getConnection();
			//������ ������ �������� ���� ����������
		ObservableList<_ONE> list = FXCollections.observableArrayList();
		
		try {
			//������ ����� ������� � ��
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + Def.STAFF_TABLE);
			System.out.println("������ ������");
			//�������� ��������� �������
			ResultSet rs = ps.executeQuery();
			//���������� �� ���� ������� �������-����������
			
			while(rs.next())
			{
				String[] strDay = rs.getString(Def.STAFF_DAYLIST).split(", ");
				String[] strFloor = rs.getString(Def.STAFF_FLOORLIST).split(", ");
				
				for(int i = 0; i < strDay.length;i++){
					
					if(strDay[i].equals(Def.searchDay)){
												
						for(int s = 0; s < strFloor.length; s++){
							
							if(strFloor[s].equals(Def.searchDayRoom)) {
								
								//��������� � ������ ���������� �������
								list.add(new _ONE(rs.getString(Def.STAFF_FIRST) + " " + 
								rs.getString(Def.STAFF_SECOND) + " " + rs.getString(Def.STAFF_PATRONYMIC)));
							}}}}
				}
			//���������� ������-���������
			return list;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public String getStringPriceRoom(){
		
		//������ ���������� � ����� ������
		try {
			Connection connection;
			connection = getConnection();
		
		try {
			//������ ����� ������� � ��
			PreparedStatement ps = connection.prepareStatement(
								"SELECT * FROM " + Def.HOTEL_TABLE + " WHERE " + 
								Def.HOTEL_ROOM + " = " + Def.searchRroom + 
								" and " + Def.HOTEL_FLOOR + " = " + Def.searchFloor);
			
			//�������� ��������� �������
			String priceText = "��������� ����� �� ����������";
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
					priceText = "     ��������� ������ ����� " + rs.getString(Def.HOTEL_PRICEDAY);
			}
			
			return priceText;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public String getInfoForFreeRoom(){
		
		//������ ���������� � ����� ������
		try {
			Connection connection;
			connection = getConnection();
		
		try {
			//������ ����� ������� � ��
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + Def.CLIENT_TABLE);
			
			//�������� ��������� �������
			
			ResultSet rs = ps.executeQuery();
			
			String priceText = "��������� ���� ���";
			int count = 0;
				while(rs.next()) {
					count++;
				}
			count = Def.countPlace - count;
			
				if(count > 0) {
					priceText = "   ��������� ���� � ��������� " + count;
				}
				else priceText = "   ��������� ���� � ��������� ���";
				
			return priceText;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public String getInfoAllMoney(){
		
		//������ ���������� � ����� ������
		try {
			Connection connection;
			connection = getConnection();
		
		try {
			//������ ����� ������� � ��
			PreparedStatement ps = connection.prepareStatement("SELECT countDays, priceDay FROM client "
					+ "JOIN hotel ON (client.room = hotel.room and client.floor = hotel.floor); ");
			//�������� ��������� �������
			
			ResultSet rs = ps.executeQuery();
			
			String priceText = "�������� � �������� �������";
			int countMoney = 0;
				while(rs.next()) {
					countMoney = countMoney + (rs.getInt(Def.CLIENT_COUNTDAYS)* rs.getInt(Def.HOTEL_PRICEDAY));
				}
				if(countMoney > 0) {
					priceText = "  ������� ��������� ����� " + countMoney;
				}
				else priceText = "�������� � �������� �������";
				
			return priceText;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public ObservableList<_ONE> getListOnlyLived(){
		
		//������ ���������� � ����� ������
		try {
			Connection connection;
			connection = getConnection();
			//������ ������ �������� ���� ����������
		ObservableList<_ONE> list = FXCollections.observableArrayList();
		
		try {
			//������ ����� ������� � ��
			PreparedStatement ps = connection.prepareStatement("SELECT firstName, secondName, patronymic, roomType \r\n"
					+ "FROM client\r\n"
					+ "INNER JOIN hotel ON client.room = hotel.room and client.floor = hotel.floor\r\n"
					+ "WHERE roomType = \"�����������\";" );
			//�������� ��������� �������
			ResultSet rs = ps.executeQuery();
			//���������� �� ���� ������� �������-����������
			
			while(rs.next())
			{	
				//��������� � ������ ���������� �������
				list.add(new _ONE(rs.getString(Def.CLIENT_FIRST) + " " + 
				rs.getString(Def.CLIENT_SECOND) + " " + rs.getString(Def.CLIENT_PATRONYMIC)));
			}
			//���������� ������-���������
			return list;
			} catch (Exception e1) {System.out.println(e1);}
			
		} catch (Exception e1) {System.out.println(e1);}
		return null;
	}
	
	public void addSTAFF(String firstName,String secondName,
			String patronymic,String floorList,String dayList){
			
			//������ ���������� � ����� ������
			try {
				Connection connection;
				connection = getConnection();
			try {
				//������ ����� ������� � ��
				PreparedStatement ps = connection.prepareStatement(
									"INSERT INTO `personnel` (`" + Def.STAFF_FIRST + "`, `" + 
				Def.STAFF_SECOND + "`, `" + Def.STAFF_PATRONYMIC + "`, `" +
				Def.STAFF_FLOORLIST + "`, `" + Def.STAFF_DAYLIST + "`) VALUES ('" + firstName +
				"', '" + secondName + "', '" + patronymic + "', '" + patronymic + "', '" + dayList + "');");
				
				//�������� ��������� �������
				
				ps.executeUpdate();
				} catch (Exception e1) {System.out.println(e1);}
				
			} catch (Exception e1) {System.out.println(e1);}
		}
}
