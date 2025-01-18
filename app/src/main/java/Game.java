import jp.ac.uryukyu.ie.e245725.*;

public class Game {
    public static void main(String[] args) {
        Board board = new Board(); 
        board.makeBoard(); 
        board.displayBoard();
        board.getBoard();

        Player player = new Player();
        player.putStone(board.getBoard());
        board.displayBoard();
        player.putStone(board.getBoard());
        board.displayBoard();

        Opponent opponent = new Opponent();
        opponent.investigate(board.getBoard());
        opponent.putStone(board.getBoard());
        board.displayBoard();
        
    }
}

