package laskin;

public class Laskin{

	public static void main(String[] args) {
		int luku1 = Integer.parseInt(args[0]);
		int luku2 = Integer.parseInt(args[2]);

		char operaattori = args[1].charAt(0);

		int vastaus = laske(luku1, luku2, operaattori);

		System.out.println(vastaus);

	}

	/**
	 * Tämä metodi luo varsinaisen laskin-olion ja laskee laskutoimituksen [luku1]
	 * [operaattori][luku2] <br>
	 * Operaattoriksi kelpaa +,-,x tai /
	 * 
	 * @param luku1
	 * @param luku2
	 * @param operaattori
	 * @return vastaus kokonaislukuna
	 */
	public static int laske(int luku1, int luku2, char operaattori) {

		NeliLaskin l = new NeliLaskin();
		int tulos;
		switch (operaattori) {
			case '+':
				tulos = l.summa(luku1, luku2);
				break;
			case '-':
				tulos = l.erotus(luku1, luku2);
				break;
			case 'x':
				tulos = l.tulo(luku1, luku2);
				break;
			case '/':
				tulos = l.osamäärä(luku1, luku2);
				break;
			default:
				// huom! Tämä on RuntimeException. Tätä ei tarvitse julistaa signatuurissa
				// eikä sitä tarvitse ottaa kiinni try-catch rakenteella. Ohjelma kuitenkin
				// kaatuu, ellei niin tehdä.
				throw new IllegalArgumentException("Tuntematon operaattori:" + operaattori);

		}
		return tulos;
	}

}
