package grafiikkatesti;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		GrafiikkaTesti kentta = new GrafiikkaTesti();

		kentta.setTitle("Animated ball");

		kentta.pack();

		kentta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		kentta.setVisible(true);

	}
}
