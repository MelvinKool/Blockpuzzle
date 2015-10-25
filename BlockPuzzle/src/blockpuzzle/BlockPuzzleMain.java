package blockpuzzle;
import java.io.PrintStream;

import javax.swing.SwingUtilities;

public class BlockPuzzleMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SwingUtilities.invokeLater (() -> new BlockPuzzleFrame());
		BlockPuzzleSolver test = new BlockPuzzleSolver();
		test.doInBackground();
	}
}
