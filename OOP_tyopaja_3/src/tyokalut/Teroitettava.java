package tyokalut;

/**
 * Rajapinta teroitettavan ty�kalun luomiseen.
 * 
 */
public interface Teroitettava {
	
	/**
	 * Teroittaa kyseisen ty�kalun.
	 * 
	 */
	public void teroita();
	
	/**
	 * 
	 * @return Palauttaa true jos ty�kalu on ter�v�, false jos ei.
	 */
	public boolean onkoTerava();
}
