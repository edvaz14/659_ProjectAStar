/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.ArrayList;

/**
 *
 * @author Edwin
 */
public class Path {
    
    static ArrayList<Pair> open = new ArrayList<Pair>();
    static ArrayList<Pair> closed = new ArrayList<Pair>();
    int zX, zY, hX, hY;
    
    Path(){
    	int dX = (Grid.x - 1) + 1;
    	int dY = (Grid.y - 1) + 1;
    	
        zX = (int) (Math.random() * dX) + 1;
        zY = (int) (Math.random() * dY) + 1;
        
        Pair zPair = new Pair(zX,zY);
        
        hX = (int) (Math.random() * dX) + 1;
        hY = (int) (Math.random() * dY) + 1;
        
        Pair hPair = new Pair(hX,hY), cpair = zPair;
        
        Grid.world[hPair.getX()][hPair.getY()]='H';
        Grid.world[zPair.getX()][zPair.getY()]='Z';
        Grid.printW();
        open.add(zPair);
        
        while(!open.isEmpty()){
            cpair = findLF();

            if(closed.contains(hPair)){
                System.out.println("\n\n\nPATH FOUND");
                
                break;
            }
        
            adjPairs(cpair, hPair);
            System.out.println("\n");
            Grid.printW();
        }
        
        Grid.world[hPair.getX()][hPair.getY()]='H';
        Grid.world[zPair.getX()][zPair.getY()]='Z';
        
        if(open.isEmpty()){
            System.out.println("\nNO PATH FOUND");
        }else{
            Pair tar = cpair;
            while(tar.getP() != zPair){
                tar=tar.getP();
                Grid.world[tar.getX()][tar.getY()]='@';
            } 
        }
        Grid.printW();
    }
    
    public Pair findLF(){
        int f = open.get(0).getF();
        Pair temp = open.get(0);
        
        for(int i=1; i<open.size(); i++){
            if(f>open.get(i).getF()){
                f=open.get(i).getF();
                temp = open.get(i);
            }
        }
        Grid.world[temp.getX()][temp.getY()]='*';
        closed.add(temp);
        open.remove(temp);
        return temp;
    }
    
    public void printOpen(){
        for(int i=0; i<open.size(); i++){
            System.out.println(open.get(i).getX()+" "+open.get(i).getY()+" "+open.get(i).getF());
        }
    }
    public void printClosed(){
        for(int i=0; i<closed.size(); i++){
            System.out.println(closed.get(i).getX()+" "+closed.get(i).getY()+" "+closed.get(i).getF());
        }
    }
    
    public void adjPairs(Pair cpair, Pair tpair){
        
        for (int x=-1;x<2;x++) {
            for (int y=-1;y<2;y++) {
                if ((x == 0) && (y == 0)) {
                        continue;
                }

                int px = x + cpair.getX(),py = y + cpair.getY();

                if(Grid.world[px][py]!='#'){
                    Pair npair = new Pair(px,py);

                    if((x != 0) && (y != 0)){
                        npair.setD(Boolean.TRUE);
                    }
                    if(closed.contains(npair)){
                        continue;
                    }
                    if(!open.contains(npair)){
                        npair.setH(functions.hVal(px, py, tpair.getX(), tpair.getY()));
                        npair.setG(functions.gVal(cpair.getG(), cpair.getD()));
                        npair.setF(functions.fVal(npair.getG(), npair.getH()));
                        npair.setP(cpair);
                        open.add(npair);
                        Grid.world[px][py]='|';
                    }else{
                        if(npair.getG()>functions.gVal(cpair.getG(), cpair.getD())){
                            npair.setG(functions.gVal(cpair.getG(),cpair.getD()));
                            npair.setF(functions.fVal(npair.getG(), npair.getH()));
                            npair.setP(cpair);
                        }
                    }  
                }
            }
        }
    }
    
}
