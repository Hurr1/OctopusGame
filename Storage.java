public class Storage {

    final int maxStorageSize = 99;
    public int gold;


    public Storage(){
        gold = 0;
    }

    void refill(int stolenCoins){
        gold= gold+stolenCoins;
    }
    void toEmpty(){
        gold=0;
    }

    public int getGold() {
        return gold;
    }
    boolean checkStatus (){
        if(gold>=maxStorageSize)
            return false;
        return true;
    }
}
