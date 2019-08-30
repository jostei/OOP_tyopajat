package tyokalut.toteutukset;

import tyokalut.Ladattava;
import tyokalut.Teroitettava;
import tyokalut.Tyokalu;


public class Sahkosaha extends Tyokalu implements Ladattava,Teroitettava{
	
	private boolean ladattu;
	private boolean terava;
	
	public Sahkosaha() {
		this.ladattu = false;
		this.terava = true;
	}
	
	public void lataa() {
		this.ladattu = true;
	}
	
	public void teroita() {
		this.terava = true;
	}
	
	@Override
	public void kayta() {
		if(!this.onkoLadattu()) {
			System.out.println("Sähkösahan akku tyhjä!");
		}else if(!this.onkoTerava()){
			System.out.println("Terä on liian tylsä!");
		}else {
			System.out.println("*sähkösahausta*");
			this.ladattu = false;
			this.terava = false;
		}
	}
	
	public boolean onkoTerava() {
		return terava;
	}
	
	public boolean onkoLadattu() {
		return ladattu;
	}

}
