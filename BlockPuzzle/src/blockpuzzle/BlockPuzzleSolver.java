/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockpuzzle;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kjeld
 */
public class BlockpuzzleSolver {
    
    List<Block> Blocks = new ArrayList<>();
    List<int[]> pinPositions = new ArrayList<>();
    List<int[][]> solutions = new ArrayList<>();
    static final int gSize = 7;
    static final int blocks = 9;
    BlockPuzzleFrame frame;
    final int[][] grid = new int[7][7];
//    {
//        {0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0}
//    };
    
    public BlockpuzzleSolver(BlockPuzzleFrame frame){
    	Blocks.add(new Block (new int[][] {{0,1},{0,2},{1,1},{1,2},{1,3},{2,0},{2,1},{2,2}}, 1, 3));        
        Blocks.add(new Block (new int[][] {{0,1},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}}, 2, 3));        
        Blocks.add(new Block (new int[][] {{0,2},{1,0},{1,1},{1,2},{1,3}}, 3, 3));        
        Blocks.add(new Block (new int[][] {{0,0},{1,0},{1,1},{2,0},{2,1},{2,2}}, 4, 3));        
        Blocks.add(new Block (new int[][] {{0,1},{0,2},{1,0},{1,1},{1,2},{1,3}}, 5, 3));        
        Blocks.add(new Block (new int[][] {{0,0},{0,1},{0,2},{0,3},{0,4}}, 6, 1));        
        Blocks.add(new Block (new int[][] {{0,2},{1,1},{1,2},{2,0},{2,1}}, 7, 3));        
        Blocks.add(new Block (new int[][] {{0,1},{1,0},{1,1},{1,2}}, 8, 3));        
        Blocks.add(new Block (new int[][] {{0,0},{0,1}}, 9, 1));
        pinPositions.add(new int[] {0,1}); pinPositions.add(new int[] {0,2});
        pinPositions.add(new int[] {0,6}); pinPositions.add(new int[] {1,3});
        pinPositions.add(new int[] {2,0}); pinPositions.add(new int[] {2,2});
        pinPositions.add(new int[] {2,5}); pinPositions.add(new int[] {3,3});
        pinPositions.add(new int[] {3,4}); pinPositions.add(new int[] {5,1});
        pinPositions.add(new int[] {5,2}); pinPositions.add(new int[] {5,6});
        pinPositions.add(new int[] {6,3});
    }
    
    /**
     * Places the pin in the grid and solves the puzzle with this pin
     * @param positions
     * @param pinNR 
     */
    public void placePin(List<int[]> positions, int pinNR){
        int[] pinPos = positions.get(pinNR);
        int[][] useGrid = grid.clone();
        useGrid[pinPos[0]][pinPos[1]] = 9;
        solve(useGrid.clone(), Blocks, 0);
    }
    
    /**
     * Checks if the block fits in the grid on the preferred location
     * @param grid
     * @param shape
     * @param y
     * @param x
     * @return 
     */
    public boolean testGrid(int[][] grid, int[][] shape, int y, int x){
        for(int[] pos : shape){
            try{
                if(grid[y + pos[0]][x + pos[1]] != 0)
                return false;
            }
            catch(Exception e){return false;};
        }
        return true;
    }
    
    /**
     * Put the block in the grid on the preferred location
     * @param grid
     * @param shape
     * @param y
     * @param x
     * @param blockNR
     * @return 
     */
    public int[][] putInGrid(int[][] grid, int[][] shape, int y, int x, int blockNR){
        for(int[] pos : shape){
            grid[y + pos[0]][x + pos[1]] = blockNR;                
        }
        return grid;
    }
    
    /**
     * Copy or clear the input grid and return a copy of the grid or the cleared grid.
     * @param oldGrid
     * @param clear
     * @param blockNR
     * @return 
     */
    public int[][] copyAndClearGrid(int[][] oldGrid, boolean clear, int blockNR){
        int[][] newGrid = new int[gSize][gSize];
        if(!clear){
            for(int y = 0; y < gSize; y++){
                System.arraycopy(oldGrid[y], 0, newGrid[y], 0, gSize);
            } 
        }
        else{
            for(int y = 0; y < gSize; y++){
                for(int x = 0; x < gSize; x++){
                    if(oldGrid[y][x] == blockNR)
                        newGrid[y][x] = 0;
                    else
                        newGrid[y][x] = oldGrid[y][x];
                }   
            } 
        }
        return newGrid;
    }
    
    /**
     * adds the solutions grid to a list of all solutions for current pin
     * @param grid 
     */
    public void addToSolutions(int[][] grid){
        int[][] solution = copyAndClearGrid(grid, false, 0);
 
        //Checks if the solver creates double results
        if(solutions.contains(solution))
            System.out.println("double result");
        else
            solutions.add(solution);
    }
    
    /**
     * Solve the block puzzle recursive
     * @param grid
     * @param blocks
     * @param blockNR 
     */
    public void solve(int[][] grid, List<Block> blocks, int blockNR){
        int newBlockNR;
        if(blockNR == 9){
            
            for(int[] p : grid){
               System.out.println( p[0] + " " + p[1] + " " + p[2] + " " + p[3] + " " + p[4] + " " + p[5] + " " + p[6]);
            }
            addToSolutions(grid);
            System.out.println();
            return;
        }
        else
            newBlockNR = blockNR +1;
        Block block = Blocks.get(blockNR);
        for(int y = 0; y < gSize; y ++){
            for(int x = 0; x < gSize; x++){
                for(int[][] shape : block.rotations){
                    if (testGrid(grid, shape, y, x))
                    {
                        int[][] newGrid = putInGrid(copyAndClearGrid(grid.clone(), false, block.blockID), shape, y, x, block.blockID);
                        solve(newGrid, blocks, newBlockNR);  
                    }
                }
            }
        }
    }
    
}
