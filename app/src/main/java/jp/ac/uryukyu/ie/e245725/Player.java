package jp.ac.uryukyu.ie.e245725;
import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    private int Px;
    private int Py;
        

    public int inputPx() {
        do {
            System.out.println("行指定：1~8の整数の中から１つ入力してください。");
            Px = scanner.nextInt() - 1;
        } while ( Px < 0 || Px > 7 );
        return Px;
    }

    public int inputPy() {
        do {
            System.out.println("列指定：1~8の整数の中から１つ入力してください。");
            Py = scanner.nextInt() - 1;
        } while ( Py < 0 || Py > 7 );

        return Py;  
    }
    
}
