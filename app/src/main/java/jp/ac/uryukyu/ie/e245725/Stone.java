package jp.ac.uryukyu.ie.e245725;

import java.util.ArrayList;

public class Stone {
        private int[][] checkSurrounds  = {
        {-1,0},{-1,+1},{0,+1},{+1,+1},{+1,0},{+1,-1},{0,-1},{-1,-1}
    } ;
    private ArrayList<ArrayList<Integer>> canPut = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<Integer>>> changeStones = new ArrayList<>();


    public ArrayList<ArrayList<Integer>> investigate( String[][] boards, String ownStone, String opponentStone ) {
        changeStones.clear();
        for ( int x = 0; x < 8; x++ ) {
            for ( int y = 0; y < 8; y++ ) {
                if ( boards[x][y].equals(ownStone) ) {
                    for ( int[] cs : checkSurrounds ) {
                        int newx = x + cs[0] ;
                        int newy = y + cs[1] ;
                        ArrayList<ArrayList<Integer>> childCS1= new ArrayList<>();
                        do {
                            if ( boards[newx][newy].equals(opponentStone) ) {
                                ArrayList<Integer> childCS2 = new ArrayList<>();
                                childCS2.add(newx);
                                childCS2.add(newy);
                                childCS1.add(childCS2);
                                newx += cs[0] ;
                                newy += cs[1] ;
                                if ( ( newx >= 0 && newx < 8 ) && ( newy >= 0 && newy < 8 ) && (boards[newx][newy].equals("🟩") ) ) { // 再度範囲チェック
                                    //System.out.println(boards[newx][newy]);
                                    ArrayList<Integer> childCanPut = new ArrayList<>();
                                    childCanPut.add(newx);
                                    childCanPut.add(newy);
                                    canPut.add(childCanPut);
                                    changeStones.add(childCS1);
                                    break;
                                } else if (( ( newx < 0 || newx >= 8 ) || ( newy < 0 || newy >= 8 ) ) && ( boards[newx][newy].equals(ownStone) ) ) { // 範囲チェック
                                    break;
                                }
                            } else {
                                break;
                            }
                                  
                        } while( ( newx >= 0 && newx < 8 ) && ( newy >= 0 && newy < 8 ) );                      
                    }
                }
            }
        }
        return canPut;
    }

    public void toChangeStones( String[][] board, String ownStone, int x, int y ) {
        int count = -1;
        for ( ArrayList<Integer> cp : canPut ) {
            count += 1;
            if ( cp.get(0) == x ) {
                if ( cp.get(1) == y ) {
                    ArrayList<ArrayList<Integer>> targetList = changeStones.get(count);
                    //System.out.println(targetList);
                    for ( ArrayList<Integer> tl : targetList ) {
                        board[tl.get(0)][tl.get(1)] = ownStone;
                    }
                }
            }
        }    
    }
}
