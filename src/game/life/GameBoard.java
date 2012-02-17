package game.life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Playing board for the Game of Life
 * 
 * @author Nicholas Funnell <nick@nick.gs>
 * @date January 12, 2012
 */
public class GameBoard extends JPanel implements MouseListener, ComponentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Universe uni;
	private int sizex, sizey, scale;
	private JFrame configFrame;

	public GameBoard(int sizeScale) {
		scale = sizeScale;
		dealWithSize();
		this.addMouseListener(this);
		this.addComponentListener(this);

		// setup the timer thing I guess
		Timer t = new Timer();
		RefreshTimerTask rt = new RefreshTimerTask(this);
		t.schedule(rt, 500, 200);
		
		// setup the config frame
		configFrame = new JFrame();
		configFrame.add(new ConfigPanel(this));
		configFrame.setSize(150, 200);
		configFrame.setResizable(false);
		configFrame.hide();
	}

	public Universe getUniverse() {
		return uni;
	}

	public void setScale(int s) {
		this.scale = s;
		this.dealWithSize();
	}

	public int getScale() {
		return this.scale;
	}

	public void dealWithSize() {
		// get our current size
		Dimension d = this.getSize();
		// scale it down
		int x, y;
		x = (int) Math.floor(d.width / scale);
		y = (int) Math.floor(d.height / scale);
		// setup the universe
		uni = new Universe(x, y);
		uni.fillRandom();
		uni.nextGeneration();
		// remember our size
		sizex = x;
		sizey = y;
		// for debug
		x = d.width;
		y = d.height;
		System.out.println("board x,y: " + x + ", " + y);
		System.out.println("Universe: " + sizex + ", " + sizey);
	}

	/*
	 * public void setSize(int x, int y) { super.setSize(x, y); sizex = x; sizey
	 * = y; uni = new Universe(x, y); uni.fillRandom(); uni.nextGeneration();
	 * this.repaint(); }
	 */

	public void paint(Graphics g) {
		// init the paint
		super.paint(g);
		// cast g to a Graphics2D object so we can use its features
		Graphics2D g2 = (Graphics2D) g;
		// get a rendering hints object. not sure why.
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		// pass it some parameters
		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		// connect rh to the graphics object
		g2.setRenderingHints(rh);

		/**
		 * Lookup Table for which color to be 0 = dead, white 1 = alive, black
		 */
		Color[] lookup = { Color.white, Color.black };

		int x, y, state;
		for (x = 0; x < sizex; x++) {
			for (y = 0; y < sizey; y++) {
				state = uni.getState(x, y);
				g2.setColor(lookup[state]);
				g2.fillRect(scale * x, scale * y, scale, scale);
			}
		}

	}

	public void refresh() {
		uni.nextGeneration();
		this.repaint();
	}

	/**
	 * Resize the universe when the board is resized.
	 */
	@Override
	public void componentResized(ComponentEvent arg0) {
		dealWithSize();
	}

	/**
	 * When the mouse is clicked, reset the whole universe lauch the config
	 * panel
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.configFrame.show();
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

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

}
