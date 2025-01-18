package jp.ac.uryukyu.ie.e245725;

import java.util.ArrayList;

public abstract class Character {
    private int x;
    private int y;
    Stone stone = new Stone();
    //private StoneCheck stoneCheck = new StoneCheck();

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX( int X ) {
        this.x = X;
    }

    public void setY( int Y ) {
        this.y = Y;
    }
    
    public ArrayList<ArrayList<Integer>> useInvestigate( String[][] board, String pstone, String ostone) {
        return stone.investigate(board, pstone, ostone);
        
    }

    public abstract void putStone( String[][] board );

        
    

    
    
    
    
}
