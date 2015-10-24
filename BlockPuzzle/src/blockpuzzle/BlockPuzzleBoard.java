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
	public List<Point> polePlaces = new ArrayList<Point>();
	
	public BlockPuzzleBoard(int panelSize,int numBlocks){
		PANELSIZE = panelSize;
		AMOUNT_BLOCKS = numBlocks;
		CELLSIZE = panelSize/numBlocks;
		this.setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
}
