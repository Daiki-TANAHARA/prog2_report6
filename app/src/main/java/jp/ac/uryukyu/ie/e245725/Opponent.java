package jp.ac.uryukyu.ie.e245725;

import java.util.ArrayList;
import java.util.Random;

public class Opponent extends Character {
    Random random = new Random();
    private int[][] checkSurrounds  = {
        {-1,0},{-1,+1},{0,+1},{+1,+1},{+1,0},{+1,-1},{0,-1},{-1,-1}
    } ;
    private ArrayList<ArrayList<Integer>> canPut = new ArrayList<>();
    //private ArrayList<ArrayList<Integer>> changeStone = new ArrayList<>();

    public void investigate( String[][] boards ) {
        for ( int x = 0; x < 8; x++ ) {
            for ( int y = 0; y < 8; y++ ) {
                if ( boards[x][y].equals("⚫️") ) {
                    for ( int[] cs : checkSurrounds ) {
                        int newx = x + cs[0] ;
                        int newy = y + cs[1] ;
                        while( ( newx >= 0 && newx < 8 && newy >= 0 && newy < 8 ) ) {
                            if ( boards[newx][newy].equals("⚪️") ) {
                                /*ArrayList<Integer> childChangeStone = new ArrayList<>();
                                childChangeStone.add(newx);
                                childChangeStone.add(newy);
                                changeStone.add(childChangeStone);*/
                                newx += cs[0] ;
                                newy += cs[1] ;
                                if ( boards[newx][newy].equals("🟩") ) {
                                    ArrayList<Integer> childCanPut = new ArrayList<>();
                                    childCanPut.add(newx);
                                    childCanPut.add(newy);
                                    canPut.add(childCanPut);
                                    break;
                                } else if ( boards[newx][newy].equals("⚫️") ){
                                    break;
                                }
                            } else {
                                break;
                            }
                        }                       
                    }
                }
            }
        }
        System.out.println(canPut);
    }
        
    


    @Override
    public void putStone( String[][] boards ) {
        int randomIndex = random.nextInt(canPut.size());
        setX(canPut.get(randomIndex).get(0));
        setY(canPut.get(randomIndex).get(1));
        boards[getX()][getY()] = "⚫️";
    }

    


    
}
