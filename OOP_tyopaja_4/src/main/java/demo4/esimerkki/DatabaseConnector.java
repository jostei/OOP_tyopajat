package demo4.esimerkki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import demo4.esimerkki.exceptions.CourseNotFoundException;
import demo4.esimerkki.exceptions.DuplicateCreditException;
import demo4.esimerkki.exceptions.StudentNotFoundExcption;

public class DatabaseConnector{

	private Connection c;

	/**
	 * Heittää poikkeuksen, jos tietokantaan yhdistämisessä tulee jokin ongelma.
	 * 
	 * @throws SQLException
	 */
	public DatabaseConnector() throws SQLException {
		//
		c = DriverManager.getConnection("jdbc:sqlite:students.db");
	}

	/**
	 * Palauttaa kysytyn opiskelijanumeron haltijan kokonaispistemäärän. <br>
	 * <br>
	 * Pohdintaa: Poikkeus heitetään, koska se signaloi kätevästi epänormaalin
	 * tilan. Jos kysely suoritetaan opiskelijanumerolla jota ei ole, palautuisi
	 * nolla. Mutta miten tämä eroaa tilanteesta, jossa opiskelijanumero on
	 * olemassa, mutta suorituksia ei vielä ole kertynyt, kuten ensimmäisen vuoden
	 * syksyn alussa? Toki tilanteessa, jossa opiskelijaa ei ole,voisi palauttaa -1,
	 * mutta käyttämällä poikkeusta, saadaan tämän metodin käyttäjä "pakotettua"
	 * reagoimaan poikkeavaan tilanteeseen
	 *
	 * 
	 * @param studentNum tarkistettava opiskelijanumero
	 * @return kyseisen opiskelijan kokonaisopintopistekertymä
	 * @throws StudentNotFoundExcption jos opiskelijaa ei ole
	 * @throws SQLException            jos tietokannassa on jotain muuta vikaa,
	 *                                 kuten yhteysongelma tai rakenteellinen
	 *                                 ongelma
	 */
	public int getTotalCredits(int studentNum) throws StudentNotFoundExcption, SQLException {

		if (!studentExists(studentNum)) {
			throw new StudentNotFoundExcption("Invalid student number:" + studentNum);
		}

		String sql = "SELECT credits FROM student_credit,course WHERE course_id==c_id AND s_num ==?";

		try (PreparedStatement ps = c.prepareStatement(sql)) {

			ps.setInt(1, studentNum);

			ResultSet r = ps.executeQuery();
			int sum = 0;
			while (r.next()) {
				sum += r.getInt(1);
			}
			return sum;
		}

	}

	/**
	 * Tarkistaa, onko kyseinen opiskelija tallennettu tietokantaan.
	 * 
	 * @param student
	 * @return
	 * @throws SQLException
	 */
	private boolean studentExists(int student) throws SQLException {
		String sql = "SELECT * FROM student WHERE student_num ==?";

		try (PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, student);
			ResultSet results = ps.executeQuery();
			return results.next();

		}
	}

	public void addCredit(int student_num, String course_id, int grade)
			throws SQLException, StudentNotFoundExcption, CourseNotFoundException, DuplicateCreditException {

		if (!studentExists(student_num)) {
			throw new StudentNotFoundExcption("Student does not exist!");
		}
		if (!courseExists(course_id)) {
			throw new CourseNotFoundException("Course does not exist!");
		}
		if (hasGrade(student_num, course_id)) {
			throw new DuplicateCreditException("Student " + student_num + " already has grade for " + course_id);
		}

		String sql = "INSERT INTO student_credit (s_num,c_id,grade) VALUES (?,?,?);";

		try (PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, student_num);
			ps.setString(2, course_id);
			ps.setInt(3, grade);
			ps.execute();
		}

	}

	private boolean hasGrade(int student_num, String course_id) throws SQLException {
		String sql = "SELECT * FROM student_credit WHERE c_id ==? AND s_num=?";

		try (PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, course_id);
			ps.setInt(2, student_num);
			ResultSet results = ps.executeQuery();
			return results.next();

		}
	}

	private boolean courseExists(String course_id) throws SQLException {
		String sql = "SELECT * FROM course WHERE course_id ==?";

		try (PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, course_id);
			ResultSet results = ps.executeQuery();
			return results.next();
		}
	}
	
	/**
	 * Hakee kaikki tietokannasta löytyvät oppilaat ja palauttaa listan nimistä.
	 * 
	 * @return Palauttaa ArrayList<String> listan nimistä, muodossa "first_name last_name".
	 * @throws SQLException jos haussa on ongelmia.
	 */
	public ArrayList<String> getStudents() throws SQLException{
		ArrayList<String> studentList = new ArrayList<String>(); 
		
		String sql = "SELECT first_name,last_name FROM student";

		try (PreparedStatement ps = c.prepareStatement(sql)) {

			ResultSet results = ps.executeQuery();
			
			while(results.next()) {
				studentList.add((results.getString("first_name")+" "+results.getString("last_name")));
			}
			
		}
		
		return studentList;
	}

}
