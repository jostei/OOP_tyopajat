package merkkijonot;

public class MerkkijonoApuvälineet{

	public static String käännäMerkkijono(String s) {
		String tulos = "";

		for (int i = s.length() - 1; i >= 0; i--) {
			tulos += s.charAt(i);
		}
		return tulos;

	}

	// Tämä metodi ei selvästikään käännä merkkijonoa, vaikka väittää tekevänsä
	// niin.
	// Tätä käytetään esimerkkinä testien suunnittelussa.
	public static String huonoKääntö(String s) {
		String kaanto = "";
		
		for(int i = 0; i < s.length(); i++) {
			kaanto = kaanto + s.charAt(s.length()-1-i);
		}
		return kaanto;
	}
}
