package test;

import test.demot2.Laivatesti;
import test.laskintestit.FunktioLaskinTesti;
import test.laskintestit.LaskinTesti;
import test.laskintestit.NelilaskinTesti;
import test.merkkijonotestit.MerkkijonoTesti;

public class TestinSuorittaja{

	// kun ohjelmoit uusia testiluokkia, lisää ne tähän.
	static Testi[] testit = { new NelilaskinTesti(), new MerkkijonoTesti(), new LaskinTesti(), new FunktioLaskinTesti(), new Laivatesti() };

	/*
	 * Huom! Tämä ohjelma on suoritettava antamalla virtuaalikoneelle seuraava vipu:
	 * -ea tai -enableassertions
	 * 
	 */
	public static void main(String[] args) {
		suoritaKaikkiTestit(); // voit kokeilla vaihtaa tämän tilanne alempana määritellyn metodin, joka ei
								// pysähdy virheeseen
	}

	/**
	 * Suorittaa kaikki testit, jotka on määritelty taulukossa "testit"
	 */
	public static void suoritaKaikkiTestit() {

		for (Testi t : testit) {
			String testinNimi = t.getClass().getSimpleName();
			System.out.println("Suoritetaan: " + testinNimi);

			t.suoritaTestit();

		}
		System.out.println("Kaikki testit suoritettu onnistuneesti!");
	}

	/**
	 * Tämä on mahdollisesti järkevämpi tapa suorittaa testit: Jos testi
	 * epäonnistuu, sen heittämä virhe otetaan kiinni ja tulostetaan
	 * virheilmoitus.<br>
	 * Näin voidaan jatkaa loppuun asti ja suorittaa kaikki testit.
	 */
	public static void suoritaKaikkiTestitVaikkaTestiEpäonnistuu() {
		int virheita = 0;
		for (Testi t : testit) {
			String testinNimi = t.getClass().getSimpleName();
			System.out.println("Suoritetaan: " + testinNimi);

			try {
				t.suoritaTestit();
			} catch (Throwable e) {
				System.out.println("Testi \"" + testinNimi + "\" epäonnistui:");
				e.printStackTrace();
				virheita++;
			}
		}
		System.out.println("Testit suoritettu: " + (testit.length - virheita) + "/" + testit.length + " onnistui");

	}
}
