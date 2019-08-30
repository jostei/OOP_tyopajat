package tyokalut.toteutukset;

import tyokalut.Teroitettava;
import tyokalut.Tyokalu;

public class Kirves extends Tyokalu implements Teroitettava {

	private boolean terava;
	
	public Kirves() {
		this.terava = true;
	}
	
	public void teroita() {
		this.terava = true;
	}

	@Override
	public void kayta() {
		if(!this.onkoTerava()){
			System.out.println("Ter‰ on liian tyls‰!");
		}else {
			System.out.println("*kirveen ‰‰ni‰*");
			this.terava = false;
		}
	}
	
	public boolean onkoTerava() {
		return terava;
	}
}
