package kalupakki;

import java.util.ArrayList;

import tyokalut.*;

/**
 * Työkalupakki Tyokalu-tyyppisten olioiden varastoimiseen, huoltamiseen ja käyttämiseen.
 * 
 */
public class Tyokalupakki {
	
	private ArrayList<Tyokalu> kalupakki = new ArrayList<Tyokalu>();

	/**
	 * Lisää työkalupakkiin uuden Tyokalu-tyyppisen työkalun.
	 * 
	 * @param kalu Pakkiin lisättävä työkalu.
	 */
	public void lisaaTyokalu(Tyokalu kalu) {
		kalupakki.add(kalu);
	}
	
	/**
	 * Teroittaa kaikki Teroitettava-rajapinnan työkalut.
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
	 * Lataa kaikki Ladattava-rajapinnan työkalut.
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
	 * Käyttää kaikkia työkaluja, eli
	 * kutsuu järjestyksessä jokaisen työkalun kaytä-metodia.
	 * 
	 */
	public void kaytaKaikkia() {
		for(Tyokalu kalu : kalupakki) {
			kalu.kayta();
		}
	}
	
}
