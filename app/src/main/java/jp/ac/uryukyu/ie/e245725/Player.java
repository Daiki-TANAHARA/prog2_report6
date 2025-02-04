package jp.ac.uryukyu.ie.e245725;
import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Character{
    Scanner scanner = new Scanner(System.in);
    private ArrayList<ArrayList<Integer>> canPut = new ArrayList<>();

    
    /**
    * investigate()を使いやすくするメソッド。
    * ownStone,opponentStoneを指定してメインクラスで混同しないようにする。
    * @param board ボード
    */
    public void findMoves(String[][] board ) {
        canPut.clear();
        canPut = useInvestigate(board, "⚪️", "⚫️");
    }
    
    /**
    * Playerが石を置くためのメソッド。
    * 数値を２つ入力することで石の位置を特定。
    * @param board ボード
    */
    @Override
    public void putStone( String[][] board ) {
        System.out.println("あなたの番です。");
        //System.out.println("canPutの内容: " + canPut);
        boolean Bool = true;
        do {
            do {
                System.out.println("行指定：1~8の整数の中から１つ入力してください。");
                setX(scanner.nextInt() - 1);
            } while ( getX() < 0 || getX() > 7 );

            do {
                System.out.println("列指定：1~8の整数の中から１つ入力してください。");
                setY(scanner.nextInt() - 1);
            } while ( getY() < 0 || getY() > 7 );

            for ( ArrayList<Integer> cp : canPut ) {
                if ( cp.get(0) == getX() ) {
                    if ( cp.get(1) == getY() ){
                        Bool = false;
                        break;
                    } 
                }
            }
            if ( Bool == true) {
                System.out.println("その場所には置けません。");
            }
        } while ( Bool == true);

        board[getX()][getY()] = "⚪️";
        useToChangeStones(board, "⚪️", getX(), getY());
    }
    
}
