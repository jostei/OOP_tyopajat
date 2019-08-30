package tyokalut;

/**
 * Rajapinta ladattavan työkalun luomiseen.
 * 
 */
public interface Ladattava {
	
	/**
	 * Lataa kyseisen työkalun.
	 * 
	 */
	public void lataa();
	
	/**
	 * 
	 * @return Palauttaa true jos työkalu on ladattu, false jos ei.
	 */
	public boolean onkoLadattu();
}
