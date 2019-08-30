package test.laskintestit;

import laskin.Laskin;
import test.Testi;

/**
 * Tämä testi testaa ainoastaan sitä, että laske-metodia voi kutsua siinä
 * määritellyillä operaattoreilla. Testi ei siis testaa, ovatko tulokset oikein.
 * Se on tehty jo NelilaskinTesti -luokassa.<br>
 * Tämän testin tarkoitus on siis varmistaa, että Laskin-luokan metodi hyväksyy
 * sellaiset operaattorit kuin sen kuvauksessa ilmoitetaan
 * 
 */
public class LaskinTesti extends Testi{

	public void testaaYhteenlasku() {
		int luku1 = 4;
		int luku2 = 6;

		Exception poikkeus = null;
		try {

			Laskin.laske(luku1, luku2, '+');
		} catch (Exception e) {
			poikkeus = e;
		}

		/*
		 * Tiedämme, että Laskin.laske heittää poikkeuksen, jos se ei tunnista annettua
		 * operaattoria. Jos poikkeus on heitetty, ylläoleva try-catch -lohko ottaa sen
		 * kiinni ja tallentaa sen muuttujaan poikkeus. Jos poikkeusta ei tullut, arvo
		 * pysyy null -arvona. Haluamme siis varmistaa, ettei poikkeusta tullut, joten
		 * teemme väitteen "poikkeus ==null"
		 */

		assert poikkeus == null : "Yhteenlasku ei onnistunut: " + poikkeus.toString();

	}

	public void testaaVähennyslasku() {
		int luku1 = 4;
		int luku2 = 6;

		Exception poikkeus = null;
		try {

			Laskin.laske(luku1, luku2, '-');
		} catch (Exception e) {
			poikkeus = e;
		}

		assert poikkeus == null : "Vähennyslasku ei onnistunut: " + poikkeus.toString();

	}

	public void testaaKertolasku() {
		int luku1 = 4;
		int luku2 = 6;

		Exception poikkeus = null;
		try {

			Laskin.laske(luku1, luku2, 'x');
		} catch (Exception e) {
			poikkeus = e;
		}

		assert poikkeus == null : "Kertolasku ei onnistunut: " + poikkeus.toString();

	}

	public void testaaJakolasku() {
		int luku1 = 4;
		int luku2 = 6;

		Exception poikkeus = null;
		try {

			Laskin.laske(luku1, luku2, '/');
		} catch (Exception e) {
			poikkeus = e;
		}

		assert poikkeus == null : "Jakolasku ei onnistunut: " + poikkeus.toString();

	}

	@Override
	public void suoritaTestit() {
		// TODO: poista alempi kommentti, jotta metodi suoritetaan
		testaaKertolasku();
		testaaJakolasku();
		testaaVähennyslasku();
		testaaYhteenlasku();
	}
}
