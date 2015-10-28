package blockpuzzle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BlockPuzzleBoard extends JPanel{
	BlockPuzzleSolver solver;
	Integer paintSolutionIndex;
	private final int PANELSIZE;
	public final int AMOUNT_BLOCKS;
	public final int CELLSIZE;
	public List<Point> placedPoles = new ArrayList<Point>();
	private final Point[] POLEPLACES = {
			//Decide the places the poles could be placed
			new Point(6,1),new Point(6,2),new Point(6,6),new Point(5,3),new Point(4,0),new Point(4,2),new Point(4,5),new Point(3,3),new Point(3,4),new Point(1,1),new Point(1,2),new Point(1,6),new Point(0,3)
	};
	public BlockPuzzleBoard(int panelSize,int numBlocks, BlockPuzzleSolver solver){
		PANELSIZE = panelSize;
		AMOUNT_BLOCKS = numBlocks;
		CELLSIZE = panelSize/numBlocks;
		this.setBackground(Color.WHITE);
		this.solver = solver;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(paintSolutionIndex == null){
			//paint pin holes
			
			return;
		}
		//paint blocks
		g.setColor(Color.BLACK);
		int x = 0, y = 0;
		String hexvalue; 
		for(int i = 0; i < PANELSIZE; i = i + CELLSIZE){
			for(int j = 0; j < PANELSIZE; j = j + CELLSIZE){
//				System.out.println(x + " " + y);
				int cellValue = solver.solutions.get(paintSolutionIndex)[y][x];
				//hexvalue = Integer.toHexString(255/cellValue);
				//g.setColor(Color.decode(hexvalue));
				g.setColor(Color.getHSBColor(cellValue / 10f, 1, 0.9f));
//				System.out.print(cellValue + " ");
//				g.setColor(cellNumb/maxColorValue);
				g.fillRect(j++, i, CELLSIZE, CELLSIZE);
				x++;
			}
			i++;
			x = 0;
			y++;
//			System.out.println();
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("board clicked 2");
	}
//	public void placePole(int x, int y){
//		Point p = new Point(x,y);
//		if(!placedPoles.contains(p)){
//			placedPoles.add(p);
//			//draw on board
//		}
//	}
}
