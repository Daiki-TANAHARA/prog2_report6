package jp.ac.uryukyu.ie.e245725;

import java.util.ArrayList;

public abstract class Character {
    private int x;
    private int y;
    Stone stone = new Stone();

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
    
    public ArrayList<ArrayList<Integer>> useInvestigate( String[][] board, String ownStone, String opponentStone) {
        return stone.investigate(board, ownStone, opponentStone);
        
    }

    public void useToChangeStones( String[][] board, String ownStone, int x, int y ) {
        stone.toChangeStones(board, ownStone, x, y);
    }

    public abstract void putStone( String[][] board );

    
}
