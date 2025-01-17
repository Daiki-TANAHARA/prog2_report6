import jp.ac.uryukyu.ie.e245725.*;

public class Game {
    static int x;
    static int y;
    static String[][] aboard;

    public static void main(String[] args) {
        Board board = new Board(); 
        board.makeBoard(); 
        board.displayBoard();
        aboard = board.getBoard();

        /*Player player = new Player();
        board.getBoard()[player.inputPx()][player.inputPy()] = "⚪️";
        board.displayBoard();*/

        Opponent opponent = new Opponent();
        opponent.investigate(aboard);
        opponent.inputOp(aboard);
        board.displayBoard();
        
    }
}

