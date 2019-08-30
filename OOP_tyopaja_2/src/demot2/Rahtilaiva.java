package demot2;

public class Rahtilaiva extends Laiva{

	private double kapasiteetti;
	private double rahti;
	
	public Rahtilaiva(String nimi, double nopeus, double pituus, double syvays, double rahtia, double kap) {
		super(nimi, nopeus, pituus, syvays);
		this.kapasiteetti = kap;
		this.rahti = rahtia;
		super.setSolmuNopeus(super.getSolmuNopeus()*(((rahti/kap)/10)*10));
	}
	
	public void setKapasiteetti(double kap) {
		this.kapasiteetti = kap;
	}
	
	public double getKapasiteetti() {
		return kapasiteetti;
	}
	
	public void setRahti(double rahtia) {
		this.rahti = rahtia;
	}
	
	public double getRahti() {
		return rahti;
	}

	
	
}