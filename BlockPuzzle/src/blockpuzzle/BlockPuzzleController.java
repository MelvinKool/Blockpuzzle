package blockpuzzle;

import java.awt.Point;
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
	
	//board panel clicked
	public void boardClicked(MouseEvent e){
		System.out.println("Board clicked");
		//determine weather a pole could be placed
		//calculate x and y coordinates of pole
		int x = e.getX() / board.CELLSIZE;
		int y = e.getY() / board.CELLSIZE;
		Point p = new Point(x,y);
		if(x < board.AMOUNT_BLOCKS && y < board.AMOUNT_BLOCKS && !board.polePlaces.contains(p)){
			//place pole on the board and draw pole
			board.polePlaces.add(p);
			
		}
	}
	
	//solution list clicked
	public void solutionlistClicked(MouseEvent e){
		System.out.println("Solution list clicked");
		//show the selected solution
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof javax.swing.JPanel)
			boardClicked(e);
		else if(e.getSource() instanceof javax.swing.JList<?>)
			solutionlistClicked(e);
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
