package demo4.esimerkki;

import java.sql.SQLException;

import demo4.esimerkki.exceptions.*;

public class StudentDatabase{
	public static void main(String[] args) {
		DatabaseConnector db = null;
		try {
			db = new DatabaseConnector();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * Tässä näyttäisi olevan käännösvirhe: Jos käyt katsomassa getTotalCredits
		 * -metodia, sen signatuurissa on throws -määrittely. Tämä tarkoittaa tietenkin,
		 * että metodi heittää poikkeuksen. Poikkeus pitää käsitellä. Huomaa, että
		 * poikkeuksia on useita. Tee siis useita peräkkäisiä catch -lohkoja, jotta voit
		 * käsitellä kaikki poikkeukset eri tavalla.
		 * 
		 * Voit myös käsitellä useampia poikkeuksia samassa lohkossa.
		 */
		try {
		int totalCredits = -1;

		totalCredits = db.getTotalCredits(666);
		}
		catch(StudentNotFoundExcption e) {
			System.out.println("Oppilasta ei löydy!");
		}
		catch(SQLException e) {
			System.out.println("Virhe yhdistäessä, yritä uudelleen myöhemmin.");
		}

		try {
		db.addCredit(666, "TKO_6556", 3);
		}
		catch(SQLException e) {
			System.out.println("Virhe yhdistäessä, yritä uudelleen myöhemmin.");
		}
		catch(StudentNotFoundExcption e) {
			System.out.println("Oppilasta ei löydy!");
		}
		catch(CourseNotFoundException e) {
			System.out.println("Kurssia ei löydy!");
		}
		catch(DuplicateCreditException e) {
			System.out.println("A!");
		}
	}
}
