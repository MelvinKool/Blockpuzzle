package blockpuzzle;

/*              GUI              */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
//////////////////////////////////

public class BlockPuzzleFrame extends JFrame{
	public BlockPuzzleFrame(){
		System.out.println("Building gui...");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel solvingPanel = new BlockPuzzlePanel(800,7);
//		solvingPanel.setSize(350,350);
		String[] test = {"item1","item2"};
		JList<String> solutionList = new JList(test);
		JSplitPane solutionPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,solutionList,solvingPanel);
//		solutionPane.setSize(1000,700);
		this.add(solutionPane,BorderLayout.CENTER);
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
		controlPanel.setAlignmentX(CENTER_ALIGNMENT);
		JButton startBtn = new JButton("Start");
		controlPanel.add(startBtn);
		JButton pauseBtn = new JButton("Pause");
		controlPanel.add(pauseBtn);
		JButton stopBtn = new JButton("Stop");
		controlPanel.add(stopBtn);
		this.add(controlPanel,BorderLayout.SOUTH);
//		this.pack();
		this.setSize(1000, 700);
	}
}

class BlockPuzzlePanel extends JPanel{
	private final int PANELSIZE;
	private final int AMOUNT_BLOCKS;
	private final int CELLSIZE;
	
	public BlockPuzzlePanel(int panelSize,int numBlocks){
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
