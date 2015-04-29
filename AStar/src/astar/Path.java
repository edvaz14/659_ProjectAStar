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
    
    static ArrayList<Pair> hopen = new ArrayList<Pair>();
    static ArrayList<Pair> hclosed = new ArrayList<Pair>();
    int zX, zY, hX, hY;
    
    Path(){
    	int dX = ((Grid.x - 1) - 1) + 1;
    	int dY = ((Grid.y - 1) - 1) + 1;
    	
        zX = ((int) (Math.random() * dX)) + 1;
        zY = ((int) (Math.random() * dY)) + 1;
        
        while(Grid.world[zY][zX] == '#') {
        	zX = ((int) (Math.random() * dX)) + 1;
            zY = ((int) (Math.random() * dY)) + 1;
        }
        
        Pair zPair = new Pair(zX,zY);
        
        hX = (int) (Math.random() * dX) + 1;
        hY = (int) (Math.random() * dY) + 1;
        
        while((hX == zPair.getX() && hY == zPair.getY()) || (Grid.world[hY][hX] == '#')) {
        	 hX = (int) (Math.random() * dX) + 1;
             hY = (int) (Math.random() * dY) + 1;
        }
        
        Pair hPair = new Pair(hX,hY), cpair = zPair, rpair = hPair;
        
        //System.out.println(cpair.getX() + " c " + cpair.getY());
        
        Grid.world[hPair.getY()][hPair.getX()]='H';
        Grid.world[zPair.getY()][zPair.getX()]='Z';
        Grid.printW();
        open.add(zPair);
        hopen.add(hPair);
        
        while(!open.isEmpty()){
            cpair = findLF();

            if(closed.contains(hPair)){
                System.out.println("\nPATH FOUND");
                
                break;
            }
        
            adjPairs(cpair, hPair);
            //System.out.println("\n");
            //Grid.printW();
        }
        
        Grid.world[hPair.getY()][hPair.getX()]='H';
        Grid.world[zPair.getY()][zPair.getX()]='Z';
        
        if(open.isEmpty()){
            System.out.println("\nNO PATH FOUND");
        }else{
            Pair tar = cpair;
            while(tar.getP() != zPair){
                tar=tar.getP();
                Grid.world[tar.getY()][tar.getX()]='@';
            } 
        }
        Grid.printW();
        
        rpair = findHF();
        
        
        
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
        Grid.world[temp.getY()][temp.getX()]='*';
        closed.add(temp);
        open.remove(temp);
        
        //System.out.println(temp.getX() + " " + temp.getY());
        return temp;
    }
    
    public Pair findHF() {
    	int f = hopen.get(0).getF();
        Pair temp = hopen.get(0);
        
        for(int i=1; i<hopen.size(); i++){
            if(f < hopen.get(i).getF()){
                f = hopen.get(i).getF();
                temp = hopen.get(i);
            }
        }
        Grid.world[temp.getY()][temp.getX()]='^';
        hclosed.add(temp);
        hopen.remove(temp);
        
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

                int px = 0, py = 0;
                if(x + cpair.getX() == Grid.x) 
                	continue;
                if(y + cpair.getY() == Grid.y) 
                	continue;
                
                px = x + cpair.getX();
                py = y + cpair.getY();

                if(Grid.world[py][px]!='#'){
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
                        Grid.world[py][px]='|';
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
    
    public void findHVals(Pair rpair, Pair zpair) {
    	for (int x=-1;x<2;x++) {
            for (int y=-1;y<2;y++) {
                if ((x == 0) && (y == 0)) {
                        continue;
                }
                
                int px = 0, py = 0;
                if(x + rpair.getX() == Grid.x) 
                	continue;
                if(y + rpair.getY() == Grid.y) 
                	continue;
                
                px = x + rpair.getX();
                py = y + rpair.getY();
                
                if(Grid.world[py][px]!='#'){
                    Pair npair = new Pair(px,py);

                    if((x != 0) && (y != 0)){
                        npair.setD(Boolean.TRUE);
                    }
                    if(hclosed.contains(npair)){
                        continue;
                    }
                    if(!hopen.contains(npair)){
                        npair.setH(functions.hVal(px, py, zpair.getX(), zpair.getY()));
                        hopen.add(npair);
                        Grid.world[py][px]='|';
                    }
                }
            }
    	}
                
    }
    
}
