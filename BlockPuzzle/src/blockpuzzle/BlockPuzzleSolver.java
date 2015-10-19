package blockpuzzle;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;

public class BlockPuzzleSolver extends SwingWorker<Boolean,int[][]>{
	private final boolean[][][] BLOCKS = {
		{
			{false,true,true},
			{false,true,true,true},
			{true,true,true}
		},
		{
			{false,true},
			{true,true,true},
			{true,true,true}
		},
		{
			{false,false,true},
			{true,true,true,true}
		},
		{
			{true},
			{true,true},
			{true,true,true}
		},
		{
			{false,true,true},
			{true,true,true,true}
		},
		{
			{true,true,true,true,true}
		},
		{
			{false,false,true},
			{false,true,true},
			{true,true}
		},
		{
			{false,true},
			{true,true,true}
		},
		{
			{true,true}
		}
	};
	private List<ArrayList<int[][]>> solutions = new ArrayList<ArrayList<int[][]>>();
	private final int FIELDWIDTH = 7;
	private final int FIELDLENGTH = 7;
	private final Point[] POLEPLACES = {
			//Decide the places the poles could be placed
			new Point(6,1),new Point(6,2),new Point(6,6),new Point(5,3),new Point(4,0),new Point(4,2),new Point(4,5),new Point(3,3),new Point(3,4),new Point(1,1),new Point(1,2),new Point(1,6),new Point(0,3)
	};
	//private static List<int[]> allCombinations = new ArrayList<int[]>();
	private List<Integer> solutionPoles = new ArrayList<Integer>();
	private int currentPole;
        /////////////////////////////////////////////////////////////////////////
	public Boolean doInBackground(){
		// TODO Auto-generated method stub
//		int[][] puzzle = new int[7][7];
//		placeBlock(1,1,BLOCKS[0],1,puzzle);
//		solveBlockCombs(new ArrayList<Integer>());
//		for(int [] i:puzzle){
//			for(int j:i){
//				System.out.printf("%d|",j);
//			}
//			System.out.println();
//		}
		System.out.println("Solving started...");
		solveBlockCombs(new ArrayList<Integer>());
		for(ArrayList<int[][]> i: solutions){
			System.out.println("FOUND A SOLUTION !!!!!!!!!!!!");
			for(int[][] j : i){
				for(int[] k : j){
					for(int l:k){
						System.out.printf("%d|",l);
					}
					System.out.println();
				}
				System.out.println();
				System.out.println();
				System.out.println();
			}
			System.out.println("Next pole :");
		}
//		System.out.println(maxIndex);
//		for(int[] i: test){
//			for(int j:i){
//				System.out.printf("%d|", j);
//			}
//			System.out.println();
//		}
		return true;
	}
	/////////////////////////////////////////////////////////////////////////
	private void solveBlockCombs(List<Integer> combs){
            if(combs.size() == BLOCKS.length){
                    int[] allCombs = new int[combs.size()];
                    for(int i =0; i < combs.size(); i++){
                            allCombs[i] = combs.get(i);
                    }
//                    for(int i: allCombs){
//                        System.out.print(i + "|");
//                    }
//                    System.out.println();
                    for(currentPole = 0; currentPole < POLEPLACES.length; currentPole++){
                            //find the solution for every pole

                            int [][]puzzle = new int[FIELDLENGTH][FIELDWIDTH];
                            //A pole is -1
                            puzzle[POLEPLACES[currentPole].y][POLEPLACES[currentPole].x] = -1;
                            solveRotate(0,0,0,allCombs, puzzle);
                    }
//                    allCombinations.add(allCombs);
            }
            else{
                    for(int i = 0; i < BLOCKS.length; i++){
                            if(!combs.contains(i)){
                                    combs.add(i);
                                    solveBlockCombs(combs);
                            }
                    }
            }
            if(combs.size() > 0){
                    combs.remove(combs.size() - 1);
            }
	}
//	static int [][] test = new int[FIELDLENGTH][FIELDWIDTH];
//	static int maxIndex = 0;
	/*Solves the puzzle*/
	private boolean solveRotate(int x, int y,int curBlockCombIndex, int[] blockComb, int[][] puzzle){
//		if(curBlockCombIndex > maxIndex){
//			maxIndex = curBlockCombIndex;
//		}
//		if(maxIndex == 4){
//                    int [][] myInt = new int[puzzle.length][];
//                    for(int i = 0; i < puzzle.length; i++)
//                    {
//                      int[] aMatrix = puzzle[i];
//                      int   aLength = aMatrix.length;
//                      myInt[i] = new int[aLength];
//                      System.arraycopy(aMatrix, 0, myInt[i], 0, aLength);
//                    }
//		}
		if(y == FIELDLENGTH){
			//check if successful
			if(curBlockCombIndex == blockComb.length){
				//if there is no solution for this pole yet, add it to solutionPoles and make a new index for the pole
				if(!solutionPoles.contains(currentPole)){
					solutions.add(new ArrayList<int[][]>());
					solutionPoles.add(currentPole);
				}
				//copy array and add it to the puzzle solution stack
				//YOU DON'T KNOW WHETHER THE SOLUTION IS FROM THE LAST POLE
				//check if this is correct!!!!!!!!!!!!!!!!!
				solutions.get(solutionPoles.indexOf(currentPole)).add(clone2DArr(puzzle));
				return true;
			}
			else{
				return false;
			}
		}
		else if(puzzle[x][y] == 0){
			boolean[][] currentBlock = clone2DArr(BLOCKS[blockComb[curBlockCombIndex]]);
			//try rotating the block
			//think about rotating the block every sides and validating whether the block fits
			for(int i =0; i< 4; i++){
				if(validMove(currentBlock,puzzle,x,y)){
					//place the block
					placeBlock(x,y,currentBlock,curBlockCombIndex + 1,puzzle);
					if(x < FIELDWIDTH - 1){
						if(x + currentBlock[0].length < FIELDWIDTH){
							solveRotate(x + currentBlock[0].length,y,curBlockCombIndex + 1,blockComb,puzzle);
						}
						else{
							solveRotate(x + currentBlock[0].length - 1,y,curBlockCombIndex + 1,blockComb,puzzle);
						}
					}
					else{
						solveRotate(0,y + 1, curBlockCombIndex + 1,blockComb,puzzle);
					}					
					//revert the placed block
					placeBlock(x,y,currentBlock,0,puzzle);
				}
				currentBlock = rotateBlock(currentBlock);
			}
		}
		//The block is not empty
		else{
			if(x < FIELDWIDTH - 1){
				solveRotate(x + 1,y,curBlockCombIndex,blockComb,puzzle);
			}
			else{
				solveRotate(0,y + 1, curBlockCombIndex,blockComb,puzzle);
			}
		}
		//if there is no solution
		return false;
	}
	
//        private static <T> T[][] clone2DArr(T[][] toClone) {
////            toClone[0][0].
//            T[][] fieldClone = new T[toClone.length][];
//            for(int i = 0; i < toClone.length; i ++){
//                fieldClone[i] = new T[toClone[i].length];
//                System.arraycopy(toClone[i], 0, fieldClone[i], 0, toClone[i].length);
//            }
//            return fieldClone;
//        }
        
