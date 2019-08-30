package kalupakki;

import java.util.ArrayList;

import tyokalut.*;

/**
 * Ty�kalupakki Tyokalu-tyyppisten olioiden varastoimiseen, huoltamiseen ja k�ytt�miseen.
 * 
 */
public class Tyokalupakki {
	
	private ArrayList<Tyokalu> kalupakki = new ArrayList<Tyokalu>();

	/**
	 * Lis�� ty�kalupakkiin uuden Tyokalu-tyyppisen ty�kalun.
	 * 
	 * @param kalu Pakkiin lis�tt�v� ty�kalu.
	 */
	public void lisaaTyokalu(Tyokalu kalu) {
		kalupakki.add(kalu);
	}
	
	/**
	 * Teroittaa kaikki Teroitettava-rajapinnan ty�kalut.
	 * 
	 */
	public void teroitaKalut() {
		for(Tyokalu kalu : kalupakki) {
			if(kalu instanceof Teroitettava) {
				((Teroitettava)kalu).teroita();
			}
		}
	}
	
	/**
	 * Lataa kaikki Ladattava-rajapinnan ty�kalut.
	 * 
	 */
	public void lataaKalut() {
		for(Tyokalu kalu : kalupakki) {
			if(kalu instanceof Ladattava) {
				((Ladattava)kalu).lataa();
			}
		}
	}
	
	/**
	 * K�ytt�� kaikkia ty�kaluja, eli
	 * kutsuu j�rjestyksess� jokaisen ty�kalun kayt�-metodia.
	 * 
	 */
	public void kaytaKaikkia() {
		for(Tyokalu kalu : kalupakki) {
			kalu.kayta();
		}
	}
	
}
