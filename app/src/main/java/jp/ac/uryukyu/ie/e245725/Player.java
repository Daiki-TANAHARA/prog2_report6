package jp.ac.uryukyu.ie.e245725;
import java.util.Scanner;

public class Player extends Character{
    Scanner scanner = new Scanner(System.in);
        
    @Override
    public void putStone( String[][] board ) {
        do {
            System.out.println("行指定：1~8の整数の中から１つ入力してください。");
            setX(scanner.nextInt() - 1);
        } while ( getX() < 0 || getX() > 7 );
        System.out.println(getX());

        do {
            System.out.println("列指定：1~8の整数の中から１つ入力してください。");
            setY(scanner.nextInt() - 1);
        } while ( getY() < 0 || getY() > 7 );
        System.out.println(getY());

        board[getX()][getY()] = "⚪️";
 
    }
    
}
