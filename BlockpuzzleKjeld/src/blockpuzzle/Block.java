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
public class Block{
    
    List<int[][]> rotations = new ArrayList<>();
    int[][] mainShape;
    int blockID;
    int maxY = 0;
    int maxX = 0;
    int rotCount;
    
    public Block(int[][] shape, int blockID, int rotCount){
        this.mainShape = shape;
        this.blockID = blockID;
        this.rotCount = rotCount;
        this.rotations = rotation(shape);
        for(int[] pos : shape){
            if(pos[0] > maxY)
                maxY = pos[0];
            if(pos[1] > maxX)
                maxX = pos[1];
        }
    }
    
    public List<int[][]> rotation(int[][] mainShape){
        List<int[][]> allRotations = new ArrayList<>();
        allRotations.add(mainShape);
        
        int[][] shape = mainShape.clone();
        int rotated = 0;
        int posCount = 0;
        while(rotated < rotCount)
        {
            switch(rotated){
               
                case 0: // x,-y
                    for(int[] pos : mainShape){
                        int[] invPos = {maxY + pos[1],-1 * pos[0]};
                        shape[posCount] = invPos;
                        posCount++;
                    }
                    posCount = 0;
                    rotated++;
                    allRotations.add(shape.clone());
                    break;
                case 1: // -y,-x
                    for(int[] pos : mainShape){
                        int[] invPos = {-1 * pos[0] + maxY,-1 * pos[1] + maxX};
                        shape[posCount] = invPos;
                        posCount++;
                    }
                    posCount = 0;
                    rotated++;
                    allRotations.add(shape.clone());
                    break;
                case 2: // -x,y
                    for(int[] pos : mainShape){
                        int[] invPos = {-1 * pos[1] + maxY, pos[0] + maxX};
                        shape[posCount] = invPos;
                        posCount++;
                    }
                    posCount = 0;
                    rotated++;
                    allRotations.add(shape.clone());
                    break;
            }
        }
        return allRotations;
    }
    
}
