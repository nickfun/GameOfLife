package game.life;

import java.util.Random;

/**
 * Universe for the Game of Life
 * 
 * @author Nicholas Funnell <nick@nick.gs>
 * @date January 6, 2012
 */
public class Universe {
	private Boolean[][] uni;
	private int x, y;

	public Universe(int sizex, int sizey) {
		x = sizex;
		y = sizey;
		uni = new Boolean[x][y];
	}

	public Universe(String filename) {
		System.out.println("Load from file " + filename);
	}

	public void fillRandom() {
		Random rng = new Random(System.nanoTime());
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (i + j % 2 == 6) {
					uni[i][j] = false;
				} else {
					uni[i][j] = rng.nextBoolean();
				}
			}
		}
	}

	public void nextGeneration() {
		/**
		 * Any live cell with fewer than two live neighbours dies, as if caused
		 * by under-population. Any live cell with two or three live neighbours
		 * lives on to the next generation. Any live cell with more than three
		 * live neighbours dies, as if by overcrowding. Any dead cell with
		 * exactly three live neighbours becomes a live cell, as if by
		 * reproduction.
		 */
		int i, j;
		Boolean[][] next = new Boolean[x][y];
		int aliveNeighbors;
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				// how many alive neighbors do we have?
				aliveNeighbors = getNumAliveNeighbors(i, j);
				// are we considering a dead cell?
				if (getState(i, j) == 0) {
					// it can live if it has 3 neighbors
					if (aliveNeighbors == 3) {
						next[i][j] = true;
					} else {
						next[i][j] = false;
					}
				} else {
					// consider the live cell
					// it will only live on if it has 2 or 3 alive neighbors
					next[i][j] = false;
					if (aliveNeighbors == 2 || aliveNeighbors == 3) {
						next[i][j] = true;
					}
				}
			}
		}
		// update ourself
		uni = next;
	}

	public int getState(int ix, int iy) {
		// is ix within bounds?
		if( ix < 0 ) {
			ix = x-1;		// wrap from the left side to the right
		}
		if( ix >= x ) {
			ix = 0;			// wrap from the right side to the left
		}
		// is iy within bounds?
		if( iy < 0 ) {
			iy = y-1;		// wrap from the top to the bottom
		}
		if( iy >= y ) {
			iy = 0;			// wrap from the bottom to the top
		}
		// we are now sure that our indexes are within bounds
		if (uni[ix][iy]) {
			return 1;
		}
		return 0;
	}

	private int getNumAliveNeighbors(int ix, int iy) {
		int num = 0;
		num += getState(ix - 1, iy - 1);
		num += getState(ix, iy - 1);
		num += getState(ix + 1, iy - 1);
		num += getState(ix - 1, iy);
		num += getState(ix + 1, iy);
		num += getState(ix - 1, iy + 1);
		num += getState(ix, iy + 1);
		num += getState(ix + 1, iy + 1);
		return num;
	}

	public String toString() {
		int i, j;
		String out = "";
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				if (uni[i][j] == true) {
					out += "#";
				} else {
					out += " ";
				}
			}
			out += "\n";
		}
		return out;
	}

	public void printNeighbors() {
		int i, j;
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				System.out.print(this.getNumAliveNeighbors(i, j));
			}
			System.out.print("\n");
		}
	}
}