        private int[][] clone2DArr(int[][] toClone) {
            //toClone[0][0].
            int[][] fieldClone = new int[toClone.length][];
            for(int i = 0; i < toClone.length; i ++){
                fieldClone[i] = new int[toClone[i].length];
                System.arraycopy(toClone[i], 0, fieldClone[i], 0, toClone[i].length);
            }
            return fieldClone;
        }
        
        private boolean[][] clone2DArr(boolean[][] toClone) {
            //toClone[0][0].
            boolean[][] fieldClone = new boolean[toClone.length][];
            for(int i = 0; i < toClone.length; i ++){
                fieldClone[i] = new boolean[toClone[i].length];
                System.arraycopy(toClone[i], 0, fieldClone[i], 0, toClone[i].length);
            }
            return fieldClone;
        }
        
	//places a block on the puzzle
	private void placeBlock(int x, int y, boolean[][] block, int number, int[][] puzzle){
            for(int i = 0; i < block.length; i++){
                for(int j = 0; j < block[i].length;j++){
                    if(block[i][j]){
                            puzzle[y + i][x + j] = number;
                    }
                }
            }
	}
	/*Checks whether the block could be placed at the specified locations and if there are blank bricks*/
	private boolean validMove(boolean[][] block, int [][] puzzle, int x, int y){
		//if it doesn't fit, return false
		if(x - 1 + longestRow(block) > FIELDWIDTH - 1|| y - 1 + block.length > FIELDLENGTH - 1){
			return false;
		}
		else{
			//try to fit the block
			for(int i = 0; i < block.length; i++){
				for(int j = 0; j < block[i].length;j++){
					//If the place is empty and the block is false at that place, return false for speed improvement
					if(puzzle[y + i][x + j] == 0){
						if(!block[i][j]){
							return false;
						}
					}
					else if(block[i][j]){
						return false;
					}
				}
			}
			return true;
		}
	}
	
	/*rotates a block 90* right*/
	private boolean[][] rotateBlock(boolean[][] block){
		boolean [][] temp;
		int longestRow = longestRow(block);
		temp = new boolean[longestRow][block.length];
		int counter = 0;
		for(int i = 0; i < longestRow;i++){
			for(int j = 0; j < block.length;j++){
				if(i < block[j].length){
					if(block[j][i]){
						temp[i][counter] = true;
						counter++;
					}
				}
				else{
					//null = false
					temp[i][counter] = false;
					counter++;
				}
			}
			counter = 0;
		}
		return stripBlock(temp);
	}
	
	/*Strips a block, example: true false false->true null null*/
	private boolean[][] stripBlock(boolean[][] fullBlock){
		List<List<java.lang.Boolean>> temp = new ArrayList<List<java.lang.Boolean>>();
		for(int i = 0; i < fullBlock.length; i++){
			List<java.lang.Boolean> tempRow = new ArrayList<java.lang.Boolean>();
			boolean removeFalse = true;
			for(int j = fullBlock[i].length - 1; j >= 0; j--){
					if(fullBlock[i][j]){
						removeFalse = false;
						//insert before -> tempRow
						tempRow.add(0, true);
					}
					else if(removeFalse){
						//dont't add false
						continue;
					}
					else{
						//add false
						tempRow.add(0,false);
					}
			}
			//if contains more than 1 element, add list to temp
			if(tempRow.size() > 0){
				temp.add(tempRow);
			}
		}
		boolean[][] strippedBlock = new boolean[temp.size()][];
		for(int i = 0; i < temp.size();i++){
			strippedBlock[i] = new boolean[temp.get(i).size()];
			for(int j = 0; j < temp.get(i).size();j++){
				strippedBlock[i][j] = temp.get(i).get(j);
			}
		}
		return strippedBlock;
	}
	
	private int longestRow(boolean[][] block){
		int longestRow = 0;
		for(int i = 0; i < block.length; i++){
			if(block[i].length > longestRow){
				longestRow = block[i].length;
			}
		}
		return longestRow;
	}
}
