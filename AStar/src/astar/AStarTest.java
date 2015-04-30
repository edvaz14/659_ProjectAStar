package astar;

import static org.junit.Assert.*;

import org.junit.Test;

public class AStarTest {

	@Test
	public void UserInputTest() {
		Grid.makeW();
		int wX = Grid.world[0].length;
		int wY = Grid.world.length;
		
		int x = Grid.x;
		int y = Grid.y;
		
		assertTrue(x == wX);
		assertTrue(y == wY);
	}
	
	@Test
	public void setBlocksTest() {
		Grid.makeW();
		Grid.setBlocks();
		int count = 0;
		
		for(int y = 1; y < Grid.world.length - 1; y++) {
			for(int x = 1; x < Grid.world[0].length - 1; x++) {
				if(Grid.world[y][x] == '#') {
					count++;
				}
			}
		}
		assertTrue(count == Grid.numObstacles);
	}
	@Test
	public void sameLocation() {
		
		Grid.makeW();
		
		int dX = (Grid.x - 1) + 1;
    	int dY = (Grid.y - 1) + 1;
    	int zX, zY, hX, hY;
    	
        zX = (int) (Math.random() * dX) + 1;
        zY = (int) (Math.random() * dY) + 1;
        
        Pair zPair = new Pair(zX,zY);
        
        hX = (int) (Math.random() * dX) + 1;
        hY = (int) (Math.random() * dY) + 1;
        
        while(hX == zPair.getX() && hY == zPair.getY()) {
        	 hX = (int) (Math.random() * dX) + 1;
             hY = (int) (Math.random() * dY) + 1;
             
             System.out.println(hX + " " + hY);
        }
        
        Pair hPair = new Pair(hX,hY);
        
        assertTrue(zPair.getX() != hPair.getX() && zPair.getY() != hPair.getY());
       
	}

}
