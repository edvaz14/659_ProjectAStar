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
public class Grid {
    
    static int[][] world = new int[10][15];
    
    public static int[][] makeW(){
        
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
      
    public static void setBlock(int x, int y){
        world[x][y] = '#';
    }
}
