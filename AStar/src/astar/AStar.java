/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

/**
 *
 * @author Edwin
 */
public class AStar {

    /**
     * @param args the command line arguments
     */
	

    public static void main(String[] args) {
        int randX, randY;
        Pair h, z;
        Grid.makeW();
        
        int dX = ((Grid.x - 1) - 1) + 1;
    	int dY = ((Grid.y - 1) - 1) + 1;
    	
        randX = (int) (Math.random() * dX) + 1;
        randY = (int) (Math.random() * dY) + 1;
        
        Grid.setBlocks();
        Path path = new Path();
    }
    
}
