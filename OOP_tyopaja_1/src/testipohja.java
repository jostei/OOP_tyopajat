
public class testipohja {

	public static void main(String[] args) {
		
		LinkitettyLista testilista = new LinkitettyLista();

		testilista.tulostaLista();
		System.out.println("Listan pituus: "+testilista.pituus());
		
		testilista.lisaaLoppuun(2);
		testilista.lisaaLoppuun(3);
		testilista.lisaaLoppuun(4);
		testilista.lisaaLoppuun(5);
		
		testilista.tulostaLista();
		System.out.println("Listan pituus: "+testilista.pituus());
		
		testilista.poistaViimeinen();
		
		testilista.tulostaLista();
		System.out.println("Listan pituus: "+testilista.pituus());
		
		System.out.println("Haetaan alkio johon on tallennettu arvo 3.");
		
		Alkio haku = testilista.haeArvo(3);
		
		System.out.println("Löydetyn alkion arvo on: "+haku.haeArvo());
		
	}

}
