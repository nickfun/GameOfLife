package game.life;

import java.util.TimerTask;

public class RefreshTimerTask extends TimerTask {
	
	private Board gameBoard;
	
	public RefreshTimerTask( Board b ) {
		gameBoard = b;
	}

	@Override
	public void run() {
		gameBoard.refresh();
		
	}

}
