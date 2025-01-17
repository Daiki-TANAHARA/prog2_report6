package jp.ac.uryukyu.ie.e245725;

public class Board {
    
    private String[][] Board = new String[8][8];

    public String[][] getBoard() {
        return this.Board;
    }


    public void makeBoard() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if ((x == 3 && y == 3) || (x == 4 && y == 4)){
                    Board[x][y] = "⚪️";
                }
                    else if ((x == 4 && y == 3) || (x == 3 && y == 4)){
                        Board[x][y] = "⚫️";
                    } 
                        else {Board[x][y] = "🟩";}
            }
        }
    }


    public void displayBoard() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                System.out.print(Board[x][y]); 
            }
            System.out.println(); 
        }
    }
    
}
