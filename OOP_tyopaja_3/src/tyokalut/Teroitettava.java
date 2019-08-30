package tyokalut;

/**
 * Rajapinta teroitettavan työkalun luomiseen.
 * 
 */
public interface Teroitettava {
	
	/**
	 * Teroittaa kyseisen työkalun.
	 * 
	 */
	public void teroita();
	
	/**
	 * 
	 * @return Palauttaa true jos työkalu on terävä, false jos ei.
	 */
	public boolean onkoTerava();
}
