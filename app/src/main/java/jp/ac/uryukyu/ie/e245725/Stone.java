package jp.ac.uryukyu.ie.e245725;

import java.util.ArrayList;

public class Stone {
        private int[][] checkSurrounds  = {
        {-1,0},{-1,+1},{0,+1},{+1,+1},{+1,0},{+1,-1},{0,-1},{-1,-1}
    } ;
    private ArrayList<ArrayList<Integer>> canPut = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<Integer>>> changeStones = new ArrayList<>();


    /**
     * 石が置ける場所を調べてリストを作るメソッド。
     * @param board　ボード
     * @param ownStone　自分の石
     * @param opponentStone 相手の石
     * @return　ownStoneを置ける場所のリスト
     */
    public ArrayList<ArrayList<Integer>> investigate( String[][] board, String ownStone, String opponentStone ) {
        changeStones.clear();
        for ( int x = 0; x < 8; x++ ) {
            for ( int y = 0; y < 8; y++ ) {
                if ( board[x][y].equals(ownStone) ) {
                    for ( int[] cs : checkSurrounds ) {
                        int newx = x + cs[0] ;
                        int newy = y + cs[1] ;
                        ArrayList<ArrayList<Integer>> childCS1= new ArrayList<>();
                        do {
                            if ( board[newx][newy].equals(opponentStone) ) {
                                ArrayList<Integer> childCS2 = new ArrayList<>();
                                childCS2.add(newx);
                                childCS2.add(newy);
                                childCS1.add(childCS2);
                                newx += cs[0] ;
                                newy += cs[1] ;
                                if ( ( newx >= 0 && newx < 8 ) && ( newy >= 0 && newy < 8 ) && (board[newx][newy].equals("🟩") ) ) { // 再度範囲チェック
                                    //System.out.println(boards[newx][newy]);
                                    ArrayList<Integer> childCanPut = new ArrayList<>();
                                    childCanPut.add(newx);
                                    childCanPut.add(newy);
                                    canPut.add(childCanPut);
                                    changeStones.add(childCS1);
                                    break;
                                } else if (( ( newx < 0 || newx >= 8 ) || ( newy < 0 || newy >= 8 ) ) && ( board[newx][newy].equals(ownStone) ) ) { // 範囲チェック
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

    /**
     * 石を裏返すためのメソッド。
     * 石を置く座標と一致するものをcanPutから探し、それと同じインデックスでchangeStonesの要素を取り出す。
     * @param board　ボード
     * @param ownStone　自分の石
     * @param x　石を置く場所のx座標
     * @param y　石を置く場所のy座標
     */
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
