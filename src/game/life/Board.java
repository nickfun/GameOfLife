package game.life;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import javax.swing.JPanel;

/**
 * Playing board for the Game of Life
 * @author Nicholas Funnell <nick@nick.gs>
 * @date January 12, 2012
 */
public class Board extends JPanel implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Universe uni;
	private int sizex, sizey;
	
	public Board() {
		sizex = 100;
		sizey = 100;
		uni = new Universe(sizex, sizey);
		uni.fillRandom();
		uni.nextGeneration();
		this.addMouseListener(this);
		
		// setup the timer thing I guess
		Timer t = new Timer();
		RefreshTimerTask rt = new RefreshTimerTask( this );
		t.schedule(rt, 500, 200);
	}
	
	public void setSize( int x, int y) {
		super.setSize(x, y);
		sizex = x;
		sizey = y;
		uni = new Universe( x, y);
		uni.fillRandom();
		uni.nextGeneration();
		this.repaint();
	}
	
	public void paint( Graphics g ) {
		// init the paint
		super.paint(g);
		// cast g to a Graphics2D object so we can use its features
		Graphics2D g2 = (Graphics2D) g;
		// get a rendering hints object. not sure why.
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// pass it some parameters
		rh.put( RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		// connect rh to the graphics object
		g2.setRenderingHints(rh);
		
		/**
		 * Lookup Table for which color to be
		 * 0 = dead, white
		 * 1 = alive, black
		 */
		Color[] lookup = {Color.white, Color.black};
		
		int x,y,state;
		for( x=0; x < sizex; x++) {
			for( y=0; y < sizey; y++) {
				state = uni.getState(x, y);
				g2.setColor( lookup[state]);
				g2.fillRect(3*x, 3*y, 3, 3);
			}
		}
		
	}
	
	public void refresh() {
		uni.nextGeneration();
		this.repaint();
	}

	/**
	 * When the mouse is clicked, reset the whole universe
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		uni.fillRandom();
		uni.nextGeneration();
		this.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// nothing when mouse entered
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// nothing when mouse exits
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// nothing when mouse pressed
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// nothing when mouse released
		
	}

}
