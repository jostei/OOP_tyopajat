package test.demot2;

import demot2.Autolautta;
import demot2.Rahtilaiva;
import test.Testi;

public class Laivatesti extends Testi{
	
	public void testaaRahtilaivanKapasiteetti() {
		
		// Luodaan rahtilaiva 30.0 nopeudella, 100.0 kapasiteettilla, ja 50.0 rahdilla
		Rahtilaiva rl = new Rahtilaiva("Ukkopekka", 30.0, 80.0, 10.0, 50.0, 100.0);

		double oikea = 15.0;
		double tulos = rl.getSolmuNopeus();

		assert oikea == tulos : "Rahtilaivan nopeus laskettu väärin!";

	}
	
	public void testaaAutolautanKapasiteetti() {
		
		Autolautta al = new Autolautta("Tallinkki", 30.0, 70.0, 10.0, 150);

		al.lisaaAutoja(7);
		al.lisaaMatkustajia(32);
		
		int oikea = (7*10)+32;
		int tulos = al.kaytettyKapasiteetti();
		
		assert oikea == tulos : "Autolautan kapasiteetti laskettu väärin!";
	}
	
	@Override
	public void suoritaTestit() {
		testaaRahtilaivanKapasiteetti();
		testaaAutolautanKapasiteetti();
	}

}
