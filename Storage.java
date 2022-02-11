public class Storage
{

    final int MAX_STORAGE_SIZE = 99;
    private int gold;

    public Storage()
    {
        this.gold = 0;
    }

    void refill(int stolenCoins)
    {
        this.gold= gold+stolenCoins;
    }
    void toEmpty()
    {
        this.gold=0;
    }
    public int getGold() 
    {
        return this.gold;
    }
    boolean checkStatus ()
    {
        return this.gold <= MAX_STORAGE_SIZE;
    }
}
