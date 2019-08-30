package laskin;

/**
 * Laskimesta peritty funktiolaskin. Toteuta metodit. Halutessasi voit
 * kirjoittaa testit ensin.
 *
 */
public class FunktioLaskin extends NeliLaskin{

	public double neliöjuuri(double x) {
		double juuri = x/2.0;
		//Palauttaa nollan jos luku on negatiivinen tai nolla
		if(x <= 0 ) {
			return 0.0;
		}
		int i = 0;
		while(i < 100) {
			juuri = 0.5*(juuri + x/juuri);
			i++;
		}
		return juuri;
	}

	public int potenssi(int x, int y) {
		int potenssi = 1;
		for(int i = 0; i < y; i++) {
			potenssi = potenssi * x;
		}
		return potenssi;
	}

	public double gcd(int a, int b) {		
		double pieni = 0;
		double suuri = 0;
		if(a < b) {
			pieni = a;
			suuri = b;
		}else {
			pieni = b;
			suuri = a;
		}
		int kerroin = 0;
		double apu = suuri;		
		double jaannos = 1;
		
		while(suuri - pieni != 0) {
			apu = suuri;
			kerroin = 0;
			while(apu > 0) {
				apu = apu - pieni;
				kerroin++;
			}
			jaannos = suuri - (kerroin-1)*pieni;
			suuri = pieni;
			pieni = jaannos;
		}
		return suuri;
	}
}
