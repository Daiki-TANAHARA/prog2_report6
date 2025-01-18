package jp.ac.uryukyu.ie.e245725;

import java.util.ArrayList;

public class Stone {
        private int[][] checkSurrounds  = {
        {-1,0},{-1,+1},{0,+1},{+1,+1},{+1,0},{+1,-1},{0,-1},{-1,-1}
    } ;
    private ArrayList<ArrayList<Integer>> canPut = new ArrayList<>();
    

    public ArrayList<ArrayList<Integer>> investigate( String[][] boards, String pstone, String ostone ) {
        for ( int x = 0; x < 8; x++ ) {
            for ( int y = 0; y < 8; y++ ) {
                if ( boards[x][y].equals(pstone) ) {
                    for ( int[] cs : checkSurrounds ) {
                        int newx = x + cs[0] ;
                        int newy = y + cs[1] ;
                        while( ( newx >= 0 && newx < 8 && newy >= 0 && newy < 8 ) ) {
                            if ( boards[newx][newy].equals(ostone) ) {
                                newx += cs[0] ;
                                newy += cs[1] ;
                                if ( boards[newx][newy].equals("🟩") ) {
                                    ArrayList<Integer> childCanPut = new ArrayList<>();
                                    childCanPut.add(newx);
                                    childCanPut.add(newy);
                                    canPut.add(childCanPut);
                                    break;
                                } else if ( boards[newx][newy].equals(pstone) ){
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
        return canPut;
    }
}
