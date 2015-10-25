package blockpuzzle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class BlockPuzzleBoard extends JPanel{
	private final int PANELSIZE;
	private final int AMOUNT_BLOCKS;
	private final int CELLSIZE;
	
	public BlockPuzzleBoard(int panelSize,int numBlocks){
		PANELSIZE = panelSize;
		AMOUNT_BLOCKS = numBlocks;
		CELLSIZE = panelSize/numBlocks;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, CELLSIZE, CELLSIZE);
		g.setColor(Color.CYAN);
		g.fillRect(CELLSIZE, CELLSIZE, CELLSIZE, CELLSIZE);
	}
}
