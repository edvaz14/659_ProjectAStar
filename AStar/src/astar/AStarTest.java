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
		
	}

}
