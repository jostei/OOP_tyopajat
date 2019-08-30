
public class Alkio {
	
	Alkio seuraava;
	private int arvo;
	
	public Alkio(int annettuArvo) {
		this.arvo = annettuArvo;
	}
	
	public int haeArvo() {
		return arvo;
	}
	
	public void asetaArvo(int uusiArvo) {
		this.arvo = uusiArvo;
	}
	
	public void asetaSeuraava(Alkio a) {
		this.seuraava = a;
	}
	
}
