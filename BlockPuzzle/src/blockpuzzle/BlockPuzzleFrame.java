package blockpuzzle;

/*              GUI              */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.PrintStream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
//////////////////////////////////

public class BlockPuzzleFrame extends JFrame{
	public BlockPuzzleFrame(){
		System.out.println("Building gui...");
		//activate controller
		BlockPuzzleController controller = new BlockPuzzleController();
		//layout
		this.setTitle("Blockpuzzle Solver v1.0");
		this.setSize(1500, 1000);
		this.setVisible(true);
		this.pack();
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		//add components
		JPanel solvingPanel = new JPanel();
		solvingPanel.setLayout(new BoxLayout(solvingPanel,BoxLayout.Y_AXIS));
		JScrollPane solutionPoles = new JScrollPane();
		JPanel puzzleGrid = new JPanel();
		JSplitPane sPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,solutionPoles,puzzleGrid);
		solvingPanel.add(sPane);
		JProgressBar solveProgressBar = new JProgressBar();
		solvingPanel.add(solveProgressBar);
		mainPanel.add(solvingPanel, BorderLayout.NORTH);
		
		JPanel controlPanel = new JPanel(new FlowLayout());
		JButton solveBtn = new JButton("Solve");
		controlPanel.add(solveBtn);
		
		JButton pauseBtn = new JButton("Pause");
		controlPanel.add(pauseBtn);
		
//		mainPanel.add(controlPanel, BorderLayout.CENTER);
		
//		JPanel consolePanel = new JPanel();
//		consolePanel.setLayout(new BoxLayout(consolePanel,BoxLayout.Y_AXIS));
//		JButton collapseBtn = new JButton("Show console");
//		consolePanel.add(collapseBtn);
//		JTextArea console = new JTextArea();
		
		/*            Built-in console               */
		///////////////////////////////////////////////
//		PrintStream con=new PrintStream(new Console(console));
//		System.setOut(con);
//		System.setErr(con);
		///////////////////////////////////////////////
//		JScrollPane scroll = new JScrollPane (console, 
//				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		consolePanel.add(console);
//		mainPanel.add(consolePanel,BorderLayout.SOUTH);
		//add the panel to the JFrame
		this.add(mainPanel);
//		System.out.println("Testdasf");
//		BlockPuzzleSolver test = new BlockPuzzleSolver();
//		test.Start();
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(1024,768);
	}
}
