package tyokalut.toteutukset;

import tyokalut.Ladattava;
import tyokalut.Tyokalu;

public class Hiomakone extends Tyokalu implements Ladattava{
	
	private boolean ladattu;
	
	public Hiomakone() {
		this.ladattu = false;
	}
	
	public void lataa() {
		this.ladattu = true;
	}
	
	@Override
	public void kayta() {
		if(!this.onkoLadattu()) {
			System.out.println("Hiomakoneen akku tyhjä!");
		}else {
			System.out.println("*hiontaa*");
			this.ladattu = false;
		}
	}
	
	public boolean onkoLadattu() {
		return ladattu;
	}
}
