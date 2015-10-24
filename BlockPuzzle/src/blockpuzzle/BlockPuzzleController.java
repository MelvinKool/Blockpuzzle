package blockpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class BlockPuzzleController implements MouseListener{
	BlockPuzzleBoard board;
	public BlockPuzzleController(BlockPuzzleBoard board) {
		//add the board panel for setting focus etc.
		this.board = board;
	}
	
	//start button
	public void actionPerformedSolve (ActionEvent ae){
		System.out.println("Start button clicked");
	}
	
	//pause button
		public void actionPerformedPause (ActionEvent ae){
			System.out.println("Pause button clicked");
		}
		
	//stop button
	public void actionPerformedStop (ActionEvent ae){
		System.out.println("Stop button clicked");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse clicked controller event");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
