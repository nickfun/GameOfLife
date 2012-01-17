package game.life;

import javax.swing.JFrame;

/**
 * Frame for the GUI version of my Game Of Life
 * @author Nicholas Funnell <nick@nick.gs>
 * @date January 12, 2012
 *
 */
public class GameOfLife extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameOfLife() {
		Board b = new Board();
		b.setSize(300,300);
		add(b);
		setTitle("Game of Life");
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setSize(950, 950);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		//add( new javax.swing.JButton("Next Generation"));
	}
	
	public static void main(String[] args) {
		new GameOfLife();
	}
	
}

/*

public class GameOfLife {
	public static void main( String[] argv) {
		System.out.println("Bluh bluh");
		
		Universe u = new Universe( 37, 100 );
		u.fillRandom();
		for( int i=0; i<900; i++ ) {
			System.out.println(u);
		//	u.printNeighbors();
			u.nextGeneration();
			System.out.println(i + "==================");
		}
		System.out.println(u);
	}
}
*/