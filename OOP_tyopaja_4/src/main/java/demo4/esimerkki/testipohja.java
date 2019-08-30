package demo4.esimerkki;

import java.sql.SQLException;
import java.util.ArrayList;

public class testipohja {

	public static void main(String[] args) {
		
		try {
			DatabaseConnector dc = new DatabaseConnector();
			
			ArrayList<String> tulos = dc.getStudents();
			
			System.out.println(tulos);
		} catch (SQLException e) {
			//System.out.println("Connection error.");
			e.printStackTrace();
			System.out.println("virhe :(");
		}
		
	}

}
