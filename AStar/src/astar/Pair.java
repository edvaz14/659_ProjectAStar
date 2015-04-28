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
public class Pair {
    
    private int x = 0, y = 0;
    private int f = 0,g = 0, h = 0;
    private Boolean d;
    private Pair parent;

    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.d = false;
        this.parent = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }
    
    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }
    
    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
    
    public Pair getP() {
        return parent;
    }

    public void setP(Pair p) {
        this.parent = p;
    }
    
    public Boolean getD() {
        return d;
    }

    public void setD(Boolean d) {
        this.d = d;
    }
    
    @Override
    public boolean equals (Object o) {
    Pair temp = (Pair) o;
        if (temp.getX() == getX()&&temp.getY() == getY()) return true;
        return false;
    }
}
