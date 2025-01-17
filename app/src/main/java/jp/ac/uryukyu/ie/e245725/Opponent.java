package jp.ac.uryukyu.ie.e245725;

import java.util.ArrayList;
import java.util.Random;

public class Opponent {
    private int Ox ;
    private int Oy ;
    private int[][] checkSurrounds  = {
        {-1,0},{-1,+1},{0,+1},{+1,+1},{+1,0},{+1,-1},{0,-1},{-1,-1}
    } ;
    private ArrayList<ArrayList<Integer>> canPut = new ArrayList<>();
    Random random = new Random();

    
    public void investigate( String[][] boards ) {
        for ( int x = 0; x < 8; x++ ) {
            for (int y = 0; y < 8; y++) {
                if ( boards[x][y].equals("⚪️") )  {
                    for ( int[] cs : checkSurrounds ) {
                        int newx = x + cs[0] ;
                        int newy = y + cs[1] ;
                        if ( boards[newx][newy].equals("⚫️" ) ) {
                            newx -= ( cs[0] * 2 ) ;
                            newy -= ( cs[1] * 2 ) ;
                            if ( boards[newx][newy].equals("🟩") ) {
                                ArrayList<Integer> childCanPut = new ArrayList<>();
                                childCanPut.add(newx);
                                childCanPut.add(newy);
                                canPut.add(childCanPut);
                            }
                        }
                    }
                }   
            }
        }
    }
        

    public void inputOp( String[][] boards ) {
        int randomIndex = random.nextInt(canPut.size());
        Ox = canPut.get(randomIndex).get(0);
        Oy = canPut.get(randomIndex).get(1);
        boards[Ox][Oy] = "⚫️";
        System.out.println(Ox);
        System.out.println(Oy);
        System.out.println(canPut.size());
    }

    


    
}
