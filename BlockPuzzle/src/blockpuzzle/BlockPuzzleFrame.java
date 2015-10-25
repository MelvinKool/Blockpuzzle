package blockpuzzle;

/*              GUI              */
import java.awt.BorderLayout;

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
		BlockPuzzleBoard solvingPanel = new BlockPuzzleBoard(800,7);
		//add the controller 
		BlockPuzzleController controller = new BlockPuzzleController(solvingPanel);
		solvingPanel.addMouseListener(controller);
//		solvingPanel.setSize(350,350);
		String[] test = {"item1","item2"};
		JList<String> solutionList = new JList(test);
		solutionList.addMouseListener(controller);
		JSplitPane solutionPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,solutionList,solvingPanel);
//		solutionPane.setSize(1000,700);
		this.add(solutionPane,BorderLayout.CENTER);
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
		controlPanel.setAlignmentX(CENTER_ALIGNMENT);
		JButton startBtn = new JButton("Start");
		startBtn.setEnabled(false);
		startBtn.addActionListener (ae -> controller.actionPerformedSolve (ae));
		controlPanel.add(startBtn);
		JButton pauseBtn = new JButton("Pause");
		pauseBtn.setEnabled(false);
		pauseBtn.addActionListener (ae -> controller.actionPerformedPause (ae));
		controlPanel.add(pauseBtn);
		JButton stopBtn = new JButton("Stop");
		stopBtn.setEnabled(false);
		stopBtn.addActionListener (ae -> controller.actionPerformedStop(ae));
		controlPanel.add(stopBtn);
		this.add(controlPanel,BorderLayout.SOUTH);
//		this.pack();
		this.setSize(1000, 700);
		System.out.println("Building gui done!");
	}
}
