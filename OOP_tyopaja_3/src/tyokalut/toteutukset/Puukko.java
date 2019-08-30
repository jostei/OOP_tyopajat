package tyokalut.toteutukset;

import tyokalut.Teroitettava;
import tyokalut.Tyokalu;

public class Puukko extends Tyokalu implements Teroitettava {

	private boolean terava;
	
	public Puukko() {
		this.terava = true;
	}
	
	public void teroita() {
		this.terava = true;
	}

	@Override
	public void kayta() {
		if(!this.onkoTerava()){
			System.out.println("Terä on liian tylsä!");
		}else {
			System.out.println("*puukottelua*");
			this.terava = false;
		}
	}
	
	public boolean onkoTerava() {
		return terava;
	}
}
