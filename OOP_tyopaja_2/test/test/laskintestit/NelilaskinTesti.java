package test.laskintestit;

import laskin.NeliLaskin;
import test.Testi;

/**
 * Tässä luokassa on erilaisia testejä Nelilaskinta varten. Lisäksi luokka
 * uudelleentoteuttaa yläluokasta löytyvän suoritaTestit- metodin
 * 
 * @author
 *
 */
public class NelilaskinTesti extends Testi{

	public void summaTesti() {
		NeliLaskin l = new NeliLaskin();

		/*
		 * Lasketaan vastaus kahdella eri tavalla: sekä normaalisti, että laskimen
		 * avulla.
		 */
		int oikeaVastaus = 4 + 6;
		int laskinVastus = l.summa(4, 6);

		/**
		 * Väitetään, että vastaukset ovat samat. Testiohjelma kaatuu tähän, jos laskin
		 * antaa erilaisen vastauksen.
		 */
		assert laskinVastus == oikeaVastaus;

	}

	public void testaaYhteenlaskuNegatiivisillaLuvuilla() {
		NeliLaskin l = new NeliLaskin();

		int oikeaVastaus = -4 + (-6);
		int laskinVastus = l.summa(-4, -6);

		assert laskinVastus == oikeaVastaus;
	}

	public void tuloTesti() {
		NeliLaskin l = new NeliLaskin();

		int oikeaVastaus = 4 * 6;
		int laskinVastus = l.tulo(4, 6);

		assert laskinVastus == oikeaVastaus;
	}

	public void erotustesti() {
		NeliLaskin l = new NeliLaskin();

		int oikeaVastaus = 4 - 6;
		int laskinVastus = l.erotus(4, 6);

		assert laskinVastus == oikeaVastaus;
	}

	public void summaTestiYlivuodolla() {
		NeliLaskin l = new NeliLaskin();

		int laskinVastus = l.summa(Integer.MAX_VALUE, 1);

		assert laskinVastus == Integer.MIN_VALUE;
	}

	public void nollallaJakaminenTesti() {
		NeliLaskin l = new NeliLaskin();

		Exception poikkeus = null;
		try {
			l.osamäärä(4, 0); // jaetaan nollalla
		} catch (Exception e) {
			poikkeus = e;
		}

		assert poikkeus instanceof ArithmeticException;
	}

	@Override
	public void suoritaTestit() {
		summaTesti();
		tuloTesti();
		erotustesti();
		testaaYhteenlaskuNegatiivisillaLuvuilla();
		summaTestiYlivuodolla();
	}

}
