package DandD;
//---------------------------------------------------------
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
	//--------------- Grandezza schermo -------------------
	static final int GAME_WIDTH = 1360;
	static final int GAME_HEIGHT = 700;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	//---------------- Grandezza Mappa ------------------
	private int Stacco1=1000;
	private int altezza1=660;
	private int lunghezza1=1050;
	//--------------- Grandezza testo -------------------
	private int Stacco2=300;
	private int altezza2=303;
	private int lunghezza2=313;
	//---------------- Grandezza personaggio ------------------
	private int Stacco3=304;
	//---------------- Grandezza altri ------------------
	private int altezza4=90;
	//----------------------------------
	Background bg;
	Dado dice;
	
//_________________________________________________________________________
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
		
	GamePanel(){
		bg = new Background(GAME_WIDTH, GAME_HEIGHT);
		dice = new Dado(GAME_WIDTH, GAME_HEIGHT);
		//-------------------------------------------
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
		//-------------------------------------------
	}
		
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
		
	//---------------- Schermata mappa ------------------
		g.setColor(Color.GRAY);								//colore bordo
		g.fillRect(25, 20, 1, altezza1);  					//lato sinistro
		g.fillRect(25, 20, Stacco1, 1);						//lato alto
		g.fillRect((Stacco1+25), 20, 1, altezza1);			//lato sinistro
		g.fillRect(25, (altezza1+20), (Stacco1), 1);		//lato basso
	//---------------- Schermata testo ------------------
		g.setColor(Color.GRAY);
		g.fillRect((lunghezza1+3), 0, 3, altezza2);
		g.fillRect((lunghezza1+3), 0, lunghezza2, 3);
		g.fillRect((lunghezza1+lunghezza2), 0, 3, altezza2);
		g.fillRect((lunghezza1+3), Stacco2, lunghezza2, 3);
	//---------------- Schermata giocatore 1 ------------------
		g.setColor(Color.RED);
		g.fillRect((lunghezza1+3), Stacco2+3, 3, Stacco3);
		g.fillRect((lunghezza1+3), Stacco2+3, lunghezza2, 3);
		g.fillRect((lunghezza1+lunghezza2), Stacco2+3, 3, Stacco3);
		g.fillRect((lunghezza1+3), (Stacco2+Stacco3+3), lunghezza2, 3);
	//---------------- Schermata dadi ------------------
		g.setColor(Color.GRAY);
		g.fillRect((lunghezza1+3), (Stacco2+Stacco3+6), 3, altezza4);
		g.fillRect((lunghezza1+3), (Stacco2+Stacco3+6), lunghezza2, 3);
		g.fillRect((lunghezza1+lunghezza2), (Stacco2+Stacco3+6), 3, altezza4);
		g.fillRect((lunghezza1+3), (Stacco2+Stacco3+altezza4+6), lunghezza2, 3);
	}
		
	public void draw(Graphics g) {
		bg.draw(g);
		dice.draw(g);
	//-----------------------------------------
		Toolkit.getDefaultToolkit().sync();
	//-----------------------------------------
	}
		
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double FPS =60.0;
		double duration = 1000000000 / FPS;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/duration;
			lastTime = now;
			if(delta >=1) {
				repaint();
				delta--;
			}
		}
	}		
		
 		
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
		}
		public void keyReleased(KeyEvent e) {
			dice.keyPressed(e);
		}
	}
}