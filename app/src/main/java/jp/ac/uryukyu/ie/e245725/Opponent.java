package jp.ac.uryukyu.ie.e245725;

import java.util.ArrayList;
import java.util.Random;

public class Opponent extends Character {
    Random random = new Random();
    private ArrayList<ArrayList<Integer>> canPut = new ArrayList<>();
    

    /**
    * investigate()を使いやすくするメソッド。
    * ownStone,opponentStoneを指定してメインクラスで混同しないようにする。
    * @param board ボード
    */
    public void findMoves(String[][] boards) {
        canPut.clear();
        canPut = useInvestigate(boards, "⚫️", "⚪️");
    }

    /**
     * 相手（コンピューター）が石を置くためのメソッド。
     * canPutの中からランダムに選ぶ。
     * @param board ボード
     */
    @Override
    public void putStone( String[][] boards ) {
        System.out.println("相手の番です。");
        int randomIndex = random.nextInt(canPut.size());
        setX(canPut.get(randomIndex).get(0));
        setY(canPut.get(randomIndex).get(1));
        boards[getX()][getY()] = "⚫️";
        useToChangeStones(boards, "⚫️", getX(), getY());
        //System.out.println("canPutの内容: " + canPut);
    }

    


    
}
