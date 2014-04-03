package game.life;

import java.util.TimerTask;

public class RefreshTimerTask extends TimerTask {
	
	private final GameBoard gameBoard;
	
	public RefreshTimerTask( GameBoard b ) {
		gameBoard = b;
	}

	@Override
	public void run() {
		gameBoard.refresh();
		
	}

}
