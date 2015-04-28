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
public class functions {
    
    public static int hVal(int s1, int s2, int g1, int g2){
        return Math.abs(g1 - s1) + Math.abs(g2-s2);
    }
    
    public static int gVal(int g1, Boolean d){
        int g;
        if(d)
            g = 14 +g1;
        else
            g = 10 + g1;
        return g;
    }
    
    public static int fVal(int g, int h){
        return g+h;
    }
    
}
