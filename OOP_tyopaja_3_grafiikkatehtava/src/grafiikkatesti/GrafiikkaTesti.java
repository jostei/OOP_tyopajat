package grafiikkatesti;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * JFrame ikkuna, sis�lt�� graafisen sovelluksen rungon. Huom! Kaikki
 * toiminnalisuus tulisi kirjoittaa erillisiin Java-luokkiin, t�m� luokka
 * sis�lt�� vain UI-komponettien k�sittelyn ja piirt�misen.
 * 
 * Alunperin ollut (hiukan muokattuna) k�yt�ss� OOP kurssin lis�teht�v�n�,
 * ainakin jo vuodesta 2013.
 * 
 * 
 *
 */
public class GrafiikkaTesti extends JFrame {

	private Image pallo;

	private PiirtoAlusta p;

	private Timer timer;

	private JButton startOrStop;

	public GrafiikkaTesti() {

		pallo = Toolkit.getDefaultToolkit().getImage("pallo.png");

		p = new PiirtoAlusta(pallo);

		startOrStop = new JButton("Start/Stop animation");

		startOrStop.addActionListener(e -> {
			if (timer.isRunning()) {
				timer.stop();
			} else {
				timer.start();
			}
		});

		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout());
		panel.add(p, BorderLayout.CENTER);
		panel.add(startOrStop, BorderLayout.SOUTH);

		this.setPreferredSize(new Dimension(400, 400));

		this.getContentPane().add(panel);

		// P�ivitet��n JPanelin sis�lt� tila 15 millsiekunnin j�lkeen
		timer = new Timer(15, e -> {
			p.repaint();
		});

	}

	/**
	 * JPanel, johon voi piirt�� esim kuvia tai muotoja
	 * 
	 * @author vm
	 *
	 */
	private class PiirtoAlusta extends JPanel {

		private Image img; // kuva, joka piirret��n n�yt�lle.

		// TODO: pallon koordinaattien tulisi ehk� olla erillisess� luokassa, jolloin
		// t�m� olisi vain piirt�mist� varten. Lis�ksi voitaisiin piirt�� useampia
		// palloja, varsinkin jos grafiikkakin olisi ko. luokassa.
		private int x = 1;

		private int y = 1;

		private int xx = 3;

		private int yy = 3;

		public PiirtoAlusta(Image img) {

			this.img = img;

			this.setBackground(Color.WHITE);

			this.setPreferredSize(new Dimension(400, 400));

		}

		// t�ss�kin on v�h�n ep�m��r�ist�, ett� piirt�mist� tekev� metodi simuloi
		// (liikuttaa) palloa. N�m� pit�isi olla erikseen.
		

		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			if (x >= this.getWidth() - img.getWidth(this)) {

				xx = -xx;

			}

			if (y >= this.getHeight() - img.getHeight(this)) {

				yy = -yy;

			}
			
			if (x <= 0 ) {

				xx = -xx;

			}
			
			if (y <= 0 ) {

				yy = -yy;

			}
			
			

			x += xx;

			y += yy;

			g.drawImage(img, x, y, this);

		}
	}

}