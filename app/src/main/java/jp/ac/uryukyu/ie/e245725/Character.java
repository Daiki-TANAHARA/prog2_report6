package jp.ac.uryukyu.ie.e245725;

import java.util.ArrayList;

public abstract class Character {
    private int x;
    private int y;
    Stone stone = new Stone();

    //getterメソッド
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    //setterメソッド
    public void setX( int X ) {
        this.x = X;
    }

    public void setY( int Y ) {
        this.y = Y;
    }
    
    /**
     * investigate()をCharacterクラスとその子クラスで使用するためのメソッド。
     * @param board ボード
     * @param ownStone　自分の石
     * @param opponentStone　相手の石
     * @return　investigate()の結果
     */
    public ArrayList<ArrayList<Integer>> useInvestigate( String[][] board, String ownStone, String opponentStone) {
        return stone.investigate(board, ownStone, opponentStone);
        
    }

    /**
     * investigate()をCharacterクラスとその子クラスで使用するためのメソッド。
     * @param board ボード
     * @param ownStone　自分の石
     * @param opponentStone　相手の石
     * @return　toChangeStones()の結果
     */
    public void useToChangeStones( String[][] board, String ownStone, int x, int y ) {
        stone.toChangeStones(board, ownStone, x, y);
    }

    public abstract void putStone( String[][] board );
    
}
