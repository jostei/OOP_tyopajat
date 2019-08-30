package test.merkkijonotestit;

import merkkijonot.MerkkijonoApuvälineet;
import test.Testi;

public class MerkkijonoTesti extends Testi{

	public static void testaaKääntö() {
		/*
		 * Testauksessa on tärkeää olla käyttämättä samaa koodia, jota testataan. Tämän
		 * takia merkkijonon kääntöä tekevää algoritmia testatessa kannattaa kääntää
		 * merkkijono käsin, tai käyttäen jotain toista metodia, joka tunnetusti toimii.
		 */
		String s = "testi";
		String käännetty = "itset"; // käännetty käsin

		String testattava = MerkkijonoApuvälineet.käännäMerkkijono(s);

		// väite pitää paikkaansa, jos merkkijono kääntyi oikein.
		assert testattava.equals(käännetty);

	}

	public static void testaaHuonoaKääntöMetodia() {

		/*
		 * Testiä miettiessä kannattaa varmistaa, että testataan jotenkin järkevällä
		 * arvolla
		 */
		String s = "kahvi";
		String käännetty = "ivhak";
		String testattava = MerkkijonoApuvälineet.huonoKääntö(s);

		// Väite pitää paikkaansa: testi on suunniteltu huonosti, sillä käännettävä sana
		// on käännettynä sama.
		assert testattava.equals(käännetty);

	}

	public static void testaaHuonoaKääntöMetodia2() {

		/*
		 * Testiä miettiessä kannattaa varmistaa, että testataan jotenkin järkevällä
		 * arvolla
		 */
		String s = "testi";
		String käännetty = "itset";
		String testattava = MerkkijonoApuvälineet.huonoKääntö(s);

		// Väite pitää paikkaansa: testi on suunniteltu huonosti, sillä käännettävä sana
		// on käännettynä sama.
		assert testattava.equals(käännetty) : "Merkkijonon kääntö ei onnistunut syötteellä \"" + s + "\"";

	}

	@Override
	public void suoritaTestit() {
		testaaKääntö();
		testaaHuonoaKääntöMetodia();
		/*
		 * TODO Ensimmäisen testikerran jälkeen voit ottaa seuraavan kommentin pois ja
		 * todeta, että alkuperäinen testimetodi oli huono. Tämä pois kommentoitu metodi
		 * on parempi, sillä se antaa virheen ja näin ollen käy ilmi, ettei metodi
		 * toiminut
		 */
		testaaHuonoaKääntöMetodia2();
	}
}
