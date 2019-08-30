package demot2;

public class Autolautta extends Laiva{

	private final int kapasiteetti;
	private int matkustajamaara;
	private int automaara;
	
	public Autolautta(String nimi, double nopeus, double pituus, double syvays, int kap) {
		super(nimi, nopeus, pituus, syvays);
		this.kapasiteetti = kap;
	}
	
	public void lisaaMatkustajia(int matkustajia) {
		this.matkustajamaara = matkustajia;
		if(matkustajamaara + automaara*10 > kapasiteetti) {
			System.out.println("Kapasiteetti ylitetty !");
			this.matkustajamaara = matkustajamaara - matkustajia;
		}
	}
	
	public void lisaaAutoja(int autoja) {
		this.automaara = autoja;
		if(matkustajamaara + automaara*10 > kapasiteetti) {
			System.out.println("Kapasiteetti ylitetty !");
			this.automaara = automaara - autoja;
		}
	}
	
	public int kaytettyKapasiteetti() {
		return automaara*10+matkustajamaara;
	}
	
	public int annaKuorma() {
		return 10*automaara + matkustajamaara;
	}
	
	public int annaKapasiteetti() {
		return kapasiteetti;
	}
	

}
