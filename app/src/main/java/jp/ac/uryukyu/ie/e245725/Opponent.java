package jp.ac.uryukyu.ie.e245725;

import java.util.ArrayList;
import java.util.Random;

public class Opponent extends Character {
    Random random = new Random();
    private ArrayList<ArrayList<Integer>> canPut = new ArrayList<>();
    

    public void findMoves(String[][] boards) {
        canPut.clear();
        canPut = useInvestigate(boards, "⚫️", "⚪️");
    }

    @Override
    public void putStone( String[][] boards ) {
        int randomIndex = random.nextInt(canPut.size());
        setX(canPut.get(randomIndex).get(0));
        setY(canPut.get(randomIndex).get(1));
        boards[getX()][getY()] = "⚫️";
        useToChangeStones(boards, "⚫️", getX(), getY());
        //System.out.println("canPutの内容: " + canPut);
    }

    


    
}
