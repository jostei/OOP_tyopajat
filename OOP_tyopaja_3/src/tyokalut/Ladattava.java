package tyokalut;

/**
 * Rajapinta ladattavan ty�kalun luomiseen.
 * 
 */
public interface Ladattava {
	
	/**
	 * Lataa kyseisen ty�kalun.
	 * 
	 */
	public void lataa();
	
	/**
	 * 
	 * @return Palauttaa true jos ty�kalu on ladattu, false jos ei.
	 */
	public boolean onkoLadattu();
}
