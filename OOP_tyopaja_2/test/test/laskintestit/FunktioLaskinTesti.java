package test.laskintestit;

import laskin.FunktioLaskin;

public class FunktioLaskinTesti extends NelilaskinTesti{

	public void potenssiTesti(){
		FunktioLaskin fl = new FunktioLaskin();
		
		int oikea = 125;
		int tulos = fl.potenssi(5,3);
		
		assert oikea == tulos : "Potenssilaskin ei toimi oikein!";
	}
	
	public void neliojuuriTesti(){
		FunktioLaskin fl = new FunktioLaskin();
		
		double oikea = 3.0;
		double tulos = fl.neliöjuuri(9);
		
		assert oikea == tulos : "Neliojuurilaskin ei toimi oikein!";
	}
	
	public void GCDTesti(){
		FunktioLaskin fl = new FunktioLaskin();
		
		double oikea = 3;
		double tulos = fl.gcd(15,27);
		
		assert oikea == tulos : "GCD-laskin ei toimi oikein!";
	}
	
	@Override
	public void suoritaTestit() {
		summaTesti();
		tuloTesti();
		erotustesti();
		testaaYhteenlaskuNegatiivisillaLuvuilla();
		summaTestiYlivuodolla();
		potenssiTesti();
		neliojuuriTesti();
		GCDTesti();
	}
}
