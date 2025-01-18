package jp.ac.uryukyu.ie.e245725;

public abstract class Character {
    private int x;
    private int y;
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
    
    /*public StoneCheck getStoneCheck() {
        return this.stoneCheck;
    }*/

    public abstract void putStone( String[][] board );

        
    

    
    
    
    
}
