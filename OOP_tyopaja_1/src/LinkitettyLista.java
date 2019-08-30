
public class LinkitettyLista {

	Alkio juuri;
	private Alkio nykyinen;

	// Tyhj‰ konstruktori
	public LinkitettyLista() {

	}

	// Luo uuden Alkion, joka sis‰lt‰‰ arvon arvo, ja lis‰‰ sen listan per‰‰n.
	public void lisaaLoppuun(int arvo) {

		// Luodaan uusi Alkio a lis‰tt‰v‰ksi listaan.
		Alkio a = new Alkio(arvo);

		// Jos lista on tyhj‰, asetetaan uusi Alkio juureen.
		if (juuri == null) {
			juuri = a;
			return;
		}

		// Asetetaan juuri nykyiseksi alkioksi...
		nykyinen = juuri;

		// ...ja k‰yd‰‰n Alkioita l‰pi j‰rjestyksess‰ kunnes lˆyd‰mme listan p‰‰n.
		while (nykyinen.seuraava != null) {
			nykyinen = nykyinen.seuraava;
		}

		// Asetetaan listan loppuun luotu uusi Alkio a.
		nykyinen.asetaSeuraava(a);
	}

	// Poistaa viimeisen alkion.
	public void poistaViimeinen() {

		nykyinen = juuri;

		while (nykyinen.seuraava.seuraava != null) {
			nykyinen = nykyinen.seuraava;
		}

		nykyinen.asetaSeuraava(null);
	}

	// Hakee juuresta l‰htien seuraavan alkion johon on tallennettu arvo
	public Alkio haeArvo(int arvo) {
		if (juuri == null) {
			return null;
		}

		nykyinen = juuri;

		while (nykyinen.seuraava != null && nykyinen.haeArvo() != arvo) {
			nykyinen = nykyinen.seuraava;
		}

		if (nykyinen.haeArvo() == arvo) {
			return nykyinen;
		}

		return null;

	}

	// Palauttaa listan alkioiden m‰‰r‰n.
	public int pituus() {

		if (juuri == null) {
			return 0;
		}

		int pituus = 1;

		nykyinen = juuri;

		while (nykyinen.seuraava != null) {
			pituus++;
			nykyinen = nykyinen.seuraava;
		}

		return pituus;
	}

	// Tulostaa listan arvot muodossa [ Alkio1, Alkio2, ... ]
	public void tulostaLista() {

		if (juuri == null) {
			System.out.println("[ ]");
			return;
		}

		nykyinen = juuri;

		System.out.print("[ ");

		while (nykyinen.seuraava != null) {
			System.out.print(nykyinen.haeArvo());
			if (nykyinen.seuraava != null) {
				System.out.print(", ");
			}
			nykyinen = nykyinen.seuraava;

		}

		System.out.print(nykyinen.haeArvo());
		System.out.println(" ]");
	}

}