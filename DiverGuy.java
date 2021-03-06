import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DiverGuy
{
    private int pos_X;
    private int pos_Y;
    private int countOfGold;
    private boolean lifeStatus = true;

    ImageView runningGuy;

    public DiverGuy(int posX,int posY) throws FileNotFoundException
    {
        this.pos_X = posX;
        this.pos_Y = posY;
        setCountOfGold(0);
        runningGuy = new ImageView(new Image(new FileInputStream("urPath/GuyOnBoard.png")));
    }

    public void setCountOfGold(int newGoldValue)
    {
        this.countOfGold = newGoldValue;
    }

    public ImageView getGuyImage()
    {
        return runningGuy;
    }

    public int getPosX()
    {
        return pos_X;
    }

    public int getPosY()
    {
        return pos_Y;
    }

    public void it()
    {
        setCountOfGold(getCountOfGold() + 1);
    }

    public void toEmpty()
    {
        setCountOfGold(0);
    }

    public void kill()
    {
        lifeStatus = false;
    }

    public boolean isAlive()
    {
        return lifeStatus;
    }

    public int getCountOfGold()
    {
        return countOfGold;
    }
}
