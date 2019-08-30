
public class Laiva {
	
	private String nimi;
	private double solmuNopeus;
	private double pituus;
	private double syvays;
	
	public Laiva(String nimi, double nopeus, double pituus, double syvays) {
		this.nimi = nimi;
		this.solmuNopeus = nopeus;
		this.pituus = pituus;
		this.syvays = syvays;
	}
	
	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public double getSolmuNopeus() {
		return solmuNopeus;
	}

	public void setSolmuNopeus(double solmuNopeus) {
		this.solmuNopeus = solmuNopeus;
	}

	public double getPituus() {
		return pituus;
	}

	public void setPituus(double pituus) {
		this.pituus = pituus;
	}

	public double getSyvays() {
		return syvays;
	}

	public void setSyvays(double syvays) {
		this.syvays = syvays;
	}

	public double laskeAika(double matka) {
		return matka/(solmuNopeus*1.852);
	}	

}
