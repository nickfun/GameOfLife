package game.life;

import javax.swing.JFrame;

/**
 * Frame for the GUI version of my Game Of Life
 * @author Nicholas Funnell <nick@nick.gs>
 * @date January 12, 2012
 *
 */
public class GameOfLifeFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameOfLifeFrame() {
		GameBoard b = new GameBoard(3);
		b.setSize(300,300);
		add(b);
		setTitle("Game of Life");
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setSize(950, 950);
		setLocationRelativeTo(null);
		setVisible(true);
		//setResizable(false);
		//add( new javax.swing.JButton("Next Generation"));
	}
	
	public static void main(String[] args) {
        GameOfLifeFrame gameOfLifeFrame = new GameOfLifeFrame();
	}
	
}
