/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.Scanner;

/**
 *
 * @author Edwin
 */
public class Grid {

    static int[][] world;
    //static Obstacle[] obstacles;
    static int x, y, numObstacles;
    static final int MAX_OBSTACLES = 5;
    public static int[][] makeW(){
        
    	Scanner in = new Scanner(System.in);
    	System.out.print("Please input x dimension: ");
    	x = Integer.parseInt(in.nextLine());
    	System.out.print("Please input y dimension: ");
    	y = Integer.parseInt(in.nextLine());
    	
    	numObstacles = (int) (Math.random() * MAX_OBSTACLES);
    	//Sobstacles = new Obstacle[numObstacles];
    	
    	world = new int[y][x];
    	
        for(int j=0; j<world[0].length;j++){
            world[0][j]='#';
        }

        for(int i=1; i<world.length-1; i++){
            world[i][0]='#';
            for(int j=1; j<world[0].length-1;j++){
                world[i][j]='-';
            }
            world[i][world[0].length-1]='#';
        }

        for(int j=0; j<world[0].length;j++){
            world[world.length-1][j]='#';
        }
        return world; 
    }
    
    public static void printW(){
        for(int i=0; i<world.length; i++){
            for(int j=0; j<world[i].length;j++){
                type(world[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    
    public static void type(int world){
        String type;
        switch (world) {
            case '#':
                type = "#";
                break;
            case '-':
                type = "-";
                break;
            case '|':
                type = "|";
                break;
            case '@':
                type = "@";
                break;
            case '*':
                type = "*";
                break;
            case 'T':
                type = "T";
                break;
            case 'S':
                type = "S";
                break;
            default:
                type = " ";
                break;
        }
        System.out.print(type);
    }
    
    public static String getW(int x, int y){
        type(world[x][y]);
        return "";
    }
      
    public static void setBlocks(){
    	int xDim = x;
    	int yDim = y;
    	int randX = (int) (Math.random() * xDim);
    	int randY = (int) (Math.random() * yDim);
    	
    	for(int x = 0; x < numObstacles; x++) {
			while(world[randY][randX] == '#') {
    			randX = (int) (Math.random() * xDim);
        		randY = (int) (Math.random() * yDim);
			}
			world[randY][randX] = '#';
    	}
        
    }
}
