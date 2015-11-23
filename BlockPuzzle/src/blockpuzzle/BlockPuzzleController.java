package blockpuzzle;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JList;

public class BlockPuzzleController implements MouseListener{
	BlockPuzzleBoard board;
	BlockPuzzleFrame frame;
	public BlockPuzzleController(BlockPuzzleBoard board, BlockPuzzleFrame frame) {
		//add the board panel for setting focus etc.
		this.board = board;
		this.frame = frame;
	}
	
	//start button
	public void actionPerformedSolve (ActionEvent ae){
		System.out.println("Start button clicked");
		BlockPuzzleSolver solver = new BlockPuzzleSolver(frame, board.placedPole);
		board.solver = solver;
		solver.execute();
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
		int x = ((e.getX() - board.CELLSIZE / 2) / board.CELLSIZE > 0) ? (e.getX() - board.CELLSIZE / 2) / board.CELLSIZE : 0;
		int y = ((e.getY() - board.CELLSIZE / 2) / board.CELLSIZE > 0) ? (e.getY() - board.CELLSIZE  /2)/ board.CELLSIZE : 0;
//		System.out.println("x = " + x + "y = "+ y);
		Point p = new Point(x,y);
		if(x < board.AMOUNT_BLOCKS && y < board.AMOUNT_BLOCKS){
			//place pole on the board and draw pole
			board.placedPole = p;
			//draw the pole
			board.repaint();
		}
	}
	
	//solution list clicked
	public void solutionlistClicked(MouseEvent e){
		System.out.println("Solution list clicked");
		//show the selected solution
//		JList templist = (JList)e.getSource();
		board.paintSolutionIndex = frame.solutionList.getSelectedIndex();
		board.repaint();
		
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
