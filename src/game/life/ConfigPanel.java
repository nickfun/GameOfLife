package game.life;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Configuration panel for the Game of Life
 * 
 * @author Nicholas Funnell <nick@nick.gs>
 * @date January 26, 2012
 */
public class ConfigPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Board board;
	private JButton btnSave, btnReset;
	private JLabel lblSize;
	private JTextField txtScale;

	public ConfigPanel( Board b ) {
		board = b;
		this.setLayout( new FlowLayout(FlowLayout.LEFT));
		this.setSize(100, 100);

		btnSave = new JButton();
		btnSave.setText("Save");
		btnSave.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnSaveMouseClicked(evt);
			}
		});
		
		btnReset = new JButton();
		btnReset.setText("Reset Board");
		btnReset.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseClicked(  java.awt.event.MouseEvent evt) {
				btnResetMouseClicked(evt);
			}
		});
		
		lblSize = new JLabel("Size of cells: ");
		txtScale = new JTextField( Integer.toString(b.getScale()) );
		txtScale.requestFocus();
		txtScale.setColumns(8);
		
		this.add(lblSize);
		this.add(txtScale);
		this.add(btnSave);
		this.add(btnReset);
	}

	public void btnSaveMouseClicked( java.awt.event.MouseEvent evt ) {
		// the save button was clicked!
		board.setScale( new Integer( txtScale.getText()) );
	}
	
	public void btnResetMouseClicked( java.awt.event.MouseEvent evt ) {
		// the reset button was clicked
		board.dealWithSize();
	}

}
