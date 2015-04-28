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
        randX = (int) Math.random() * Grid.x;
        randY = (int) Math.random() * Grid.y;
        Grid.setBlocks();
        Path path = new Path();
    }
    
}
