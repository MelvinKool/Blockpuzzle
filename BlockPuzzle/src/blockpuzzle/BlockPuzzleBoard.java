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
	private final int PANELSIZE;
	public final int AMOUNT_BLOCKS;
	public final int CELLSIZE;
	public List<Point> placedPoles = new ArrayList<Point>();
	private final Point[] POLEPLACES = {
			//Decide the places the poles could be placed
			new Point(6,1),new Point(6,2),new Point(6,6),new Point(5,3),new Point(4,0),new Point(4,2),new Point(4,5),new Point(3,3),new Point(3,4),new Point(1,1),new Point(1,2),new Point(1,6),new Point(0,3)
	};
	public BlockPuzzleBoard(int panelSize,int numBlocks){
		PANELSIZE = panelSize;
		AMOUNT_BLOCKS = numBlocks;
		CELLSIZE = panelSize/numBlocks;
		this.setBackground(Color.WHITE);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//draw holes
		g.setColor(Color.BLACK);
		for(int i = 0; i < PANELSIZE; i = i + (PANELSIZE/6)){
			for(int j = 0; j < PANELSIZE; j = j + (PANELSIZE /6)){
				g.fillOval(i, j, CELLSIZE / 2, CELLSIZE / 2);
			}
		}
	}
	
//	public void placePole(int x, int y){
//		Point p = new Point(x,y);
//		if(!placedPoles.contains(p)){
//			placedPoles.add(p);
//			//draw on board
//		}
//	}
}
