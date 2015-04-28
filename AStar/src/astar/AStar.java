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
        
        Grid.makeW();
        Grid.setBlock(3, 2);
        Grid.setBlock(4, 1);
        Path path = new Path(2,1,8,10);
    }
    
}
